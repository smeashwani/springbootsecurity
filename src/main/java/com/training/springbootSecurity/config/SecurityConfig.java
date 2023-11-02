package com.training.springbootSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
import org.springframework.security.web.server.SecurityWebFilterChain;

import reactor.core.publisher.Mono;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity serverHttpSecurity) {

		serverHttpSecurity
				.authorizeExchange(exchanges -> exchanges
						.pathMatchers("/").permitAll()
						.pathMatchers("/public").hasAnyRole("springapp-admin", "springapp-user")
						.pathMatchers("/getAllEmployee").hasAnyRole("springapp-admin"))
				.oauth2ResourceServer(resourceServer -> resourceServer
						.jwt(jwtSpec -> jwtSpec.jwtAuthenticationConverter(grantedAuthoritiesExtractor())));
		serverHttpSecurity.csrf(csrfSpec -> csrfSpec.disable());
		return serverHttpSecurity.build();
	}

	private Converter<Jwt, Mono<AbstractAuthenticationToken>> grantedAuthoritiesExtractor() {
		JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
		jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeyclockRoleCvt());
		return new ReactiveJwtAuthenticationConverterAdapter(jwtAuthenticationConverter);
	}
}