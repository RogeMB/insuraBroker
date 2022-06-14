package com.salesianostriana.dam.correduriacrm.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.correduriacrm.model.Empleado;
import com.salesianostriana.dam.correduriacrm.repository.EmpleadoRepository;


@RequestMapping("/user")
@Controller
public class UserController {

	    //private static final Logger log = LoggerFactory.getLogger(AdminController.class);

	    @Autowired
	    private EmpleadoRepository empleadoRepo;

	    @GetMapping("/")
	    public String userIndex(Model model, @AuthenticationPrincipal UserDetails user) {

	        //model.addAttribute("usuario", user.getUsername());
	        Optional<Empleado> elUsuario = empleadoRepo.findUserByUsername(user.getUsername());
	        
	        if (elUsuario.isPresent()) {
	            model.addAttribute("usuario", elUsuario.get());
	            model.addAttribute("listaEmpleados", empleadoRepo.getEmpleados());
	        } else {
	            return "error404";
	        }

	        return "dashboard/admin/index";
	    }
	    
	    
	    @GetMapping("/tablesCat")
	    public String userTablesCat(Model model, @AuthenticationPrincipal UserDetails user) {

	    	//model.addAttribute("usuario", user.getUsername());
	        Optional<Empleado> elUsuario = empleadoRepo.findUserByUsername(user.getUsername());
	        
	        
	        if (elUsuario.isPresent()) {
	            model.addAttribute("usuario", elUsuario.get());
	            model.addAttribute("listaEmpleados", empleadoRepo.getEmpleados());
	        } else {
	            return "error404";
	        }
	        
	    	//user.getUsername()
	        return "dashboard/admin/tablesCat";
	    }
	   
}
