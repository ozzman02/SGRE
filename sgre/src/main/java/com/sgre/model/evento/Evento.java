package com.sgre.model.evento;

import java.math.BigDecimal;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sgre.model.evento.Area;
import com.sgre.model.evento.CaracterDelEvento;
import com.sgre.model.evento.CategoriaEventoPerdida;
import com.sgre.model.evento.LineaDeNegocio;
import com.sgre.model.evento.Responsable;

@Entity
@Table(name = "evento")
public class Evento {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id",nullable=false)
	private Long id;
	
	@Column(name="titulo", nullable=false)
	private String titulo;
	
	@Column(name="descripcion", nullable=false)
	private String descripcion;
	
	@OneToOne
	@JoinColumn(name="categoria_evento_perdida_id")
	private CategoriaEventoPerdida categoria_evento_perdida;
	
	@OneToOne
	@JoinColumn(name="linea_de_negocio_id")
	private LineaDeNegocio linea_de_negocio;
	
	@OneToOne
	@JoinColumn(name="caracter_del_evento_id")
	private CaracterDelEvento caracter_del_evento;
	
	private String detalle;
	
	@OneToOne
	@JoinColumn(name="area_id")
	private Area area;
	
	@Column(name="monto_estimado_perdida", nullable=true)
	private BigDecimal monto_estimado_perdida;
	
	@Column(name="tipo_moneda_perdida", nullable=true)
	private String tipo_moneda_perdida;
	
	@Column(name="tipo_cambio_perdida", nullable=true)
	private BigDecimal tipo_cambio_perdida;
	

	@OneToOne
	@JoinColumn(name="responsable_id")
	private Responsable responsable;
	
	@Column(name="observaciones_generales", nullable=true)
	private String observaciones_generales;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public CategoriaEventoPerdida getCategoria_evento_perdida() {
		return categoria_evento_perdida;
	}

	public void setCategoria_evento_perdida(CategoriaEventoPerdida categoria_evento_perdida) {
		this.categoria_evento_perdida = categoria_evento_perdida;
	}

	public LineaDeNegocio getLinea_de_negocio() {
		return linea_de_negocio;
	}

	public void setLinea_de_negocio(LineaDeNegocio linea_de_negocio) {
		this.linea_de_negocio = linea_de_negocio;
	}

	public CaracterDelEvento getCaracter_del_evento() {
		return caracter_del_evento;
	}

	public void setCaracter_del_evento(CaracterDelEvento caracter_del_evento) {
		this.caracter_del_evento = caracter_del_evento;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public BigDecimal getMonto_estimado_perdida() {
		return monto_estimado_perdida;
	}

	public void setMonto_estimado_perdida(BigDecimal monto_estimado_perdida) {
		this.monto_estimado_perdida = monto_estimado_perdida;
	}

	public String getTipo_moneda_perdida() {
		return tipo_moneda_perdida;
	}

	public void setTipo_moneda_perdida(String tipo_moneda_perdida) {
		this.tipo_moneda_perdida = tipo_moneda_perdida;
	}

	public BigDecimal getTipo_cambio_perdida() {
		return tipo_cambio_perdida;
	}

	public void setTipo_cambio_perdida(BigDecimal tipo_cambio_perdida) {
		this.tipo_cambio_perdida = tipo_cambio_perdida;
	}

	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	public String getObservaciones_generales() {
		return observaciones_generales;
	}

	public void setObservaciones_generales(String observaciones_generales) {
		this.observaciones_generales = observaciones_generales;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion
				+ ", categoria_evento_perdida=" + categoria_evento_perdida + ", linea_de_negocio=" + linea_de_negocio
				+ ", caracter_del_evento=" + caracter_del_evento + ", detalle=" + detalle + ", area=" + area
				+ ", monto_estimado_perdida=" + monto_estimado_perdida + ", tipo_moneda_perdida=" + tipo_moneda_perdida
				+ ", tipo_cambio_perdida=" + tipo_cambio_perdida + ", responsable=" + responsable
				+ ", observaciones_generales=" + observaciones_generales + "]";
	}

	
	
}
