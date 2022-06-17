package com.salesianostriana.dam.correduriacrm.repository;

import java.time.LocalDate;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.correduriacrm.model.Cliente;
import com.salesianostriana.dam.correduriacrm.model.Seguro;
import com.salesianostriana.dam.correduriacrm.model.Venta;


public interface IVentaRepository extends JpaRepository<Venta, Long>{
	
	 // TODO calcular la cantidad dinero ganado en el mes actual, calcular el del mes de un año atrás y devolver la diferencia en porcentaje
	
	@Query("SELECT SUM(v.precioVenta) FROM Venta v WHERE v.fecha_venta < (CURRENT_DATE) AND v.fecha_venta > DATEADD('MONTH',-3, CURRENT_DATE)")
	public Long getDineroTrimestre();

	@Query("SELECT SUM(v.precioVenta) FROM Venta v WHERE v.fecha_venta > :creationDateTime AND v.fecha_venta <= (CURRENT_DATE)")
    public Long getVentasAnno(@Param("creationDateTime") LocalDate creationDateTime);
  
	
	public boolean existsBySeguro(Seguro seguro);

	public boolean existsByCliente(Cliente cliente);
	
	/*
	@Query("SELECT id_seguro FROM venta v WHERE v.es_activo = true")
	public List<Venta> getVentasActivas();
	*/

}