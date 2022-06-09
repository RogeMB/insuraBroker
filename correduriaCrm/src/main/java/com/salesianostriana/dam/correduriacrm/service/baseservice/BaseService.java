package com.salesianostriana.dam.correduriacrm.service.baseservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class BaseService <T, ID, R extends JpaRepository<T, ID>> implements IBaseServiceable<T, ID> {

	@Autowired
	protected R repositorio;

	
	@Override
	public List<T> findAll() {
		return repositorio.findAll();
	}

	@Override
	public Optional<T> findByID(ID id) {
		return repositorio.findById(id);
		//return Optional.ofNullable(repositorio.findByID(id).orElse(null));
	}

	@Override
	public T save(T a) {
		return repositorio.save(a);
	}
	
	@Override
	public List<T> saveAll(List<T> list) {
		return repositorio.saveAll(list);
	}

	@Override
	public T edit(T t) {
		return save(t);
	}

	@Override
	public void delete(T t) {
		repositorio.delete(t);
	}

	@Override
	public void deleteByID(ID id) {
		repositorio.deleteById(id);
	}
	
}