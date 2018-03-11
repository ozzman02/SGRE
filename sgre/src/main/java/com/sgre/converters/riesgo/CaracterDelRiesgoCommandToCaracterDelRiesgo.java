package com.sgre.converters.riesgo;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.riesgo.CaracterDelRiesgoCommand;
import com.sgre.model.riesgo.CaracterDelRiesgo;

@Component
public class CaracterDelRiesgoCommandToCaracterDelRiesgo
		implements Converter<CaracterDelRiesgoCommand, CaracterDelRiesgo> {

	@Override
	public CaracterDelRiesgo convert(CaracterDelRiesgoCommand source) {
		// TODO Auto-generated method stub
		return null;
	}

}
