package com.salesianostriana.dam.correduriacrm.service;

import com.salesianostriana.dam.correduriacrm.model.Categoria;
import com.salesianostriana.dam.correduriacrm.repository.ICategoriaRepository;
import com.salesianostriana.dam.correduriacrm.repository.IVentaRepository;
import com.salesianostriana.dam.correduriacrm.service.baseservice.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService extends BaseService<Categoria, Long, ICategoriaRepository> {
	
	
	public CategoriaService (ICategoriaRepository repositorioCategoria) {
		super(repositorioCategoria);
	}
	
}