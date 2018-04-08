package com.sgre.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sgre.model.riesgo.Usuario;
import com.sgre.service.riesgo.UsuarioService;

@Service("customUserDetailsService")
public class AuthorizationUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioService incidenciasUserService;
	
	@Autowired
	@Qualifier("eventoUsuarioService")
	private com.sgre.service.evento.UsuarioService eventoUserService;
	
	private User userDetails;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		String user_name = "";
		String user_pwd = "";
		
		Usuario usuario_incidencias = incidenciasUserService.buscarUsuarioPorId(username);
		
		com.sgre.model.evento.Usuario usuario_eventos = eventoUserService.buscarUsuarioPorId(username);
		
		if (usuario_incidencias != null && usuario_eventos != null) {
			user_name = usuario_incidencias.getUserId();
			user_pwd = usuario_incidencias.getPassword();
		}
		
		userDetails = new User(user_name, user_pwd, enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, obtenerRoles(usuario_incidencias, usuario_eventos));
		
		return userDetails;
	}
	
	private List<GrantedAuthority> obtenerRoles(Usuario usuario_incidencias, 
			com.sgre.model.evento.Usuario usuario_eventos) {
		
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		
		System.out.println(usuario_incidencias);
		System.out.println(usuario_eventos);
		
		roles.add(new SimpleGrantedAuthority(usuario_incidencias.getRol().name()));
		roles.add(new SimpleGrantedAuthority(usuario_eventos.getRol().name()));
		
		for (GrantedAuthority grantedAuthority : roles) {
			System.out.println(grantedAuthority);
		}
		
		return roles;
	}
	

}
