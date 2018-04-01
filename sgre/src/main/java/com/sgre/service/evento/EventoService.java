package com.sgre.service.evento;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sgre.model.evento.Evento;


@Service
public interface EventoService {
	
	List<Evento> listarEventos();
	
	Evento buscarEventoPorId(Long id);
	
	void guardarEvento(Evento evento);
	
	void borrarEventoPorId(Long id);
	
}
