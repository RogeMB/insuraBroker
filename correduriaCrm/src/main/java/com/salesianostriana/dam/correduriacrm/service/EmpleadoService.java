package com.salesianostriana.dam.correduriacrm.service;

import com.salesianostriana.dam.correduriacrm.repository.IEmpleadoRepository;
import com.salesianostriana.dam.correduriacrm.model.Empleado;
import com.salesianostriana.dam.correduriacrm.service.baseservice.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService extends BaseService<Empleado, Long, IEmpleadoRepository> {
	
	@Autowired
    private IEmpleadoRepository empleadoRepository;
 
}