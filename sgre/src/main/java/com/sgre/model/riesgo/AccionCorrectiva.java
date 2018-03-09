package com.sgre.model.riesgo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="accion_correctiva")
public class AccionCorrectiva {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	
	@Column(name="descripcion", nullable=false)
	private String descripcion;
	
	@OneToOne(mappedBy = "accion_correctiva")
	private Riesgo riesgo;

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
		return "AccionCorrectiva [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
}
