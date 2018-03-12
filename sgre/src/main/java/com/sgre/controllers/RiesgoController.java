package com.sgre.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	

}
