package com.almacenamiento.demo.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.almacenamiento.demo.models.entity.Almacen;
import com.almacenamiento.demo.models.entity.Asignar;
import com.almacenamiento.demo.models.entity.Cliente;
import com.almacenamiento.demo.models.entity.DetalleEntrada;
import com.almacenamiento.demo.models.entity.Entrada;
import com.almacenamiento.demo.models.entity.Producto;
import com.almacenamiento.demo.models.entity.Proveedor;
import com.almacenamiento.demo.models.service.IAlmacenService;
import com.almacenamiento.demo.models.service.IAsignarService;
import com.almacenamiento.demo.models.service.IClienteService;
import com.almacenamiento.demo.models.service.IDetalleService;
import com.almacenamiento.demo.models.service.IEntradaService;
import com.almacenamiento.demo.models.service.IProductoService;

@Controller
@RequestMapping("/modulos/administracion")
public class DetalleEntradaController {
	
	@Autowired
	private IDetalleService detalleService;
	
	@Autowired
	private IEntradaService entradaService;
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private IAlmacenService almacenService ;
	
	@Autowired
	private IAsignarService asignarService;
	
	
	@GetMapping("/listaringresos")
	public String listarIngresos(Model model) {
		
		List<DetalleEntrada> listadoDetalles = detalleService.listarDetalle();
		
		
		model.addAttribute("titulo","Lista de Ingresos");
		model.addAttribute("entrada", listadoDetalles);
		
		return "/modulos/administracion/ingresoproductos";
	}
	
	@PostMapping("/savedetentrada")
	
	public String guardar(@Valid @ModelAttribute("detalleentradas") DetalleEntrada detalleEntrada,BindingResult result,Model model) {
		List<Producto> listaProducto= productoService.listaProductos();
		List<DetalleEntrada> listaDetalles = new ArrayList<>();
		List<Almacen> listaAlmacen= almacenService.listarAlmacen();
		List<Entrada> listaEntradas= entradaService.listarEntrada();
		if(result.hasErrors()) {
			
			model.addAttribute("titulo","Ingreso de Producto");
			model.addAttribute("id_entradass",entradaService.encontrarID());
			model.addAttribute("listaProducto", listaProducto);
			model.addAttribute("listaAlmacen", listaAlmacen);
			model.addAttribute("listaEntrada", listaEntradas);
			model.addAttribute("listaDetalles", listaDetalles);
			model.addAttribute("detalleentradas", detalleEntrada);
			return "/modulos/administracion/detalleingreso";						
		}
		asignarService.update(detalleEntrada.getCantidad(), detalleEntrada.getAlmacen().getIdalmacenes(), detalleEntrada.getProducto().getIdproductos());
		detalleService.guardar(detalleEntrada);
		return "redirect:/modulos/administracion/listaringresos";
	}
	
	@GetMapping("/createdetentrada")
	public String crearEntrada(Model model) {
		DetalleEntrada detalleEntrada = new DetalleEntrada();
		List<Producto> listaProducto= productoService.listaProductos();
		List<DetalleEntrada> listaDetalles = new ArrayList<>();
		List<Almacen> listaAlmacen= almacenService.listarAlmacen();
		List<Entrada> listaEntradas= entradaService.listarEntrada();
		model.addAttribute("titulo","Ingreso de Producto");
		model.addAttribute("id_entradass",entradaService.encontrarID());
		model.addAttribute("listaProducto", listaProducto);
		model.addAttribute("listaAlmacen", listaAlmacen);
		model.addAttribute("listaEntrada", listaEntradas);
		model.addAttribute("listaDetalles", listaDetalles);
		model.addAttribute("detalleentradas", detalleEntrada);
		return "/modulos/administracion/detalleingreso";
	}
	@RequestMapping("/listaAlmacen")
    @ResponseBody
    public List<Asignar> ajaxBrands(Long idAlmacen, Model model) {

        return asignarService.listaAsignadosAlmacen(idAlmacen);
    }
}
