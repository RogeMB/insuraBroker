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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
	private Categoria idCategoria;  //categoria categoria_id_categoria

    private String tipo;

    private double cantidadAsegurada;

    private double precio;
    
    private String empresa;

    private String icono;
    
    @OneToOne
    @JoinColumn(name="id_venta")  // ¿Correcto? ¿debo añadirlo a la base de datos?
    private Ventas idVenta;


}