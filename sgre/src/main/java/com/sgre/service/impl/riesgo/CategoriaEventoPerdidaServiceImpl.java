package com.sgre.service.impl.riesgo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sgre.dao.riesgo.CategoriaEventoPerdidaRepository;
import com.sgre.model.riesgo.CategoriaEventoPerdida;
import com.sgre.service.riesgo.CategoriaEventoPerdidaService;

public class CategoriaEventoPerdidaServiceImpl implements CategoriaEventoPerdidaService {

	@Autowired
	private CategoriaEventoPerdidaRepository repository;
	
	@Override
	@Transactional
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
