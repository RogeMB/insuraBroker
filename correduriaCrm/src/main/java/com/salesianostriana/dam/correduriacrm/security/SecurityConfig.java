package com.salesianostriana.dam.correduriacrm.security;

import com.salesianostriana.dam.correduriacrm.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private EmpleadoRepository empleados;
    
    @Autowired
    private SecurityHandler successLoginHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/").permitAll()
                .and()
	                .authorizeRequests().antMatchers("/h2-console/**").permitAll()
	                .antMatchers("/assets/**").permitAll()
	                .antMatchers("/dashboard/user/**").hasAnyRole("USER", "ADMIN")
	                .antMatchers("/dashboard/admin/**").hasRole("ADMIN")
	                .anyRequest().permitAll()
                .and()
                	.exceptionHandling()
                	.accessDeniedPage("/error")
                .and()
	                .formLogin()
	                .loginPage("/")
	                .loginProcessingUrl("/login")
	                //defaultSuccessUrl("/admin/")
	                .successHandler(successLoginHandler)
	               
	                .failureUrl("/login-error").permitAll()
                .and()
                	.logout()
                	.logoutUrl("/logout")
                	.logoutSuccessUrl("/")
                	.permitAll();
        http.csrf()
                //.ignoringAntMatchers("/h2-console/**")
                .disable();
        http.headers().frameOptions().disable();


//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/admin/**").hasAnyRole("USER", "ADMIN") //estas rutas son controladores
//                .antMatchers("/admin/privado/**").hasRole("ADMIN")
//                .antMatchers("/h2-console").permitAll()
//                .anyRequest().authenticated()
//                //.anyRequest().permitAll()
//                .and().exceptionHandling().accessDeniedPage("/error403")
//                .and().formLogin().loginPage("/login").loginProcessingUrl("/login")
//                		.defaultSuccessUrl("/private")
//                		.failureUrl("/login-error").permitAll()
//                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll();
//
    }
    
    //https://www.baeldung.com/spring_redirect_after_login

    @Bean
    @Override
    public UserDetailsService userDetailsService() {

        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

        empleados.getEmpleados()
                .stream()
                .map(u -> {
                    return User
                            .withUsername(u.getUsername())
                            .password("{noop}" + u.getPassword())
                            .roles(u.getRole())
                            .build();

                })
                .forEach(userDetailsManager::createUser);


        return userDetailsManager;
    }
}
    
   /* 
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
            .antMatchers("/h2-console/**");
    }
    */
