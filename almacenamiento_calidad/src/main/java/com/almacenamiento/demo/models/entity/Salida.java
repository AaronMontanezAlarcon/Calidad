package com.almacenamiento.demo.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="t_salida")
public class Salida  implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_salida;
	
	@NotEmpty(message="No puedes generar una salida sin fecha")
	private String fecha_registro;
	private String observacion;
	
	@ManyToOne
	@JoinColumn(name = "idcliente")
	private Cliente cliente;

	public Long getId_salida() {
		return id_salida;
	}

	public void setId_salida(Long id_salida) {
		this.id_salida = id_salida;
	}

	public String getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Salida [id_salida=" + id_salida + ", fecha_registro=" + fecha_registro + ", observacion=" + observacion
				+ ", cliente=" + cliente + "]";
	}

	public Salida() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
