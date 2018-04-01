package com.sgre.dao.riesgo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sgre.model.riesgo.AccionCorrectiva;

@Repository
public interface AccionCorrectivaRepository extends CrudRepository<AccionCorrectiva, Long> {

}
