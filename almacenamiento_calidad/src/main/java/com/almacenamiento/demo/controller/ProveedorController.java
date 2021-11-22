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

import com.almacenamiento.demo.models.entity.Proveedor;
import com.almacenamiento.demo.models.service.IProveedorService;

@Controller
@RequestMapping("/modulos/administracion")
public class ProveedorController {
	@Autowired
	private IProveedorService proveedorService;
	
	@GetMapping("/proveedor")
	public String listarProvedores(Model model) {
		List<Proveedor> listadoProveedor = proveedorService.listaProveedor();
		model.addAttribute("titulo","Lista de Provedores");
		model.addAttribute("provedores", listadoProveedor);

		return "/modulos/administracion/proveedor";
	}
	
	@PostMapping("/saveproveedor")
	public String guardar(@Valid @ModelAttribute("provedores") Proveedor proveedor,BindingResult result, Model model,RedirectAttributes flash) {
		if(result.hasErrors()) {
			model.addAttribute("titulo","Agregar Proveedor");
			model.addAttribute("provedores", proveedor);

			return "/modulos/administracion/agregarproveedor";	
		}
		 if(proveedorService.verificarExisteEmpleado(proveedor.getRuc())) {
			  
			 proveedorService.guardar(proveedor);		  
		  }else {
			  flash.addFlashAttribute("error", "El ruc de los proveedores no puede ser duplicado");
			  return "redirect:/modulos/administracion/proveedor/";
		  }
		proveedorService.guardar(proveedor);
		return "redirect:/modulos/administracion/proveedor/";
	}
	
	@GetMapping("/createproveedor")
	public String crearProveedor(Model model) {
		Proveedor proveedor = new Proveedor();
		model.addAttribute("titulo","Agregar Proveedor");
		model.addAttribute("provedores", proveedor);

		return "/modulos/administracion/agregarproveedor";
	}
	
	@GetMapping("/editproveedor/{id}")
	public String editarProveedor(@PathVariable("id") Long idProveedor, Model model) {
		
		Proveedor proveedor = proveedorService.buscarProveedor(idProveedor);
		model.addAttribute("titulo","Editar Proveedor");
		model.addAttribute("provedores", proveedor);

		return "/modulos/administracion/agregarproveedor";
	}
	
}
