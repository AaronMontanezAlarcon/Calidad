package com.almacenamiento.demo.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.almacenamiento.demo.models.entity.DetalleEntrada;
import com.almacenamiento.demo.models.entity.Entrada;

@Repository
public interface EntradaRepository extends CrudRepository<Entrada, Long> {
	@Query("select max(id_entrada) from Entrada")
	public Long findByEntrada();
}
