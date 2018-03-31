package com.sgre.service.impl.riesgo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sgre.dao.riesgo.AccionCorrectivaRepository;
import com.sgre.model.riesgo.AccionCorrectiva;
import com.sgre.service.riesgo.AccionCorrectivaService;

public class AccionCorrectivaServiceImpl implements AccionCorrectivaService {

	@Autowired
	private AccionCorrectivaRepository repository;
	
	@Override
	@Transactional
	public List<AccionCorrectiva> listarAcciones() {
		Iterable<AccionCorrectiva> acciones = repository.findAll();
		return (List<AccionCorrectiva>) acciones;
	}

	@Override
	public AccionCorrectiva buscarAccionCorrectivaPorId(Long id) {
		Optional<AccionCorrectiva> accion = repository.findById(id);
		return accion.get();
	}

}
