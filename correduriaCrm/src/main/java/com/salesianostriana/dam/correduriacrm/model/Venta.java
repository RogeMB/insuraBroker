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
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idVenta;
    
    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;   

    @ManyToOne    
    @JoinColumn(name="id_seguro")
    private Seguro seguro;
    
    private String empleado;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha_venta;

    private boolean esActivo;
    
    private double precioVenta;
    
    @Column(nullable = true)
    private double descuento; 
    
    
    // helpers
    public void addToCliente(Cliente client) { 
		this.setCliente(client);
		client.getVentas().add(this);
	}
	
	public void removeFromCliente(Cliente client) {
		this.setCliente(client);
		client.getVentas().remove(this);
	}
	
}