package sv.udb.eventbooking.security;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
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

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
                //
                // DESACTIVAR CSRF
                //
                .csrf(csrf -> csrf.disable())

                //
                // CORS
                //
                .cors(cors -> {})

                //
<<<<<<< HEAD
                // STATELESS JWT
                //
=======
                // JWT STATELESS
                //
=======
                .csrf(csrf -> csrf.disable())

                .cors(cors -> {})

>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
                .sessionManagement(session ->
                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS
                        )
                )

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
                //
                // AUTORIZACION
                //
                .authorizeHttpRequests(auth -> auth

                        //
                        // PUBLICOS
                        //
<<<<<<< HEAD
=======
=======
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
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
                        .requestMatchers(
                                "/api/auth/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/v3/api-docs/**"
                        ).permitAll()

<<<<<<< HEAD
                        //
                        // EVENTOS GET
                        //
=======
<<<<<<< HEAD
                        //
                        // EVENTOS GET
                        //
=======
<<<<<<< HEAD
                        //
                        // VER EVENTOS
                        //
=======
<<<<<<< HEAD
                        // VER EVENTOS -> USER Y ADMIN
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/events/**"
                        ).authenticated()

<<<<<<< HEAD
                        //
                        // EVENTOS SOLO ADMIN
=======
<<<<<<< HEAD
                        //
                        // SOLO ADMIN
=======
<<<<<<< HEAD
                        //
                        // ADMIN
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
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
<<<<<<< HEAD
                        // BOOKINGS
                        //
                        .requestMatchers(
                                HttpMethod.POST,
                                "/api/bookings/**"
                        ).authenticated()

                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/bookings/**"
                        ).authenticated()

                        .requestMatchers(
                                HttpMethod.DELETE,
                                "/api/bookings/**"
                        ).hasAnyRole(
                                "ADMIN",
                                "USER"
                        )

                        //
                        // TODO LO DEMAS
=======
<<<<<<< HEAD
                        // TODO AUTH
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
                        //
                        .anyRequest().authenticated()
                )

                //
                // JWT FILTER
                //
<<<<<<< HEAD
=======
=======
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

>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
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