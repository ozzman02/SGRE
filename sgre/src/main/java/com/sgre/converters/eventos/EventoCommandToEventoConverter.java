package com.sgre.converters.eventos;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.evento.EventoCommand;
import com.sgre.model.evento.Evento;

@Component
public class EventoCommandToEventoConverter implements Converter<EventoCommand, Evento> {

	@Autowired
	@Qualifier("eventoAreaCommandToAreaConverter")
	private AreaCommandToAreaConverter areaConverter;
	
	@Autowired
	@Qualifier("eventoCaracterDelEventoCommandToCaracterDelEventoConverter")
	private CaracterDelEventoCommandToCaracterDelEventoConverter caracterDelEventoConverter;
	
	@Autowired
	@Qualifier("eventoCategoriaEventoPerdidaCommandToCategoriaEventoPerdidaConverter")
	private CategoriaEventoPerdidaCommandToCategoriaEventoPerdidaConverter categoriaEventoPerdidaConverter;
	
	@Autowired
	@Qualifier("eventoLineaDeNegocioCommandToLineaDeNegocioConverter")
	private LineaDeNegocioCommandToLineaDeNegocioConverter lineaDeNegocioConverter;
	
	@Override
	public Evento convert(EventoCommand source) {
		
		if (source == null) {
			return null;
		}
		
		Evento evento = new Evento();
		
		evento.setArea(areaConverter.convert(source.getArea()));
		
		evento.setCaracter_del_evento(caracterDelEventoConverter
				.convert(source.getCaracter_del_evento()));
		
		evento.setCategoria_evento_perdida(categoriaEventoPerdidaConverter
				.convert(source.getCategoria_evento_perdida()));
		
		evento.setLinea_de_negocio(lineaDeNegocioConverter
				.convert(source.getLinea_de_negocio()));
		
		evento.setResponsable(source.getResponsable());
		
		evento.setDescripcion(source.getDescripcion());
		
		evento.setTitulo(source.getTitulo());
		
		if (source.getId() != null) {
			evento.setId(Long.valueOf(source.getId()));
		}
		
		if (!source.getDetalle().isEmpty()) {
			evento.setDetalle(source.getDetalle());
		}
		
		if (!source.getMonto_estimado_perdida().isEmpty()) {
			evento.setMonto_estimado_perdida(new BigDecimal(source.getMonto_estimado_perdida()));
		}
		
		if (!source.getTipo_moneda_perdida().isEmpty()) {
			evento.setTipo_moneda_perdida(source.getTipo_moneda_perdida());
		}
		
		if (!source.getTipo_cambio_perdida().isEmpty()) {
			evento.setTipo_cambio_perdida(new BigDecimal(source.getTipo_cambio_perdida()));
		}
		
		if (!source.getObservaciones_generales().isEmpty()) {
			evento.setObservaciones_generales(source.getObservaciones_generales());
		}
		
		return evento;
		
	}
	
}
