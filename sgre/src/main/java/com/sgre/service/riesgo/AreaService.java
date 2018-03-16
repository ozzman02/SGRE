package com.sgre.service.riesgo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sgre.model.riesgo.Area;

@Service
public interface AreaService {

	List<Area> listarAreas();
	
}
