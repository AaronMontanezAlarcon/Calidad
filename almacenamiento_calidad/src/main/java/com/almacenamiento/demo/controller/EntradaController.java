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

import com.almacenamiento.demo.models.entity.Categoria;
import com.almacenamiento.demo.models.entity.Entrada;
import com.almacenamiento.demo.models.entity.Producto;
import com.almacenamiento.demo.models.entity.Proveedor;
import com.almacenamiento.demo.models.service.ICategoriaService;
import com.almacenamiento.demo.models.service.IEntradaService;
import com.almacenamiento.demo.models.service.IProveedorService;




@Controller
@RequestMapping("/modulos/administracion")
public class EntradaController {
	
	
	@Autowired
	private IEntradaService entradaService;
	@Autowired
	private IProveedorService proveedorService;
	

	
	
	
	@PostMapping("/saveentrada")
	//@PostMapping(value = {"/savedetentrada","/saveentrada"})
	public String guardar(@Valid @ModelAttribute("entradas") Entrada entrada,BindingResult result,Model model) {
		List<Proveedor> listaProveedor = proveedorService.listaProveedor();
		if(result.hasErrors()) {
			
			model.addAttribute("titulo","Ingreso de Producto");
			model.addAttribute("listaProveedor", listaProveedor);
			model.addAttribute("entradas", entrada);
			return "/modulos/administracion/formfactura";
		}
		
		entradaService.guardar(entrada);
		
		return "redirect:/modulos/administracion/createdetentrada";
	}
	
	@GetMapping("/createentrada")
	public String crearEntrada(Model model) {
		Entrada entrada= new Entrada();
		List<Proveedor> listaProveedor = proveedorService.listaProveedor();
		model.addAttribute("titulo","Ingreso de Producto");
		model.addAttribute("listaProveedor", listaProveedor);
		model.addAttribute("entradas", entrada);

		return "/modulos/administracion/formfactura";
	}
	
	@GetMapping("/crearingresos")
	public String crearIngreso(Model model) {
		
		model.addAttribute("titulo","Lista de Ingresos");

		return "/modulos/administracion/formfactura";
	}
	

	

	
	
}
