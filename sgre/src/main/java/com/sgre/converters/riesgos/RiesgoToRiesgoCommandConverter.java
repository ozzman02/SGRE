package com.sgre.converters.riesgos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.riesgo.RiesgoCommand;
import com.sgre.model.riesgo.Riesgo;

@Component
public class RiesgoToRiesgoCommandConverter implements Converter<Riesgo, RiesgoCommand> {

	@Autowired
	private AccionCorrectivaToAccionCorrectivaCommandConverter accionCorrectivaConverter;
	
	@Autowired
	private AreaToAreaCommandConverter areaConverter;
	
	@Autowired
	private CaracterDelRiesgoToCaracterDelRiesgoCommandConverter caracterDelRiesgoConverter;
	
	@Autowired
	private CategoriaEventoPerdidaToCategoriaEventoPerdidaCommandConverter categoriaEventoPerdidaConverter;
	
	@Autowired
	private LineaDeNegocioToLineaDeNegocioCommandConverter lineaDeNegocioConverter;
	
	@Autowired 
	private ResponsableToResponsableCommandConverter responsableConverter;
	
	@Autowired
	private RiesgoVinculadoToRiesgoVinculadoCommandConverter riesgoVinculadoConverter;
	
	private String convertDate(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateAsText = df.format(date);
		return dateAsText;
	}
	
	@Override
	public RiesgoCommand convert(Riesgo source) {
		
		if(source == null) {
			return null;
		}
		
		RiesgoCommand command = new RiesgoCommand();
		
		command.setAccion_correctiva(String.valueOf(source.getAccion_correctiva().getId()));
		command.setAccion_correctiva_command(accionCorrectivaConverter.convert(source.getAccion_correctiva()));
		command.setArea(String.valueOf(source.getArea().getId()));
		command.setArea_command(areaConverter.convert(source.getArea()));
		command.setCaracter_del_riesgo(String.valueOf(source.getCaracter_del_riesgo().getId()));
		command.setCaracter_del_riesgo_command(caracterDelRiesgoConverter.convert(source.getCaracter_del_riesgo()));
		command.setCategoria_evento_perdida(String.valueOf(source.getCategoria_evento_perdida().getId()));
		command.setCategoria_evento_perdida_command(categoriaEventoPerdidaConverter
				.convert(source.getCategoria_evento_perdida()));
		command.setLinea_de_negocio(String.valueOf(source.getLinea_de_negocio().getId()));
		command.setLinea_de_negocio_command(lineaDeNegocioConverter.convert(source.getLinea_de_negocio()));
		command.setResponsable(String.valueOf(source.getResponsable().getId()));
		command.setResponsable_command(responsableConverter.convert(source.getResponsable()));
		command.setRiesgo_vinculado(String.valueOf(source.getRiesgo_vinculado().getId()));
		command.setRiesgo_vinculado_command(riesgoVinculadoConverter.convert(source.getRiesgo_vinculado()));
		command.setAplica_cuenta_contable(source.getAplica_cuenta_contable());
		command.setImpacto_del_riesgo(source.getImpacto_del_riesgo());
		command.setDescripcion(source.getDescripcion());
		command.setFecha_inicio(convertDate(source.getFecha_inicio()));
		command.setFrecuencia(String.valueOf(source.getFrecuencia()));
		command.setPlazo_ejecucion(source.getPlazo_ejecucion());
		command.setProbabilidad(String.valueOf(source.getProbabilidad()));
		command.setTitulo(source.getTitulo());
		
		if (source.getId() != null) {
			command.setId(String.valueOf(source.getId()));
		}
		
		command.setControles_de_riesgo(source.getControles_de_riesgo());
		
		command.setDetalle(source.getDetalle());
		
		if (source.getFecha_conclusion() != null) {
			command.setFecha_conclusion(convertDate(source.getFecha_conclusion()));
		}
		
		if (source.getFecha_descubrimiento() != null) {
			command.setFecha_descubrimiento(convertDate(source.getFecha_descubrimiento()));
		}
		
		if (source.getFecha_registro_contable() != null) {
			command.setFecha_registro_contable(convertDate(source.getFecha_registro_contable()));
		}
		
		if (source.getMonto_bruto_perdida() != null) {
			command.setMonto_bruto_perdida(String.valueOf(source.getMonto_bruto_perdida()));
		}
		
		if (source.getMonto_neto_perdida() != null) {
			command.setMonto_neto_perdida(String.valueOf(source.getMonto_neto_perdida()));
		}
		
		if (source.getMonto_total_recuperado() != null) {
			command.setMonto_total_recuperado(String.valueOf(source.getMonto_total_recuperado()));
		}
		
		command.setNotas_cuenta_contable(source.getNotas_cuenta_contable());
		
		command.setObservaciones_generales(source.getObservaciones_generales());
		
		if (source.getTipo_cambio_perdida_bruta() != null) {
			command.setTipo_cambio_perdida_bruta(String.valueOf(source.getTipo_cambio_perdida_bruta()));
		}
		
		if (source.getTipo_cambio_perdida_neta() != null) {
			command.setTipo_cambio_perdida_neta(String.valueOf(source.getTipo_cambio_perdida_neta()));
		}
		
		command.setTipo_moneda_perdida_bruta(source.getTipo_moneda_perdida_bruta());
		
		command.setTipo_moneda_perdida_neta(source.getTipo_moneda_perdida_neta());
		
		return command;
	}

}
