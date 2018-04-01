package com.sgre.dao.riesgo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sgre.model.riesgo.Riesgo;

@Repository
public interface RiesgoRepository extends PagingAndSortingRepository<Riesgo, Long> {

}
