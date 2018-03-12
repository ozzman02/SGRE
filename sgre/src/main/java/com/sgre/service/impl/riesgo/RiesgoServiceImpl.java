package com.sgre.service.impl.riesgo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sgre.commands.riesgo.RiesgoCommand;
import com.sgre.converters.riesgo.RiesgoCommandToRiesgo;
import com.sgre.converters.riesgo.RiesgoToRiesgoCommand;
import com.sgre.dao.riesgo.RiesgoRepository;
import com.sgre.model.riesgo.Riesgo;
import com.sgre.service.riesgo.RiesgoService;

public class RiesgoServiceImpl implements RiesgoService {

	@Autowired
	private RiesgoRepository riesgoRepository;
	
	private RiesgoCommandToRiesgo riesgoCommandToRiesgo;
	
	private RiesgoToRiesgoCommand riesgoToRiesgoCommand;
	
	@Override
	public List<Riesgo> listarRiesgos() {
		Iterable<Riesgo> riesgos = riesgoRepository.findAll();
		return (List<Riesgo>) riesgos;
	}

	@Override
	@Transactional
	public RiesgoCommand guardarRiesgoCommand(RiesgoCommand riesgoComamand) {
		Riesgo riesgo = riesgoCommandToRiesgo.convert(riesgoComamand);
		Riesgo savedRiesgo = riesgoRepository.save(riesgo);
		return riesgoToRiesgoCommand.convert(savedRiesgo);
	}

	@Override
	@Transactional
	public Riesgo findById(Long id) {
		Optional<Riesgo> riesgo = riesgoRepository.findById(id);
		return riesgo.get();
	}

	@Override
	@Transactional
	public RiesgoCommand findCommandById(Long id) {
		return riesgoToRiesgoCommand.convert(findById(id));
	}

	@Override
	public void deleteById(Long id) {
		riesgoRepository.deleteById(id);
	}
	
}
