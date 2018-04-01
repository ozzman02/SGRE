package com.sgre.dao.evento;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sgre.model.evento.LineaDeNegocio;

@Repository(value="eventoLineaDeNegocioRepository")
public interface LineaDeNegocioRepository extends CrudRepository<LineaDeNegocio, Long> {

}
