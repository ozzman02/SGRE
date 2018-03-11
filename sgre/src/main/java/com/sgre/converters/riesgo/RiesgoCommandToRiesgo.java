package com.sgre.converters.riesgo;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.riesgo.RiesgoCommand;
import com.sgre.model.riesgo.Riesgo;

@Component
public class RiesgoCommandToRiesgo implements Converter<RiesgoCommand, Riesgo> {

	@Override
	public Riesgo convert(RiesgoCommand source) {
		// TODO Auto-generated method stub
		return null;
	}

}
