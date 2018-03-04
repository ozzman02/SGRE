package com.sgre.riesgos.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sgre.riesgos.domain.Riesgo;
import com.sgre.riesgos.repositories.RiesgoRepository;
import com.sgre.riesgos.services.RiesgosService;

public class RiesgosServiceImpl implements RiesgosService {

	@Autowired
	private RiesgoRepository riesgoRepository;
	
	@Override
	public List<Riesgo> listarRiesgos() {
		return (List<Riesgo>) riesgoRepository.findAll();
	}

}
