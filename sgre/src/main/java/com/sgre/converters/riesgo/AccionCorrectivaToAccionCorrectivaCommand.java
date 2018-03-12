package com.sgre.converters.riesgo;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.riesgo.AccionCorrectivaCommand;
import com.sgre.model.riesgo.AccionCorrectiva;

@Component
public class AccionCorrectivaToAccionCorrectivaCommand implements Converter<AccionCorrectiva, AccionCorrectivaCommand> {

	@Override
	public AccionCorrectivaCommand convert(AccionCorrectiva source) {
		
		if (source == null) {
			return null;
		}
		
		final AccionCorrectivaCommand accionCorrectivaCommand = new AccionCorrectivaCommand();
		
		accionCorrectivaCommand.setId(source.getId());
		accionCorrectivaCommand.setDescripcion(source.getDescripcion());
		
		return accionCorrectivaCommand;
		
	}

}
