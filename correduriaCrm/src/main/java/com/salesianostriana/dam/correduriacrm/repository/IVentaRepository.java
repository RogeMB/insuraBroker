package com.salesianostriana.dam.correduriacrm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.correduriacrm.model.Seguro;
import com.salesianostriana.dam.correduriacrm.model.Venta;


public interface IVentaRepository extends JpaRepository<Venta, Long>{

	
	// calcular suma de dinero ganado en el trimestre actual 
	// contar la suma de ventas totales 
	 // calcular la cantidad dinero ganado en el mes actual, calcular el del mes de un año atrás y devolver la diferencia en porcentaje
	
	
	//@Query("SELECT id_seguro FROM venta v WHERE v.es_activo is true", nativeQuery=true)
	//public List<Venta> getVentasActivas();
	
	public boolean existBySeguro(Optional<Seguro> seguro);
	
	
	
	/*
	 * @Query("select * from venta v ")
	public String getVenta();
	*/
}