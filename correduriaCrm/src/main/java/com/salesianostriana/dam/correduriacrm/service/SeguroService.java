package com.salesianostriana.dam.correduriacrm.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.salesianostriana.dam.correduriacrm.repository.ISeguroRepository;
import com.salesianostriana.dam.correduriacrm.model.Seguro;
import com.salesianostriana.dam.correduriacrm.service.baseservice.BaseService;

public class SeguroService extends BaseService<Seguro, Long, ISeguroRepository> {
	
	@Autowired
	private ISeguroRepository segurosRepository ;
	
}
