package com.almacenamiento.demo.models.service;

import java.util.List;


import com.almacenamiento.demo.models.entity.DetalleEntrada;
import com.almacenamiento.demo.models.entity.Entrada;

public interface IEntradaService {
	
	public List<Entrada> listarEntrada();
	public void guardar(Entrada entrada);
	public void eliminar(Long id);
	public Long encontrarID();
}
