package com.sgre.service.riesgo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sgre.model.riesgo.Riesgo;

@Service
public interface RiesgoService {
	
	List<Riesgo> listarRiesgos();
	
	Riesgo buscarRiesgoPorId(Long id);
	
	void guardarRiesgo(Riesgo riesgo);
	
	void borrarRiesgoPorId(Long id);
	
}
