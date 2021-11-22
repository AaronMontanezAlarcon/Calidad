package com.almacenamiento.demo.models.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.almacenamiento.demo.models.entity.Cliente;
import com.almacenamiento.demo.models.entity.Producto;
import com.almacenamiento.demo.models.repository.ClienteRepository;
import com.almacenamiento.demo.models.repository.ProductoRepository;

@Service
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public List<Cliente> listarCliente() {
		return (List<Cliente>) clienteRepository.findAll();
	}

	@Override
	public void guardar(Cliente cliente) {
		clienteRepository.save(cliente);
		
	}

	@Override
	public Cliente buscarCliente(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		clienteRepository.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findProductoById(Long id) {
		// TODO Auto-generated method stub
		return productoRepository.findById(id).orElse(null) ;
	}

	@Override
	public boolean verificarExisteEmpleado(String dnicliente) {
		List<Cliente> lista = clienteRepository.findBydnicliente(dnicliente);
		Boolean rpta;
		if(lista.size() == 0) {
			rpta = true;			
		}else {
			rpta = false;
		}
		return rpta;		
	}

}
