package com.salesianostriana.dam.correduriacrm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idVenta;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha_venta;

    private double precioVenta;

    private double descuento;

    @OneToOne
    private Seguros seguros;

    @ManyToOne
    private Cliente cliente;

    //@ManyToOne
    //private Empleado empleado;
    
    private String empleado;

}