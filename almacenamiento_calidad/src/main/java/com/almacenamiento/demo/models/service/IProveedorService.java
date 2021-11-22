package com.almacenamiento.demo.models.service;

import java.util.List;

import com.almacenamiento.demo.models.entity.Proveedor;

public interface IProveedorService {
	List<Proveedor> listaProveedor();
	public void guardar(Proveedor proveedor);
	public Proveedor buscarProveedor(Long id);
	public void eliminar(Long id);
	Boolean verificarExisteEmpleado(String ruc);
}
