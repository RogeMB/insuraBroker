package com.salesianostriana.dam.correduriacrm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idEmpleado;
	
    private String nombre;

    private String apellidos;

    private String dni;
    
    //private String imagen;

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
		if(username=="eva") {
			return "https://i.pinimg.com/originals/0d/0b/8d/0d0b8d1ff23860d87b5d2b2d0c94f449.jpg";
		}else if (username=="admin") {
			return "https://i.pinimg.com/originals/63/e0/85/63e0851e9ad6ede6aae2e765570e2123.jpg";
		}else if (username=="user") {
			return "https://i.pinimg.com/originals/7a/08/0b/7a080b24b19be93a5b423219fd38789e.jpg";
		}else if (username=="sergio") {
			return "https://i.pinimg.com/originals/e7/ef/9e/e7ef9eed6a30bdedf9b4466e0c4858b5.jpg";
		}
		return "https://robohash.org/"+username;
	}
	
}
