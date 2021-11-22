package com.almacenamiento.demo.models.service;

import java.util.List;

import com.almacenamiento.demo.models.entity.Asignar;


public interface IAsignarService {
	
	List<Asignar> listaAsignar();
	public void guardar(Asignar asignar);
	Boolean verificarExisteAsignado(Long idalmacenes, Long idproductos);
	List <Asignar> verificarCantidadAsignado(Long idalmacenes, Long idproductos);
	List<Asignar> listaAsignadosAlmacen(Long idalmacenes);
	public void update(int cantidad,Long idalmacenes, Long idproductos);
	public void updatesalida(int cantidad,Long idalmacenes, Long idproductos);
}
