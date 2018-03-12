package com.sgre.converters.riesgo;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.riesgo.ResponsableCommand;
import com.sgre.model.riesgo.Responsable;

@Component
public class ResponsableCommandToResponsable implements Converter<ResponsableCommand, Responsable> {

	@Override
	public Responsable convert(ResponsableCommand source) {
		
		if (source == null) {
			return null;
		}
		
		final Responsable responsable = new Responsable();
		
		responsable.setId(source.getId());
		responsable.setNombre(source.getNombre());
		responsable.setApellido(source.getApellido());
		responsable.setPuesto(source.getPuesto());
		
		return responsable;
	}

}
