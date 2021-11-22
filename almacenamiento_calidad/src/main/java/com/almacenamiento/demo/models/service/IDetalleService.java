package com.almacenamiento.demo.models.service;

import java.util.List;


import com.almacenamiento.demo.models.entity.DetalleEntrada;

public interface IDetalleService {
	public List<DetalleEntrada> listarDetalle();
	public void guardar(DetalleEntrada detalleEntrada);
	public DetalleEntrada buscarDetalle(Long id);
	public void eliminar(Long id);
}
