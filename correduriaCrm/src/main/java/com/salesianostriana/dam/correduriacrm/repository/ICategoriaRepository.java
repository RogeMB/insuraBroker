package com.salesianostriana.dam.correduriacrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.salesianostriana.dam.correduriacrm.model.Categoria;
import org.springframework.stereotype.Repository;


public interface ICategoriaRepository extends JpaRepository<Categoria, Long> {

}