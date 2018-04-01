package com.sgre.converters.eventos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.evento.EventoCommand;
import com.sgre.model.evento.Evento;

@Component
public class EventoToEventoCommandConverter implements Converter<Evento, EventoCommand> {

	@Autowired
	@Qualifier("eventoAreaToAreaCommandConverter")
	private AreaToAreaCommandConverter areaConverter;
	
	@Autowired
	@Qualifier("eventoCaracterDelEventoToCaracterDelEventoCommandConverter")
	private CaracterDelEventoToCaracterDelEventoCommandConverter caracterDelEventoConverter;
	
	@Autowired
	@Qualifier("eventoCategoriaEventoPerdidaToCategoriaEventoPerdidaCommandConverter")
	private CategoriaEventoPerdidaToCategoriaEventoPerdidaCommandConverter categoriaEventoPerdidaConverter;
	
	@Autowired
	@Qualifier("eventoLineaDeNegocioToLineaDeNegocioCommandConverter")
	private LineaDeNegocioToLineaDeNegocioCommandConverter lineaDeNegocioConverter;
	
	@Autowired
	@Qualifier("eventoResponsableToResponsableCommandConverter")
	private ResponsableToResponsableCommandConverter responsableConverter;
	
	@Override
	public EventoCommand convert(Evento source) {
		
		if(source == null) {
			return null;
		}
		
		EventoCommand command = new EventoCommand();
		
		command.setArea(String.valueOf(source.getArea().getId()));
		
		command.setArea_command(areaConverter.convert(source.getArea()));
		
		command.setCaracter_del_evento(String.valueOf(source.getCaracter_del_evento().getId()));
	
		command.setCaracter_del_evento_command(caracterDelEventoConverter
				.convert(source.getCaracter_del_evento()));
		
		command.setCategoria_evento_perdida(String.valueOf(source.getCategoria_evento_perdida().getId()));
		
		command.setCategoria_evento_perdida_command(categoriaEventoPerdidaConverter
				.convert(source.getCategoria_evento_perdida()));
		
		command.setLinea_de_negocio(String.valueOf(source.getLinea_de_negocio().getId()));
		
		command.setLinea_de_negocio_command(lineaDeNegocioConverter
				.convert(source.getLinea_de_negocio()));
		
		command.setResponsable(String.valueOf(source.getResponsable().getId()));
		
		command.setResponsable_command(responsableConverter
				.convert(source.getResponsable()));
		
		command.setDescripcion(source.getDescripcion());
		
		command.setTitulo(source.getTitulo());
		
		if (source.getId() != null) {
			command.setId(String.valueOf(source.getId()));
		}
		
		command.setDetalle(source.getDetalle());
		
		if (source.getMonto_estimado_perdida() != null) {
			command.setMonto_estimado_perdida(String.valueOf(source.getMonto_estimado_perdida()));
		}
		
		if (source.getTipo_cambio_perdida() != null) {
			command.setTipo_cambio_perdida(String.valueOf(source.getTipo_cambio_perdida()));
		}
		
		command.setTipo_moneda_perdida(source.getTipo_moneda_perdida());
		
		command.setObservaciones_generales(source.getObservaciones_generales());
		
		return command;
	}

}
