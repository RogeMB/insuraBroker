package com.salesianostriana.dam.correduriacrm.repository;

import com.salesianostriana.dam.correduriacrm.model.Empleado;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class EmpleadoRepository {
	private List<Empleado> empleados;

	public List<Empleado> getEmpleados() {
		return Collections.unmodifiableList(empleados);
	}

	
	public Optional<Empleado> findUserByUsername(String username) {
		return empleados.stream()
				.filter(u -> u.getUsername().equals(username))
				.findFirst();
	}
	
	
	@PostConstruct
	public void init() {
		empleados = List.of(
				Empleado.builder()
				.nombre("Rogelio")
				.apellidos("Mohigefer Barrera")
				.dni("11122233Q")
				.imagen(null)
				.fechaNacimiento(LocalDate.of(1989, 6, 9))
				.username("admin")
				.password("admin")
				.role("ADMIN")
				.telefono("612312323")
				.email("rogelio@gmail.com")
				.fechaAlta(LocalDate.of(2020, 1, 1))
				.Cargo("Director")
				.Salario(40500.00)
				.build()
				,
				Empleado.builder()
				.nombre("María")
				.apellidos("Troyano Ballesteros")
				.dni("31212351A")
				.imagen(null)
				.fechaNacimiento(LocalDate.of(1993, 3, 21))
				.username("user")
				.password("1234")
				.role("USER")
				.telefono("687941358")
				.email("mariatroyano@gmail.com")
				.fechaNacimiento(LocalDate.of(2020, 3, 18))
				.Cargo("Asesor")
				.Salario(35850.00)
				.build()
				,
				Empleado.builder()
				.nombre("Sergio")
				.apellidos("Jiménez Toledo")
				.dni("22122122R")
				.imagen(null)
				.fechaNacimiento(LocalDate.of(1990, 7, 15))
				.username("sergio")
				.password("user1234")
				.role("USER")
				.telefono("645894561")
				.email("sergiojimenez@gmail.com")
				.fechaAlta(LocalDate.of(2020, 2, 12))
				.Cargo("Gestor")
				.Salario(23350.00)
				.build()
				,
				Empleado.builder()
				.nombre("Eva")
				.apellidos("Reyes Trigo")
				.dni("75516387J")
				.imagen(null)
				.fechaNacimiento(LocalDate.of(1998, 12, 4))
				.username("eva")
				.password("user1234")
				.role("USER")
				.telefono("678159753")
				.email("evareyes@gmail.com")
				.fechaAlta(LocalDate.of(2020,  5, 9))
				.Cargo("Gestor")
				.Salario(20350.00)
				.build()
				);
				
	}
}
