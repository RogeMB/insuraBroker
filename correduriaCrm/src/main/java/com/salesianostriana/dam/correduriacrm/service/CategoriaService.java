package com.salesianostriana.dam.correduriacrm.service;

import com.salesianostriana.dam.correduriacrm.model.Categoria;
import com.salesianostriana.dam.correduriacrm.repository.ICategoriaRepository;
import com.salesianostriana.dam.correduriacrm.service.baseservice.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoriaService extends BaseService<Categoria, Long, ICategoriaRepository> {
	
	@Autowired
	private ICategoriaRepository categoriaRepository;
}