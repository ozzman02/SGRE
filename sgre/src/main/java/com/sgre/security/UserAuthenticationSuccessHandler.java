package com.sgre.security;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserAuthenticationSuccessHandler implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {

	@Override
	public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
		
		UserDetails userDetails = (UserDetails) event.getAuthentication().getPrincipal();
		System.out.println(userDetails.getAuthorities());
		
	}

}
