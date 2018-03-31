package com.sgre.converters.riesgos;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.riesgo.RiesgoVinculadoCommand;
import com.sgre.model.riesgo.RiesgoVinculado;

@Component
public class RiesgoVinculadoToRiesgoVinculadoCommandConverter implements Converter<RiesgoVinculado, RiesgoVinculadoCommand> {

	@Override
	public RiesgoVinculadoCommand convert(RiesgoVinculado source) {
		
		if(source == null) {
			return null;
		}
		
		RiesgoVinculadoCommand command = new RiesgoVinculadoCommand();
		command.setId(String.valueOf(source.getId()));
		command.setDescripcion(source.getDescripcion());
		
		return command;
	}
	
}
