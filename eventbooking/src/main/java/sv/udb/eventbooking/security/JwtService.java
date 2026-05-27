package sv.udb.eventbooking.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET =
            "mi_clave_super_secreta_para_jwt_2026_muy_segura";

    private Key getSignKey() {

        return Keys.hmacShaKeyFor(
                SECRET.getBytes()
        );
    }

    // GENERAR TOKEN
    public String generateToken(String username) {

        return Jwts.builder()

                .setSubject(username)

                .setIssuedAt(new Date())

                .setExpiration(
                        new Date(
                                System.currentTimeMillis()
                                        + 1000 * 60 * 60
                        )
                )

                .signWith(
                        getSignKey(),
                        SignatureAlgorithm.HS256
                )

                .compact();
    }

    // EXTRAER USERNAME
    public String extractUsername(String token) {

        return extractClaim(
                token,
                Claims::getSubject
        );
    }

    // EXTRAER CLAIM
    public <T> T extractClaim(
            String token,
            Function<Claims, T> resolver
    ) {

        Claims claims = extractAllClaims(token);

        return resolver.apply(claims);
    }

    // EXTRAER CLAIMS
    private Claims extractAllClaims(String token) {

        return Jwts.parserBuilder()

                .setSigningKey(getSignKey())

                .build()

                .parseClaimsJws(token)

                .getBody();
    }

    // VALIDAR TOKEN
    public boolean isTokenValid(
            String token,
            String username
    ) {

        String user = extractUsername(token);

        return user.equals(username);
    }
}