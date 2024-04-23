package com.register.auth.html.config;

import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringConfg {

    @Bean
    protected SecurityFilterChain springSecurityFilterChain(HttpSecurity http, OAuth2ResourceServerProperties oAuth2ResourceServerProperties) throws Exception {
        http
                .authorizeHttpRequests(authoriza -> authoriza.anyRequest().authenticated())
                .csrf(csrf -> csrf.disable())
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
                .sessionManagement(sesseion -> sesseion.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }
}
