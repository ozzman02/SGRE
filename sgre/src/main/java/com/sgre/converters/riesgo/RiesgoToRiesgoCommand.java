package com.sgre.converters.riesgo;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.riesgo.RiesgoCommand;
import com.sgre.model.riesgo.Riesgo;

@Component
public class RiesgoToRiesgoCommand implements Converter<Riesgo, RiesgoCommand> {

	@Override
	public RiesgoCommand convert(Riesgo source) {
		// TODO Auto-generated method stub
		return null;
	}

}
