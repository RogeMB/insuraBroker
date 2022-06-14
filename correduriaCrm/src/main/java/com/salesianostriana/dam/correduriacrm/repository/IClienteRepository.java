package com.salesianostriana.dam.correduriacrm.repository;

import com.salesianostriana.dam.correduriacrm.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IClienteRepository extends JpaRepository<Cliente, Long>{
	
	// contar número de clientes premium y devolverlos( Long)
	// calcular gasto medio de clientes y devolverlo (long)
}