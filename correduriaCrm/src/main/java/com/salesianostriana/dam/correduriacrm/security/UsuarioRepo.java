package com.salesianostriana.dam.correduriacrm.security;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepo {
	
	private List<Usuario> usuarios;

	public List<Usuario> getUsuarios() {
		return Collections.unmodifiableList(usuarios);
	}

	public Optional<Usuario> findUserByUsername(String username) {
		return usuarios.stream()
				.filter(u -> u.getUsername().equals(username))
				.findFirst();
	}
	
	@PostConstruct
	public void init() {
		usuarios = List.of(
				Usuario.builder()
					.username("admin")
					.password("admin")
					.role("ADMIN")
					.nombre("Rogelio")
					.apellidos("Mohigefer")
					.fechaNacimiento(LocalDate.of(1989, 6, 9))
					.build()
				,
				Usuario.builder()
				.username("user")
				.password("1234")
				.role("USER")
				.nombre("María")
				.apellidos("Troyano Ballesteros")
				.fechaNacimiento(LocalDate.of(1993, 3, 21))
				.build()
				,
				Usuario.builder()
				.username("eva")
				.password("eva")
				.role("USER")
				.nombre("Eva")
				.apellidos("Reyes Trigo")
				.fechaNacimiento(LocalDate.of(1993, 3, 21))
				.build()
				,
				Usuario.builder()
				.username("sergio")
				.password("sergio")
				.role("USER")
				.nombre("María")
				.apellidos("Jiménez Toledo")
				.fechaNacimiento(LocalDate.of(1993, 3, 21))
				.build()
				);
				
	}
	
}