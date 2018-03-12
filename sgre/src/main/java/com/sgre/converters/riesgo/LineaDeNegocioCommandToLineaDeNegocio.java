package com.sgre.converters.riesgo;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.riesgo.LineaDeNegocioCommand;
import com.sgre.model.riesgo.LineaDeNegocio;

@Component
public class LineaDeNegocioCommandToLineaDeNegocio implements Converter<LineaDeNegocioCommand, LineaDeNegocio> {

	@Override
	public LineaDeNegocio convert(LineaDeNegocioCommand source) {
		
		if (source == null) {
			return null;
		}
		
		final LineaDeNegocio lineaDeNegocio = new LineaDeNegocio();
		
		lineaDeNegocio.setId(source.getId());
		lineaDeNegocio.setDescripcion(source.getDescripcion());
		lineaDeNegocio.setTipo(source.getTipo());
		
		return lineaDeNegocio;
	}

}
