package com.almacenamiento.demo.models.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.almacenamiento.demo.models.entity.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	public List<Cliente> findBydnicliente (String nombre);
}
