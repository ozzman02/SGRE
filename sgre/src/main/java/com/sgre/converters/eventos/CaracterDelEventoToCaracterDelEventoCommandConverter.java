package com.sgre.converters.eventos;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.evento.CaracterDelEventoCommand;
import com.sgre.model.evento.CaracterDelEvento;

@Component(value="eventoCaracterDelEventoToCaracterDelEventoCommandConverter")
public class CaracterDelEventoToCaracterDelEventoCommandConverter 
	implements Converter<CaracterDelEvento, CaracterDelEventoCommand> {

	@Override
	public CaracterDelEventoCommand convert(CaracterDelEvento source) {
		
		if (source == null) {
			return null;
		}
		
		CaracterDelEventoCommand command = new CaracterDelEventoCommand();
		command.setId(String.valueOf(source.getId()));
		command.setDescripcion(source.getDescripcion());
		
		return command;
	}

	
}
