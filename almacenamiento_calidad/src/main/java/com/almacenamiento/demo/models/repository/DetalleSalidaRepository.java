package com.almacenamiento.demo.models.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.almacenamiento.demo.models.entity.DetalleSalida;

@Repository
public interface DetalleSalidaRepository extends CrudRepository<DetalleSalida, Long>{
	
}
