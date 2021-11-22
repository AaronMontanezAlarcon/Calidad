package com.almacenamiento.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.almacenamiento.demo.models.entity.Categoria;
import com.almacenamiento.demo.models.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public List<Categoria> listarCategoria() {
	
		return (List<Categoria>) categoriaRepository.findAll();
	}

	@Override
	public void guardar(Categoria categoria) {
		
		categoriaRepository.save(categoria);	
	}

	@Override
	public Categoria buscarCategoria(Long id) {
		
		return categoriaRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		categoriaRepository.deleteById(id);
		
	}

	@Override
	public Boolean verificarExisteCategoria(String categorianombre) {
		List<Categoria> lista = categoriaRepository.findBycategorianombre(categorianombre);
		Boolean rpta;
		if(lista.size() == 0) {
			rpta = true;			
		}else {
			rpta = false;
		}
		return rpta;
	}

	

	
	
}
