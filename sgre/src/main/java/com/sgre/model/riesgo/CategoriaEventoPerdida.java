package com.sgre.model.riesgo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="categoria_evento_perdida")
public class CategoriaEventoPerdida {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	
	@Column(name="descripcion", nullable=false)
	private String descripcion;
	
	@OneToOne(mappedBy = "categoria_evento_perdida")
	private Riesgo riesgo;
	
	public CategoriaEventoPerdida() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "CategoriaEventoPerdida [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
}
