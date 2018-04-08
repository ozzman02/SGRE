package com.sgre.dao.riesgo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sgre.model.riesgo.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
	Usuario findUsuarioByUserId(String userId);
	
}
