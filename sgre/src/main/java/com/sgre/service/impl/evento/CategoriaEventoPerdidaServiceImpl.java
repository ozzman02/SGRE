package com.sgre.service.impl.evento;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sgre.dao.evento.CategoriaEventoPerdidaRepository;
import com.sgre.model.evento.CategoriaEventoPerdida;
import com.sgre.service.evento.CategoriaEventoPerdidaService;

public class CategoriaEventoPerdidaServiceImpl implements CategoriaEventoPerdidaService {

	@Autowired
	private CategoriaEventoPerdidaRepository repository;
	
	@Override
	public List<CategoriaEventoPerdida> listarCategorias() {
		Iterable<CategoriaEventoPerdida> categorias = repository.findAll();
		return (List<CategoriaEventoPerdida>) categorias;
	}

	@Override
	public CategoriaEventoPerdida buscarCatergoriaPorId(Long id) {
		Optional<CategoriaEventoPerdida> categoria = repository.findById(id);
		return categoria.get();
	}

}
