package com.sgre.commands.riesgo;

import java.math.BigDecimal;
import java.util.Date;

import com.sgre.model.riesgo.AplicaCuentaContable;
import com.sgre.model.riesgo.ImpactoDelRiesgo;

public class RiesgoCommand {

	private Long id;
	
	private String titulo;
	
	private String descripcion;
	
	private Integer frecuencia;
	
	private BigDecimal probabilidad;
	
	private String controles_de_riesgo;
	
	private ImpactoDelRiesgo impacto_del_riesgo;
	
	private Date fecha_inicio;
	
	private Date fecha_conclusion;
	
	private Date fecha_descubrimiento;
	
	private Date fecha_registro_contable;
	
	private BigDecimal monto_bruto_perdida;
	
	private String tipo_moneda_perdida_bruta;
	
	private BigDecimal tipo_cambio_perdida_bruta;
	
	private BigDecimal monto_total_recuperado;
	
	private BigDecimal monto_neto_perdida;
	
	private String tipo_moneda_perdida_neta;
	
	private BigDecimal tipo_cambio_perdida_neta;
	
	private AplicaCuentaContable aplica_cuenta_contable;
	
	private String notas_cuenta_contable;
	
	private String plazo_ejecucion;
	
	private String observaciones_generales;
	
	private CategoriaEventoPerdidaCommand categoria_evento_perdida;
	
	private LineaDeNegocioCommand linea_de_negocio;
	
	private CaracterDelRiesgoCommand caracter_del_riesgo;
	
	private String detalle;
	
	private AreaCommand area;
	
	private AccionCorrectivaCommand accion_correctiva;
	
	private RiesgoVinculadoCommand riesgo_vinculado;
	
	private ResponsableCommand responsable;

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

	public BigDecimal getMonto_total_recuperado() {
		return monto_total_recuperado;
	}

	public void setMonto_total_recuperado(BigDecimal monto_total_recuperado) {
		this.monto_total_recuperado = monto_total_recuperado;
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

	public CategoriaEventoPerdidaCommand getCategoria_evento_perdida() {
		return categoria_evento_perdida;
	}

	public void setCategoria_evento_perdida(CategoriaEventoPerdidaCommand categoria_evento_perdida) {
		this.categoria_evento_perdida = categoria_evento_perdida;
	}

	public LineaDeNegocioCommand getLinea_de_negocio() {
		return linea_de_negocio;
	}

	public void setLinea_de_negocio(LineaDeNegocioCommand linea_de_negocio) {
		this.linea_de_negocio = linea_de_negocio;
	}

	public CaracterDelRiesgoCommand getCaracter_del_riesgo() {
		return caracter_del_riesgo;
	}

	public void setCaracter_del_riesgo(CaracterDelRiesgoCommand caracter_del_riesgo) {
		this.caracter_del_riesgo = caracter_del_riesgo;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public AreaCommand getArea() {
		return area;
	}

	public void setArea(AreaCommand area) {
		this.area = area;
	}

	public AccionCorrectivaCommand getAccion_correctiva() {
		return accion_correctiva;
	}

	public void setAccion_correctiva(AccionCorrectivaCommand accion_correctiva) {
		this.accion_correctiva = accion_correctiva;
	}

	public RiesgoVinculadoCommand getRiesgo_vinculado() {
		return riesgo_vinculado;
	}

	public void setRiesgo_vinculado(RiesgoVinculadoCommand riesgo_vinculado) {
		this.riesgo_vinculado = riesgo_vinculado;
	}

	public ResponsableCommand getResponsable() {
		return responsable;
	}

	public void setResponsable(ResponsableCommand responsable) {
		this.responsable = responsable;
	}
	
}
