package com.salesianostriana.dam.correduriacrm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seguros {
    
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idSeguro;
	
	@ManyToOne
	private Categoria categoria;  //idCategoria

    private String tipo;

    private double cantidadAsegurada;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaAlta;

    private String empresa;

    private String icono;


}