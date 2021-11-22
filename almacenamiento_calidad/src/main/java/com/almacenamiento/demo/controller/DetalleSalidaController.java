package com.almacenamiento.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.metamodel.StaticMetamodel;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.almacenamiento.demo.models.entity.Almacen;
import com.almacenamiento.demo.models.entity.Asignar;
import com.almacenamiento.demo.models.entity.Cliente;
import com.almacenamiento.demo.models.entity.DetalleEntrada;
import com.almacenamiento.demo.models.entity.DetalleSalida;
import com.almacenamiento.demo.models.entity.Entrada;
import com.almacenamiento.demo.models.entity.Producto;
import com.almacenamiento.demo.models.entity.Salida;
import com.almacenamiento.demo.models.service.IAlmacenService;
import com.almacenamiento.demo.models.service.IAsignarService;
import com.almacenamiento.demo.models.service.IClienteService;
import com.almacenamiento.demo.models.service.IDetalleSalidaService;
import com.almacenamiento.demo.models.service.IDetalleService;
import com.almacenamiento.demo.models.service.IEntradaService;
import com.almacenamiento.demo.models.service.IProductoService;
import com.almacenamiento.demo.models.service.ISalidaService;

@Controller
@RequestMapping("/modulos/administracion")
public class DetalleSalidaController {
	
	@Autowired
	private IDetalleSalidaService detalleSalidaService;
	@Autowired
	private IClienteService clienteService;
	@Autowired
	private ISalidaService salidaService;
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private IAlmacenService almacenService ;
	
	
	@Autowired
	private IAsignarService asignarService;
	
	@GetMapping("/listarsalidas")
	public String listarSalidas(Model model) {
		
		List<DetalleSalida> listadoDetallesSalida = detalleSalidaService.listarDetalleSalida();
		
		List<Cliente> listadoClientes = clienteService.listarCliente();
		model.addAttribute("titulo","Lista de Salidas");
		model.addAttribute("salida", listadoDetallesSalida);
		model.addAttribute("cliente", listadoClientes);
		return "/modulos/administracion/listasalida";
	}
	
	@PostMapping("/savedetsalida")
	
	public String guardar(@Valid @ModelAttribute("detallesalidas") DetalleSalida detalleSalida,BindingResult result,Model model,RedirectAttributes flash) {
		List<Producto> listaProducto= productoService.listaProductos();
		List<DetalleSalida> listaDetallesSalida = new ArrayList<>();
		List<Almacen> listaAlmacen= almacenService.listarAlmacen();
		List<Salida> listaSalidas= salidaService.listarSalida();
		List<DetalleEntrada> listaDetalles = new ArrayList<>();
		if(result.hasErrors()) {
			
			model.addAttribute("titulo","Salida de Producto");
			model.addAttribute("id_salidass",salidaService.encontrarID());
			model.addAttribute("listaProducto", listaProducto);
			model.addAttribute("listaAlmacen", listaAlmacen);
			model.addAttribute("listaSalida", listaSalidas);
			model.addAttribute("listaDetallesSalidas", listaDetalles);
			model.addAttribute("detallesalidas", detalleSalida);
			System.out.println("detallesalidacontroller");
			return "/modulos/administracion/detallesalida";
		}
		
			
			model.addAttribute("titulo","Salida de Producto");
			System.out.println(salidaService.encontrarID());
			model.addAttribute("id_salidass",salidaService.encontrarID());
			model.addAttribute("listaProducto", listaProducto);
			model.addAttribute("listaAlmacen", listaAlmacen);
			model.addAttribute("listaSalida", listaSalidas);
			model.addAttribute("listaDetalles", listaDetallesSalida);
			model.addAttribute("detalleentradas", detalleSalida);
			
			List<Asignar> lista = asignarService.verificarCantidadAsignado(detalleSalida.getAlmacen().getIdalmacenes(), detalleSalida.getProducto().getIdproductos());
			int cantidad = lista.get(0).getCantidad_asignada();
			int cantidad2 = detalleSalida.getCantidad();
			if(cantidad2<=cantidad) {
				asignarService.updatesalida(detalleSalida.getCantidad(), detalleSalida.getAlmacen().getIdalmacenes(), detalleSalida.getProducto().getIdproductos());
				detalleSalidaService.guardar(detalleSalida);
				return "redirect:/modulos/administracion/listarsalidas";
				  
			}else {
				
				flash.addFlashAttribute("error2", "La cantidad de salida del producto no puede ser mayor al stock");
				  return "redirect:/modulos/administracion/listarsalidas";
				  
			}	
	}
	
	@GetMapping("/createdetsalida")
	public String crearSalida(Model model) {
		DetalleSalida detalleSalida= new DetalleSalida();
		List<Producto> listaProducto= productoService.listaProductos();
		List<DetalleEntrada> listaDetalles = new ArrayList<>();
		List<Almacen> listaAlmacen= almacenService.listarAlmacen();
		List<Salida> listaSalidas= salidaService.listarSalida();
		model.addAttribute("titulo","Salida de Producto");
		model.addAttribute("id_salidass",salidaService.encontrarID());
		model.addAttribute("listaProducto", listaProducto);
		model.addAttribute("listaAlmacen", listaAlmacen);
		model.addAttribute("listaSalida", listaSalidas);
		model.addAttribute("listaDetallesSalidas", listaDetalles);
		model.addAttribute("detallesalidas", detalleSalida);
		return "/modulos/administracion/detallesalida";
	}
	@RequestMapping("/listasalidaAlmacen")
    @ResponseBody
    public List<Asignar> ajaxBrands(Long idAlmacen, Model model) {

        return asignarService.listaAsignadosAlmacen(idAlmacen);
    }
	
}
