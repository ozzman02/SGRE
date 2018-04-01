package com.sgre.dao.evento;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sgre.model.evento.Evento;

@Repository
public interface EventoRepository extends PagingAndSortingRepository<Evento, Long> {

}
