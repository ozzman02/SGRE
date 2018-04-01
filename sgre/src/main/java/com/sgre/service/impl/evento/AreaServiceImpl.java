package com.sgre.service.impl.evento;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.sgre.dao.evento.AreaRepository;
import com.sgre.model.evento.Area;
import com.sgre.service.evento.AreaService;

public class AreaServiceImpl implements AreaService {

	@Autowired
	@Qualifier("eventoAreaRepository")
	private AreaRepository repository;
	
	@Override
	public List<Area> listarAreas() {
		Iterable<Area> areas = repository.findAll();
		return (List<Area>) areas;
	}

	@Override
	public Area buscarAreaPorId(Long id) {
		Optional<Area> area = repository.findById(id);
		return area.get();
	}

}
