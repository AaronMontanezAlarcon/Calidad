package com.almacenamiento.demo.models.service;

import java.util.List;


import com.almacenamiento.demo.models.entity.Salida;

public interface ISalidaService {
	
	public List<Salida> listarSalida();
	public void guardar(Salida salida);
	public void eliminar(Long id);
	public Long encontrarID();
}
