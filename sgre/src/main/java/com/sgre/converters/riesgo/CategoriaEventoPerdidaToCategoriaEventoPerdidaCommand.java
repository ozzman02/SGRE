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
		// TODO Auto-generated method stub
		return null;
	}

}
