package sv.udb.eventbooking.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
<<<<<<< HEAD
import java.util.HashMap;
import java.util.Map;
=======
<<<<<<< HEAD
import java.util.HashMap;
import java.util.Map;
=======
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
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
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
    public String generateToken(
            String username,
            String role
    ) {

        Map<String, Object> claims =
                new HashMap<>();

        claims.put("role", role);

        return Jwts.builder()

                .setClaims(claims)

<<<<<<< HEAD
=======
=======
    public String generateToken(String username) {

        return Jwts.builder()

>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
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
<<<<<<< HEAD
    public String extractUsername(
            String token
    ) {
=======
<<<<<<< HEAD
    public String extractUsername(
            String token
    ) {
=======
    public String extractUsername(String token) {
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c

        return extractClaim(
                token,
                Claims::getSubject
        );
    }

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
    // EXTRAER ROLE
    public String extractRole(
            String token
    ) {

        Claims claims =
                extractAllClaims(token);

        return claims.get(
                "role",
                String.class
        );
    }

<<<<<<< HEAD
=======
=======
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
    // EXTRAER CLAIM
    public <T> T extractClaim(
            String token,
            Function<Claims, T> resolver
    ) {

<<<<<<< HEAD
        Claims claims =
                extractAllClaims(token);
=======
<<<<<<< HEAD
        Claims claims =
                extractAllClaims(token);
=======
        Claims claims = extractAllClaims(token);
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c

        return resolver.apply(claims);
    }

    // EXTRAER CLAIMS
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c
    private Claims extractAllClaims(
            String token
    ) {

        return Jwts.parserBuilder()

                .setSigningKey(
                        getSignKey()
                )
<<<<<<< HEAD
=======
=======
    private Claims extractAllClaims(String token) {

        return Jwts.parserBuilder()

                .setSigningKey(getSignKey())
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c

                .build()

                .parseClaimsJws(token)

                .getBody();
    }

    // VALIDAR TOKEN
    public boolean isTokenValid(
            String token,
            String username
    ) {

<<<<<<< HEAD
        String user =
                extractUsername(token);
=======
<<<<<<< HEAD
        String user =
                extractUsername(token);
=======
        String user = extractUsername(token);
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
>>>>>>> aa5d16b6e567a8aaff7c06c7e9e3255d2c4d890c

        return user.equals(username);
    }
}