package com.sgre.service.evento;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sgre.model.evento.LineaDeNegocio;


@Service
public interface LineaDeNegocioService {
	
	List<LineaDeNegocio> listarLineas();

	LineaDeNegocio buscarLineaDeNegocioPorId(Long id);
}
