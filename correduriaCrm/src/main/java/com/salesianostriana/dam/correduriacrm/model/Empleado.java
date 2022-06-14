package com.salesianostriana.dam.correduriacrm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empleado {

	private Long idEmpleado;
	
    private String nombre;

    private String apellidos;

    private String dni;
    
    private String imagen;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;
    
    private String username;
    
    private String password;
    
    private String role;

    private String telefono;

    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaAlta;

    private String Cargo;

    private Double Salario;
    
	public String getImagen() {
		if (imagen == null) {
			return "https://robohash.org/"+username;
		}
		return imagen;
	}
	
}
