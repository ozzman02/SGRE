package com.sgre.converters.eventos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.model.evento.LineaDeNegocio;
import com.sgre.service.evento.LineaDeNegocioService;

@Component
public class LineaDeNegocioCommandToLineaDeNegocioConverter implements Converter<String, LineaDeNegocio> {

	@Autowired
	private LineaDeNegocioService service;
	
	@Override
	public LineaDeNegocio convert(String source) {
		
		if (source == null) {
			return null;
		}

		return service.buscarLineaDeNegocioPorId(Long.valueOf(source));
	}

}
