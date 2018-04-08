package com.sgre.service.impl.riesgo;

import org.springframework.beans.factory.annotation.Autowired;

import com.sgre.dao.riesgo.UsuarioRepository;
import com.sgre.model.riesgo.Usuario;
import com.sgre.service.riesgo.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public Usuario buscarUsuarioPorId(String userId) {
		return repository.findUsuarioByUserId(userId);
	}

}
