package com.salesianostriana.dam.correduriacrm.controller;

import java.util.Optional;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.correduriacrm.model.Categoria;
import com.salesianostriana.dam.correduriacrm.model.Cliente;
import com.salesianostriana.dam.correduriacrm.model.Empleado;
import com.salesianostriana.dam.correduriacrm.model.Seguro;
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
    
    private final VentaService ventaService;

    @GetMapping("/")
    public String adminIndex(Model model, @AuthenticationPrincipal UserDetails user) {
    	
    	Optional<Empleado> elUsuario = empleadoService.findUserByUsername(user.getUsername());
        
        if (elUsuario.isPresent()) {
        	long numeroDeClientes = clienteService.getNumeroDeClientes();
        	double dineroTrimestre = ventaService.calcularVentasTrimestre();
        	//long dineroGanado = ventaService.getDineroGanado();
        	
        	model.addAttribute("usuario", elUsuario.get());
    		model.addAttribute("listaEmpleados", empleadoService.getEmpleados());
    		model.addAttribute("ventasTrimestre", dineroTrimestre);
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
    
    
    @GetMapping("/venta")
    public String adminVentas(Model model, @AuthenticationPrincipal UserDetails user) {
    	
    	Optional<Empleado> elUsuario = empleadoService.findUserByUsername(user.getUsername());
        
        if (elUsuario.isPresent()) {
        	model.addAttribute("usuario", elUsuario.get());
    		model.addAttribute("listaVentas", ventaService.findAll());	
    		return "dashboard/admin/venta";
        } else {
            return "error404";
        }
    }
    
   
	@GetMapping("/eliminar/{element}/{id}")
	public String borrar (@PathVariable("id") Long id, @PathVariable("element") String element) {
		Optional<Seguro> seguro = seguroService.findByID(id);
		Optional<Cliente> cliente = clienteService.findByID(id);
		Optional<Categoria> categoria = categoriaService.findByID(id);
		
		switch(element) {
			case "seguro":
				if (seguro.isPresent()) {
					seguroService.deleteSeguro(seguro.get());
					return "redirect:/admin/tables/seguro/?success=true";
				} else {
					return "redirect:/admin/tables/seguro/?error=true";
				}	
			case "cliente":
				if (cliente.isPresent()) {
					clienteService.deleteByID(id);
					return "redirect:/admin/tables/cliente/?success=true";
				} else {	
					return "redirect:/admin/tables/cliente/?error=true";
				}
			case "categoria":
				if (categoria.isPresent()) {
					categoriaService.deleteByID(id);
					return "redirect:/admin/tables/categoria/?success=true";
				} else {
					return "redirect:/admin/tables/categoria/?error=true";
				}
				
			default:
				return "dashboard/admin/index";

		}
		
	}
	
 
	@GetMapping("/eliminar/venta/{id}")
	public String eliminarVenta(@PathVariable("id") Long id, Model model) {
		// System.out.print(ventaService.buscarVentasActivas());
		ventaService.deleteByID(id);
		return "redirect:/admin/venta/?success=true";
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
