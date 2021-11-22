package com.almacenamiento.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almacenamiento.demo.models.entity.DetalleEntrada;
import com.almacenamiento.demo.models.repository.DetalleEntradaRepository;

@Service
public class DetalleServiceImpl implements IDetalleService {

	@Autowired
	private DetalleEntradaRepository detalleEntradaRepository;
	
	@Override
	public List<DetalleEntrada> listarDetalle() {
		return (List<DetalleEntrada>) detalleEntradaRepository.findAll();
	}

	@Override
	public void guardar(DetalleEntrada detalleEntrada) {
		detalleEntradaRepository.save(detalleEntrada);
		
	}

	@Override
	public DetalleEntrada buscarDetalle(Long id) {
		return detalleEntradaRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		detalleEntradaRepository.deleteById(id);
		
	}
		
}
