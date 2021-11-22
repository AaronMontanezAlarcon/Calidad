package com.almacenamiento.demo.models.entity;

import java.io.Serializable;

import java.util.Date;



import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name="t_entrada")
public class Entrada implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_entrada;
	
	@NotEmpty(message="Ingresar fecha de Ingreso")
	private String fecha_entrada;
	
	
	private String observacion;
	
	
	@ManyToOne
	@JoinColumn(name = "id_proveedor")
	private Proveedor proveedor;
	
	
	
	
	
	
	
	public Long getId_entrada() {
		return id_entrada;
	}

	public void setId_entrada(Long id_entrada) {
		this.id_entrada = id_entrada;
	}

	public String getFecha_entrada() {
		return fecha_entrada;
	}

	public void setFecha_entrada(String fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}



	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	
	



	@Override
	public String toString() {
		return "Entrada [id_entrada=" + id_entrada + ", fecha_entrada=" + fecha_entrada + ", observacion=" + observacion
				+ ", proveedor=" + proveedor + "]";
	}

	public Entrada() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	
}
