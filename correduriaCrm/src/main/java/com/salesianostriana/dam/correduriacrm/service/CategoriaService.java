package com.salesianostriana.dam.correduriacrm.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.salesianostriana.dam.correduriacrm.model.Categoria;
import com.salesianostriana.dam.correduriacrm.repository.ICategoriaRepository;
import com.salesianostriana.dam.correduriacrm.service.baseservice.BaseService;

public class CategoriaService extends BaseService<Categoria, Long, ICategoriaRepository> {
	
	@Autowired
	private ICategoriaRepository categoriaRepository;
}
