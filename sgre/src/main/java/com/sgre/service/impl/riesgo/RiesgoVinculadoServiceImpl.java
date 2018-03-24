package com.sgre.service.impl.riesgo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sgre.dao.riesgo.RiesgoVinculadoRepository;
import com.sgre.model.riesgo.RiesgoVinculado;
import com.sgre.service.riesgo.RiesgoVinculadoService;

public class RiesgoVinculadoServiceImpl implements RiesgoVinculadoService {

	@Autowired
	private RiesgoVinculadoRepository repository;
	
	@Override
	@Transactional
	public List<RiesgoVinculado> listarRiesgosVinculados() {
		Iterable<RiesgoVinculado> lista = repository.findAll();
		return (List<RiesgoVinculado>) lista;
	}

	@Override
	public RiesgoVinculado buscarRiesgoVinculadoPorId(Long id) {
		Optional<RiesgoVinculado> riesgoVinculado = repository.findById(id);
		return riesgoVinculado.get();
	}

}
