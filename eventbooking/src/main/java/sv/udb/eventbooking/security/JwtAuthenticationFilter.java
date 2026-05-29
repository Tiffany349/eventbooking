package sv.udb.eventbooking.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
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
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be

    @Autowired
    private JwtService jwtService;

<<<<<<< HEAD
    @Autowired
    private UserRepository userRepository;

=======
<<<<<<< HEAD
    @Autowired
    private UserRepository userRepository;

=======
<<<<<<< HEAD
    @Autowired
    private UserRepository userRepository;

=======
<<<<<<< HEAD
    @Autowired
    private UserRepository userRepository;

=======
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
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
        //
        // VALIDAR HEADER
        //
=======
<<<<<<< HEAD
        //
        // VALIDAR HEADER
        //
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
        // SI NO HAY TOKEN
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
        if (
                authHeader == null ||
                        !authHeader.startsWith("Bearer ")
        ) {

            filterChain.doFilter(
                    request,
                    response
            );
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
        if (authHeader == null ||
                !authHeader.startsWith("Bearer ")) {

            filterChain.doFilter(request, response);
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be

            return;
        }

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
        //
        // EXTRAER TOKEN
        //
        jwt = authHeader.substring(7);

        //
        // EXTRAER USERNAME
        //
        username =
                jwtService.extractUsername(jwt);

        //
        // SI NO HAY AUTHENTICATION
        //
<<<<<<< HEAD
=======
=======
<<<<<<< HEAD
        jwt = authHeader.substring(7);

        username =
                jwtService.extractUsername(jwt);

=======
<<<<<<< HEAD
        // EXTRAER TOKEN
        jwt = authHeader.substring(7);

        // EXTRAER USERNAME
        username =
                jwtService.extractUsername(jwt);

        // SI NO HAY AUTH
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
        if (
                username != null &&
                        SecurityContextHolder
                                .getContext()
                                .getAuthentication() == null
        ) {

<<<<<<< HEAD
            //
            // BUSCAR USER EN DB
            //
=======
<<<<<<< HEAD
            //
            // BUSCAR USER EN DB
            //
=======
<<<<<<< HEAD
=======
            // BUSCAR USUARIO REAL EN DB
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
            sv.udb.eventbooking.entity.User appUser =
                    userRepository
                            .findByUsername(username)
                            .orElse(null);

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
            //
            // VALIDAR USER Y TOKEN
            //
            if (
                    appUser != null &&
                            jwtService.isTokenValid(
                                    jwt,
                                    username
                            )
            ) {

                //
                // ROLE_ADMIN
                //
                String role =
                        "ROLE_" + appUser.getRole();
                System.out.println(
                        "ROLE => " + role
                );

                //
                // USERDETAILS
                //
<<<<<<< HEAD
=======
=======
<<<<<<< HEAD
            if (appUser != null &&
                    jwtService.isTokenValid(jwt, username)
            ) {

                //
                // IMPORTANTE 🔥
                //
                String role =
                        "ROLE_" + appUser.getRole();

                User userDetails =
                        new User(
                                appUser.getUsername(),
                                appUser.getPassword(),
                                List.of(
                                        new SimpleGrantedAuthority(role)
                                )
                        );

=======
            if (appUser != null) {

                // CREAR USERDETAILS
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
                User userDetails =
                        new User(
                                appUser.getUsername(),

                                appUser.getPassword(),

                                List.of(
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
                                        new SimpleGrantedAuthority(role)
                                )
                        );

                //
                // AUTH TOKEN
                //
<<<<<<< HEAD
=======
=======
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

>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
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

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
                //
                // SET AUTH
                //
                SecurityContextHolder
                        .getContext()
                        .setAuthentication(authToken);

                System.out.println(
                        "AUTH OK"
                );
            }
        }

<<<<<<< HEAD
=======
=======
                SecurityContextHolder
                        .getContext()
                        .setAuthentication(authToken);
            }
        }

<<<<<<< HEAD
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
        filterChain.doFilter(
                request,
                response
        );
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
        filterChain.doFilter(request, response);
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
>>>>>>> 94a7a18f1bf8c674dd8860b156b541530868c5d1
>>>>>>> 877167939f9e10d949c292c821688475df3ee5be
    }
}