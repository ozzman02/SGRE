package com.sgre.converters.riesgos;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.riesgo.RiesgoCommand;
import com.sgre.model.riesgo.Riesgo;

@Component
public class RiesgoCommandToRiesgoConverter implements Converter<RiesgoCommand, Riesgo> {

	@Autowired
	private AccionCorrectivaCommandToAccionCorrectivaConverter accionCorrectivaConverter;
	
	@Autowired
	private AreaCommandToAreaConverter areaConverter;
	
	@Autowired
	private CaracterDelRiesgoCommandToCaracterDelRiesgoConverter caracterDelRiesgoConverter;
	
	@Autowired
	private CategoriaEventoPerdidaCommandToCategoriaEventoPerdidaConverter categoriaEventoPerdidaConverter;
	
	@Autowired
	private LineaDeNegocioCommandToLineaDeNegocioConverter lineaDeNegocioConverter;
	
	@Autowired
	private RiesgoVinculadoCommandToRiesgoVinculadoConverter riesgoVinculadoConverter;
		
	private Date convertDate(String date) {
	
		Date convertedDate = null;
		
		if (!date.isEmpty() || date != null) {
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				convertedDate = sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	
		return convertedDate;
	}
	
	@Override
	public Riesgo convert(RiesgoCommand source) {
		
	
		if (source == null) {
			return null;
		}
		
		Riesgo riesgo = new Riesgo();
		
		riesgo.setAccion_correctiva(accionCorrectivaConverter.convert(source.getAccion_correctiva()));
		
		riesgo.setArea(areaConverter.convert(source.getArea()));
		
		riesgo.setCaracter_del_riesgo(caracterDelRiesgoConverter.convert(source.getCaracter_del_riesgo()));
		
		riesgo.setCategoria_evento_perdida(categoriaEventoPerdidaConverter
				.convert(source.getCategoria_evento_perdida()));
		
		riesgo.setLinea_de_negocio(lineaDeNegocioConverter.convert(source.getLinea_de_negocio()));
		
		riesgo.setResponsable(source.getResponsable());
		
		riesgo.setRiesgo_vinculado(riesgoVinculadoConverter.convert(source.getRiesgo_vinculado()));
		
		riesgo.setAplica_cuenta_contable(source.getAplica_cuenta_contable());
		
		riesgo.setImpacto_del_riesgo(source.getImpacto_del_riesgo());
		
		riesgo.setDescripcion(source.getDescripcion());
		
		riesgo.setFecha_inicio(convertDate(source.getFecha_inicio()));
		
		riesgo.setFrecuencia(Integer.valueOf(source.getFrecuencia()));
		
		riesgo.setPlazo_ejecucion(source.getPlazo_ejecucion());
		
		riesgo.setProbabilidad(Integer.valueOf(source.getProbabilidad()));
		
		riesgo.setTitulo(source.getTitulo());
		
		if (source.getId() != null) {
			riesgo.setId(Long.valueOf(source.getId()));
		}
		
		if (!source.getControles_de_riesgo().isEmpty()) {
			riesgo.setControles_de_riesgo(source.getControles_de_riesgo());
		}
		
		if (!source.getDetalle().isEmpty()) {
			riesgo.setDetalle(source.getDetalle());
		}
		
		if (!source.getFecha_conclusion().isEmpty()) {
			riesgo.setFecha_conclusion(convertDate(source.getFecha_conclusion()));
		}
		
		if (!source.getFecha_descubrimiento().isEmpty()) {
			riesgo.setFecha_descubrimiento(convertDate(source.getFecha_descubrimiento()));
		}
		
		if (!source.getFecha_registro_contable().isEmpty()) {
			riesgo.setFecha_registro_contable(convertDate(source.getFecha_registro_contable()));
		}
		
		if (!source.getMonto_bruto_perdida().isEmpty()) {
			riesgo.setMonto_bruto_perdida(new BigDecimal(source.getMonto_bruto_perdida()));
		}
		
		if (!source.getMonto_neto_perdida().isEmpty()) {
			riesgo.setMonto_neto_perdida(new BigDecimal(source.getMonto_neto_perdida()));
		}
		
		if (!source.getMonto_total_recuperado().isEmpty()) {
			riesgo.setMonto_total_recuperado(new BigDecimal(source.getMonto_total_recuperado()));
		}
		
		if (!source.getNotas_cuenta_contable().isEmpty()) {
			riesgo.setNotas_cuenta_contable(source.getNotas_cuenta_contable());
		}
		
		if (!source.getObservaciones_generales().isEmpty()) {
			riesgo.setObservaciones_generales(source.getObservaciones_generales());
		}
		
		if (!source.getTipo_cambio_perdida_bruta().isEmpty()) {
			riesgo.setTipo_cambio_perdida_bruta(new BigDecimal(source.getTipo_cambio_perdida_bruta()));
		}
			
		if (!source.getTipo_cambio_perdida_neta().isEmpty()) {
			riesgo.setTipo_cambio_perdida_neta(new BigDecimal(source.getTipo_cambio_perdida_neta()));
		}
		
		if (!source.getTipo_moneda_perdida_bruta().isEmpty()) {
			riesgo.setTipo_moneda_perdida_bruta(source.getTipo_moneda_perdida_bruta());
		}
		
		if (!source.getTipo_moneda_perdida_neta().isEmpty()) {
			riesgo.setTipo_moneda_perdida_neta(source.getTipo_moneda_perdida_neta());
		}
		
		return riesgo;
	}
	

}
