package com.sgre.converters.riesgo;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.riesgo.CaracterDelRiesgoCommand;
import com.sgre.model.riesgo.CaracterDelRiesgo;

@Component
public class CaracterDelRiesgoToCaracterDelRiesgoCommand
		implements Converter<CaracterDelRiesgo, CaracterDelRiesgoCommand> {

	@Override
	public CaracterDelRiesgoCommand convert(CaracterDelRiesgo source) {
		// TODO Auto-generated method stub
		return null;
	}

}
