package com.sgre.commands.riesgo;

public class AreaCommand {
	
	private String id;
	
	private String descripcion;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
		return "AreaCommand [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
}
