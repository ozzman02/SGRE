package com.sgre.service.riesgo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sgre.model.riesgo.CategoriaEventoPerdida;

@Service
public interface CategoriaEventoPerdidaService {
	
	List<CategoriaEventoPerdida> listarCategorias();
	
	CategoriaEventoPerdida buscarCatergoriaPorId(Long id);
	
}
