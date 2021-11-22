package com.almacenamiento.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almacenamiento.demo.models.entity.Producto;
import com.almacenamiento.demo.models.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService {
	
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public List<Producto> listaProductos() {
		return (List<Producto>) productoRepository.findAll();
	}

	@Override
	public void guardar(Producto producto) {
		productoRepository.save(producto);
		
	}

	@Override
	public Producto buscarProducto(Long id) {
		return productoRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		productoRepository.deleteById(id);
		
	}

	@Override
	public List<Producto> finByNombre(String term) {
		// TODO Auto-generated method stub
		return productoRepository.findByNombre(term);
	}

	@Override
	public Boolean verificarExisteProducto(String nombre) {
		List<Producto> lista = productoRepository.findBymarca(nombre);
		Boolean rpta;
		if(lista.size() == 0) {
			rpta = true;			
		}else {
			rpta = false;
		}
		return rpta;
	}

}
