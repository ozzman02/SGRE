package com.sgre.service.impl.riesgo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sgre.dao.riesgo.RiesgoRepository;
import com.sgre.model.riesgo.Riesgo;
import com.sgre.service.riesgo.RiesgoService;

public class RiesgoServiceImpl implements RiesgoService {

	@Autowired
	private RiesgoRepository riesgoRepository;
	
	@Override
	public List<Riesgo> listarRiesgos() {
		Iterable<Riesgo> riesgos = riesgoRepository.findAll();
		return (List<Riesgo>) riesgos;
	}

	@Override
	@Transactional
	public void guardarRiesgoCommand(Riesgo riesgo) {
		riesgoRepository.save(riesgo);
	}

	@Override
	@Transactional
	public Riesgo findById(Long id) {
		Optional<Riesgo> riesgo = riesgoRepository.findById(id);
		return riesgo.get();
	}

	@Override
	public void deleteById(Long id) {
		riesgoRepository.deleteById(id);
	}
	
}
