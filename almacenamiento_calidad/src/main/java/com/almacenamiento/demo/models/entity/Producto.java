package com.almacenamiento.demo.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name="productos")
public class Producto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idproductos;
	@NotEmpty(message="No puede estar vacío")
	@Size(min=4, max=40, message="No puede ser menos a 4 ni mayor a 40")
	@Pattern(regexp="^[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+$",message="Solo ingresar letras con espacios")
	private String marca;
	@NotEmpty(message="No puede estar vacío")
	@Size(min=4, max=40, message="No puede ser menos a 4 ni mayor a 40")
	@Pattern(regexp="^[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+$",message="Solo ingresar letras con espacios")
	private String nombre;
	@NotEmpty(message="No puede estar vacío")
	@Size(min=4, max=20, message="No puede ser menos a 4 ni mayor a 20")
	@Pattern(regexp="^[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+$",message="Solo ingresar letras con espacios")
	private String modelo;
	@NotEmpty(message="No puede estar vacío")
	@Size(min=4, max=20, message="No puede ser menos a 4 ni mayor a 20")
	@Pattern(regexp="^[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+$",message="Solo ingresar letras con espacios")
	private String genero;
	@DecimalMax(value = "1000.00", message="Valor máximo es 1000")
	@DecimalMin(value = "1.00", message="Valor mínimo es 1")
	@NotNull(message="No puede ser un campo nulo")
	private Double precio;
	@NotEmpty(message="No puede estar vacío")
	@Size(min=4, max=45, message="No puede ser menos a 4 ni mayor a 45")
	@Pattern(regexp="^[#.0-9a-zA-Z\\s,-]+$",message="Solo ingresar letras con espacios")
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

	public Long getIdproductos() {
		return idproductos;
	}

	public void setIdproductos(Long idproductos) {
		this.idproductos = idproductos;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Producto [idproductos=" + idproductos + ", marca=" + marca + ", nombre=" + nombre + ", modelo=" + modelo
				+ ", genero=" + genero + ", precio=" + precio + ", descripcion=" + descripcion + ", categoria="
				+ categoria + "]";
	}

	
	
	
}
