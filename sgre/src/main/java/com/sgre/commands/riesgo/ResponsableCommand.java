package com.sgre.commands.riesgo;

public class ResponsableCommand {
	
	private String id;
	
	private String nombre;
	
	private String apellido;
	
	private String puesto;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	@Override
	public String toString() {
		return "ResponsableCommand [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", puesto=" + puesto
				+ "]";
	}
	
}
