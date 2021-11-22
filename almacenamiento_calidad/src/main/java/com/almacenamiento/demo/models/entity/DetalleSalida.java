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
import javax.validation.constraints.NotNull;

@Entity
@Table(name="t_detalle_salida")
public class DetalleSalida implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_detalle_salida;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_salida")
	private Salida salida;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idproductos")
	private Producto producto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idalmacenes")
	private Almacen almacen;
	
	@Max(value=9999,message="El número no puede contener más de 4 dígitos")
	@Min(value=1, message="El número debe ser mayor a 1")
	@NotNull(message="La cantidad no puede ser vacía")
	private Integer cantidad;
	
	public Long getId_detalle_salida() {
		return id_detalle_salida;
	}

	public void setId_detalle_salida(Long id_detalle_salida) {
		this.id_detalle_salida = id_detalle_salida;
	}

	public Salida getSalida() {
		return salida;
	}

	public void setSalida(Salida salida) {
		this.salida = salida;
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

	@Override
	public String toString() {
		return "DetalleSalida [id_detalle_salida=" + id_detalle_salida + ", salida=" + salida + ", producto=" + producto
				+ ", almacen=" + almacen + ", cantidad=" + cantidad + "]";
	}

	public DetalleSalida() {
		super();
		
	}
	
	
}
