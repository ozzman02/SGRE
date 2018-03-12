package com.sgre.converters.riesgo;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.riesgo.AreaCommand;
import com.sgre.model.riesgo.Area;

@Component
public class AreaCommandToArea implements Converter<AreaCommand, Area> {

	@Override
	public Area convert(AreaCommand source) {
		
		if (source == null) {
			return null;
		}
		
		final Area area = new Area();
		
		area.setId(source.getId());
		area.setDescripcion(source.getDescripcion());
		
		return area;
	}

}
