package com.sgre.converters.eventos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.model.evento.CategoriaEventoPerdida;
import com.sgre.service.evento.CategoriaEventoPerdidaService;

@Component(value="eventoCategoriaEventoPerdidaCommandToCategoriaEventoPerdidaConverter")
public class CategoriaEventoPerdidaCommandToCategoriaEventoPerdidaConverter 
	implements Converter<String, CategoriaEventoPerdida> {

	@Autowired
	@Qualifier("eventoCategoriaEventoPerdidaService")
	private CategoriaEventoPerdidaService service;
	
	@Override
	public CategoriaEventoPerdida convert(String source) {
		
		if (source == null) {
			return null;
		}
		
		return service.buscarCatergoriaPorId(Long.valueOf(source));
	}

}
