package com.salesianostriana.dam.correduriacrm.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.salesianostriana.dam.correduriacrm.model.Ventas;
import com.salesianostriana.dam.correduriacrm.repository.IVentasRepository;
import com.salesianostriana.dam.correduriacrm.service.baseservice.BaseService;

public class VentasService extends BaseService<Ventas, Long, IVentasRepository>{
	
	@Autowired
	private IVentasRepository ventasRepository;
}
