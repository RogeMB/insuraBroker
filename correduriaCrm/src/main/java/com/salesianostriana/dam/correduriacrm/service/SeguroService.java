package com.salesianostriana.dam.correduriacrm.service;

import com.salesianostriana.dam.correduriacrm.model.Seguro;
import com.salesianostriana.dam.correduriacrm.repository.ISeguroRepository;
import com.salesianostriana.dam.correduriacrm.service.baseservice.BaseService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeguroService extends BaseService<Seguro, Long, ISeguroRepository> {
	
	@Autowired
	private ISeguroRepository segurosRepository ;
	
	
	@Autowired
	private VentaService ventaService;
	
/*
	public boolean deleteSeguro(Seguro s) { //Seguro s

		boolean resultado = ventaService.comprobarVentasSeguro(s);
		
		if (resultado == true)
			
			resultado = false;
			// No se puede borrar
			// Devuelvo false y en la plantilla le digo al usuario que no se puede borrar
		else {
			//segurosRepository.deleteById(s);
			resultado = true;
			// borro el seguro
			// Devuelvo true
		}
		return resultado;			
	}
	
	*/
	
	
}