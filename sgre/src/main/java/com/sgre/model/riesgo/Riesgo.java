package com.sgre.model.riesgo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;



@Entity
@Table(name = "riesgo")
public class Riesgo {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable=false)
	private Long id;
	
	@Column(name="titulo", nullable=false)
	private String titulo;
	
	@Column(name="descripcion", nullable=false)
	private String descripcion;
	
	@Column(name="frecuencia", nullable=false)
	private Integer frecuencia;
	
	@Column(name="probabilidad", nullable=false)
	private BigDecimal probabilidad;
	
	@Column(name="controles_de_riesgo", nullable=true)
	private String controles_de_riesgo;
	
	@Column(name = "impacto_del_riesgo", nullable = false)
	@Enumerated(EnumType.STRING)
	private ImpactoDelRiesgo impacto_del_riesgo;
	
	@Column(name="fecha_inicio", nullable=false)
	@Type(type="date")
	private Date fecha_inicio;
	
	@Column(name="fecha_conclusion", nullable=true)
	@Type(type="date")
	private Date fecha_conclusion;
	
	@Column(name="fecha_descubrimiento", nullable=true)
	@Type(type="date")
	private Date fecha_descubrimiento;
	
	@Column(name="fecha_registro_contable", nullable=true)
	@Type(type="date")
	private Date fecha_registro_contable;
	
	@Column(name="monto_bruto_perdida", nullable=true)
	private BigDecimal monto_bruto_perdida;
	
	@Column(name="tipo_moneda_perdida_bruta", nullable=true)
	private String tipo_moneda_perdida_bruta;
	
	@Column(name="tipo_cambio_perdida_bruta", nullable=true)
	private BigDecimal tipo_cambio_perdida_bruta;
	
	@Column(name="monto_total_recuperado", nullable=true)
	private BigDecimal monto_total_recuperado;
	
	@Column(name="monto_neto_perdida", nullable=true)
	private BigDecimal monto_neto_perdida;
	
	@Column(name="tipo_moneda_perdida_neta", nullable=true)
	private String tipo_moneda_perdida_neta;
	
	@Column(name="tipo_cambio_perdida_neta", nullable=true)
	private BigDecimal tipo_cambio_perdida_neta;
	
	@Column(name="aplica_cuenta_contable", nullable=false)
	@Enumerated(EnumType.STRING)
	private AplicaCuentaContable aplica_cuenta_contable;
	
	@Column(name="notas_cuenta_contable", nullable=true)
	private String notas_cuenta_contable;
	
	@Column(name="plazo_ejecucion", nullable=false)
	private String plazo_ejecucion;
	
	@Column(name="observaciones_generales", nullable=true)
	private String observaciones_generales;
	
	@OneToOne
	@JoinColumn(name="categoria_evento_perdida_id")
	private CategoriaEventoPerdida categoria_evento_perdida;
	
	@OneToOne
	@JoinColumn(name="linea_de_negocio_id")
	private LineaDeNegocio linea_de_negocio;
	
	@OneToOne
	@JoinColumn(name="caracter_del_riesgo_id")
	private CaracterDelRiesgo caracter_del_riesgo;
	
	@Column(name="detalle", nullable=true)
	private String detalle;
	
	@OneToOne
	@JoinColumn(name="area_id")
	private Area area;
	
	@OneToOne
	@JoinColumn(name="accion_correctiva_id")
	private AccionCorrectiva accion_correctiva;
	
	@OneToOne
	@JoinColumn(name="riesgo_vinculado_id")
	private RiesgoVinculado riesgo_vinculado;
	
	@OneToOne
	@JoinColumn(name="responsable_id")
	private Responsable responsable;
	
	public Riesgo() {
		
	}

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

	public Integer getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(Integer frecuencia) {
		this.frecuencia = frecuencia;
	}

	public BigDecimal getProbabilidad() {
		return probabilidad;
	}

	public void setProbabilidad(BigDecimal probabilidad) {
		this.probabilidad = probabilidad;
	}

	public String getControles_de_riesgo() {
		return controles_de_riesgo;
	}

	public void setControles_de_riesgo(String controles_de_riesgo) {
		this.controles_de_riesgo = controles_de_riesgo;
	}
	
	public ImpactoDelRiesgo getImpacto_del_riesgo() {
		return impacto_del_riesgo;
	}

	public void setImpacto_del_riesgo(ImpactoDelRiesgo impacto_del_riesgo) {
		this.impacto_del_riesgo = impacto_del_riesgo;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_conclusion() {
		return fecha_conclusion;
	}

	public void setFecha_conclusion(Date fecha_conclusion) {
		this.fecha_conclusion = fecha_conclusion;
	}

	public Date getFecha_descubrimiento() {
		return fecha_descubrimiento;
	}

	public void setFecha_descubrimiento(Date fecha_descubrimiento) {
		this.fecha_descubrimiento = fecha_descubrimiento;
	}

	public Date getFecha_registro_contable() {
		return fecha_registro_contable;
	}

	public void setFecha_registro_contable(Date fecha_registro_contable) {
		this.fecha_registro_contable = fecha_registro_contable;
	}

	public BigDecimal getMonto_bruto_perdida() {
		return monto_bruto_perdida;
	}

	public void setMonto_bruto_perdida(BigDecimal monto_bruto_perdida) {
		this.monto_bruto_perdida = monto_bruto_perdida;
	}

	public String getTipo_moneda_perdida_bruta() {
		return tipo_moneda_perdida_bruta;
	}

	public void setTipo_moneda_perdida_bruta(String tipo_moneda_perdida_bruta) {
		this.tipo_moneda_perdida_bruta = tipo_moneda_perdida_bruta;
	}

	public BigDecimal getTipo_cambio_perdida_bruta() {
		return tipo_cambio_perdida_bruta;
	}

	public void setTipo_cambio_perdida_bruta(BigDecimal tipo_cambio_perdida_bruta) {
		this.tipo_cambio_perdida_bruta = tipo_cambio_perdida_bruta;
	}

	public BigDecimal getMonto_neto_perdida() {
		return monto_neto_perdida;
	}

	public void setMonto_neto_perdida(BigDecimal monto_neto_perdida) {
		this.monto_neto_perdida = monto_neto_perdida;
	}

	public String getTipo_moneda_perdida_neta() {
		return tipo_moneda_perdida_neta;
	}

	public void setTipo_moneda_perdida_neta(String tipo_moneda_perdida_neta) {
		this.tipo_moneda_perdida_neta = tipo_moneda_perdida_neta;
	}

	public BigDecimal getTipo_cambio_perdida_neta() {
		return tipo_cambio_perdida_neta;
	}

	public void setTipo_cambio_perdida_neta(BigDecimal tipo_cambio_perdida_neta) {
		this.tipo_cambio_perdida_neta = tipo_cambio_perdida_neta;
	}

	public AplicaCuentaContable getAplica_cuenta_contable() {
		return aplica_cuenta_contable;
	}

	public void setAplica_cuenta_contable(AplicaCuentaContable aplica_cuenta_contable) {
		this.aplica_cuenta_contable = aplica_cuenta_contable;
	}

	public String getNotas_cuenta_contable() {
		return notas_cuenta_contable;
	}

	public void setNotas_cuenta_contable(String notas_cuenta_contable) {
		this.notas_cuenta_contable = notas_cuenta_contable;
	}

	public String getPlazo_ejecucion() {
		return plazo_ejecucion;
	}

	public void setPlazo_ejecucion(String plazo_ejecucion) {
		this.plazo_ejecucion = plazo_ejecucion;
	}

	public String getObservaciones_generales() {
		return observaciones_generales;
	}

	public void setObservaciones_generales(String observaciones_generales) {
		this.observaciones_generales = observaciones_generales;
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

	public CaracterDelRiesgo getCaracter_del_riesgo() {
		return caracter_del_riesgo;
	}

	public void setCaracter_del_riesgo(CaracterDelRiesgo caracter_del_riesgo) {
		this.caracter_del_riesgo = caracter_del_riesgo;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public AccionCorrectiva getAccion_correctiva() {
		return accion_correctiva;
	}

	public void setAccion_correctiva(AccionCorrectiva accion_correctiva) {
		this.accion_correctiva = accion_correctiva;
	}

	public RiesgoVinculado getRiesgo_vinculado() {
		return riesgo_vinculado;
	}

	public void setRiesgo_vinculado(RiesgoVinculado riesgo_vinculado) {
		this.riesgo_vinculado = riesgo_vinculado;
	}

	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	public BigDecimal getMonto_total_recuperado() {
		return monto_total_recuperado;
	}

	public void setMonto_total_recuperado(BigDecimal monto_total_recuperado) {
		this.monto_total_recuperado = monto_total_recuperado;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	@Override
	public String toString() {
		return "Riesgo [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", frecuencia=" + frecuencia
				+ ", probabilidad=" + probabilidad + ", controles_de_riesgo=" + controles_de_riesgo
				+ ", impacto_del_riesgo=" + impacto_del_riesgo + ", fecha_inicio=" + fecha_inicio
				+ ", fecha_conclusion=" + fecha_conclusion + ", fecha_descubrimiento=" + fecha_descubrimiento
				+ ", fecha_registro_contable=" + fecha_registro_contable + ", monto_bruto_perdida="
				+ monto_bruto_perdida + ", tipo_moneda_perdida_bruta=" + tipo_moneda_perdida_bruta
				+ ", tipo_cambio_perdida_bruta=" + tipo_cambio_perdida_bruta + ", monto_total_recuperado="
				+ monto_total_recuperado + ", monto_neto_perdida=" + monto_neto_perdida + ", tipo_moneda_perdida_neta="
				+ tipo_moneda_perdida_neta + ", tipo_cambio_perdida_neta=" + tipo_cambio_perdida_neta
				+ ", aplica_cuenta_contable=" + aplica_cuenta_contable + ", notas_cuenta_contable="
				+ notas_cuenta_contable + ", plazo_ejecucion=" + plazo_ejecucion + ", observaciones_generales="
				+ observaciones_generales + ", categoria_evento_perdida=" + categoria_evento_perdida
				+ ", linea_de_negocio=" + linea_de_negocio + ", caracter_del_riesgo=" + caracter_del_riesgo
				+ ", detalle=" + detalle + ", area=" + area + ", accion_correctiva=" + accion_correctiva
				+ ", riesgo_vinculado=" + riesgo_vinculado + ", responsable=" + responsable + "]";
	}

	
	
}
