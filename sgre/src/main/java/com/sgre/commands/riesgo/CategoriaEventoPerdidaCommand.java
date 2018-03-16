package com.sgre.commands.riesgo;

public class CategoriaEventoPerdidaCommand {
	
	private Long id;
	
	private String descripcion;

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
		return "CategoriaEventoPerdidaCommand [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
}
