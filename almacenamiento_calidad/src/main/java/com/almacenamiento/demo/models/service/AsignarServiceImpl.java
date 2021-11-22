package com.almacenamiento.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almacenamiento.demo.models.entity.Asignar;

import com.almacenamiento.demo.models.repository.AsignarRepository;


@Service
public class AsignarServiceImpl implements IAsignarService {
	
	@Autowired
	private AsignarRepository asignarRepository;
	
	@Override
	public List<Asignar> listaAsignar() {
		return (List<Asignar>) asignarRepository.findAll();
	}

	@Override
	public void guardar(Asignar asignar) {
		asignarRepository.save(asignar);
		
	}

	@Override
	public Boolean verificarExisteAsignado(Long idalmacenes, Long idproductos) {
		List<Asignar> listaAsig = asignarRepository.findByAlmacenAndProducto(idalmacenes,idproductos);
		
		Boolean rpta;
		if(listaAsig.size() == 0) {
			rpta = true;			
		}else{
			rpta = false;
		}
		return rpta;
	}

	@Override
	public List<Asignar> listaAsignadosAlmacen(Long idalmacenes) {
		return (List<Asignar>) asignarRepository.findByAlmacen(idalmacenes);
	}

	@Override
	public void update(int cantidad, Long idalmacenes, Long idproductos) {
		asignarRepository.update(cantidad, idalmacenes, idproductos);
		
	}

	@Override
	public void updatesalida(int cantidad, Long idalmacenes, Long idproductos) {
		asignarRepository.updatesalida(cantidad, idalmacenes, idproductos);
		
	}

	@Override
	public List<Asignar> verificarCantidadAsignado(Long idalmacenes, Long idproductos) {
		List<Asignar> listaAsig = asignarRepository.findByAlmacenAndProducto(idalmacenes,idproductos);
		return listaAsig;
	}




}
