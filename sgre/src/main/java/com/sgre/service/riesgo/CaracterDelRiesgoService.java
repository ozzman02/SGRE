package com.sgre.service.riesgo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sgre.model.riesgo.CaracterDelRiesgo;

@Service
public interface CaracterDelRiesgoService {

	List<CaracterDelRiesgo> listar();
	
}
