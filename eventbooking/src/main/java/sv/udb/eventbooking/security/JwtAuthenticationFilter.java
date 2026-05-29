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

        jwt = authHeader.substring(7);

        username =
                jwtService.extractUsername(jwt);

        if (
                username != null &&
                        SecurityContextHolder
                                .getContext()
                                .getAuthentication() == null
        ) {

            sv.udb.eventbooking.entity.User appUser =
                    userRepository
                            .findByUsername(username)
                            .orElse(null);

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

        filterChain.doFilter(
                request,
                response
        );
    }
}