package com.almacenamiento.demo.models.service;

import java.util.List;

import com.almacenamiento.demo.models.entity.Categoria;

public interface ICategoriaService {
	
	public List<Categoria> listarCategoria();
	public void guardar(Categoria categoria);
	public Categoria buscarCategoria(Long id);
	public void eliminar(Long id);
	public Boolean verificarExisteCategoria(String categorianombre);

	
	
}
