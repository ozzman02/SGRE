package com.sgre.converters.eventos;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.evento.CategoriaEventoPerdidaCommand;
import com.sgre.model.evento.CategoriaEventoPerdida;

@Component(value="eventoCategoriaEventoPerdidaToCategoriaEventoPerdidaCommandConverter")
public class CategoriaEventoPerdidaToCategoriaEventoPerdidaCommandConverter 
	implements Converter<CategoriaEventoPerdida, CategoriaEventoPerdidaCommand>{

	@Override
	public CategoriaEventoPerdidaCommand convert(CategoriaEventoPerdida source) {
		
		if (source == null) {
			return null;
		}
		
		CategoriaEventoPerdidaCommand command = new CategoriaEventoPerdidaCommand();
		command.setId(String.valueOf(source.getId()));
		command.setDescripcion(source.getDescripcion());
		
		return command;
	}

}
