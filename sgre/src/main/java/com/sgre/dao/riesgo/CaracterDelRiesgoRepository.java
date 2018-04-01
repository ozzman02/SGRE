package com.sgre.dao.riesgo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sgre.model.riesgo.CaracterDelRiesgo;

@Repository
public interface CaracterDelRiesgoRepository extends CrudRepository<CaracterDelRiesgo, Long> {
	
}
