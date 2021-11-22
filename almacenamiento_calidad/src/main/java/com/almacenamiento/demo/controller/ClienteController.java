package com.almacenamiento.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.almacenamiento.demo.models.entity.Cliente;
import com.almacenamiento.demo.models.service.IClienteService;



@Controller
@RequestMapping("/modulos/administracion")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/cliente")
	public String listarCliente(Model model) {
		List<Cliente> listarClientes = clienteService.listarCliente();
		model.addAttribute("titulo","Lista de Cliente");
		model.addAttribute("clientes", listarClientes);

		return "/modulos/administracion/cliente";
	}
	
	@PostMapping("/savecliente")
	public String guardar(@Valid @ModelAttribute("clientes") Cliente cliente,BindingResult result, Model model,RedirectAttributes flash) {
		if(result.hasErrors()) {
			model.addAttribute("titulo","Agregar Cliente");
			model.addAttribute("clientes", cliente);

			return "/modulos/administracion/agregarcliente";
		}
		if(clienteService.verificarExisteEmpleado(cliente.getDnicliente())) {
			  
			clienteService.guardar(cliente);		  
	  }else {
		  flash.addFlashAttribute("error", "El DNI del cliente no puede ser duplicado");
		  return "redirect:/modulos/administracion/cliente/";
	  }
		
		clienteService.guardar(cliente);
		return "redirect:/modulos/administracion/cliente/";
	}
	
	@GetMapping("/createcliente")
	public String crearCliente(Model model) {
		Cliente cliente= new Cliente();
		model.addAttribute("titulo","Agregar Cliente");
		model.addAttribute("clientes", cliente);

		return "/modulos/administracion/agregarcliente";
	}
	
	@GetMapping("/editcliente/{id}")
	public String editarCliente(@PathVariable("id") Long idCliente, Model model) {
		
		Cliente cliente= clienteService.buscarCliente(idCliente);
		model.addAttribute("titulo","Editar Cliente");
		model.addAttribute("clientes", cliente);

		return "/modulos/administracion/agregarcliente";
	}
}
