package com.sgre.converters.riesgos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.model.riesgo.CategoriaEventoPerdida;
import com.sgre.service.riesgo.CategoriaEventoPerdidaService;

@Component
public class CategoriaEventoPerdidaCommandToCategoriaEventoPerdidaConverter
		implements Converter<String, CategoriaEventoPerdida> {

	@Autowired
	private CategoriaEventoPerdidaService categoriaEventoPerdidaService;
	
	@Override
	public CategoriaEventoPerdida convert(String source) {
		
		if (source == null) {
			return null;
		}
		
		return categoriaEventoPerdidaService.buscarCatergoriaPorId(Long.valueOf(source));
	}

}
