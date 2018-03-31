package com.sgre.service.riesgo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sgre.model.riesgo.Responsable;

@Service
public interface ResponsableService {

	List<Responsable> listarResponsables();
	
	Responsable buscarResponsablePorId(Long id);
	
}
