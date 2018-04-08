package com.sgre.configuration;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.sgre.service.evento.AreaService;
import com.sgre.service.evento.CaracterDelEventoService;
import com.sgre.service.evento.CategoriaEventoPerdidaService;
import com.sgre.service.evento.EventoService;
import com.sgre.service.evento.LineaDeNegocioService;
import com.sgre.service.evento.ResponsableService;
import com.sgre.service.evento.UsuarioService;
import com.sgre.service.impl.evento.AreaServiceImpl;
import com.sgre.service.impl.evento.CaracterDelEventoServiceImpl;
import com.sgre.service.impl.evento.CategoriaEventoPerdidaServiceImpl;
import com.sgre.service.impl.evento.EventoServiceImpl;
import com.sgre.service.impl.evento.LineaDeNegocioServiceImpl;
import com.sgre.service.impl.evento.ResponsableServiceImpl;
import com.sgre.service.impl.evento.UsuarioServiceImpl;

@Configuration
@PropertySource({ "classpath:persistence-multiple-db.properties" })
@EnableJpaRepositories(
		basePackages = "com.sgre.dao.evento", 
		entityManagerFactoryRef = "eventoEntityManager", 
		transactionManagerRef = "eventoTransactionManager")
public class EventoDBConfiguration {

	@Autowired
	private Environment env;
	
	private DatabasePopulator databasePopulator() {
		ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
		resourceDatabasePopulator.setContinueOnError(true);
		resourceDatabasePopulator.addScript(new ClassPathResource("evento_data.sql"));
		return resourceDatabasePopulator;
	}
	
	@Bean
	public DataSource eventoDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("eventos.datasource.driver-class-name"));
		dataSource.setUrl(env.getProperty("eventos.datasource.url"));
		dataSource.setUsername(env.getProperty("eventos.datasource.username"));
		dataSource.setPassword(env.getProperty("eventos.datasource.password"));

		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean eventoEntityManager() {
		
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(eventoDataSource());
		em.setPackagesToScan(new String[] { "com.sgre.model.evento" });
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaPropertyMap(properties);

		return em;
	}
	
	@Bean
	public PlatformTransactionManager eventoTransactionManager() {

		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(eventoEntityManager().getObject());
		DatabasePopulatorUtils.execute(databasePopulator(), eventoDataSource());
		
		return transactionManager;
	}
	
	@Bean(name="eventoService")
	public EventoService eventoService() {
		return new EventoServiceImpl();
	}
	
	@Bean(name="caracterDelEventoService")
	public CaracterDelEventoService caracterDelEventoService() {
		return new CaracterDelEventoServiceImpl();
	}
	
	@Bean(name="eventoAreaService")
	public AreaService areaService() {
		return new AreaServiceImpl();
	}
	
	@Bean(name="eventoLineaDeNegocioService")
	public LineaDeNegocioService lineaDeNegocioService() {
		return new LineaDeNegocioServiceImpl();
	}
	
	@Bean(name="eventoResponsableService")
	public ResponsableService responsableService() {
		return new ResponsableServiceImpl();
	}
	
	@Bean(name="eventoCategoriaEventoPerdidaService")
	public CategoriaEventoPerdidaService categoriaEventoPerdidaService() {
		return new CategoriaEventoPerdidaServiceImpl();
	}
	
	@Bean(name="eventoUsuarioService")
	public UsuarioService usuarioService() {
		return new UsuarioServiceImpl();
	}
	
}
