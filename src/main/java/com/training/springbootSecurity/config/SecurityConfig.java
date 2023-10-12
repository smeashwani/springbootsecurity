package com.training.springbootSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity serverHttpSecurity) {
		
		serverHttpSecurity.authorizeExchange(exchanges -> exchanges
				.pathMatchers("/").permitAll()
				.pathMatchers("/public").permitAll()
				.pathMatchers("/getAllEmployee").authenticated())
			.oauth2ResourceServer(resourceServer -> resourceServer.jwt(Customizer.withDefaults()));
		serverHttpSecurity.csrf(csrfSpec -> csrfSpec.disable());

		return serverHttpSecurity.build();
	}
}