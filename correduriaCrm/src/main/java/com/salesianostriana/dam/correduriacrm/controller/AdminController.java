package com.salesianostriana.dam.correduriacrm.controller;

import java.util.Optional;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.correduriacrm.model.Empleado;
import com.salesianostriana.dam.correduriacrm.service.CategoriaService;
import com.salesianostriana.dam.correduriacrm.service.ClienteService;
import com.salesianostriana.dam.correduriacrm.service.EmpleadoService;
import com.salesianostriana.dam.correduriacrm.service.SeguroService;
import com.salesianostriana.dam.correduriacrm.service.VentaService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/admin")
@Controller
@RequiredArgsConstructor
public class AdminController {

	private final EmpleadoService empleadoService;
	
    private final CategoriaService categoriaService;
    
    private final SeguroService seguroService;
    
    private final ClienteService clienteService;
    
   // private final VentaService ventaService;

    @GetMapping("/")
    public String adminIndex(Model model, @AuthenticationPrincipal UserDetails user) {
    	
    	Optional<Empleado> elUsuario = empleadoService.findUserByUsername(user.getUsername());
        
        if (elUsuario.isPresent()) {
        	long numeroDeClientes = clienteService.getNumeroDeClientes();
        	//long dineroGanado = ventaService.getDineroGanado();
        	
        	model.addAttribute("usuario", elUsuario.get());
    		model.addAttribute("listaEmpleados", empleadoService.getEmpleados());
    		
    		model.addAttribute("numeroDeClientes", numeroDeClientes);
    		//model.addAttribute("dineroGanado", dineroGanado);
    		
    		return "dashboard/admin/index";
        } else {
            return "error404";
        }
    }
    
    @GetMapping("/tables/{nav}")
    public String adminTablesCat(@PathVariable("nav") String nav,  Model model, @AuthenticationPrincipal UserDetails user) {
    	
    	Optional<Empleado> elUsuario = empleadoService.findUserByUsername(user.getUsername());
        
        if (elUsuario.isPresent()) {
        	if ("categoria".equals(nav)) {
        		model.addAttribute("usuario", elUsuario.get());
	            model.addAttribute("listaCategorias", categoriaService.findAll());
	            return "dashboard/admin/tablesCat";
        	} else if ("seguro".equals(nav)) {
        		model.addAttribute("usuario", elUsuario.get());
                model.addAttribute("listaSeguros", seguroService.findAll());
                return "dashboard/admin/tablesSeg";
        	} else if ("cliente".equals(nav)) {
        		model.addAttribute("usuario", elUsuario.get());
        		model.addAttribute("listaClientes", clienteService.findAll());
        		return "dashboard/admin/tablesCli";
        	} else {
        		model.addAttribute("usuario", elUsuario.get());
        		model.addAttribute("listaEmpleados", empleadoService.getEmpleados());
        		return "dashboard/admin/index";
        	}
        } else {
            return "error404";
        }
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
