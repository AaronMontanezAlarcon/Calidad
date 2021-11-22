package com.almacenamiento.demo.models.entity;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="t_detalle_entrada")
public class DetalleEntrada implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_detalle_entrada;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_entrada")
	private Entrada entrada;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_productos")
	private Producto producto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_almacenes")
	private Almacen almacen;
	
	@Max(value=9999,message="El número no puede contener más de 4 dígitos")
	@Min(value=1, message="El número debe ser mayor a 0")
	@NotNull(message="La cantidad no puede ser vacía")
	private Integer cantidad;
	
	
	public Entrada getEntrada() {
		return entrada;
	}

	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
	}

	public Long getId_detalle_entrada() {
		return id_detalle_entrada;
	}

	public void setId_detalle_entrada(Long id_detalle_entrada) {
		this.id_detalle_entrada = id_detalle_entrada;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public Almacen getAlmacen() {
		return almacen;
	}


	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}



	public Double calcularImporte() {
		return cantidad.doubleValue()*producto.getPrecio();
	}
	


	@Override
	public String toString() {
		return "DetalleEntrada [id_detalle_entrada=" + id_detalle_entrada + ", entrada=" + entrada + ", producto="
				+ producto + ", almacen=" + almacen + ", cantidad=" + cantidad + "]";
	}

	public DetalleEntrada() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
