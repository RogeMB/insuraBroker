package com.salesianostriana.dam.correduriacrm.repository;

import com.salesianostriana.dam.correduriacrm.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IClienteRepository extends JpaRepository<Cliente, Long>{
	
	
	
	@Query("SELECT COUNT(c) FROM Cliente c WHERE c.esPremium = true")
	public int getClientesPremium();
}