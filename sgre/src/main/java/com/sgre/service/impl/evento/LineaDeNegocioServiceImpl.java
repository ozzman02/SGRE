package com.sgre.service.impl.evento;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sgre.dao.evento.LineaDeNegocioRepository;
import com.sgre.model.evento.LineaDeNegocio;
import com.sgre.service.evento.LineaDeNegocioService;

public class LineaDeNegocioServiceImpl implements LineaDeNegocioService {

	@Autowired
	private LineaDeNegocioRepository repository;
	
	@Override
	public List<LineaDeNegocio> listarLineas() {
		Iterable<LineaDeNegocio> lineas = repository.findAll();
		return (List<LineaDeNegocio>) lineas;
	}

	@Override
	public LineaDeNegocio buscarLineaDeNegocioPorId(Long id) {
		Optional<LineaDeNegocio> linea = repository.findById(id);
		return linea.get();
	}

}
