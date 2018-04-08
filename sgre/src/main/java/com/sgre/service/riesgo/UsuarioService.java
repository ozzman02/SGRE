package com.sgre.service.riesgo;

import org.springframework.stereotype.Service;

import com.sgre.model.riesgo.Usuario;

@Service
public interface UsuarioService {
	
	Usuario buscarUsuarioPorId(String userId);
	
}
