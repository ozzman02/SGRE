package com.sgre.converters.eventos;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.evento.LineaDeNegocioCommand;
import com.sgre.model.evento.LineaDeNegocio;

@Component(value="eventoLineaDeNegocioToLineaDeNegocioCommandConverter")
public class LineaDeNegocioToLineaDeNegocioCommandConverter 
	implements Converter<LineaDeNegocio, LineaDeNegocioCommand> {

	@Override
	public LineaDeNegocioCommand convert(LineaDeNegocio source) {
		
		if (source == null) {
			return null;
		}
		
		LineaDeNegocioCommand command = new LineaDeNegocioCommand();
		command.setId(String.valueOf(source.getId()));
		command.setDescripcion(source.getDescripcion());
		command.setTipo(source.getTipo());
		
		return command;
	}

}
