package com.almacenamiento.demo.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="categoria")
public class Categoria implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcategoria;
	@NotEmpty(message="No puede estar vacío")
	@Size(min=4, max=20, message="No puede ser menor a 4 ni mayor a 20")
	@Pattern(regexp="^[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+$",message="Solo ingresar letras con espacios")
	private String categorianombre;
	@NotEmpty(message="No puede estar vacío")
	@Size(min=4, max=45, message="No puede ser menor a 4 ni mayor a 45")
	@Pattern(regexp="^[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+$",message="Solo ingresar letras con espacios")
	private String comentario_categoria;
	public Long getIdcategoria() {
		return idcategoria;
	}
	public void setIdcategoria(Long idcategoria) {
		this.idcategoria = idcategoria;
	}
	
	public String getCategorianombre() {
		return categorianombre;
	}
	public void setCategorianombre(String categorianombre) {
		this.categorianombre = categorianombre;
	}
	public String getComentario_categoria() {
		return comentario_categoria;
	}
	public void setComentario_categoria(String comentario_categoria) {
		this.comentario_categoria = comentario_categoria;
	}
	@Override
	public String toString() {
		return "Categoria [idcategoria=" + idcategoria + ", categorianombre=" + categorianombre
				+ ", comentario_categoria=" + comentario_categoria + "]";
	}
	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
