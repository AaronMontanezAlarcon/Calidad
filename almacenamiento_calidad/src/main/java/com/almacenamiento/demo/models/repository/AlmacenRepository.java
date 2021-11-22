package com.almacenamiento.demo.models.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.almacenamiento.demo.models.entity.Almacen;

@Repository
public interface AlmacenRepository extends CrudRepository<Almacen, Long> {

	public List<Almacen> findBynombrealmacen(String nombre);
	public List<Almacen> findByidalmacenes(Long idalmacen);
	
	
}
