package com.almacenamiento.demo.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="t_proveedor")
public class Proveedor  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_proveedor;
	@NotEmpty(message="No puede estar vacío")
	@Size(min=11, max=11, message="No puede ser menor a 11 ni mayor a 11")
	@Pattern(regexp="^([0-9]{11})$",message="Solo ingresar números")	
	private String ruc;
	@NotEmpty(message="No puede estar vacío")
	@Size(min=4, max=30, message="No puede ser menos a 4 ni mayor a 30")
	@Pattern(regexp="^[a-zA-Z_^&^.\s]*$",message="Solo ingresar letras con espacios")
	private String razon_social;
	@NotEmpty(message="No puede estar vacío")
	@Size(min=4, max=45, message="No puede ser menos a 4 ni mayor a 45")
	
	private String direccion;
	@NotEmpty(message="No puede estar vacío")
	@Size(min=9, max=9, message="No puede ser menor ni mayor a 9")
	@Pattern(regexp="^[0-9]*$",message="Solo ingresar números")	
	private String telefono;
	@NotEmpty(message="No puede estar vacío")
	@Email(message="Tiene que ser un correo obligatoriamente")
	private String mail;
	@NotEmpty(message="No puede estar vacío")
	@Size(min=4, max=45, message="No puede ser menos a 4 ni mayor a 45")
	//@Pattern(regexp="^[#.0-9a-zA-Z\\s,-]+$",message="Solo ingresar letras con espacios")
	private String observacion;
	
	@OneToMany(mappedBy = "proveedor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Entrada> entradas;
	
	public Proveedor() {
		entradas= new ArrayList<>();
	}
	public Long getId_proveedor() {
		return id_proveedor;
	}
	public void setId_proveedor(Long id_proveedor) {
		this.id_proveedor = id_proveedor;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getRazon_social() {
		return razon_social;
	}
	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	
	public List<Entrada> getEntradas() {
		return entradas;
	}
	public void setEntradas(List<Entrada> entradas) {
		this.entradas = entradas;
	}
	
	public void addEntradas(Entrada entrada) {
		entradas.add(entrada);
	}
	@Override
	public String toString() {
		return "Proveedor [id_proveedor=" + id_proveedor + ", ruc=" + ruc + ", razon_social=" + razon_social
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", mail=" + mail + ", observacion="
				+ observacion + "]";
	}
	
	
}
