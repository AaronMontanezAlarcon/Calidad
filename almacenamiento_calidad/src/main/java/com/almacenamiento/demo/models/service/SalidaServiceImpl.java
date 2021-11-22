package com.almacenamiento.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almacenamiento.demo.models.entity.Salida;
import com.almacenamiento.demo.models.repository.SalidaRepository;

@Service
public class SalidaServiceImpl implements ISalidaService{

	@Autowired
	private SalidaRepository salidaRepository;
	@Override
	public List<Salida> listarSalida() {
		return (List<Salida>)salidaRepository.findAll();
	}

	@Override
	public void guardar(Salida salida) {
		salidaRepository.save(salida);
		
	}

	@Override
	public void eliminar(Long id) {
		salidaRepository.deleteById(id);
		
	}

	@Override
	public Long encontrarID() {
		return salidaRepository.findBySalida();
	}

}
