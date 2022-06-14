package com.salesianostriana.dam.correduriacrm.service.baseservice;

import java.util.List;
import java.util.Optional;

public interface IBaseServiceable <T, ID>{
	
	T save(T t);
	
	List<T> saveAll(List<T> list);

	Optional<T> findByID (ID id);
	
	List<T> findAll();
	
	T edit (T t);
	
	void delete (T t);
	
	void deleteByID (ID id);

}
