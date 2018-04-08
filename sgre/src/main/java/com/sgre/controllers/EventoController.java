package com.sgre.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sgre.commands.evento.EventoCommand;
import com.sgre.converters.eventos.EventoCommandToEventoConverter;
import com.sgre.converters.eventos.EventoToEventoCommandConverter;
import com.sgre.model.evento.Evento;
import com.sgre.service.evento.AreaService;
import com.sgre.service.evento.CaracterDelEventoService;
import com.sgre.service.evento.CategoriaEventoPerdidaService;
import com.sgre.service.evento.EventoService;
import com.sgre.service.evento.LineaDeNegocioService;

@Controller
public class EventoController {
	
	@Autowired
	@Qualifier("eventoService")
	private EventoService eventoService;
	
	@Autowired
	@Qualifier("eventoCategoriaEventoPerdidaService")
	private CategoriaEventoPerdidaService categoriaEventoPerdidaService;
	
	@Autowired
	@Qualifier("caracterDelEventoService")
	private CaracterDelEventoService caracterDelEventoService;
	
	@Autowired
	@Qualifier("eventoAreaService")
	private AreaService areaService;
	
	@Autowired
	@Qualifier("eventoLineaDeNegocioService")
	private LineaDeNegocioService lineaDeNegocioService;
	
	@Autowired
	private EventoCommandToEventoConverter eventoConverter;
	
	@Autowired
	private EventoToEventoCommandConverter commandConverter;
	
	@GetMapping("eventos/listar")
	public String listarEventos(Model model) {
		model.addAttribute("eventos", eventoService.listarEventos());
		return "eventos/listar-eventos";
	}
	
	@GetMapping("eventos/{id}/consultar")
	public String consultarEvento(@PathVariable String id, Model model) {
		model.addAttribute("evento", eventoService.buscarEventoPorId(Long.valueOf(id)));
		return "eventos/consultar-evento";
	}
	
	@GetMapping("eventos/{id}/modificar")
	public String modificarEvento(@PathVariable String id, Model model) {
		Evento evento = eventoService.buscarEventoPorId(Long.valueOf(id));
		EventoCommand eventoCommand = commandConverter.convert(evento);
		model.addAttribute("categorias", categoriaEventoPerdidaService.listarCategorias());
		model.addAttribute("caracteres", caracterDelEventoService.listar());
		model.addAttribute("areas", areaService.listarAreas());
		model.addAttribute("lineas", lineaDeNegocioService.listarLineas());
		model.addAttribute("evento", eventoCommand);
		return "eventos/modificar-evento";
	}
	
	@GetMapping("eventos/crear")
	public String crearEvento(Model model) {
		model.addAttribute("categorias", categoriaEventoPerdidaService.listarCategorias());
		model.addAttribute("caracteres", caracterDelEventoService.listar());
		model.addAttribute("areas", areaService.listarAreas());
		model.addAttribute("lineas", lineaDeNegocioService.listarLineas());
		model.addAttribute("evento", new EventoCommand());
		return "eventos/crear-evento";
	}
	
	@PostMapping("guardar/evento")
	public String guardarEvento(@Valid @ModelAttribute("evento") EventoCommand command,
			BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("categorias", categoriaEventoPerdidaService.listarCategorias());
			model.addAttribute("caracteres", caracterDelEventoService.listar());
			model.addAttribute("areas", areaService.listarAreas());
			model.addAttribute("lineas", lineaDeNegocioService.listarLineas());
			return "eventos/crear-evento";
		}
		
		Evento evento = eventoConverter.convert(command);
		eventoService.guardarEvento(evento);
		
		return "redirect:/eventos/listar";
	}
	
	@PostMapping("modificar/evento")
	public String guardarModificacionEvento(@Valid @ModelAttribute("evento") EventoCommand command,
			BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("categorias", categoriaEventoPerdidaService.listarCategorias());
			model.addAttribute("caracteres", caracterDelEventoService.listar());
			model.addAttribute("areas", areaService.listarAreas());
			model.addAttribute("lineas", lineaDeNegocioService.listarLineas());
			return "eventos/modificar-evento";
		}
		
		Evento evento = eventoConverter.convert(command);
		eventoService.guardarEvento(evento);
		
		return "redirect:/eventos/listar";
	}
	
	@GetMapping("eventos/{id}/eliminar")
	public String borrarEvento(@PathVariable String id) {
		eventoService.borrarEventoPorId(Long.valueOf(id));
		return "redirect:/eventos/listar";
	}
	
}
