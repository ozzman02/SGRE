package com.sgre.converters.riesgos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.model.riesgo.AccionCorrectiva;
import com.sgre.service.riesgo.AccionCorrectivaService;

@Component
public class AccionCorrectivaCommandToAccionCorrectivaConverter
		implements Converter<String, AccionCorrectiva> {
	
	@Autowired
	private AccionCorrectivaService accionCorrectivaService;
	
	@Override
	public AccionCorrectiva convert(String source) {

		if (source == null) {
			return null;
		}
			
		return accionCorrectivaService.buscarAccionCorrectivaPorId(Long.valueOf(source));
	}

}
