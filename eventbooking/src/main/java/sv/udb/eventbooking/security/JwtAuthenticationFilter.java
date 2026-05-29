package sv.udb.eventbooking.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

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

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

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

        //
        // VALIDAR HEADER
        //
        if (
                authHeader == null ||
                        !authHeader.startsWith("Bearer ")
        ) {

            filterChain.doFilter(
                    request,
                    response
            );

            return;
        }

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
        if (
                username != null &&
                        SecurityContextHolder
                                .getContext()
                                .getAuthentication() == null
        ) {

            //
            // BUSCAR USER EN DB
            //
            sv.udb.eventbooking.entity.User appUser =
                    userRepository
                            .findByUsername(username)
                            .orElse(null);

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
                User userDetails =
                        new User(
                                appUser.getUsername(),

                                appUser.getPassword(),

                                List.of(
                                        new SimpleGrantedAuthority(role)
                                )
                        );

                //
                // AUTH TOKEN
                //
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

        filterChain.doFilter(
                request,
                response
        );
    }
}