package com.salesianostriana.dam.correduriacrm.service;

import com.salesianostriana.dam.correduriacrm.model.Cliente;
import com.salesianostriana.dam.correduriacrm.repository.IClienteRepository;
import com.salesianostriana.dam.correduriacrm.service.baseservice.BaseService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteService extends BaseService<Cliente, Long, IClienteRepository>{
	
	@Autowired
	private VentaService ventaService;
	
	public ClienteService (IClienteRepository repositorioCliente) {
		super(repositorioCliente);
	}
	
	
	public long getNumeroDeClientes() {
		long numeroDeClientes = repositorio.count();
		return numeroDeClientes;
	}

	public boolean deleteCliente(Cliente cliente) {
		boolean resultado = ventaService.comprobarVentasCliente(cliente);
		
		if (resultado)
			resultado = false;
		else {
			try {				
				repositorio.deleteById(cliente.getIdCliente());
				resultado = true;
			} catch(IllegalArgumentException e) {
				return false;
			}
		}
		return resultado;			
	}
	
	
	public int getNumeroClientesPreium( ) {
		return repositorio.getClientesPremium();
	}


	public List<Cliente> buscarPorNombreApellidos (String nombre, String apellidos) {
		return repositorio.findByNombreContainsIgnoreCaseOrApellidosContainsIgnoreCase(nombre, apellidos);
	}
	
}