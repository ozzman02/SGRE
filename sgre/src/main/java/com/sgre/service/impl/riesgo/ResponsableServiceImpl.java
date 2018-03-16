package com.sgre.service.impl.riesgo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sgre.dao.riesgo.ResponsableRepository;
import com.sgre.model.riesgo.Responsable;
import com.sgre.service.riesgo.ResponsableService;

public class ResponsableServiceImpl implements ResponsableService {

	@Autowired
	private ResponsableRepository repository;
	
	@Override
	@Transactional
	public List<Responsable> listarResponsables() {
		Iterable<Responsable> lista = repository.findAll();
		return (List<Responsable>) lista;
	}

}
