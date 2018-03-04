package com.sgre.riesgos.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sgre.riesgos.domain.Riesgo;

@Repository
public interface RiesgoRepository extends PagingAndSortingRepository<Riesgo, Long> {

}
