package com.almacenamiento.demo.models.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.almacenamiento.demo.models.entity.Proveedor;

public interface ProveedorRepository extends CrudRepository<Proveedor, Long> {
	public List<Proveedor> findByruc (String ruc);
}
