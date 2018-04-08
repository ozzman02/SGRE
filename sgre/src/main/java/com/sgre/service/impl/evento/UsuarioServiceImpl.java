package com.sgre.service.impl.evento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.sgre.dao.evento.UsuarioRepository;
import com.sgre.model.evento.Usuario;
import com.sgre.service.evento.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	@Qualifier("eventoUsuarioRepository")
	private UsuarioRepository repository;
	
	@Override
	public Usuario buscarUsuarioPorId(String userId) {
		return repository.findUsuarioByUserId(userId);
	}

}
