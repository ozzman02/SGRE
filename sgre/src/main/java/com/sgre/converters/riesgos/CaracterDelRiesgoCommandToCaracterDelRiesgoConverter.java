package com.sgre.converters.riesgos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.model.riesgo.CaracterDelRiesgo;
import com.sgre.service.riesgo.CaracterDelRiesgoService;

@Component
public class CaracterDelRiesgoCommandToCaracterDelRiesgoConverter
		implements Converter<String, CaracterDelRiesgo> {

	@Autowired
	private CaracterDelRiesgoService caracterDelRiesgoService;
	
	@Override
	public CaracterDelRiesgo convert(String source) {
		
		if (source == null) {
			return null;
		}
		
		return caracterDelRiesgoService.buscarCaracterPorId(Long.valueOf(source));
	}

}
