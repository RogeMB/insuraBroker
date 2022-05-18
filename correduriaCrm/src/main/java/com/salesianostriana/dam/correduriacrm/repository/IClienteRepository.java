package com.salesianostriana.dam.correduriacrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.salesianostriana.dam.correduriacrm.model.Cliente;
import org.springframework.stereotype.Repository;


public interface IClienteRepository extends JpaRepository<Cliente, Long>{
}