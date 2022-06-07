package com.salesianostriana.dam.correduriacrm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCliente;

    private String nombre;

    private String apellidos;

    private String dni;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;

    private String telefono;

    private String email;
    
    private String genero;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaAlta;

    private boolean esPremium;

    @OneToMany(mappedBy="idVenta", fetch = FetchType.EAGER)  // qué hacía esto exactamente? ¿debo añadirlo a la base de datos?
    private List<Ventas> listaVentas;
    
    // helpers
    public void addVenta(Ventas vent) {  //van aquí estos helpers? 
		this.listaVentas.add(vent);
		vent.setIdCliente(this);
	}
	
	public void removeVenta(Ventas vent) {
		this.listaVentas.remove(vent);
		vent.setIdCliente(null);
	}


}