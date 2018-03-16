package com.sgre.configuration;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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

import com.sgre.service.impl.riesgo.AccionCorrectivaServiceImpl;
import com.sgre.service.impl.riesgo.AreaServiceImpl;
import com.sgre.service.impl.riesgo.CaracterDelRiesgoServiceImpl;
import com.sgre.service.impl.riesgo.CategoriaEventoPerdidaServiceImpl;
import com.sgre.service.impl.riesgo.LineaDeNegocioServiceImpl;
import com.sgre.service.impl.riesgo.ResponsableServiceImpl;
import com.sgre.service.impl.riesgo.RiesgoServiceImpl;
import com.sgre.service.impl.riesgo.RiesgoVinculadoServiceImpl;
import com.sgre.service.riesgo.AccionCorrectivaService;
import com.sgre.service.riesgo.AreaService;
import com.sgre.service.riesgo.CaracterDelRiesgoService;
import com.sgre.service.riesgo.CategoriaEventoPerdidaService;
import com.sgre.service.riesgo.LineaDeNegocioService;
import com.sgre.service.riesgo.ResponsableService;
import com.sgre.service.riesgo.RiesgoService;
import com.sgre.service.riesgo.RiesgoVinculadoService;

@Configuration
@PropertySource({ "classpath:persistence-multiple-db.properties" })
@EnableJpaRepositories(
		basePackages = "com.sgre.dao.riesgo", 
		entityManagerFactoryRef = "riesgoEntityManager", 
		transactionManagerRef = "riesgoTransactionManager")
public class RiesgoDBConfiguration {

	@Autowired
	private Environment env;

	private DatabasePopulator databasePopulator() {
		ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
		resourceDatabasePopulator.setContinueOnError(true);
		resourceDatabasePopulator.addScript(new ClassPathResource("data.sql"));
		return resourceDatabasePopulator;
	}
	
	@Bean
	@Primary
	public DataSource riesgoDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("riesgos.datasource.driver-class-name"));
		dataSource.setUrl(env.getProperty("riesgos.datasource.url"));
		dataSource.setUsername(env.getProperty("riesgos.datasource.username"));
		dataSource.setPassword(env.getProperty("riesgos.datasource.password"));
	
		return dataSource;
	}
	
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean riesgoEntityManager() {
		
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(riesgoDataSource());
		em.setPackagesToScan(new String[] { "com.sgre.model.riesgo" });
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaPropertyMap(properties);

		return em;
	}
	
	@Bean
	@Primary
	public PlatformTransactionManager riesgoTransactionManager() {

		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(riesgoEntityManager().getObject());
		DatabasePopulatorUtils.execute(databasePopulator(), riesgoDataSource());
		
		return transactionManager;
	}
	
	@Bean
	public RiesgoService riesgoService() {
		return new RiesgoServiceImpl();
	}
	
	@Bean
	public CaracterDelRiesgoService caracterDelRiesgoService() {
		return new CaracterDelRiesgoServiceImpl();
	}
	
	@Bean
	public CategoriaEventoPerdidaService categoriaEventoPerdidaService() {
		return new CategoriaEventoPerdidaServiceImpl();
	}
	
	@Bean
	public AccionCorrectivaService accionCorrectivaService() {
		return new AccionCorrectivaServiceImpl();
	}
	
	@Bean
	public AreaService areaService() {
		return new AreaServiceImpl();
	}
	
	@Bean
	public LineaDeNegocioService lineaDeNegocioService() {
		return new LineaDeNegocioServiceImpl();
	}
	
	@Bean
	public ResponsableService responsableService() {
		return new ResponsableServiceImpl();
	}
	
	@Bean
	public RiesgoVinculadoService riesgoVinculadoService() {
		return new RiesgoVinculadoServiceImpl();
	}
	
}
