package com.sgre.service.evento;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sgre.model.evento.Area;

@Service
public interface AreaService {
	
	List<Area> listarAreas();
	
	Area buscarAreaPorId(Long id);
}
