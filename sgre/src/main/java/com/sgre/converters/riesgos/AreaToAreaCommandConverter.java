package com.sgre.converters.riesgos;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.riesgo.AreaCommand;
import com.sgre.model.riesgo.Area;

@Component
public class AreaToAreaCommandConverter implements Converter<Area, AreaCommand> {

	@Override
	public AreaCommand convert(Area source) {
		
		if (source == null) {
			return null;
		}
		
		AreaCommand command = new AreaCommand();
		command.setId(String.valueOf(source.getId()));
		command.setDescripcion(source.getDescripcion());
		
		return command;
	}

}
