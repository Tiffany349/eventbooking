package sv.udb.eventbooking.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
<<<<<<< HEAD

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.userdetails.User;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import org.springframework.stereotype.Component;

import org.springframework.web.filter.OncePerRequestFilter;

import sv.udb.eventbooking.repository.UserRepository;

import java.io.IOException;

import java.util.List;

@Component
public class JwtAuthenticationFilter
        extends OncePerRequestFilter {
=======
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49

    @Autowired
    private JwtService jwtService;

<<<<<<< HEAD
    @Autowired
    private UserRepository userRepository;

=======
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        final String authHeader =
                request.getHeader("Authorization");

        final String jwt;

        final String username;

<<<<<<< HEAD
        // SI NO HAY TOKEN
        if (
                authHeader == null ||
                        !authHeader.startsWith("Bearer ")
        ) {

            filterChain.doFilter(
                    request,
                    response
            );
=======
        if (authHeader == null ||
                !authHeader.startsWith("Bearer ")) {

            filterChain.doFilter(request, response);
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49

            return;
        }

<<<<<<< HEAD
        // EXTRAER TOKEN
        jwt = authHeader.substring(7);

        // EXTRAER USERNAME
        username =
                jwtService.extractUsername(jwt);

        // SI NO HAY AUTH
        if (
                username != null &&
                        SecurityContextHolder
                                .getContext()
                                .getAuthentication() == null
        ) {

            // BUSCAR USUARIO REAL EN DB
            sv.udb.eventbooking.entity.User appUser =
                    userRepository
                            .findByUsername(username)
                            .orElse(null);

            if (appUser != null) {

                // CREAR USERDETAILS
                User userDetails =
                        new User(
                                appUser.getUsername(),

                                appUser.getPassword(),

                                List.of(
                                        new SimpleGrantedAuthority(
                                                appUser.getRole()
                                        )
                                )
                        );

                // VALIDAR TOKEN
                if (
                        jwtService.isTokenValid(
                                jwt,
                                username
                        )
                ) {

                    UsernamePasswordAuthenticationToken authToken =
                            new UsernamePasswordAuthenticationToken(
                                    userDetails,
                                    null,
                                    userDetails.getAuthorities()
                            );

                    authToken.setDetails(
                            new WebAuthenticationDetailsSource()
                                    .buildDetails(request)
                    );

                    SecurityContextHolder
                            .getContext()
                            .setAuthentication(authToken);
                }
            }
        }

        filterChain.doFilter(
                request,
                response
        );
=======
        jwt = authHeader.substring(7);

        username = jwtService.extractUsername(jwt);

        if (username != null &&
                SecurityContextHolder
                        .getContext()
                        .getAuthentication() == null) {

            User userDetails = new User(
                    username,
                    "",
                    Collections.emptyList()
            );

            if (jwtService.isTokenValid(jwt, username)) {

                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );

                authToken.setDetails(
                        new WebAuthenticationDetailsSource()
                                .buildDetails(request)
                );

                SecurityContextHolder
                        .getContext()
                        .setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
    }
}