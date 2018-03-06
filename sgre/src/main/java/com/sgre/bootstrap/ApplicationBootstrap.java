package com.sgre.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.sgre.dao.evento.EventoRepository;
import com.sgre.dao.riesgo.RiesgoRepository;
import com.sgre.model.evento.Evento;
import com.sgre.model.riesgo.Riesgo;


@Component
public class ApplicationBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private RiesgoRepository riesgoRepository;
	
	@Autowired EventoRepository eventoRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Riesgo riesgo = new Riesgo();
		
		riesgo.setTitulo("Titulo de prueba");
		riesgo.setDescripcion("Descripcion de prueba");
		riesgoRepository.save(riesgo);
		
		Evento evento = new Evento();
		
		evento.setTitulo("Titulo de prueba");
		evento.setDescripcion("Descripcion de prueba");
		eventoRepository.save(evento);
		
	}

}
