package com.sgre.converters.eventos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.model.evento.Responsable;
import com.sgre.service.evento.ResponsableService;

@Component
public class ResponsableCommandToResponsableConverter implements Converter<String, Responsable> {

	@Autowired
	private ResponsableService service;
	
	@Override
	public Responsable convert(String source) {
		
		if (source == null) {
			return null;
		}
		
		return service.buscarResponsablePorId(Long.valueOf(source));
	}

}
