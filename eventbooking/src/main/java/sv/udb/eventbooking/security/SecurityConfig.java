package sv.udb.eventbooking.security;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

<<<<<<< HEAD
=======
=======
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
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
                        //
                        // PUBLICOS
                        //
=======
<<<<<<< HEAD
                        // PUBLICOS
=======
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
                        .requestMatchers(
                                "/api/auth/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/v3/api-docs/**"
                        ).permitAll()

<<<<<<< HEAD
                        //
                        // VER EVENTOS
                        //
=======
<<<<<<< HEAD
                        // VER EVENTOS -> USER Y ADMIN
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/events/**"
                        ).authenticated()

<<<<<<< HEAD
                        //
                        // ADMIN
                        //
                        .requestMatchers(
                                HttpMethod.POST,
                                "/api/events/**"
                        ).hasRole("ADMIN")

                        .requestMatchers(
                                HttpMethod.PUT,
                                "/api/events/**"
                        ).hasRole("ADMIN")

                        .requestMatchers(
                                HttpMethod.DELETE,
                                "/api/events/**"
                        ).hasRole("ADMIN")

                        //
                        // TODO LO DEMÁS
                        //
=======
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
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
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