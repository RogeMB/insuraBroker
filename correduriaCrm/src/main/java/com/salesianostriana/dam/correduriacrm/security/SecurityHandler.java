package com.salesianostriana.dam.correduriacrm.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class SecurityHandler implements AuthenticationSuccessHandler {

	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
		
		List<String> roles = List.copyOf(authentication.getAuthorities())
								.stream()
								.map(GrantedAuthority::getAuthority)
								.toList();
		
		String target = "";
		
		if (roles.contains("ROLE_ADMIN")) {
			target = "/admin/";
		} else {
			target = "/user/";			
		}
		
		redirectStrategy.sendRedirect(request, response, target);
				
	}
	          
}
