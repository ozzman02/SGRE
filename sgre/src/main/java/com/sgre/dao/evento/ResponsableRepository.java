package com.sgre.dao.evento;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sgre.model.evento.Responsable;

@Repository(value="eventoResponsableRepository")
public interface ResponsableRepository extends CrudRepository<Responsable, Long> {

}
