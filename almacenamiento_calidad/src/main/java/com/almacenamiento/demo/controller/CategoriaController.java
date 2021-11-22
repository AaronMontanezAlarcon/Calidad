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

import com.almacenamiento.demo.models.entity.Categoria;
import com.almacenamiento.demo.models.service.ICategoriaService;

@Controller
@RequestMapping("/modulos/administracion")
public class CategoriaController {
	@Autowired
	private ICategoriaService categoriaService;
	
	@GetMapping("/categoria")
	public String listarCategorias(Model model) {
		List<Categoria> listadoCategorias = categoriaService.listarCategoria();
		model.addAttribute("titulo","Lista de Categoria");
		model.addAttribute("categorias", listadoCategorias);

		return "/modulos/administracion/categoria";
	}
	
	@PostMapping("/savecategoria")
	public String guardar(@Valid @ModelAttribute("categorias") Categoria categoria, BindingResult result, Model model,RedirectAttributes flash) {
		if(result.hasErrors()) {
			model.addAttribute("titulo","Agregar Categoría");
			model.addAttribute("categorias", categoria);
			System.out.println("Existieron errores en el formulario");

			return "/modulos/administracion/agregarcategoria";
		}
		if(categoriaService.verificarExisteCategoria(categoria.getCategorianombre())) {
			  
			  categoriaService.guardar(categoria);		  
		  }else {
			  flash.addFlashAttribute("error", "El nombre de la categoría no puede ser duplicado");
			  return "redirect:/modulos/administracion/categoria/";
		  }
		
		
		categoriaService.guardar(categoria);
		return "redirect:/modulos/administracion/categoria/";
	}
	
	@GetMapping("/createcategoria")
	public String crearCategoria(Model model) {
		Categoria categoria = new Categoria();
		model.addAttribute("titulo","Agregar Categoría");
		model.addAttribute("categorias", categoria);

		return "/modulos/administracion/agregarcategoria";
	}
	
	@GetMapping("/editcategoria/{id}")
	public String editarCategoria(@PathVariable("id") Long idCategoria, Model model) {
		
		Categoria categoria = categoriaService.buscarCategoria(idCategoria);
		model.addAttribute("titulo","Editar Categoria");
		model.addAttribute("categorias", categoria);

		return "/modulos/administracion/agregarcategoria";
	}
}
