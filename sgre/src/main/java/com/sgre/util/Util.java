package com.sgre.util;

import java.util.List;

import com.sgre.model.riesgo.Riesgo;

public class Util {
	
	public static Double promedioDeProbabilidad(List<Riesgo> riesgos) {
		
		Double sumaDeProbabilidades = 0.00;
		
		Double cantidadDeRiesgos = (double) riesgos.size();
		
		for (Riesgo riesgo : riesgos) {
			sumaDeProbabilidades += riesgo.getProbabilidad();
		}
		
		Double promedio = sumaDeProbabilidades / cantidadDeRiesgos;
		
		return promedio;
	}
	
}
