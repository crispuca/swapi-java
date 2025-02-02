package com.demo.swapijava.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
public class SecurityConfig {

    private final JwtUtil jwtUtil;

    public SecurityConfig(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/auth/login", "/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html").permitAll()// Permite acceso sin autenticación, agregar , "/swapi/**" para los test de integracion
                        .anyRequest().authenticated()  // Requiere autenticación para cualquier otra solicitud
                )
                .addFilterBefore(new JwtFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class)  // Agrega el filtro JWT
                .csrf().disable();

        return http.build();
    }


    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService())
                .and()
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            if ("admin".equals(username)) {
                return User.withUsername("admin")
                        .password("{noop}password")  // {noop} para contraseñas sin cifrar
                        .roles("ADMIN")
                        .build();
            } else if ("user".equals(username)) {
                return User.withUsername("user")
                        .password("{noop}password")
                        .roles("USER")
                        .build();
            } else {
                throw new UsernameNotFoundException("Usuario no encontrado");
            }
        };
    }

}
