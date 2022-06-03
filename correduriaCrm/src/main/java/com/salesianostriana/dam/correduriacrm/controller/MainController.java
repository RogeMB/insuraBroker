package com.salesianostriana.dam.correduriacrm.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.correduriacrm.model.Empleado;
import com.salesianostriana.dam.correduriacrm.repository.EmpleadoRepository;

@Controller
public class MainController {
	
	@Autowired
	private EmpleadoRepository empleadoRepo;
	
    @GetMapping("/admin")
    public String adminIndex(Model model, @AuthenticationPrincipal UserDetails user) {
       
        //model.addAttribute("usuario", user.getUsername());
    	Optional<Empleado> elUsuario = empleadoRepo.findUserByUsername(user.getUsername());
    	
    	if(elUsuario.isPresent()){
    		model.addAttribute("usuario", elUsuario.get());
    	}else {
    		return "error404";
    	}
    	
        return "dashboard/admin/admin";
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/redirect")
    public String redirect() {
    	return "redirect:/login-login-in";
    }
    

    
    /*
	@GetMapping("/login-in")
	public String autentificar(Empleado empleado, Model model) {

		Optional<Empleado> elUsuario = empleadoRepo.findUserByUsername(empleado.getUsername());

		if(elUsuario.isPresent()){
			Empleado empl = elUsuario.get();

			if (empl.getRole().equals("USER")) {
				//model.addAttribute("usuario", elUsuario.get());
				return "dashboard/admin/admin";
			} else if (empl.getRole().equals("ADMIN")) {
				//model.addAttribute("usuario", elUsuario.get());
				return "admin/user/admin";
			}
		}
		return "index";
	}
*/
    

    @GetMapping("/login-error")
    public String loginError(Model model) {
    	model.addAttribute("loginError", true);
        return "login";
    }
    
    @GetMapping("/private")
	public String privateIndex(Model model, @AuthenticationPrincipal UserDetails user) {
		
		model.addAttribute("usuario", user.getUsername());
		
		return "private/index";
	}
    
    
	@GetMapping("/")
	public String welcome() {
		return "index";
	}

/*
	@GetMapping("/error")
	public String error() {
		return "error404";
	}
*/
	
}
