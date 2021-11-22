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
import com.almacenamiento.demo.models.entity.Producto;
import com.almacenamiento.demo.models.service.ICategoriaService;
import com.almacenamiento.demo.models.service.IProductoService;


@Controller
@RequestMapping("/modulos/administracion")
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;
	@Autowired
	private ICategoriaService categoriaService;
	
	@GetMapping("/producto")
	public String listarCategorias(Model model) {
		List<Producto> listadoProductos = productoService.listaProductos();
		List<Categoria> listaCategorias = categoriaService.listarCategoria();
		model.addAttribute("titulo","lista de productos");
		model.addAttribute("listaCategorias", listaCategorias);
		model.addAttribute("productos", listadoProductos);

		return "/modulos/administracion/producto";
	}
	
	@PostMapping("/saveproducto")
	public String guardar(@Valid @ModelAttribute("productos") Producto producto,BindingResult result,Model model,RedirectAttributes flash) {
		List<Categoria> listaCategorias = categoriaService.listarCategoria();
		if(result.hasErrors()) {
			model.addAttribute("titulo","Agregar Productos");
			model.addAttribute("listaCategorias", listaCategorias);
			model.addAttribute("productos", producto);

			return "/modulos/administracion/agregarproducto";		
		}
		if(productoService.verificarExisteProducto(producto.getMarca())) {
			productoService.guardar(producto);
		}else {
			  flash.addFlashAttribute("error", "El nombre del producto no puede ser duplicado");
			  return "redirect:/modulos/administracion/producto/";
		  }
		
		
		productoService.guardar(producto);
		return "redirect:/modulos/administracion/producto/";
	}
	
	@GetMapping("/createproducto")
	public String crearProducto(Model model) {
		Producto producto= new Producto();
		List<Categoria> listaCategorias = categoriaService.listarCategoria();
		model.addAttribute("titulo","Agregar Productos");
		model.addAttribute("listaCategorias", listaCategorias);
		model.addAttribute("productos", producto);

		return "/modulos/administracion/agregarproducto";
	}
	
	@GetMapping("/editproducto/{id}")
	public String editarProducto(@PathVariable("id") Long idProducto, Model model) {
		
		List<Categoria> listaCategorias = categoriaService.listarCategoria();
		Producto producto= productoService.buscarProducto(idProducto);
		model.addAttribute("titulo","Editar Productos");
		model.addAttribute("productos", producto);
		model.addAttribute("listaCategorias", listaCategorias);
		return "/modulos/administracion/agregarproducto";
	}
}
