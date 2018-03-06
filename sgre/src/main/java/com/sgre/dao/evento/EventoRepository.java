package com.sgre.dao.evento;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sgre.model.evento.Evento;

public interface EventoRepository extends PagingAndSortingRepository<Evento, Long> {

}
