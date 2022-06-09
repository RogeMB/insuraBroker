package com.salesianostriana.dam.correduriacrm.service;

import com.salesianostriana.dam.correduriacrm.model.Venta;
import com.salesianostriana.dam.correduriacrm.repository.IVentaRepository;
import com.salesianostriana.dam.correduriacrm.service.baseservice.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class VentaService extends BaseService<Venta, Long, IVentaRepository>{
	
	@Autowired
	private IVentaRepository ventasRepository;
}

