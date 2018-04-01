package com.sgre.dao.evento;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sgre.model.evento.CaracterDelEvento;

@Repository(value="eventoCaracterDelEventoRepository")
public interface CaracterDelEventoRepository extends CrudRepository<CaracterDelEvento, Long>{

}
