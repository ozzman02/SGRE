package com.sgre.converters.eventos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.model.evento.CaracterDelEvento;
import com.sgre.service.evento.CaracterDelEventoService;


@Component(value="eventoCaracterDelEventoCommandToCaracterDelEventoConverter")
public class CaracterDelEventoCommandToCaracterDelEventoConverter 
	implements Converter<String, CaracterDelEvento> {
	
	@Autowired
	@Qualifier("caracterDelEventoService")
	private CaracterDelEventoService service;
	
	@Override
	public CaracterDelEvento convert(String source) {
		
		if (source == null) {
			return null;
		}
		
		return service.buscarCaracterPorId(Long.valueOf(source));
	}

}
