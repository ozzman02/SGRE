package com.sgre.commands.riesgo;

public class LineaDeNegocioCommand {
	
	private String id;
	
	private String descripcion;
	
	private String tipo;

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "LineaDeNegocioCommand [id=" + id + ", descripcion=" + descripcion + ", tipo=" + tipo + "]";
	}

}
