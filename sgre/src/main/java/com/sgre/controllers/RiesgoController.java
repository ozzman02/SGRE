package com.sgre.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sgre.commands.riesgo.RiesgoCommand;
import com.sgre.converters.RiesgoConverter;
import com.sgre.model.riesgo.Riesgo;
import com.sgre.service.riesgo.AccionCorrectivaService;
import com.sgre.service.riesgo.AreaService;
import com.sgre.service.riesgo.CaracterDelRiesgoService;
import com.sgre.service.riesgo.CategoriaEventoPerdidaService;
import com.sgre.service.riesgo.LineaDeNegocioService;
import com.sgre.service.riesgo.ResponsableService;
import com.sgre.service.riesgo.RiesgoService;
import com.sgre.service.riesgo.RiesgoVinculadoService;

@Controller
public class RiesgoController {
	
	@Autowired
	private RiesgoService riesgoService;
	
	@Autowired
	private CategoriaEventoPerdidaService categoriaEventoPerdidaService;
	
	@Autowired
	private CaracterDelRiesgoService caracterDelRiesgoService;
	
	@Autowired
	private AccionCorrectivaService accionCorrectivaService;
	
	@Autowired
	private AreaService areaService;
	
	@Autowired
	private LineaDeNegocioService lineaDeNegocioService;
	
	@Autowired
	private ResponsableService responsableService;
	
	@Autowired
	private RiesgoVinculadoService riesgoVinculadoService;
	
	@Autowired
	private RiesgoConverter converter;
	
	@GetMapping("riesgos/listar")
	public String listarRiesgos(Model model) {
		model.addAttribute("riesgos", riesgoService.listarRiesgos());
		return "riesgos/listar-riesgos";
	}
	
	@GetMapping("riesgos/{id}/consultar")
	public String consultarRiesgo(@PathVariable String id, Model model) {
		model.addAttribute("riesgo", riesgoService.buscarRiesgoPorId(new Long(id)));
		return "riesgos/consultar-riesgo";
	}
	
	@GetMapping("riesgos/{id}/modificar")
	public String modificarRiesgo(@PathVariable String id, Model model) {
		
		model.addAttribute("riesgosVinculados", riesgoVinculadoService.listarRiesgosVinculados());
		model.addAttribute("responsables", responsableService.listarResponsables());
		model.addAttribute("lineas", lineaDeNegocioService.listarLineas());
		model.addAttribute("areas", areaService.listarAreas());
		model.addAttribute("acciones", accionCorrectivaService.listarAcciones());
		model.addAttribute("categorias", categoriaEventoPerdidaService.listarCategorias());
		model.addAttribute("caracteres", caracterDelRiesgoService.listar());
		model.addAttribute("riesgo", riesgoService.buscarRiesgoPorId(Long.valueOf(id)));
		
		return "riesgos/modificar-riesgo";
	}
	
	@PostMapping("guardar")
	public String guardarRiesgo(@ModelAttribute RiesgoCommand command) {
		Riesgo riesgo = converter.convert(command);
		riesgoService.guardarRiesgo(riesgo);
		return "redirect:/riesgos/listar";
	}
	
}
