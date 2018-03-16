package com.sgre.service.riesgo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sgre.model.riesgo.RiesgoVinculado;

@Service
public interface RiesgoVinculadoService {

	List<RiesgoVinculado> listarRiesgosVinculados();
	
}
