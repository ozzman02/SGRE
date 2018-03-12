package com.sgre.converters.riesgo;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.riesgo.CategoriaEventoPerdidaCommand;
import com.sgre.model.riesgo.CategoriaEventoPerdida;

@Component
public class CategoriaEventoPerdidaToCategoriaEventoPerdidaCommand
		implements Converter<CategoriaEventoPerdida, CategoriaEventoPerdidaCommand> {

	@Override
	public CategoriaEventoPerdidaCommand convert(CategoriaEventoPerdida source) {
		
		if (source == null) {
			return null;
		}
		
		final CategoriaEventoPerdidaCommand categoriaEventoPerdidaCommand = new CategoriaEventoPerdidaCommand();
		
		categoriaEventoPerdidaCommand.setId(source.getId());
		categoriaEventoPerdidaCommand.setDescripcion(source.getDescripcion());
		
		return categoriaEventoPerdidaCommand;
	}

}
