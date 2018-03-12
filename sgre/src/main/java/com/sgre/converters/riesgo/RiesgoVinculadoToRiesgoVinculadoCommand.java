package com.sgre.converters.riesgo;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.riesgo.RiesgoVinculadoCommand;
import com.sgre.model.riesgo.RiesgoVinculado;

@Component
public class RiesgoVinculadoToRiesgoVinculadoCommand implements Converter<RiesgoVinculado, RiesgoVinculadoCommand> {

	@Override
	public RiesgoVinculadoCommand convert(RiesgoVinculado source) {
		
		if (source == null) {
			return null;
		}
		
		final RiesgoVinculadoCommand riesgoVinculadoCommand = new RiesgoVinculadoCommand();
		
		riesgoVinculadoCommand.setId(source.getId());
		riesgoVinculadoCommand.setDescripcion(source.getDescripcion());
		
		return riesgoVinculadoCommand;
	}

}
