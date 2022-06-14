package com.salesianostriana.dam.correduriacrm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.correduriacrm.model.Empleado;
import com.salesianostriana.dam.correduriacrm.repository.EmpleadoRepository;

@Service
public class EmpleadoService {
	
	private final EmpleadoRepository empleadoRepo;
	
	public EmpleadoService(EmpleadoRepository empleadoRepo) {
		this.empleadoRepo = empleadoRepo;
	}
	
	public List<Empleado> getEmpleados() {
		return empleadoRepo.getEmpleados();
	}
	
	public Optional<Empleado> findUserByUsername(String username) {
		return empleadoRepo.findUserByUsername(username);
	}

}
