package com.sgre.converters.riesgos;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.riesgo.AccionCorrectivaCommand;
import com.sgre.model.riesgo.AccionCorrectiva;

@Component
public class AccionCorrectivaToAccionCorrectivaCommandConverter
		implements Converter<AccionCorrectiva, AccionCorrectivaCommand> {

	@Override
	public AccionCorrectivaCommand convert(AccionCorrectiva source) {
		
		if (source == null) {
			return null;
		}
		
		AccionCorrectivaCommand command = new AccionCorrectivaCommand();
		command.setId(String.valueOf(source.getId()));
		command.setDescripcion(source.getDescripcion());
		
		return command;
	}

}
