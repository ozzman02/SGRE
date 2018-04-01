package com.sgre.dao.riesgo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sgre.model.riesgo.CategoriaEventoPerdida;

@Repository
public interface CategoriaEventoPerdidaRepository extends CrudRepository<CategoriaEventoPerdida, Long> {

}
