package com.sgre.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sgre.service.riesgo.RiesgoService;

@Controller
public class RiesgoController {
	
	@Autowired
	private RiesgoService riesgoService;
	
	@GetMapping("riesgos/listar")
	public String listarRiesgos(Model model) {
		model.addAttribute("riesgos", riesgoService.listarRiesgos());
		return "riesgos/listar-riesgos";
	}
	
	@GetMapping("riesgos/{id}/consultar")
	public String consultarRiesgo(@PathVariable String id, Model model) {
		model.addAttribute("riesgo", riesgoService.findById(new Long(id)));
		return "riesgos/consultar-riesgo";
	}
	

}
