package com.sgre.security;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("customUserDetailsService")
	private UserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean getSpringSecurityFilterChainBindedToError(
			@Qualifier("springSecurityFilterChain") Filter springSecurityFilterChain) {

		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(springSecurityFilterChain);
		registration.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
		return registration;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/css/**", "/js/**", "/img/**", "/resources/**").permitAll();

		http.authorizeRequests()
			.antMatchers("/", "/login")
				.permitAll()
			.antMatchers("/riesgos/listar")
				.permitAll()
			.antMatchers("/riesgos/{id}/consultar")
				.permitAll()
			.antMatchers("/riesgos/{id}/modificar")
				.hasAnyAuthority("INCIDENCIAS_ROLE_ADMIN", "EVENTOS_ROLE_ADMIN")
			.antMatchers("/riesgos/{id}/eliminar")
				.hasAnyAuthority("INCIDENCIAS_ROLE_ADMIN", "EVENTOS_ROLE_ADMIN")
			.antMatchers("/riesgos/crear")
				.hasAnyAuthority("INCIDENCIAS_ROLE_ADMIN", "EVENTOS_ROLE_ADMIN")
			.antMatchers("/eventos/listar")
				.permitAll()
			.antMatchers("/eventos/{id}/consultar")
				.permitAll()
			.antMatchers("/eventos/{id}/modificar")
				.hasAnyAuthority("INCIDENCIAS_ROLE_ADMIN", "EVENTOS_ROLE_ADMIN")
			.antMatchers("/eventos/{id}/eliminar")
				.hasAnyAuthority("INCIDENCIAS_ROLE_ADMIN", "EVENTOS_ROLE_ADMIN")
			.antMatchers("/eventos/crear")
				.hasAnyAuthority("INCIDENCIAS_ROLE_ADMIN", "EVENTOS_ROLE_ADMIN")
			.and()
			.exceptionHandling()
				.accessDeniedPage("/403")
			.and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/riesgos/listar")
			.and()
			.logout()
				.permitAll();
		

	}

}
