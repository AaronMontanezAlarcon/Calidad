package com.almacenamiento.demo.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.almacenamiento.demo.models.entity.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {
	
	@Query("select p from Producto p where p.nombre like %?1%")
	public List< Producto> findByNombre(String term);
	public List< Producto> findBymarca(String term);
}
