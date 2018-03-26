package com.sgre.model.riesgo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="caracter_del_riesgo")
public class CaracterDelRiesgo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	
	@Column(name="descripcion", nullable=false)
	private String descripcion;
	
	@OneToOne(mappedBy="caracter_del_riesgo")
	private Riesgo riesgo;
	
	public CaracterDelRiesgo() {
	
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
		return "CaracterDelRiesgo [id=" + id + ", descripcion=" + descripcion + "]";
	}

}
