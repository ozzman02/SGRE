package com.sgre.eventos.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sgre.eventos.domain.Evento;

@Repository
public interface EventoRepository extends PagingAndSortingRepository<Evento, Long> {

}
