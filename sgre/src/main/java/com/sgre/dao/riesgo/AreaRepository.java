package com.sgre.dao.riesgo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sgre.model.riesgo.Area;

@Repository
public interface AreaRepository extends CrudRepository<Area, Long> {

}
