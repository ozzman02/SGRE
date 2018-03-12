package com.sgre.service.impl.riesgo;

import java.util.List;



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
	
}
