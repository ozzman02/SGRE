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
}
