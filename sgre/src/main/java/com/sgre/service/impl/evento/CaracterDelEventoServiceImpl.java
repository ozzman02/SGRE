package com.sgre.service.impl.evento;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.sgre.dao.evento.CaracterDelEventoRepository;
import com.sgre.model.evento.CaracterDelEvento;
import com.sgre.service.evento.CaracterDelEventoService;

public class CaracterDelEventoServiceImpl implements CaracterDelEventoService {

	@Autowired
	@Qualifier("eventoCaracterDelEventoRepository")
	private CaracterDelEventoRepository repository;
	
	@Override
	public List<CaracterDelEvento> listar() {
		Iterable<CaracterDelEvento> list = repository.findAll();
		return (List<CaracterDelEvento>) list;
	}

	@Override
	public CaracterDelEvento buscarCaracterPorId(Long id) {
		Optional<CaracterDelEvento> caracter = repository.findById(id);
		return caracter.get();
	}

}
