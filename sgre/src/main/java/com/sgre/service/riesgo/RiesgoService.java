package com.sgre.service.riesgo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sgre.model.riesgo.Riesgo;

@Service
public interface RiesgoService {
	
	void guardarRiesgo();
	
	List<Riesgo> listarRiesgos();
	
}
