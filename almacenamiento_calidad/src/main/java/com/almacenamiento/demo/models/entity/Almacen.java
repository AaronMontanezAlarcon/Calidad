package com.almacenamiento.demo.models.entity;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Table(name="almacenes")
public class Almacen implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idalmacenes;
	@NotEmpty(message="No puede estar vacío")
	@Size(min=4, max=45, message="No puede ser menor a 4 ni mayor a 45")
	//@Pattern(regexp="^[a-zA-Z\\s]{2,254}",message="Solo ingresar letras con espacios")
	private String nombrealmacen;
	@NotEmpty(message="No puede estar vacío")
	@Size(min=4, max=45, message="No puede ser menor a 4 ni mayor a 45")
	private String direccionalmacen;
	@NotEmpty(message="No puede estar vacío")
	@Size(min=9, max=9, message="No puede ser menor ni mayor a 9")
	@Pattern(regexp="^[0-9]*$",message="Solo ingresar números")	
	private String telefono;
	
	
	public Almacen() {
		super();
		
	}
	public Long getIdalmacenes() {
		return idalmacenes;
	}
	public void setIdalmacenes(Long idalmacenes) {
		this.idalmacenes = idalmacenes;
	}
	public String getNombrealmacen() {
		return nombrealmacen;
	}
	public void setNombrealmacen(String nombrealmacen) {
		this.nombrealmacen = nombrealmacen;
	}
	public String getDireccionalmacen() {
		return direccionalmacen;
	}
	public void setDireccionalmacen(String direccionalmacen) {
		this.direccionalmacen = direccionalmacen;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "Almacen [idalmacenes=" + idalmacenes + ", nombrealmacen=" + nombrealmacen + ", direccionalmacen="
				+ direccionalmacen + ", telefono=" + telefono + "]";
	}
	
	

	
	
}
