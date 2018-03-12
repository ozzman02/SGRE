package com.sgre.service.riesgo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sgre.commands.riesgo.RiesgoCommand;
import com.sgre.model.riesgo.Riesgo;

@Service
public interface RiesgoService {
	
	List<Riesgo> listarRiesgos();
	
	RiesgoCommand guardarRiesgoCommand(RiesgoCommand riesgoComamand);
	
	
	
}
