package com.sgre.converters.riesgo;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.riesgo.ResponsableCommand;
import com.sgre.model.riesgo.Responsable;

@Component
public class ResponsableToResponsableCommand implements Converter<Responsable, ResponsableCommand> {

	@Override
	public ResponsableCommand convert(Responsable source) {
		// TODO Auto-generated method stub
		return null;
	}

}
