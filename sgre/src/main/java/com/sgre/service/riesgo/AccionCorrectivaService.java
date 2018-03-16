package com.sgre.service.riesgo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sgre.model.riesgo.AccionCorrectiva;

@Service
public interface AccionCorrectivaService {
	
	List<AccionCorrectiva> listarAcciones();
	
}
