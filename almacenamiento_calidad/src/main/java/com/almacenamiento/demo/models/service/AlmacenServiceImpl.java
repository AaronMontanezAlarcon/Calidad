package com.almacenamiento.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almacenamiento.demo.models.entity.Almacen;
import com.almacenamiento.demo.models.repository.AlmacenRepository;

@Service
public class AlmacenServiceImpl implements IAlmacenService {
	
	
	
	
	@Autowired
	private AlmacenRepository almacenRepository;
	
	@Override
	public List<Almacen> listarAlmacen() {
		
		return (List<Almacen>) almacenRepository.findAll();
	}

	@Override
	public void guardar(Almacen almacen) {
		almacenRepository.save(almacen);

	}

	@Override
	public Almacen buscarAlmacen(Long id) {
		return almacenRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		almacenRepository.deleteById(id);
	}
	@Override
	public Boolean verificarExisteCategoria(String nombre) {
		List<Almacen> lista = almacenRepository.findBynombrealmacen(nombre);
		Boolean rpta;
		if(lista.size()==0) {
			rpta = true;			
		}else {
			rpta = false;
		}
		return rpta;
	}

	@Override
	public List<Almacen> listarAlmacen2(Long id) {
		return (List<Almacen>) almacenRepository.findByidalmacenes(id);
	}


}
