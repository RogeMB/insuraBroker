package com.salesianostriana.dam.correduriacrm.service;

import com.salesianostriana.dam.correduriacrm.model.Cliente;
import com.salesianostriana.dam.correduriacrm.repository.IClienteRepository;
import com.salesianostriana.dam.correduriacrm.service.baseservice.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteService extends BaseService<Cliente, Long, IClienteRepository>{
	
	@Autowired
	private IClienteRepository clienteRepository;
	
}