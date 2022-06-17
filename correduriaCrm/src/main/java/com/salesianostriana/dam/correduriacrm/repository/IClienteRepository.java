package com.salesianostriana.dam.correduriacrm.repository;

import com.salesianostriana.dam.correduriacrm.model.Cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IClienteRepository extends JpaRepository<Cliente, Long>{
		
	@Query("SELECT COUNT(c) FROM Cliente c WHERE c.esPremium = true")
	public int getClientesPremium();

	public List<Cliente> findByNombreContainsIgnoreCaseOrApellidosContainsIgnoreCase(
			String nombre, String apellidos);
}