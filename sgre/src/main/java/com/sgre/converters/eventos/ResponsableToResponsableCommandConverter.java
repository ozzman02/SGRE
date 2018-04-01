package com.sgre.converters.eventos;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.evento.ResponsableCommand;
import com.sgre.model.evento.Responsable;

@Component(value="eventoResponsableToResponsableCommandConverter")
public class ResponsableToResponsableCommandConverter implements Converter<Responsable, ResponsableCommand> {

	@Override
	public ResponsableCommand convert(Responsable source) {
		
		if (source == null) {
			return null;
		}

		ResponsableCommand command = new ResponsableCommand();
		command.setId(String.valueOf(source.getId()));
		command.setNombre(source.getNombre());
		command.setApellido(source.getApellido());
		command.setPuesto(source.getPuesto());

		return command;
		
	}

}
