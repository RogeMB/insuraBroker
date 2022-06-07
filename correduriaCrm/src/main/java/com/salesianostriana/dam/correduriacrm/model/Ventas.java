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
    
    @ManyToOne
    private Cliente idCliente;   

    @OneToOne(mappedBy="idVentas")
    private Seguros idSeguro;  // revisar relación
    
    private String empleado;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha_venta;

    private boolean esActivo;
    
    private double precioVenta;

    private double descuento;
    

}