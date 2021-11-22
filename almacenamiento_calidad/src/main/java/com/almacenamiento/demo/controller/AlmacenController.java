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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.almacenamiento.demo.models.entity.Almacen;
import com.almacenamiento.demo.models.service.IAlmacenService;


@Controller
@RequestMapping("/modulos/administracion")
public class AlmacenController {
	
	@Autowired
	private IAlmacenService almacenService;

	
	@GetMapping("/listar")
	public String listarAlmacen(Model model) {
		List<Almacen> listadoAlmacen = almacenService.listarAlmacen();
		model.addAttribute("titulo","Lista de Almacenes");
		model.addAttribute("almacenes", listadoAlmacen);		

		return "/modulos/administracion/almacen";
	}
	
	//@PostMapping("/save")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String guardar(@Valid @ModelAttribute("almacenes") Almacen almacen,BindingResult result, Model model,RedirectAttributes flash) {
		
		if(result.hasErrors()) {			
			model.addAttribute("titulo","Agregar Almacén");
			model.addAttribute("almacenes", almacen);
			System.out.println("Existieron errores en el formulario");
			
			return "/modulos/administracion/agregaralmacen";
		}
		if(almacenService.verificarExisteCategoria(almacen.getNombrealmacen())) {
			almacenService.guardar(almacen);
			System.out.println("IF");
			
		}else {
			  flash.addFlashAttribute("error", "El nombre del almacen no puede ser duplicado");
			  System.out.println("ELSE");
			  return "redirect:/modulos/administracion/listar/";
		  }
		
		
		System.out.println("Guardado");
		almacenService.guardar(almacen);
		
		return "redirect:/modulos/administracion/listar/";
	}
	
	@GetMapping("/create")
	public String crearAlmacen(Model model) {
		Almacen almacen = new Almacen();
		
		model.addAttribute("titulo","Agregar Almacén");
		model.addAttribute("almacenes", almacen);

		return "/modulos/administracion/agregaralmacen";
	}
	
	@GetMapping("/edit/{id}")
	public String editarAlmacen(@PathVariable("id") Long idAlmacen, Model model) {
		
		Almacen almacen = almacenService.buscarAlmacen(idAlmacen);
		model.addAttribute("titulo","Editar Almacén");
		model.addAttribute("almacenes", almacen);

		return "/modulos/administracion/agregaralmacen";
	}
	
	
	
}
