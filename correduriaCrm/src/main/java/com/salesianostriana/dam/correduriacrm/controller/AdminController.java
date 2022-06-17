package com.salesianostriana.dam.correduriacrm.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.correduriacrm.model.Categoria;
import com.salesianostriana.dam.correduriacrm.model.Cliente;
import com.salesianostriana.dam.correduriacrm.model.Empleado;
import com.salesianostriana.dam.correduriacrm.model.Seguro;
import com.salesianostriana.dam.correduriacrm.model.Venta;
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

    
    // index
    
    @GetMapping("/")
    public String adminIndex(Model model, @AuthenticationPrincipal UserDetails user) {
    	
    	Optional<Empleado> elUsuario = empleadoService.findUserByUsername(user.getUsername());
        
        if (elUsuario.isPresent()) {
        	long numeroDeClientes = clienteService.getNumeroDeClientes();
        	double dineroTrimestre = ventaService.calcularVentasTrimestre();
        	double dineroAnno = ventaService.calcularVentasAnno();
        	
        	model.addAttribute("usuario", elUsuario.get());
    		model.addAttribute("listaEmpleados", empleadoService.getEmpleados());
    		model.addAttribute("ventasTrimestre", dineroTrimestre);
    		model.addAttribute("numeroDeClientes", numeroDeClientes);
    		model.addAttribute("ventasAnno", dineroAnno);
    		return "dashboard/admin/index";
        } else {
            return "error404";
        }
    }
    
    // cualquier tabla
    
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
        		int numeroClientesPremium = clienteService.getNumeroClientesPreium();
        		double mediaGastoCliente = ventaService.calcularMediaGastoCliente();
        		model.addAttribute("usuario", elUsuario.get());
        		model.addAttribute("listaClientes", clienteService.findAll());
        		model.addAttribute("clientesPremium", numeroClientesPremium);
        		model.addAttribute("gastoMedio", mediaGastoCliente);
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
    
    // tabla ventas
    
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
    
    // eliminar cualquier entidad
    
	@GetMapping("/eliminar/{element}/{id}")
	public String borrar (@PathVariable("id") Long id, @PathVariable("element") String element) {
		Optional<Seguro> seguro = seguroService.findByID(id);
		Optional<Cliente> cliente = clienteService.findByID(id);
		Optional<Categoria> categoria = categoriaService.findByID(id);
		
		switch(element) {
			case "seguro":
				if (seguro.isPresent() && seguroService.deleteSeguro(seguro.get())) {
					return "redirect:/admin/tables/seguro/?success=true";
				} else {
					return "redirect:/admin/tables/seguro/?error=true";
				}	
			case "cliente":
				if (cliente.isPresent() && clienteService.deleteCliente(cliente.get())) {
					return "redirect:/admin/tables/cliente/?success=true";
				} else {	
					return "redirect:/admin/tables/cliente/?error=true";
				}
			case "categoria":
				if (categoria.isPresent() && categoriaService.deleteCategoria(categoria.get())) {
					return "redirect:/admin/tables/categoria/?success=true";
				} else {
					return "redirect:/admin/tables/categoria/?error=true";
				}
				
			default:
				return "error404";

		}		
	}
	 
	@GetMapping("/eliminar/venta/{id}")
	public String eliminarVenta(@PathVariable("id") Long id, Model model) {
		ventaService.deleteByID(id);
		return "redirect:/admin/venta/?success=true";
	}
	
	// crear categoría
    
	@GetMapping("/gestion/categoria")
	public String altaCategoria(Model model, @AuthenticationPrincipal UserDetails user) {
		Optional<Empleado> elUsuario = empleadoService.findUserByUsername(user.getUsername());
        
        if (elUsuario.isPresent()) {
      	
        	model.addAttribute("usuario", elUsuario.get());

        	model.addAttribute("categoria", new Categoria());
        	return "dashboard/admin/categoriaForm";
        } else {
        	return "error404";
        }
	}
	
	@PostMapping("/gestion/categoria/submit")
	public String submitCategoria(@ModelAttribute("categoria") Categoria categoria, Model model) {
		categoriaService.save(categoria);
	    return "redirect:/admin/tables/categoria";
	}
	
	// editar categoría
	
	@GetMapping("/editar/categoria/{id}")
	public String editarCategoria(@PathVariable Long id, Model model, @AuthenticationPrincipal UserDetails user) {
		Optional<Categoria> categoria = categoriaService.findByID(id);
		Optional<Empleado> elUsuario = empleadoService.findUserByUsername(user.getUsername());

        if (elUsuario.isPresent()){
        	model.addAttribute("usuario", elUsuario.get());
        	model.addAttribute("categoria", categoria);
        	return "dashboard/admin/categoriaEditForm";
        } else {
        	return "error404";
        }
	}
	
	@PostMapping("/editar/categoria")
	public String editar(@ModelAttribute("categoria") Categoria categoria) {
		categoriaService.edit(categoria);
		return "redirect:/admin/tables/categoria/?success=true";
	}
	

	
	// crear venta
	
	@GetMapping("/gestion/venta")
	public String annadirVenta(Model model, @AuthenticationPrincipal UserDetails user) {
		Optional<Empleado> elUsuario = empleadoService.findUserByUsername(user.getUsername());
        
        if (elUsuario.isPresent()) {
        	List<Cliente> clientes = clienteService.findAll();
        	List<Seguro> seguros = seguroService.findAll();
        	
        	model.addAttribute("usuario", elUsuario.get());
        	model.addAttribute("venta", new Venta());
        	
        	model.addAttribute("seguros", seguros);
        	model.addAttribute("clientes", clientes);
        	
        	model.addAttribute("fechaDia", LocalDate.now().format(DateTimeFormatter.ISO_DATE)); 
        	
        	return "dashboard/admin/ventaForm";
        } else {
        	return "error404";
        }
	}
	

	
	@PostMapping("/gestion/venta/submit")
	public String submitVenta(@ModelAttribute("venta") Venta venta, Model model, @AuthenticationPrincipal UserDetails user) {
		Optional<Empleado> elUsuario = empleadoService.findUserByUsername(user.getUsername());
	
		double precioVenta = ventaService.calcularPrecioVenta(venta);
		venta.setPrecioVenta(precioVenta);
		venta.setFecha_venta(LocalDate.now());
		venta.setEmpleado(elUsuario.get().getNombre());
		ventaService.save(venta);
	    return "redirect:/admin/venta";
	}
	
	// Buscar
	
	@GetMapping("/cliente/buscar")
	public String buscarCliente(@RequestParam("clienteSearch") String busqueda,  Model model, @AuthenticationPrincipal UserDetails user) {
		Optional<Empleado> elUsuario = empleadoService.findUserByUsername(user.getUsername());
		if(elUsuario.isPresent()) {
			int numeroClientesPremium = clienteService.getNumeroClientesPreium();
			double mediaGastoCliente = ventaService.calcularMediaGastoCliente();
			
			model.addAttribute("listaClientes", clienteService.buscarPorNombreApellidos(busqueda, busqueda));
			model.addAttribute("usuario", elUsuario.get());
			model.addAttribute("clientesPremium", numeroClientesPremium);
			model.addAttribute("gastoMedio", mediaGastoCliente);
			return "dashboard/admin/tablesCli";
		}else {
			return "error404";
		}
	
	}
	
}
