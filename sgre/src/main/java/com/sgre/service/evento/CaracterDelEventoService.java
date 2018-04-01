package com.sgre.service.evento;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sgre.model.evento.CaracterDelEvento;

@Service
public interface CaracterDelEventoService {
	
	List<CaracterDelEvento> listar();
	
	CaracterDelEvento buscarCaracterPorId(Long id);
}
