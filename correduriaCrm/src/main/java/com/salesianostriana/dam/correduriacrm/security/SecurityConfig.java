package com.salesianostriana.dam.correduriacrm.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.salesianostriana.dam.correduriacrm.repository.EmpleadoRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private EmpleadoRepository empleados;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/admin/privado/**").hasRole("ADMIN")
                .antMatchers("/h2-console").permitAll()
                .anyRequest().permitAll()
                .and().exceptionHandling().accessDeniedPage("/error")
                .and().formLogin().loginPage("/").loginProcessingUrl("/login")
                		.defaultSuccessUrl("/private")
                		.failureUrl("/login-error").permitAll()
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll();
        
        http.headers().frameOptions().disable();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {

        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

        empleados.getEmpleados()
                .stream()
                .map(u -> {
                    return User
                            .withUsername(u.getUsername())
                            .password("{noop}"+ u.getPassword())
                            .roles(u.getRole())
                            .build();

                })
                .forEach(userDetailsManager::createUser);


        return userDetailsManager;


    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
            .antMatchers("/h2-console/**");
    }
}