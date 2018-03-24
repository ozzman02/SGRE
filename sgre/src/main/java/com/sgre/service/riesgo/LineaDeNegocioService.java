package com.sgre.service.riesgo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sgre.model.riesgo.LineaDeNegocio;

@Service
public interface LineaDeNegocioService {
	
	List<LineaDeNegocio> listarLineas();

	LineaDeNegocio buscarLineaDeNegocioPorId(Long id);
}
