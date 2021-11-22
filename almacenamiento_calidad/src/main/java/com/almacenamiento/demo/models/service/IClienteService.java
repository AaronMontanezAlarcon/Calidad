package com.almacenamiento.demo.models.service;

import java.util.List;


import com.almacenamiento.demo.models.entity.Cliente;
import com.almacenamiento.demo.models.entity.Producto;


public interface IClienteService {
	public List<Cliente> listarCliente();
	public void guardar(Cliente cliente);
	public Cliente buscarCliente(Long id);
	public void eliminar(Long id);
	
	public Producto findProductoById(Long id);
	public boolean verificarExisteEmpleado(String dnicliente);
}
