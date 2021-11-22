package com.almacenamiento.demo.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.almacenamiento.demo.models.entity.Almacen;
import com.almacenamiento.demo.models.entity.Asignar;

import com.almacenamiento.demo.models.entity.Producto;
import com.almacenamiento.demo.models.service.IAlmacenService;
import com.almacenamiento.demo.models.service.IAsignarService;
import com.almacenamiento.demo.models.service.IProductoService;


@Controller
@RequestMapping("/modulos/administracion")
public class AsignarController {
	
	@Autowired
	private IAsignarService asignarService;
	@Autowired
	private IProductoService productoService;
	@Autowired
	private IAlmacenService almacenService;
	
	@GetMapping("/listasig/{id}")
	public String listarAsignados(@PathVariable("id") Long idAlmacen,Model model) {
		List<Asignar> listadoAsignar= asignarService.listaAsignadosAlmacen(idAlmacen);
		
		model.addAttribute("titulo","lista de productos");
		
		model.addAttribute("asignados", listadoAsignar);

		return "/modulos/administracion/productosasignados";
	}
	
	@PostMapping("/saveasignar")
	public String guardar(Asignar asignar,Model model,RedirectAttributes flash) {
		
		if(asignarService.verificarExisteAsignado(asignar.getAlmacen().getIdalmacenes(),asignar.getProducto().getIdproductos())) {
			
			asignarService.guardar(asignar);
		}else {
			List<Almacen> listaAlmacen= almacenService.listarAlmacen2(asignar.getAlmacen().getIdalmacenes());
			
			  flash.addFlashAttribute("error2", "El producto ya se encuentra asignado en el almacén "+listaAlmacen.get(0).getNombrealmacen());
			  return "redirect:/modulos/administracion/listar/";
		}
		

		asignarService.guardar(asignar);
		return "redirect:/modulos/administracion/listar/";
	}
	
	@GetMapping("/asignacion/{id}")
	public String editarAlmacen(@PathVariable("id") Long idAlmacen, Model model) {
		Asignar asignar = new Asignar();
		List<Producto> listaProductos= productoService.listaProductos();
		
		model.addAttribute("titulo","Asignar Productos a Almacén");
		model.addAttribute("id_almacenesss", idAlmacen);
		model.addAttribute("listaProductos", listaProductos);
		model.addAttribute("asignar", asignar);
		return "/modulos/administracion/asignarproductos";
	}
}
