package com.sgre.converters;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sgre.commands.riesgo.RiesgoCommand;
import com.sgre.model.riesgo.AccionCorrectiva;
import com.sgre.model.riesgo.Area;
import com.sgre.model.riesgo.CaracterDelRiesgo;
import com.sgre.model.riesgo.CategoriaEventoPerdida;
import com.sgre.model.riesgo.LineaDeNegocio;
import com.sgre.model.riesgo.Responsable;
import com.sgre.model.riesgo.Riesgo;
import com.sgre.model.riesgo.RiesgoVinculado;
import com.sgre.service.riesgo.AccionCorrectivaService;
import com.sgre.service.riesgo.AreaService;
import com.sgre.service.riesgo.CaracterDelRiesgoService;
import com.sgre.service.riesgo.CategoriaEventoPerdidaService;
import com.sgre.service.riesgo.LineaDeNegocioService;
import com.sgre.service.riesgo.ResponsableService;
import com.sgre.service.riesgo.RiesgoVinculadoService;

@Component
public class RiesgoConverter implements Converter<RiesgoCommand, Riesgo> {

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
	
	private Date convertirFecha(String date) {
		
		
		Date convertedDate = null;
		
		if (!date.isEmpty() || date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			
			try {
				convertedDate = sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	
		return convertedDate;
	}
	
	@Override
	public Riesgo convert(RiesgoCommand source) {
		
		if (source == null) {
			return null;
		}
		
		AccionCorrectiva accion = accionCorrectivaService
				.buscarAccionCorrectivaPorId(Long.valueOf(source.getAccion_correctiva()));
		
		CategoriaEventoPerdida categoria = categoriaEventoPerdidaService
				.buscarCatergoriaPorId(Long.valueOf(source.getCategoria_evento_perdida()));
		
		CaracterDelRiesgo caracter = caracterDelRiesgoService
				.buscarCaracterPorId(Long.valueOf(source.getCaracter_del_riesgo()));
		
		Area area = areaService
				.buscarAreaPorId(Long.valueOf(source.getArea()));
		
		LineaDeNegocio linea = lineaDeNegocioService
				.buscarLineaDeNegocioPorId(Long.valueOf(source.getLinea_de_negocio()));
		
		Responsable responsable = responsableService
				.buscarResponsablePorId(Long.valueOf(source.getResponsable()));
		
		RiesgoVinculado riesgoVinculado = riesgoVinculadoService
				.buscarRiesgoVinculadoPorId(Long.valueOf(source.getRiesgo_vinculado()));
		
		Riesgo riesgo = new Riesgo();
		
		riesgo.setAccion_correctiva(accion);
		riesgo.setArea(area);
		riesgo.setCaracter_del_riesgo(caracter);
		riesgo.setCategoria_evento_perdida(categoria);
		riesgo.setDescripcion(source.getDescripcion());
		riesgo.setFecha_inicio(convertirFecha(source.getFecha_inicio()));
		riesgo.setFrecuencia(Integer.valueOf(source.getFrecuencia()));		
		riesgo.setImpacto_del_riesgo(source.getImpacto_del_riesgo());
		riesgo.setLinea_de_negocio(linea);
		riesgo.setProbabilidad(new BigDecimal(source.getProbabilidad()));
		riesgo.setResponsable(responsable);
		riesgo.setRiesgo_vinculado(riesgoVinculado);
		riesgo.setTitulo(source.getTitulo());
		
		if (!source.getId().isEmpty()) {
			riesgo.setId(Long.valueOf(source.getId()));
		}
		
		if (source.getAplica_cuenta_contable() != null) {
			riesgo.setAplica_cuenta_contable(source.getAplica_cuenta_contable());
		}
		
		if (!source.getControles_de_riesgo().isEmpty()) {
			riesgo.setControles_de_riesgo(source.getControles_de_riesgo());
		}
		
		if (!source.getDetalle().isEmpty()) {
			riesgo.setDetalle(source.getDetalle());
		}
		
		if (!source.getFecha_conclusion().isEmpty()) {
			riesgo.setFecha_conclusion(convertirFecha(source.getFecha_conclusion()));
		}
		
		if (!source.getFecha_descubrimiento().isEmpty()) {
			riesgo.setFecha_descubrimiento(convertirFecha(source.getFecha_descubrimiento()));
		}
		
		if (!source.getFecha_registro_contable().isEmpty()) {
			riesgo.setFecha_registro_contable(convertirFecha(source.getFecha_registro_contable()));
		}
		
		if (!source.getMonto_bruto_perdida().isEmpty()) {
			riesgo.setMonto_bruto_perdida(new BigDecimal(source.getMonto_bruto_perdida()));
		}
		
		if (!source.getMonto_neto_perdida().isEmpty()) {
			riesgo.setMonto_neto_perdida(new BigDecimal(source.getMonto_neto_perdida()));
		}
		
		if (!source.getMonto_total_recuperado().isEmpty()) {
			riesgo.setMonto_total_recuperado(new BigDecimal(source.getMonto_total_recuperado()));
		}
		
		if (!source.getNotas_cuenta_contable().isEmpty()) {
			riesgo.setNotas_cuenta_contable(source.getNotas_cuenta_contable());
		}
		
		if (!source.getObservaciones_generales().isEmpty()) {
			riesgo.setObservaciones_generales(source.getObservaciones_generales());
		}
		
		if (!source.getPlazo_ejecucion().isEmpty()) {
			riesgo.setPlazo_ejecucion(source.getPlazo_ejecucion());
		}
		
		if (!source.getTipo_cambio_perdida_bruta().isEmpty()) {
			riesgo.setTipo_cambio_perdida_bruta(new BigDecimal(source.getTipo_cambio_perdida_bruta()));
		}
		
		if (!source.getTipo_cambio_perdida_neta().isEmpty()) {
			riesgo.setTipo_cambio_perdida_neta(new BigDecimal(source.getTipo_cambio_perdida_neta()));
		}
		
		if (!source.getTipo_moneda_perdida_bruta().isEmpty()) {
			riesgo.setTipo_moneda_perdida_bruta(source.getTipo_moneda_perdida_bruta());
		}

		if (!source.getTipo_moneda_perdida_neta().isEmpty()) {
			riesgo.setTipo_moneda_perdida_neta(source.getTipo_moneda_perdida_neta());
		}
		
		return riesgo;
	}
	

}
