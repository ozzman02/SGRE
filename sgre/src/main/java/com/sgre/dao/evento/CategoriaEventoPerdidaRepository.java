package com.sgre.dao.evento;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sgre.model.evento.CategoriaEventoPerdida;

@Repository(value="eventoCategoriaEventoPerdidaRepository")
public interface CategoriaEventoPerdidaRepository extends CrudRepository<CategoriaEventoPerdida, Long> {

}
