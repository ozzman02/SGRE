package com.sgre.service.impl.evento;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sgre.dao.evento.EventoRepository;
import com.sgre.model.evento.Evento;
import com.sgre.service.evento.EventoService;

public class EventoServiceImpl implements EventoService {

	@Autowired
	private EventoRepository repository;
	
	@Override
	public List<Evento> listarEventos() {
		Iterable<Evento> eventos = repository.findAll();
		return (List<Evento>) eventos;
	}

	@Override
	public Evento buscarEventoPorId(Long id) {
		Optional<Evento> evento = repository.findById(id);
		return evento.get();
	}

	@Override
	public void guardarEvento(Evento evento) {
		repository.save(evento);
	}

	@Override
	public void borrarEventoPorId(Long id) {
		repository.deleteById(id);
	}

}
