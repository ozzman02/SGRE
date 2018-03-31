package com.sgre.converters.riesgos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.model.riesgo.Responsable;
import com.sgre.service.riesgo.ResponsableService;

@Component
public class ResponsableCommandToResponsableConverter implements Converter<String, Responsable> {

	@Autowired
	private ResponsableService responsableService;
	
	@Override
	public Responsable convert(String source) {
		
		if (source == null) {
			return null;
		}
		
		return responsableService.buscarResponsablePorId(Long.valueOf(source));
	}

}
