package com.almacenamiento.demo.models.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.almacenamiento.demo.models.entity.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
	public List<Categoria> findBycategorianombre (String categorianombre);
	

	
}
