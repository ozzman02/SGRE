package com.sgre.riesgos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sgre.riesgos.domain.Riesgo;

@Service
public interface RiesgosService {
	
	List<Riesgo> listarRiesgos();
	
}
