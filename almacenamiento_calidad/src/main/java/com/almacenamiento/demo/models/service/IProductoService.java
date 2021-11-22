package com.almacenamiento.demo.models.service;

import java.util.List;

import com.almacenamiento.demo.models.entity.Producto;

public interface IProductoService {
	List<Producto> listaProductos();
	public void guardar(Producto producto );
	public Producto buscarProducto(Long id);
	public void eliminar(Long id);
	public List<Producto> finByNombre(String term);
	Boolean verificarExisteProducto(String nombre);
}
