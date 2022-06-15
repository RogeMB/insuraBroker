package com.salesianostriana.dam.correduriacrm.service;

import com.salesianostriana.dam.correduriacrm.model.Cliente;
import com.salesianostriana.dam.correduriacrm.repository.IClienteRepository;
import com.salesianostriana.dam.correduriacrm.repository.IVentaRepository;
import com.salesianostriana.dam.correduriacrm.service.baseservice.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteService extends BaseService<Cliente, Long, IClienteRepository>{
	
	public ClienteService (IClienteRepository repositorioCliente) {
		super(repositorioCliente);
	}
	

	public long getNumeroDeClientes() {
		long numeroDeClientes = repositorio.count();
		return numeroDeClientes;
	}
	
	
}