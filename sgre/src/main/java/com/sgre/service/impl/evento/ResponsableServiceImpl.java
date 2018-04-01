package com.sgre.service.impl.evento;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.sgre.dao.evento.ResponsableRepository;
import com.sgre.model.evento.Responsable;
import com.sgre.service.evento.ResponsableService;

public class ResponsableServiceImpl implements ResponsableService {
	
	@Autowired
	@Qualifier("eventoResponsableRepository")
	private ResponsableRepository repository;
	
	@Override
	public List<Responsable> listarResponsables() {
		Iterable<Responsable> responsables = repository.findAll();
		return (List<Responsable>) responsables;
	}

	@Override
	public Responsable buscarResponsablePorId(Long id) {
		Optional<Responsable> responsable = repository.findById(id);
		return responsable.get();
	}

}
