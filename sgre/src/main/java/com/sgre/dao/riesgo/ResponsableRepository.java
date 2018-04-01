package com.sgre.dao.riesgo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sgre.model.riesgo.Responsable;

@Repository
public interface ResponsableRepository extends CrudRepository<Responsable, Long> {

}
