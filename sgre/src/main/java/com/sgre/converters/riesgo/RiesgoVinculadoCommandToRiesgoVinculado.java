package com.sgre.converters.riesgo;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.riesgo.RiesgoVinculadoCommand;
import com.sgre.model.riesgo.RiesgoVinculado;

@Component
public class RiesgoVinculadoCommandToRiesgoVinculado implements Converter<RiesgoVinculadoCommand, RiesgoVinculado> {

	@Override
	public RiesgoVinculado convert(RiesgoVinculadoCommand source) {
		
		if (source == null) {
			return null;
		}
		
		final RiesgoVinculado riesgoVinculado = new RiesgoVinculado();
		
		riesgoVinculado.setId(source.getId());
		riesgoVinculado.setDescripcion(source.getDescripcion());
		
		return riesgoVinculado;
	}

}
