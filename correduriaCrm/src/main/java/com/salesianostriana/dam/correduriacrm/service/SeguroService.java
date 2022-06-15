package com.salesianostriana.dam.correduriacrm.service;

import com.salesianostriana.dam.correduriacrm.model.Seguro;
import com.salesianostriana.dam.correduriacrm.repository.ISeguroRepository;
import com.salesianostriana.dam.correduriacrm.repository.IVentaRepository;
import com.salesianostriana.dam.correduriacrm.service.baseservice.BaseService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeguroService extends BaseService<Seguro, Long, ISeguroRepository> {
	
	public SeguroService (ISeguroRepository repositorioSeguro) {
		super(repositorioSeguro);
	}
	
	
	/*
	@Autowired
	private ISeguroRepository segurosRepository ;
	*/
	
	@Autowired
	private VentaService ventaService;

	
	public boolean deleteSeguro(Seguro s) { //Seguro s

		boolean resultado = ventaService.comprobarVentasSeguro(s);
		
		if (resultado)
			resultado = false;
			// No se puede borrar
			// Devuelvo false y en la plantilla le digo al usuario que no se puede borrar
		else {
			try {				
				// borro el seguro
				// Devuelvo true
				repositorio.deleteById(s.getIdSeguro());
				resultado = true;
			} catch(IllegalArgumentException e) {
				return false;
			}
		}
		return resultado;			
	}
	

	
	
}