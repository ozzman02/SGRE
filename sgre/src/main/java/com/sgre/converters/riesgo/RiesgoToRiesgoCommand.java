package com.sgre.converters.riesgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.riesgo.RiesgoCommand;
import com.sgre.model.riesgo.Riesgo;

@Component
public class RiesgoToRiesgoCommand implements Converter<Riesgo, RiesgoCommand> {

	@Autowired
	private CategoriaEventoPerdidaToCategoriaEventoPerdidaCommand categoriaEventoPerdidaConverter;
	
	@Autowired
	private LineaDeNegocioToLineaDeNegocioCommand lineaDeNegocioConverter;
	
	@Autowired
	private CaracterDelRiesgoToCaracterDelRiesgoCommand caracterDelRiesgoConverter;
	
	@Autowired
	private AreaToAreaCommand areaConverter;
	
	@Autowired
	private AccionCorrectivaToAccionCorrectivaCommand accionCorrectivaConverter;
	
	@Autowired
	private RiesgoVinculadoToRiesgoVinculadoCommand riesgoVinculadoConverter;
	
	@Autowired
	private ResponsableToResponsableCommand responsableConverter;
	
	@Override
	public RiesgoCommand convert(Riesgo source) {
		
		if (source == null) {
			return null;
		}
		
		RiesgoCommand riesgoCommand = new RiesgoCommand();
		
		riesgoCommand.setId(source.getId());
		riesgoCommand.setTitulo(source.getTitulo());
		riesgoCommand.setDescripcion(source.getDescripcion());
		riesgoCommand.setCategoria_evento_perdida(categoriaEventoPerdidaConverter.convert(source.getCategoria_evento_perdida()));
		riesgoCommand.setLinea_de_negocio(lineaDeNegocioConverter.convert(source.getLinea_de_negocio()));
		riesgoCommand.setCaracter_del_riesgo(caracterDelRiesgoConverter.convert(source.getCaracter_del_riesgo()));
		riesgoCommand.setDetalle(source.getDetalle());
		riesgoCommand.setArea(areaConverter.convert(source.getArea()));
		riesgoCommand.setFrecuencia(source.getFrecuencia());
		riesgoCommand.setProbabilidad(source.getProbabilidad());
		riesgoCommand.setControles_de_riesgo(source.getControles_de_riesgo());
		riesgoCommand.setImpacto_del_riesgo(source.getImpacto_del_riesgo());
		riesgoCommand.setFecha_inicio(source.getFecha_inicio());
		riesgoCommand.setFecha_conclusion(source.getFecha_conclusion());
		riesgoCommand.setFecha_descubrimiento(source.getFecha_descubrimiento());
		riesgoCommand.setFecha_registro_contable(source.getFecha_registro_contable());
		riesgoCommand.setMonto_bruto_perdida(source.getMonto_bruto_perdida());
		riesgoCommand.setTipo_moneda_perdida_bruta(source.getTipo_moneda_perdida_bruta());
		riesgoCommand.setTipo_cambio_perdida_bruta(source.getTipo_cambio_perdida_bruta());
		riesgoCommand.setMonto_total_recuperado(source.getMonto_total_recuperado());
		riesgoCommand.setMonto_neto_perdida(source.getMonto_neto_perdida());
		riesgoCommand.setTipo_moneda_perdida_neta(source.getTipo_moneda_perdida_neta());
		riesgoCommand.setTipo_cambio_perdida_neta(source.getTipo_cambio_perdida_neta());
		riesgoCommand.setAplica_cuenta_contable(source.getAplica_cuenta_contable());
		riesgoCommand.setNotas_cuenta_contable(source.getNotas_cuenta_contable());
		riesgoCommand.setAccion_correctiva(accionCorrectivaConverter.convert(source.getAccion_correctiva()));
		riesgoCommand.setRiesgo_vinculado(riesgoVinculadoConverter.convert(source.getRiesgo_vinculado()));
		riesgoCommand.setPlazo_ejecucion(source.getPlazo_ejecucion());
		riesgoCommand.setResponsable(responsableConverter.convert(source.getResponsable()));
		riesgoCommand.setObservaciones_generales(source.getObservaciones_generales());
		
		return riesgoCommand;
	}

}
