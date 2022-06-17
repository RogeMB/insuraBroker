package com.salesianostriana.dam.correduriacrm.repository;

import com.salesianostriana.dam.correduriacrm.model.Categoria;
import com.salesianostriana.dam.correduriacrm.model.Seguro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISeguroRepository extends JpaRepository<Seguro, Long> {

	boolean existsByCategoria(Categoria categoria);
	
	

	
	
// contar el tipo de seguro más vendido y devlverlo (string)
	// contar la empresa más vendida y devolerla (string)
}