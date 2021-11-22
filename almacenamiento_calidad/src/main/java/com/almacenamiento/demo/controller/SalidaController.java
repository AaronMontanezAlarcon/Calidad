package com.almacenamiento.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.almacenamiento.demo.models.entity.Cliente;

import com.almacenamiento.demo.models.entity.Salida;
import com.almacenamiento.demo.models.service.IClienteService;
import com.almacenamiento.demo.models.service.ISalidaService;

@Controller
@RequestMapping("/modulos/administracion")
public class SalidaController {
	@Autowired
	private ISalidaService salidaService;
	@Autowired
	private IClienteService clienteService;
	
	@PostMapping("/savesalida")
	
	public String guardar(@Valid @ModelAttribute("salida") Salida salida,BindingResult result,Model model) {
		List<Cliente> listaClientes = clienteService.listarCliente();
		if(result.hasErrors()) {
		
			model.addAttribute("titulo","Salida de Productos");
			model.addAttribute("listaClientes", listaClientes);
			model.addAttribute("salida", salida);
			System.out.println("salidacontroller");
			
			return "/modulos/administracion/salidaproductos";
		}
		
		System.out.println(salidaService.encontrarID());
			model.addAttribute("titulo","Ingreso de Producto");
			model.addAttribute("listaProveedor", listaClientes);
			
			salidaService.guardar(salida);
		
		return "redirect:/modulos/administracion/createdetsalida";
	}
	
	@GetMapping("/createsalida")
	public String crearSalida(Model model) {
		Salida salida= new Salida();
		List<Cliente> listaClientes = clienteService.listarCliente();
		model.addAttribute("titulo","Salida de Productos");
		model.addAttribute("listaClientes", listaClientes);
		model.addAttribute("salida", salida);
		
		return "/modulos/administracion/salidaproductos";
	}
	
}
