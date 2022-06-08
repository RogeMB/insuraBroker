package com.salesianostriana.dam.correduriacrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.correduriacrm.model.Cliente;
import com.salesianostriana.dam.correduriacrm.service.ClienteService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/cliente")
	public String addCliente () {
		
		return "dashboard/admin/clienteFormulario";  // desde templates la ruta a seguir donde quiero que se ejecute
	}
	
	@PostMapping("/addCliente")
	public String submitCliente(@ModelAttribute("clienteForm") Cliente cliente) {
		
		clienteService.save(cliente);
			return "dashboard/admin/tablas/cliente"; 			
	}	
	
	// PostMapping: objeto que se crea: modelAttribute("objeto") Objeto nuevo
	// El nombre dle modelAtribute será lo que ponga en el th:Object en el <form> 
	
	
	
}
