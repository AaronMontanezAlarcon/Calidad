package com.almacenamiento.demo.models.service;

import java.util.List;

import com.almacenamiento.demo.models.entity.Almacen;

public interface IAlmacenService {
	
	public List<Almacen> listarAlmacen();
	public List<Almacen> listarAlmacen2(Long id);
	public void guardar(Almacen almacen);
	public Almacen buscarAlmacen(Long id);
	public void eliminar(Long id);
	public Boolean verificarExisteCategoria(String nombre);
	
	
}
