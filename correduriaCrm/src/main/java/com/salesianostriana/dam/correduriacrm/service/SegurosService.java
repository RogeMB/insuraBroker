package com.salesianostriana.dam.correduriacrm.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.salesianostriana.dam.correduriacrm.repository.ISegurosRepository;
import com.salesianostriana.dam.correduriacrm.model.Seguros;
import com.salesianostriana.dam.correduriacrm.service.baseservice.BaseService;

public class SegurosService extends BaseService<Seguros, Long, ISegurosRepository> {
	
	@Autowired
	private ISegurosRepository segurosRepository ;
	
}
