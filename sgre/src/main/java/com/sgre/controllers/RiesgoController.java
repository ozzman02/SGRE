package com.sgre.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sgre.commands.riesgo.RiesgoCommand;
import com.sgre.converters.riesgos.RiesgoCommandToRiesgoConverter;
import com.sgre.converters.riesgos.RiesgoToRiesgoCommandConverter;
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
	private RiesgoCommandToRiesgoConverter riesgoConverter;
	
	@Autowired
	private RiesgoToRiesgoCommandConverter commandConverter;
	
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
		
		Riesgo riesgo = riesgoService.buscarRiesgoPorId(Long.valueOf(id));
	
		RiesgoCommand riesgoCommand = commandConverter.convert(riesgo);
		
		model.addAttribute("riesgosVinculados", riesgoVinculadoService.listarRiesgosVinculados());
		model.addAttribute("responsables", responsableService.listarResponsables());
		model.addAttribute("lineas", lineaDeNegocioService.listarLineas());
		model.addAttribute("areas", areaService.listarAreas());
		model.addAttribute("acciones", accionCorrectivaService.listarAcciones());
		model.addAttribute("categorias", categoriaEventoPerdidaService.listarCategorias());
		model.addAttribute("caracteres", caracterDelRiesgoService.listar());
		model.addAttribute("riesgo", riesgoCommand);
		
		return "riesgos/modificar-riesgo";
	}
	
	@GetMapping("riesgos/crear")
	public String crearRiesgo(Model model) {
		
		model.addAttribute("riesgosVinculados", riesgoVinculadoService.listarRiesgosVinculados());
		model.addAttribute("responsables", responsableService.listarResponsables());
		model.addAttribute("lineas", lineaDeNegocioService.listarLineas());
		model.addAttribute("areas", areaService.listarAreas());
		model.addAttribute("acciones", accionCorrectivaService.listarAcciones());
		model.addAttribute("categorias", categoriaEventoPerdidaService.listarCategorias());
		model.addAttribute("caracteres", caracterDelRiesgoService.listar());
		model.addAttribute("riesgo", new RiesgoCommand());
		
		return "riesgos/crear-riesgo";
	}
	
	@PostMapping("guardar")
	public String guardarRiesgo(@Valid @ModelAttribute("riesgo") RiesgoCommand command, 
			BindingResult bindingResult, Model model) {
	
		if (bindingResult.hasErrors()) {
			model.addAttribute("riesgosVinculados", riesgoVinculadoService.listarRiesgosVinculados());
			model.addAttribute("responsables", responsableService.listarResponsables());
			model.addAttribute("lineas", lineaDeNegocioService.listarLineas());
			model.addAttribute("areas", areaService.listarAreas());
			model.addAttribute("acciones", accionCorrectivaService.listarAcciones());
			model.addAttribute("categorias", categoriaEventoPerdidaService.listarCategorias());
			model.addAttribute("caracteres", caracterDelRiesgoService.listar());
			
			return "riesgos/crear-riesgo";
		}
		
		Riesgo riesgo = riesgoConverter.convert(command);
		riesgoService.guardarRiesgo(riesgo);
		
		return "redirect:/riesgos/listar";
		
	}
	
	@PostMapping("modificar")
	public String guardarModificacion(@Valid @ModelAttribute("riesgo") RiesgoCommand command, 
			BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			
			model.addAttribute("riesgosVinculados", riesgoVinculadoService.listarRiesgosVinculados());
			model.addAttribute("responsables", responsableService.listarResponsables());
			model.addAttribute("lineas", lineaDeNegocioService.listarLineas());
			model.addAttribute("areas", areaService.listarAreas());
			model.addAttribute("acciones", accionCorrectivaService.listarAcciones());
			model.addAttribute("categorias", categoriaEventoPerdidaService.listarCategorias());
			model.addAttribute("caracteres", caracterDelRiesgoService.listar());
			
			return "riesgos/modificar-riesgo";
		}
		
		Riesgo riesgo = riesgoConverter.convert(command);
		riesgoService.guardarRiesgo(riesgo);
		
		return "redirect:/riesgos/listar";
		
	}

	@GetMapping("riesgos/{id}/eliminar")
	public String borrarRiesgo(@PathVariable String id) {
		riesgoService.borrarRiesgoPorId(Long.valueOf(id));
		return "redirect:/riesgos/listar";
	}
}
