package com.salesianostriana.dam.correduriacrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.salesianostriana.dam.correduriacrm.model.Ventas;
import org.springframework.stereotype.Repository;


public interface IVentasRepository extends JpaRepository<Ventas, Long>{

}