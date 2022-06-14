package com.salesianostriana.dam.correduriacrm.service;

import com.salesianostriana.dam.correduriacrm.model.Venta;
import com.salesianostriana.dam.correduriacrm.repository.ISeguroRepository;
import com.salesianostriana.dam.correduriacrm.repository.IVentaRepository;
import com.salesianostriana.dam.correduriacrm.service.baseservice.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService extends BaseService<Venta, Long, IVentaRepository>{
	
	@Autowired
	private IVentaRepository ventasRepository;
	
	@Autowired
	private ISeguroRepository seguroRepository;
/*
	public long getDineroGanado() {
		String str = ventasRepository.getVenta();
		// ....
		return 220;
	}
*/

}

