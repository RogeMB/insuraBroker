package com.salesianostriana.dam.correduriacrm.repository;

import com.salesianostriana.dam.correduriacrm.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IVentaRepository extends JpaRepository<Venta, Long>{

	
	// calcular suma de dinero ganado en el trimestre actual 
	// contar la suma de ventas totales 
	 // calcular la cantidad dinero ganado en el mes actual, calcular el del mes de un año atrás y devolver la diferencia en porcentaje
	
	
	
	
	
	
	/*
	 * @Query("select * from venta")
	public String getVenta();
	*/
}