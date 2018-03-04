package com.sgre.eventos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sgre.eventos.domain.Evento;

@Service
public interface EventosService {
	
	List<Evento> listarEventos();
	
}
