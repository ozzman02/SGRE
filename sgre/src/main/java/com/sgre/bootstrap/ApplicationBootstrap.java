package com.sgre.bootstrap;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.sgre.dao.evento.EventoRepository;
import com.sgre.dao.riesgo.AccionCorrectivaRepository;
import com.sgre.dao.riesgo.AreaRepository;
import com.sgre.dao.riesgo.CaracterDelRiesgoRepository;
import com.sgre.dao.riesgo.CategoriaEventoPerdidaRepository;
import com.sgre.dao.riesgo.LineaDeNegocioRepository;
import com.sgre.dao.riesgo.ResponsableRepository;
import com.sgre.dao.riesgo.RiesgoRepository;
import com.sgre.dao.riesgo.RiesgoVinculadoRepository;
import com.sgre.model.evento.Evento;
import com.sgre.model.riesgo.AccionCorrectiva;
import com.sgre.model.riesgo.AplicaCuentaContable;
import com.sgre.model.riesgo.Area;
import com.sgre.model.riesgo.CaracterDelRiesgo;
import com.sgre.model.riesgo.CategoriaEventoPerdida;
import com.sgre.model.riesgo.ImpactoDelRiesgo;
import com.sgre.model.riesgo.LineaDeNegocio;
import com.sgre.model.riesgo.Responsable;
import com.sgre.model.riesgo.Riesgo;
import com.sgre.model.riesgo.RiesgoVinculado;


