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
import com.salesianostriana.dam.correduriacrm.repository.ICategoriaRepository;
import com.salesianostriana.dam.correduriacrm.repository.ISeguroRepository;

@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    private EmpleadoRepository empleadoRepo;
    
    @Autowired
    private ICategoriaRepository categoriaRepo;
    
    @Autowired
    private ISeguroRepository seguroRepo;

    @GetMapping("/")
    public String adminIndex(Model model, @AuthenticationPrincipal UserDetails user) {

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
    public String adminTablesCat(Model model, @AuthenticationPrincipal UserDetails user) {

        Optional<Empleado> elUsuario = empleadoRepo.findUserByUsername(user.getUsername());
        
        categoriaRepo.findAll();
        
        if (elUsuario.isPresent()) {
            model.addAttribute("usuario", elUsuario.get());
            model.addAttribute("listaCategorias",  categoriaRepo.findAll());
        } else {
            return "error404";
        }
        
    	//user.getUsername()
        return "dashboard/admin/tablesCat";
    }
    
    
    @GetMapping("/tablesSeg")
    public String adminTablesSeg(Model model, @AuthenticationPrincipal UserDetails user) {

        Optional<Empleado> elUsuario = empleadoRepo.findUserByUsername(user.getUsername());
        
        categoriaRepo.findAll();
        
        if (elUsuario.isPresent()) {
            model.addAttribute("usuario", elUsuario.get());
            model.addAttribute("listaSeguros",  seguroRepo.findAll());
        } else {
            return "error404";
        }
        
    	//user.getUsername()
        return "dashboard/admin/tablesSeg";
    }
    
    
	/*
	 * 
	 * Autowired de cliente
	 * 
	@GetMapping("/cliente")
	public String addCliente () {
		
		return "dashboard/admin/clienteFormulario";  // desde templates la ruta a seguir donde quiero que se ejecute
	}
	
	@PostMapping("/addCliente")
	public String submitCliente(@ModelAttribute("clienteForm") Cliente cliente) {
		
		clienteService.save(cliente);
			return "dashboard/admin/tablas/cliente"; 			
	}	
	*/
	// PostMapping: objeto que se crea: modelAttribute("objeto") Objeto nuevo
	// El nombre dle modelAtribute será lo que ponga en el th:Object en el <form> 	
	
}
