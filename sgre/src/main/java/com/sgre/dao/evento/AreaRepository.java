package com.sgre.dao.evento;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sgre.model.evento.Area;

@Repository(value="eventoAreaRepository")
public interface AreaRepository extends CrudRepository<Area, Long> {

}
