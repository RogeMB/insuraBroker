package com.salesianostriana.dam.correduriacrm.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.correduriacrm.model.Cliente;
import com.salesianostriana.dam.correduriacrm.model.Seguro;
import com.salesianostriana.dam.correduriacrm.model.Venta;
import com.salesianostriana.dam.correduriacrm.repository.IVentaRepository;
import com.salesianostriana.dam.correduriacrm.service.baseservice.BaseService;

@Service
public class VentaService extends BaseService<Venta, Long, IVentaRepository>{

	public VentaService(IVentaRepository repositorioVenta) {
		super(repositorioVenta);
	}
	
	
	public boolean comprobarVentasSeguro(Seguro seguro) {
		boolean exists = repositorio.existsBySeguro(seguro);
		return exists;
	}

	public double calcularVentasTrimestre() {
		return repositorio.getDineroTrimestre();
	}
	
	
	public double calcularVentasAnno() {
		return repositorio.getVentasAnno(LocalDate.of(2022, 1, 1));
	}

	public boolean comprobarVentasCliente(Cliente cliente) {
		boolean exists = repositorio.existsByCliente(cliente);
		return exists;
	}
	
	public double calcularMediaGastoCliente () {
		
		double totalVentas= 0.0;
		for (Venta venta : findAll()) {
			totalVentas+=venta.getPrecioVenta();
		}
		
		double resultado = totalVentas/findAll().size();
		return resultado;
	}



	public double calcularPrecioVenta(Venta venta) {
		int cantidadSegurosCliente = venta.getCliente().getVentas().size();
		double precioSeguro = venta.getSeguro().getPrecio();
		
		double descuento = 0;
		if (cantidadSegurosCliente > 1) {
			descuento = 0.75;
		} else if (cantidadSegurosCliente > 2) {
			descuento = 0.65;
		} else {
			descuento = 1;
		}
		
		double precioVenta = (precioSeguro * 1.21) * descuento;
		return precioVenta;
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
}

