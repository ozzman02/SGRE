package com.sgre.service.impl.riesgo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sgre.dao.riesgo.LineaDeNegocioRepository;
import com.sgre.model.riesgo.LineaDeNegocio;
import com.sgre.service.riesgo.LineaDeNegocioService;

public class LineaDeNegocioServiceImpl implements LineaDeNegocioService {

	@Autowired
	private LineaDeNegocioRepository repository;
	
	@Override
	@Transactional
	public List<LineaDeNegocio> listarLineas() {
		Iterable<LineaDeNegocio> lineas = repository.findAll();
		return (List<LineaDeNegocio>) lineas;
	}

}
