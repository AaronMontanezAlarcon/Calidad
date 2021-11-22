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
@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcliente;
	@NotEmpty(message="No puede estar vacío")
	@Size(min=8, max=8, message="No puede ser menor o mayor a 8")
	@Pattern(regexp="^[0-9]*$",message="Solo ingresar números")	
	private String dnicliente;
	@NotEmpty(message="No puede estar vacío")
	@Size(min=4, max=20, message="No puede ser menos a 4 ni mayor a 20")
	@Pattern(regexp="^[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+$",message="Solo ingresar letras con espacios")
	private String nombres;
	@NotEmpty(message="No puede estar vacío")
	@Size(min=4, max=20, message="No puede ser menos a 4 ni mayor a 20")
	@Pattern(regexp="^[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+$",message="Solo ingresar letras con espacios")
	private String apellidos;
	@NotEmpty(message="No puede estar vacío")
	@Size(min=9, max=9, message="No puede ser menor ni mayor a 9")
	@Pattern(regexp="^[0-9]*$",message="Solo ingresar números")
	private String telefono;
	@NotEmpty(message="No puede estar vacío")
	@Size(min=4, max=45, message="No puede ser menos a 4 ni mayor a 45")
	private String direccion;

	@NotEmpty(message="No puede quedar vacío")
	private String fecha_nacimiento;


	public Long getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}

	public String getDnicliente() {
		return dnicliente;
	}

	public void setDnicliente(String dnicliente) {
		this.dnicliente = dnicliente;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}	

	@Override
	public String toString() {
		return "Cliente [idcliente=" + idcliente + ", dnicliente=" + dnicliente + ", nombres=" + nombres
				+ ", apellidos=" + apellidos + ", telefono=" + telefono + ", direccion=" + direccion
				+ ", fecha_nacimiento=" + fecha_nacimiento + "]";
	}
	
	
	
}
