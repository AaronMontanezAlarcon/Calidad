package com.almacenamiento.demo.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="productos_asignados")
public class Asignar implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idasignados;
	
	@ManyToOne
	@JoinColumn(name = "almacenes_idalmacenes")
	private Almacen almacen;
	
	@ManyToOne
	@JoinColumn(name = "productos_idproductos")
	private Producto producto;
	
	private int cantidad_asignada;

	

	public Long getIdasignados() {
		return idasignados;
	}



	public void setIdasignados(Long idasignados) {
		this.idasignados = idasignados;
	}



	public Almacen getAlmacen() {
		return almacen;
	}



	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}



	public Producto getProducto() {
		return producto;
	}



	public void setProducto(Producto producto) {
		this.producto = producto;
	}



	public int getCantidad_asignada() {
		return cantidad_asignada;
	}



	public void setCantidad_asignada(int cantidad_asignada) {
		this.cantidad_asignada = cantidad_asignada;
	}

	

	@Override
	public String toString() {
		return "Asignar [idasignados=" + idasignados + ", almacen=" + almacen + ", producto=" + producto
				+ ", cantidad_asignada=" + cantidad_asignada + "]";
	}



	public Asignar() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
