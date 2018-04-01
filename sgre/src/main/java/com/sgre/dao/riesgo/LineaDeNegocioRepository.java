package com.sgre.dao.riesgo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sgre.model.riesgo.LineaDeNegocio;

@Repository
public interface LineaDeNegocioRepository extends CrudRepository<LineaDeNegocio, Long> {

}
