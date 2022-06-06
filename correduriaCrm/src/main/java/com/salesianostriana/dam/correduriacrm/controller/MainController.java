package com.salesianostriana.dam.correduriacrm.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;


import com.salesianostriana.dam.correduriacrm.model.Empleado;
import com.salesianostriana.dam.correduriacrm.repository.EmpleadoRepository;

@Controller
public class MainController {
	
	@Autowired
	private EmpleadoRepository empleadoRepo;
	
	@GetMapping("/")
	public String welcome() {
		return "index";
	}

	
    @GetMapping("/login-in")
    public String adminIndex(Model model, @AuthenticationPrincipal UserDetails user) {
       
        //model.addAttribute("usuario", user.getUsername());
    	Optional<Empleado> elUsuario = empleadoRepo.findUserByUsername(user.getUsername());
    	
    	if(elUsuario.isPresent()){
			Empleado empl = elUsuario.get(); // como es opcional recupero los datos con .get()

			if (empl.getRole().equals("ADMIN")) {
				model.addAttribute("administrador", elUsuario.get());
				return "dashboard/admin/admin";
			} else if (empl.getRole().equals("USER")) {
				model.addAttribute("empleado", elUsuario.get());
				return "dashboard/user/user";
			}
		}
    	model.addAttribute("loginError", true);
        return "login";
    }


    @GetMapping("/login")
    public String login() {
    	//hacer aquí el redirect. Mirar si se puede mirar el @authentification principal
        return "login";
    }
    
    @GetMapping("/redirect")
    public String redirect() {
    	return "redirect:/dashboard";
    }

    
    @GetMapping("/login-error")
    public String loginError(Model model) {
    	model.addAttribute("loginError", true);
        return "login";
    }
    
    @GetMapping("/dashboard")
	public String privateIndex(Model model, @AuthenticationPrincipal UserDetails user) {

    	Optional<Empleado> elUsuario = empleadoRepo.findUserByUsername(user.getUsername());
    	
		Empleado empl = elUsuario.get();

		if (empl.getRole().equals("ADMIN")) {
			//model.addAttribute("usuario", elUsuario.get());
			return "dashboard/admin/admin";
		} else {
			//model.addAttribute("usuario", elUsuario.get());
			return "admin/user/user";
		}
	}
    
    

/*
	@GetMapping("/error")
	public String error() {
		return "error404";
	}
*/
	
}
