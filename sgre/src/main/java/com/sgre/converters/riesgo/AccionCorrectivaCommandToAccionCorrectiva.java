package com.sgre.converters.riesgo;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.riesgo.AccionCorrectivaCommand;
import com.sgre.model.riesgo.AccionCorrectiva;

@Component
public class AccionCorrectivaCommandToAccionCorrectiva implements Converter<AccionCorrectivaCommand, AccionCorrectiva> {

	@Override
	public AccionCorrectiva convert(AccionCorrectivaCommand source) {
		// TODO Auto-generated method stub
		return null;
	}

}
