package com.almacenamiento.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almacenamiento.demo.models.entity.Proveedor;
import com.almacenamiento.demo.models.repository.ProveedorRepository;


@Service
public class ProveedorServiceImpl implements IProveedorService {
	
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@Override
	public List<Proveedor> listaProveedor(){
		
		return (List<Proveedor>) proveedorRepository.findAll();
	}

	@Override
	public void guardar(Proveedor proveedor) {
		proveedorRepository.save(proveedor);
	}

	@Override
	public Proveedor buscarProveedor(Long id) {
		return proveedorRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		proveedorRepository.deleteById(id);
	}

	@Override
	public Boolean verificarExisteEmpleado(String ruc) {
		List<Proveedor> lista = proveedorRepository.findByruc(ruc);
		Boolean rpta;
		if(lista.size() == 0) {
			rpta = true;			
		}else {
			rpta = false;
		}
		return rpta;
	}
}
