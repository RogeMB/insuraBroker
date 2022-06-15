package com.salesianostriana.dam.correduriacrm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.correduriacrm.model.Seguro;
import com.salesianostriana.dam.correduriacrm.model.Venta;
import com.salesianostriana.dam.correduriacrm.repository.ISeguroRepository;
import com.salesianostriana.dam.correduriacrm.repository.IVentaRepository;
import com.salesianostriana.dam.correduriacrm.service.baseservice.BaseService;

@Service
public class VentaService extends BaseService<Venta, Long, IVentaRepository>{
	
	@Autowired
	private IVentaRepository ventasRepository;
	
	@Autowired
	private ISeguroRepository seguroRepository;
	
	
	public boolean comprobarVentasSeguro(Optional<Seguro> seguro) {
		boolean resultado = false;
		
		if(ventasRepository.existBySeguro(seguro)) {
			resultado = true;
		}
		return resultado;		
	}
	
	/*
	public List<Venta> buscarVentasActivas() {
		List<Venta>ventas = findAll();
		List<Venta>ventasActivas = new ArrayList<>();
		
		for (Venta venta : ventas) {
			if(venta.isEsActivo()) {
				ventasActivas.add(venta);
			}
			
		}
	return ventasActivas;
	}
	*/
	
	/*
	public long getDineroGanado() {
		String str = ventasRepository.getVenta();
		// ....
		return 220;
	}
*/
}

