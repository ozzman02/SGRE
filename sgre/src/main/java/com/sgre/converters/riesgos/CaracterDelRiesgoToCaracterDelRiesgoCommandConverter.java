package com.sgre.converters.riesgos;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.riesgo.CaracterDelRiesgoCommand;
import com.sgre.model.riesgo.CaracterDelRiesgo;

@Component
public class CaracterDelRiesgoToCaracterDelRiesgoCommandConverter
		implements Converter<CaracterDelRiesgo, CaracterDelRiesgoCommand> {

	@Override
	public CaracterDelRiesgoCommand convert(CaracterDelRiesgo source) {
		
		if (source == null) {
			return null;
		}
		
		CaracterDelRiesgoCommand command = new CaracterDelRiesgoCommand();
		command.setId(String.valueOf(source.getId()));
		command.setDescripcion(source.getDescripcion());
		
		return command;
	}

}
