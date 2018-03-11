package com.sgre.converters.riesgo;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.riesgo.CategoriaEventoPerdidaCommand;
import com.sgre.model.riesgo.CategoriaEventoPerdida;

@Component
public class CategoriaEventoPerdidaCommandToCategoriaEventoPerdida
		implements Converter<CategoriaEventoPerdidaCommand, CategoriaEventoPerdida> {

	@Override
	public CategoriaEventoPerdida convert(CategoriaEventoPerdidaCommand source) {
		// TODO Auto-generated method stub
		return null;
	}

}
