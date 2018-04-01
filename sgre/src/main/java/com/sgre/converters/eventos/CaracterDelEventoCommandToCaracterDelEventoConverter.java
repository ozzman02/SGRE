package com.sgre.converters.eventos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.model.evento.CaracterDelEvento;
import com.sgre.service.evento.CaracterDelEventoService;


@Component
public class CaracterDelEventoCommandToCaracterDelEventoConverter 
	implements Converter<String, CaracterDelEvento> {
	
	@Autowired
	private CaracterDelEventoService service;
	
	@Override
	public CaracterDelEvento convert(String source) {
		
		if (source == null) {
			return null;
		}
		
		return service.buscarCaracterPorId(Long.valueOf(source));
	}

}
