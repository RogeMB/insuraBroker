package com.salesianostriana.dam.correduriacrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.salesianostriana.dam.correduriacrm.model.Seguros;

public interface ISegurosRepository extends JpaRepository<Seguros, Long> {

}