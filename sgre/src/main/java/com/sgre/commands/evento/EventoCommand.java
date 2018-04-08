package com.sgre.commands.evento;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


public class EventoCommand {
	
	private String id;
	
	@NotEmpty
	private String titulo;
	
	@NotEmpty
	private String descripcion;
	
	@NotEmpty
	private String categoria_evento_perdida;
	
	private CategoriaEventoPerdidaCommand categoria_evento_perdida_command;
	
	@NotEmpty
	private String linea_de_negocio;
	
	private LineaDeNegocioCommand linea_de_negocio_command;
	
	@NotEmpty
	private String caracter_del_evento;
	
	private CaracterDelEventoCommand caracter_del_evento_command;
	
	private String detalle;
	
	@NotEmpty
	private String area;
	
	private AreaCommand area_command;
	
	@Pattern(regexp = "(^[+]?([0-9]+(?:[\\.][0-9]*)?|\\.[0-9]+)$)", message="El monto debe ser un número decimal válido")
	private String monto_estimado_perdida = "0.0";
	
	private String tipo_moneda_perdida;
	
	@Pattern(regexp = "(^[+]?([0-9]+(?:[\\.][0-9]*)?|\\.[0-9]+)$)", message="El tipo de cambio debe ser un número decimal válido")
	private String tipo_cambio_perdida = "0.0";
	
	@NotEmpty
	private String responsable;
	
	private String observaciones_generales;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCategoria_evento_perdida() {
		return categoria_evento_perdida;
	}

	public void setCategoria_evento_perdida(String categoria_evento_perdida) {
		this.categoria_evento_perdida = categoria_evento_perdida;
	}

	public CategoriaEventoPerdidaCommand getCategoria_evento_perdida_command() {
		return categoria_evento_perdida_command;
	}

	public void setCategoria_evento_perdida_command(CategoriaEventoPerdidaCommand categoria_evento_perdida_command) {
		this.categoria_evento_perdida_command = categoria_evento_perdida_command;
	}

	public String getLinea_de_negocio() {
		return linea_de_negocio;
	}

	public void setLinea_de_negocio(String linea_de_negocio) {
		this.linea_de_negocio = linea_de_negocio;
	}

	public LineaDeNegocioCommand getLinea_de_negocio_command() {
		return linea_de_negocio_command;
	}

	public void setLinea_de_negocio_command(LineaDeNegocioCommand linea_de_negocio_command) {
		this.linea_de_negocio_command = linea_de_negocio_command;
	}

	public String getCaracter_del_evento() {
		return caracter_del_evento;
	}

	public void setCaracter_del_evento(String caracter_del_evento) {
		this.caracter_del_evento = caracter_del_evento;
	}

	public CaracterDelEventoCommand getCaracter_del_evento_command() {
		return caracter_del_evento_command;
	}

	public void setCaracter_del_evento_command(CaracterDelEventoCommand caracter_del_evento_command) {
		this.caracter_del_evento_command = caracter_del_evento_command;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public AreaCommand getArea_command() {
		return area_command;
	}

	public void setArea_command(AreaCommand area_command) {
		this.area_command = area_command;
	}

	public String getMonto_estimado_perdida() {
		return monto_estimado_perdida;
	}

	public void setMonto_estimado_perdida(String monto_estimado_perdida) {
		this.monto_estimado_perdida = monto_estimado_perdida;
	}

	public String getTipo_moneda_perdida() {
		return tipo_moneda_perdida;
	}

	public void setTipo_moneda_perdida(String tipo_moneda_perdida) {
		this.tipo_moneda_perdida = tipo_moneda_perdida;
	}

	public String getTipo_cambio_perdida() {
		return tipo_cambio_perdida;
	}

	public void setTipo_cambio_perdida(String tipo_cambio_perdida) {
		this.tipo_cambio_perdida = tipo_cambio_perdida;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getObservaciones_generales() {
		return observaciones_generales;
	}

	public void setObservaciones_generales(String observaciones_generales) {
		this.observaciones_generales = observaciones_generales;
	}
	
}
