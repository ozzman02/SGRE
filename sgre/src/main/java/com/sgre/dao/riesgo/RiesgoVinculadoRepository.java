package com.sgre.dao.riesgo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sgre.model.riesgo.RiesgoVinculado;

@Repository
public interface RiesgoVinculadoRepository extends CrudRepository<RiesgoVinculado, Long> {

}
