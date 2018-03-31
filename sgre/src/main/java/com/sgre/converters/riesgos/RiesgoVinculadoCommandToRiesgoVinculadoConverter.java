package com.sgre.converters.riesgos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.model.riesgo.RiesgoVinculado;
import com.sgre.service.riesgo.RiesgoVinculadoService;

@Component
public class RiesgoVinculadoCommandToRiesgoVinculadoConverter
		implements Converter<String, RiesgoVinculado> {

	@Autowired
	private RiesgoVinculadoService riesgoVinculadoService;
	
	@Override
	public RiesgoVinculado convert(String source) {

		if (source == null) {
			return null;
		}

		return riesgoVinculadoService.buscarRiesgoVinculadoPorId(Long.valueOf(source));
	}

}
