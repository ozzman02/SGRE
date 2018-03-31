package com.sgre.converters.riesgos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.model.riesgo.LineaDeNegocio;
import com.sgre.service.riesgo.LineaDeNegocioService;

@Component
public class LineaDeNegocioCommandToLineaDeNegocioConverter implements Converter<String, LineaDeNegocio> {

	@Autowired
	private LineaDeNegocioService lineaDeNegocioService;

	@Override
	public LineaDeNegocio convert(String source) {

		if (source == null) {
			return null;
		}

		return lineaDeNegocioService.buscarLineaDeNegocioPorId(Long.valueOf(source));
	}

}
