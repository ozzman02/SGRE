package com.sgre.eventos.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sgre.eventos.domain.Evento;
import com.sgre.eventos.repositories.EventoRepository;
import com.sgre.eventos.services.EventosService;

public class EventosServiceImpl implements EventosService {

	@Autowired
	private EventoRepository eventoRepository;
	
	@Override
	public List<Evento> listarEventos() {
		return (List<Evento>) eventoRepository.findAll(); 
	}
	
}
