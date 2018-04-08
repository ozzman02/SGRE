package com.sgre.dao.evento;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sgre.model.evento.Usuario;

@Repository(value = "eventoUsuarioRepository")
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	Usuario findUsuarioByUserId(String userId);
	
}
