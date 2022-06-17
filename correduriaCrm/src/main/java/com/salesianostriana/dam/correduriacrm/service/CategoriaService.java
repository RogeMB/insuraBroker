package com.salesianostriana.dam.correduriacrm.service;

import com.salesianostriana.dam.correduriacrm.model.Categoria;
import com.salesianostriana.dam.correduriacrm.model.Cliente;
import com.salesianostriana.dam.correduriacrm.repository.ICategoriaRepository;
import com.salesianostriana.dam.correduriacrm.repository.IVentaRepository;
import com.salesianostriana.dam.correduriacrm.service.baseservice.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService extends BaseService<Categoria, Long, ICategoriaRepository> {
	
	@Autowired
	private SeguroService seguroService;
	
	public CategoriaService (ICategoriaRepository repositorioCategoria) {
		super(repositorioCategoria);
	}


	public boolean deleteCategoria(Categoria categoria) {
		boolean resultado = seguroService.comprobarSeguroCategoria(categoria);
			
			if (resultado)
				resultado = false;
			else {
				try {				
					repositorio.deleteById(categoria.getIdCategoria());
					resultado = true;
				} catch(IllegalArgumentException e) {
					return false;
				}
			}
			return resultado;			
	}


	public boolean editCategoria(Categoria categoria) {
		boolean resultado;
		try {				
			repositorio.save(categoria);
			resultado = true;
		} catch(IllegalArgumentException e) {
			return false;
		}
		return resultado;
	}
	
}