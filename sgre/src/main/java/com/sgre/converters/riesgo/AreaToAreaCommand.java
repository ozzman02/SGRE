package com.sgre.converters.riesgo;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.riesgo.AreaCommand;
import com.sgre.model.riesgo.Area;

@Component
public class AreaToAreaCommand implements Converter<Area, AreaCommand> {

	@Override
	public AreaCommand convert(Area source) {
		
		if (source == null) {
			return null;
		}
		
		final AreaCommand areaCommand = new AreaCommand();
		
		areaCommand.setId(source.getId());
		areaCommand.setDescripcion(source.getDescripcion());
		
		return areaCommand;
	}

}
