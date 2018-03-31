package com.sgre.service.impl.riesgo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sgre.dao.riesgo.CaracterDelRiesgoRepository;
import com.sgre.model.riesgo.CaracterDelRiesgo;
import com.sgre.service.riesgo.CaracterDelRiesgoService;

public class CaracterDelRiesgoServiceImpl implements CaracterDelRiesgoService {

	@Autowired
	private CaracterDelRiesgoRepository repository;
	
	@Override
	public List<CaracterDelRiesgo> listar() {
		Iterable<CaracterDelRiesgo> lista = repository.findAll();
		return (List<CaracterDelRiesgo>) lista;
	}

	@Override
	public CaracterDelRiesgo buscarCaracterPorId(Long id) {
		Optional<CaracterDelRiesgo> caracter = repository.findById(id);
		return caracter.get();
	}

}
