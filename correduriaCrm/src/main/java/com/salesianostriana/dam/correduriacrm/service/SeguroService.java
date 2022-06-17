package com.salesianostriana.dam.correduriacrm.service;

import com.salesianostriana.dam.correduriacrm.model.Categoria;
import com.salesianostriana.dam.correduriacrm.model.Seguro;
import com.salesianostriana.dam.correduriacrm.repository.ISeguroRepository;
import com.salesianostriana.dam.correduriacrm.service.baseservice.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SeguroService extends BaseService<Seguro, Long, ISeguroRepository> {

	@Autowired
	private VentaService ventaService;
	
	public SeguroService (ISeguroRepository repositorioSeguro) {
		super(repositorioSeguro);
	}
	
	
	public boolean deleteSeguro(Seguro seguro) {

		boolean resultado = ventaService.comprobarVentasSeguro(seguro);
		
		if (resultado)
			resultado = false;
		else {
			try {				
				repositorio.deleteById(seguro.getIdSeguro());
				resultado = true;
			} catch(IllegalArgumentException e) {
				return false;
			}
		}
		return resultado;			
	}

	public boolean comprobarSeguroCategoria(Categoria categoria) {
		boolean exists = repositorio.existsByCategoria(categoria);
		return exists;
	}
	
}