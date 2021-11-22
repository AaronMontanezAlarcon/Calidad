package com.almacenamiento.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.almacenamiento.demo.models.entity.Entrada;
import com.almacenamiento.demo.models.repository.EntradaRepository;

@Service
public class EntradaServiceImpl implements IEntradaService{

	@Autowired
	private EntradaRepository entradaRepository;
	
	@Override
	public List<Entrada> listarEntrada() {
		return (List<Entrada>)entradaRepository.findAll();
	}

	@Override
	public void guardar(Entrada entrada) {
		entradaRepository.save(entrada);
		
	}


	@Override
	public void eliminar(Long id) {
		entradaRepository.deleteById(id);
		
	}

	@Override
	public Long encontrarID() {
		return entradaRepository.findByEntrada();
	}

}
