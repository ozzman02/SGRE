package com.sgre.service.evento;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sgre.model.evento.CategoriaEventoPerdida;


@Service
public interface CategoriaEventoPerdidaService {
	
	List<CategoriaEventoPerdida> listarCategorias();
	
	CategoriaEventoPerdida buscarCatergoriaPorId(Long id);
}
