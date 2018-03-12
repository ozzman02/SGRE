package com.sgre.converters.riesgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.riesgo.RiesgoCommand;
import com.sgre.model.riesgo.Riesgo;

@Component
public class RiesgoCommandToRiesgo implements Converter<RiesgoCommand, Riesgo> {

	@Autowired
	private CategoriaEventoPerdidaCommandToCategoriaEventoPerdida categoriaEventoPerdidaConverter;
	
	@Autowired
	private LineaDeNegocioCommandToLineaDeNegocio lineaDeNegocioConverter;
	
	@Autowired
	private CaracterDelRiesgoCommandToCaracterDelRiesgo caracterDelRiesgoConverter;
	
	@Autowired
	private AreaCommandToArea areaConverter;
	
	@Autowired
	private AccionCorrectivaCommandToAccionCorrectiva accionCorrectivaConverter;
	
	@Autowired
	private RiesgoVinculadoCommandToRiesgoVinculado riesgoVinculadoConverter;
	
	@Autowired
	private ResponsableCommandToResponsable responsableConverter;
	
	@Override
	public Riesgo convert(RiesgoCommand source) {
		
		if (source == null) {
			return null;
		}
		
		Riesgo riesgo = new Riesgo();
		
		riesgo.setId(source.getId());
		riesgo.setTitulo(source.getTitulo());
		riesgo.setDescripcion(source.getDescripcion());
		riesgo.setCategoria_evento_perdida(categoriaEventoPerdidaConverter.convert(source.getCategoria_evento_perdida()));
		riesgo.setLinea_de_negocio(lineaDeNegocioConverter.convert(source.getLinea_de_negocio()));
		riesgo.setCaracter_del_riesgo(caracterDelRiesgoConverter.convert(source.getCaracter_del_riesgo()));
		riesgo.setDetalle(source.getDetalle());
		riesgo.setArea(areaConverter.convert(source.getArea()));
		riesgo.setFrecuencia(source.getFrecuencia());
		riesgo.setProbabilidad(source.getProbabilidad());
		riesgo.setControles_de_riesgo(source.getControles_de_riesgo());
		riesgo.setImpacto_del_riesgo(source.getImpacto_del_riesgo());
		riesgo.setFecha_inicio(source.getFecha_inicio());
		riesgo.setFecha_conclusion(source.getFecha_conclusion());
		riesgo.setFecha_descubrimiento(source.getFecha_descubrimiento());
		riesgo.setFecha_registro_contable(source.getFecha_registro_contable());
		riesgo.setMonto_bruto_perdida(source.getMonto_bruto_perdida());
		riesgo.setTipo_moneda_perdida_bruta(source.getTipo_moneda_perdida_bruta());
		riesgo.setTipo_cambio_perdida_bruta(source.getTipo_cambio_perdida_bruta());
		riesgo.setMonto_total_recuperado(source.getMonto_total_recuperado());
		riesgo.setMonto_neto_perdida(source.getMonto_neto_perdida());
		riesgo.setTipo_moneda_perdida_neta(source.getTipo_moneda_perdida_neta());
		riesgo.setTipo_cambio_perdida_neta(source.getTipo_cambio_perdida_neta());
		riesgo.setAplica_cuenta_contable(source.getAplica_cuenta_contable());
		riesgo.setNotas_cuenta_contable(source.getNotas_cuenta_contable());
		riesgo.setAccion_correctiva(accionCorrectivaConverter.convert(source.getAccion_correctiva()));
		riesgo.setRiesgo_vinculado(riesgoVinculadoConverter.convert(source.getRiesgo_vinculado()));
		riesgo.setPlazo_ejecucion(source.getPlazo_ejecucion());
		riesgo.setResponsable(responsableConverter.convert(source.getResponsable()));
		riesgo.setObservaciones_generales(source.getObservaciones_generales());
		
		return riesgo;
	}

}
