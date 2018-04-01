package com.sgre.service.evento;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sgre.model.evento.Responsable;


@Service
public interface ResponsableService {
	
	List<Responsable> listarResponsables();
	
	Responsable buscarResponsablePorId(Long id);
}
