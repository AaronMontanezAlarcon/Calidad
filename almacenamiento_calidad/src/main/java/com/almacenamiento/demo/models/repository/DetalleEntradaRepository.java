package com.almacenamiento.demo.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.almacenamiento.demo.models.entity.DetalleEntrada;
import com.almacenamiento.demo.models.entity.Producto;

@Repository
public interface DetalleEntradaRepository extends CrudRepository<DetalleEntrada, Long>{
	
}
