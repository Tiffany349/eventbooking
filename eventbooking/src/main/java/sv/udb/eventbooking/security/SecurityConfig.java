package sv.udb.eventbooking.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

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

                //
                // DESACTIVAR CSRF
                //
                .csrf(csrf -> csrf.disable())

                //
                // CORS
                //
                .cors(cors -> {})

                //
                // STATELESS JWT
                //
                .sessionManagement(session ->
                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS
                        )
                )

                //
                // AUTORIZACION
                //
                .authorizeHttpRequests(auth -> auth

                        //
                        // PUBLICOS
                        //
                        .requestMatchers(
                                "/api/auth/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/v3/api-docs/**"
                        ).permitAll()

                        //
                        // EVENTOS GET
                        //
                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/events/**"
                        ).authenticated()

                        //
                        // EVENTOS SOLO ADMIN
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
                        //
                        .anyRequest().authenticated()
                )

                //
                // JWT FILTER
                //
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