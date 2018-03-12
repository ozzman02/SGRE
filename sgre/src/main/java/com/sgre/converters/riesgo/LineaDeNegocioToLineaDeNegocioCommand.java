package com.sgre.converters.riesgo;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.riesgo.LineaDeNegocioCommand;
import com.sgre.model.riesgo.LineaDeNegocio;

@Component
public class LineaDeNegocioToLineaDeNegocioCommand implements Converter<LineaDeNegocio, LineaDeNegocioCommand> {

	@Override
	public LineaDeNegocioCommand convert(LineaDeNegocio source) {
		
		if (source == null) {
			return null;
		}
		
		final LineaDeNegocioCommand lineaDeNegocioCommand = new LineaDeNegocioCommand();
		
		lineaDeNegocioCommand.setId(source.getId());
		lineaDeNegocioCommand.setDescripcion(source.getDescripcion());
		lineaDeNegocioCommand.setTipo(source.getTipo());
		
		return lineaDeNegocioCommand;
	}

}
