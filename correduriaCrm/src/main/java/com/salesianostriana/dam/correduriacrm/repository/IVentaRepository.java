package com.salesianostriana.dam.correduriacrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.salesianostriana.dam.correduriacrm.model.Venta;
import org.springframework.stereotype.Repository;


public interface IVentaRepository extends JpaRepository<Venta, Long>{

}