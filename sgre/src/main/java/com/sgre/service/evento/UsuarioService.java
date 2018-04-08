package com.sgre.service.evento;

import org.springframework.stereotype.Service;

import com.sgre.model.evento.Usuario;

@Service
public interface UsuarioService {
	
	Usuario buscarUsuarioPorId(String userId);
	
}
