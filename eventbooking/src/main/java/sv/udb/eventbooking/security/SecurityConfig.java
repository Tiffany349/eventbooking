package sv.udb.eventbooking.security;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

=======
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
<<<<<<< HEAD

=======
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http
    ) throws Exception {

        http

                .csrf(csrf -> csrf.disable())

                .cors(cors -> {})

                .sessionManagement(session ->
                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS
                        )
                )

                .authorizeHttpRequests(auth -> auth

<<<<<<< HEAD
                        // PUBLICOS
=======
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
                        .requestMatchers(
                                "/api/auth/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/v3/api-docs/**"
                        ).permitAll()

<<<<<<< HEAD
                        // VER EVENTOS -> USER Y ADMIN
                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/events/**"
                        ).authenticated()

                        // CREAR EVENTO -> SOLO ADMIN
                        .requestMatchers(
                                HttpMethod.POST,
                                "/api/events/**"
                        ).hasAuthority("ADMIN")

                        // EDITAR EVENTO -> SOLO ADMIN
                        .requestMatchers(
                                HttpMethod.PUT,
                                "/api/events/**"
                        ).hasAuthority("ADMIN")

                        // ELIMINAR EVENTO -> SOLO ADMIN
                        .requestMatchers(
                                HttpMethod.DELETE,
                                "/api/events/**"
                        ).hasAuthority("ADMIN")

                        // TODO LO DEMÁS
=======
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
                        .anyRequest().authenticated()
                )

                .addFilterBefore(
                        jwtAuthFilter,
                        UsernamePasswordAuthenticationFilter.class
                );

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
}