package com.sgre.converters.riesgo;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.riesgo.AreaCommand;
import com.sgre.model.riesgo.Area;

@Component
public class AreaCommandToArea implements Converter<AreaCommand, Area> {

	@Override
	public Area convert(AreaCommand source) {
		// TODO Auto-generated method stub
		return null;
	}

}
