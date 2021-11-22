package com.almacenamiento.demo.models.service;

import java.util.List;


import com.almacenamiento.demo.models.entity.DetalleSalida;

public interface IDetalleSalidaService {
	
	public List<DetalleSalida> listarDetalleSalida();
	public void guardar(DetalleSalida detalleSalida);
	public DetalleSalida buscarDetalleSalida(Long id);
	public void eliminar(Long id);
}