@Component
public class ApplicationBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private AccionCorrectivaRepository accionCorrectivaRepository;
	
	@Autowired
	private AreaRepository areaRepository;
	
	@Autowired
	private CaracterDelRiesgoRepository caracterDelRiesgoRepository;
	
	@Autowired
	private CategoriaEventoPerdidaRepository categoriaEventoPerdidaRepository;
	
	@Autowired
	private LineaDeNegocioRepository lineaDeNegocioRepository;
	
	@Autowired
	private ResponsableRepository responsableRepository;
	
	@Autowired
	private RiesgoRepository riesgoRepository;
	
	@Autowired
	private RiesgoVinculadoRepository riesgoVinculadoRepository;
	
	@Autowired 
	private EventoRepository eventoRepository;
	
	private void cargarCategoriasEventosPerdida() {
		
		CategoriaEventoPerdida categoria1 = new CategoriaEventoPerdida();
		categoria1.setDescripcion("Fraude interno");
		categoriaEventoPerdidaRepository.save(categoria1);
		
		CategoriaEventoPerdida categoria2 = new CategoriaEventoPerdida();
		categoria2.setDescripcion("Fraude externo");
		categoriaEventoPerdidaRepository.save(categoria2);
		
		CategoriaEventoPerdida categoria3 = new CategoriaEventoPerdida();
		categoria3.setDescripcion("Relaciones laborales y seguridad en el puesto de trabajo");
		categoriaEventoPerdidaRepository.save(categoria3);
		
		CategoriaEventoPerdida categoria4 = new CategoriaEventoPerdida();
		categoria4.setDescripcion("Clientes, productos y prácticas empresariales");
		categoriaEventoPerdidaRepository.save(categoria4);
		
		CategoriaEventoPerdida categoria5 = new CategoriaEventoPerdida();
		categoria5.setDescripcion("Daños a activos materiales");
		categoriaEventoPerdidaRepository.save(categoria5);
		
		CategoriaEventoPerdida categoria6 = new CategoriaEventoPerdida();
		categoria6.setDescripcion("Interrupción del negocio y fallos en los sistemas");
		categoriaEventoPerdidaRepository.save(categoria6);
		
		CategoriaEventoPerdida categoria7 = new CategoriaEventoPerdida();
		categoria7.setDescripcion("Ejecución entrega y gestión de procesos");
		categoriaEventoPerdidaRepository.save(categoria7);
	}
	
	private void cargarLineasDeNegocio() {
		
		LineaDeNegocio linea1 = new LineaDeNegocio();
		linea1.setTipo("Finanzas corporativas");
		linea1.setDescripcion("Finanzas corporativas");
		lineaDeNegocioRepository.save(linea1);
		
		LineaDeNegocio linea2 = new LineaDeNegocio();
		linea2.setTipo("Finanzas corporativas");
		linea2.setDescripcion("Finanzas de administraciones locales y públicas");
		lineaDeNegocioRepository.save(linea2);
		
		LineaDeNegocio linea3 = new LineaDeNegocio();
		linea3.setTipo("Finanzas corporativas");
		linea3.setDescripcion("Banca de inversión");
		lineaDeNegocioRepository.save(linea3);
		
		LineaDeNegocio linea4 = new LineaDeNegocio();
		linea4.setTipo("Finanzas corporativas");
		linea4.setDescripcion("Servicios de asesoramiento");
		lineaDeNegocioRepository.save(linea4);
		
		LineaDeNegocio linea5 = new LineaDeNegocio();
		linea5.setTipo("Tesorería");
		linea5.setDescripcion("Tesorería por cuentas de terceros");
		lineaDeNegocioRepository.save(linea5);
		
		LineaDeNegocio linea6 = new LineaDeNegocio();
		linea6.setTipo("Tesorería");
		linea6.setDescripcion("Tesorería posiciones propias");
		lineaDeNegocioRepository.save(linea6);
		
		LineaDeNegocio linea7 = new LineaDeNegocio();
		linea7.setTipo("Tesorería");
		linea7.setDescripcion("Tesorería Tradicional");
		lineaDeNegocioRepository.save(linea7);
		
		LineaDeNegocio linea8 = new LineaDeNegocio();
		linea8.setTipo("Banca Minorista");
		linea8.setDescripcion("Banca de Personas");
		lineaDeNegocioRepository.save(linea8);
		
		LineaDeNegocio linea9 = new LineaDeNegocio();
		linea9.setTipo("Banca Minorista");
		linea9.setDescripcion("Banca Privada");
		lineaDeNegocioRepository.save(linea9);
		
		LineaDeNegocio linea10 = new LineaDeNegocio();
		linea10.setTipo("Banca Minorista");
		linea10.setDescripcion("Banca de desarrollo minorista");
		lineaDeNegocioRepository.save(linea10);
		
		LineaDeNegocio linea11 = new LineaDeNegocio();
		linea11.setTipo("Banca Comercial");
		linea11.setDescripcion("Banca corporativa");
		lineaDeNegocioRepository.save(linea11);
		
		LineaDeNegocio linea12 = new LineaDeNegocio();
		linea12.setTipo("Banca Comercial");
		linea12.setDescripcion("Banca empresarial");
		lineaDeNegocioRepository.save(linea12);
		
		LineaDeNegocio linea13 = new LineaDeNegocio();
		linea13.setTipo("Banca Comercial");
		linea13.setDescripcion("Banca de Desarrollo Comercial");
		lineaDeNegocioRepository.save(linea13);
		
		LineaDeNegocio linea14 = new LineaDeNegocio();
		linea14.setTipo("Banca Comercial");
		linea14.setDescripcion("Banca de Segundo Piso");
		lineaDeNegocioRepository.save(linea14);
		
		LineaDeNegocio linea15 = new LineaDeNegocio();
		linea15.setTipo("Tarjetas");
		linea15.setDescripcion("Tarjetas de crédito y débito");
		lineaDeNegocioRepository.save(linea15);
		
		LineaDeNegocio linea16 = new LineaDeNegocio();
		linea16.setTipo("Tarjetas");
		linea16.setDescripcion("Administración y Adhesión de comercios");
		lineaDeNegocioRepository.save(linea16);
		
		LineaDeNegocio linea17 = new LineaDeNegocio();
		linea17.setTipo("Cobros, pagos y liquidación");
		linea17.setDescripcion("Cobros, pagos y liquidación");
		lineaDeNegocioRepository.save(linea17);
		
		LineaDeNegocio linea18 = new LineaDeNegocio();
		linea18.setTipo("Administración de Activos");
		linea18.setDescripcion("Administración de Fondos de Cesantía");
		lineaDeNegocioRepository.save(linea18);
		
		LineaDeNegocio linea19 = new LineaDeNegocio();
		linea19.setTipo("Administración de Activos");
		linea19.setDescripcion("Administración de peaje bancario y otros");
		lineaDeNegocioRepository.save(linea19);
		
		LineaDeNegocio linea20 = new LineaDeNegocio();
		linea20.setTipo("Administración de Activos");
		linea20.setDescripcion("Administración de fideicomisos");
		lineaDeNegocioRepository.save(linea20);
		
		LineaDeNegocio linea21 = new LineaDeNegocio();
		linea21.setTipo("Administración de Activos");
		linea21.setDescripcion("Administración de Fondos de Pensión");
		lineaDeNegocioRepository.save(linea21);
		
		LineaDeNegocio linea22 = new LineaDeNegocio();
		linea22.setTipo("Otros Servicios");
		linea22.setDescripcion("Custodia");
		lineaDeNegocioRepository.save(linea22);
		
		LineaDeNegocio linea23 = new LineaDeNegocio();
		linea23.setTipo("Otros Servicios");
		linea23.setDescripcion("Comercialización de Seguros autoexpedibles");
		lineaDeNegocioRepository.save(linea23);
		
		LineaDeNegocio linea24 = new LineaDeNegocio();
		linea24.setTipo("Otros Servicios");
		linea24.setDescripcion("Tecnología de la información y comunicación");
		lineaDeNegocioRepository.save(linea24);
		
		LineaDeNegocio linea25 = new LineaDeNegocio();
		linea25.setTipo("Otros Servicios");
		linea25.setDescripcion("Cambios y transformaciones organizacionales");
		lineaDeNegocioRepository.save(linea25);
		
		LineaDeNegocio linea26 = new LineaDeNegocio();
		linea26.setTipo("Otros Servicios");
		linea26.setDescripcion("Otros procesos Transversales a la Organización");
		lineaDeNegocioRepository.save(linea26);
		
	}
	
	private void cargarCaracteresDelRiesgo() {
		
		CaracterDelRiesgo caracter1 = new CaracterDelRiesgo();
		caracter1.setDescripcion("Pérdida ocurrida individual");
		caracter1.setDetalle("");
		caracterDelRiesgoRepository.save(caracter1);
		
		CaracterDelRiesgo caracter2 = new CaracterDelRiesgo();
		caracter2.setDescripcion("Pérdida ocurrida repetitiva");
		caracter2.setDetalle("");
		caracterDelRiesgoRepository.save(caracter2);
		
		CaracterDelRiesgo caracter3 = new CaracterDelRiesgo();
		caracter3.setDescripcion("Pérdida estimada contablemente");
		caracter3.setDetalle("");
		caracterDelRiesgoRepository.save(caracter3);
		
	}
	
	private void cargarAccionesCorrectivas() {
		
		AccionCorrectiva accion1 = new AccionCorrectiva();
		accion1.setDescripcion("Plan de acción");
		accionCorrectivaRepository.save(accion1);
		
		AccionCorrectiva accion2 = new AccionCorrectiva();
		accion2.setDescripcion("Plan de contingencia");
		accionCorrectivaRepository.save(accion2);
	}

	private void cargarAreas() {
		
		Area area1 = new Area();
		area1.setDescripcion("Proceso");
		areaRepository.save(area1);
		
		Area area2 = new Area();
		area2.setDescripcion("Subproceso");
		areaRepository.save(area2);
		
		Area area3 = new Area();
		area3.setDescripcion("Producto");
		areaRepository.save(area3);
		
	}
	
	private void cargarRiesgosVinculados() {
		
		RiesgoVinculado rv1 = new RiesgoVinculado();
		rv1.setDescripcion("Crédito");
		riesgoVinculadoRepository.save(rv1);
		
		RiesgoVinculado rv2 = new RiesgoVinculado();
		rv2.setDescripcion("Mercado");
		riesgoVinculadoRepository.save(rv2);
		
		RiesgoVinculado rv3 = new RiesgoVinculado();
		rv3.setDescripcion("Crédito y Mercado");
		riesgoVinculadoRepository.save(rv3);
		
		RiesgoVinculado rv4 = new RiesgoVinculado();
		rv4.setDescripcion("Otros");
		riesgoVinculadoRepository.save(rv4);
		
	}
	
	private void cargarResponsables() {
		
		Responsable responsable = new Responsable();
		responsable.setNombre("Sergio");
		responsable.setApellido("Santamaria");
		responsable.setPuesto("Ingeniero");
		responsableRepository.save(responsable);
		
		Responsable responsable2 = new Responsable();
		responsable2.setNombre("Carlos");
		responsable2.setApellido("Santamaria");
		responsable2.setPuesto("Ingeniero");
		responsableRepository.save(responsable2);
	}
	
	private void cargarRiesgos() {
		CategoriaEventoPerdida categoriaEventoPerdida = new CategoriaEventoPerdida();
		categoriaEventoPerdida.setDescripcion("Fraude interno");
		
		LineaDeNegocio lineaDeNegocio = new LineaDeNegocio();
		lineaDeNegocio.setTipo("Finanzas corporativas");
		lineaDeNegocio.setDescripcion("Finanzas corporativas");
		
		CaracterDelRiesgo caracterDelRiesgo = new CaracterDelRiesgo();
		caracterDelRiesgo.setDescripcion("Pérdida ocurrida individual");
		caracterDelRiesgo.setDetalle("");
		
		Area area = new Area();
		area.setDescripcion("Proceso");
		
		RiesgoVinculado riesgoVinculado = new RiesgoVinculado();
		riesgoVinculado.setDescripcion("Crédito");
		
		Responsable responsable = new Responsable();
		responsable.setNombre("Sergio");
		responsable.setApellido("Santamaria");
		responsable.setPuesto("Ingeniero");
		
		Riesgo riesgo = new Riesgo();
		
		riesgo.setTitulo("Titulo de prueba");
		riesgo.setDescripcion("Descripcion de prueba");
		riesgo.setFrecuencia(1);
		riesgo.setProbabilidad(new BigDecimal(2.0));
		riesgo.setFecha_inicio(new Date());
		riesgo.setAplica_cuenta_contable(AplicaCuentaContable.SI);
		riesgo.setPlazo_ejecucion("2 Meses");
		riesgo.setCategoria_evento_perdida(categoriaEventoPerdida);
		riesgo.setLinea_de_negocio(lineaDeNegocio);
		riesgo.setCaracter_del_riesgo(caracterDelRiesgo);
		riesgo.setArea(area);
		riesgo.setImpacto_del_riesgo(ImpactoDelRiesgo.ALTO);
		riesgo.setRiesgo_vinculado(riesgoVinculado);
		riesgo.setResponsable(responsable);
		
		riesgoRepository.save(riesgo);
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		cargarCategoriasEventosPerdida();
		cargarLineasDeNegocio();
		cargarAccionesCorrectivas();
		cargarAreas();
		cargarCaracteresDelRiesgo();
		cargarResponsables();
		cargarRiesgosVinculados();
		cargarRiesgos();

	}

}
