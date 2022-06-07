package com.salesianostriana.dam.correduriacrm.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.salesianostriana.dam.correduriacrm.model.Venta;
import com.salesianostriana.dam.correduriacrm.repository.IVentaRepository;
import com.salesianostriana.dam.correduriacrm.service.baseservice.BaseService;

public class VentaService extends BaseService<Venta, Long, IVentaRepository>{
	
	@Autowired
	private IVentaRepository ventasRepository;
}
