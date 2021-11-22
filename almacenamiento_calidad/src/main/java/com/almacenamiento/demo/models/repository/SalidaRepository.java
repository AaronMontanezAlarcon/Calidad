package com.almacenamiento.demo.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.almacenamiento.demo.models.entity.Salida;

public interface SalidaRepository extends CrudRepository<Salida, Long>{
	@Query("select max(id_salida) from Salida")
	public Long findBySalida();
}
