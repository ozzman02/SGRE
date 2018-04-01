package com.sgre.converters.eventos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.model.evento.Area;
import com.sgre.service.evento.AreaService;

@Component(value="eventoAreaCommandToAreaConverter")
public class AreaCommandToAreaConverter implements Converter<String, Area> {

	@Autowired
	@Qualifier("eventoAreaService")
	private AreaService areaService;
	
	@Override
	public Area convert(String source) {
		
		if (source == null) {
			return null;
		}
		
		return areaService.buscarAreaPorId(Long.valueOf(source));
	}

}
