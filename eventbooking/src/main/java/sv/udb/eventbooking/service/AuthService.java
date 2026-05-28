package sv.udb.eventbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import sv.udb.eventbooking.dto.AuthRequest;
import sv.udb.eventbooking.dto.AuthResponse;

import sv.udb.eventbooking.entity.User;

import sv.udb.eventbooking.repository.UserRepository;

import sv.udb.eventbooking.security.JwtService;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    //
    // REGISTER
    //
    public User register(
            User user
    ) {

        // VALIDACIONES
        if (
                user.getUsername() == null ||
                        user.getUsername().isBlank()
        ) {

            throw new RuntimeException(
                    "Username obligatorio"
            );
        }

        if (
                user.getFirstname() == null ||
                        user.getFirstname().isBlank()
        ) {

            throw new RuntimeException(
                    "Nombre obligatorio"
            );
        }

        if (
                user.getLastname() == null ||
                        user.getLastname().isBlank()
        ) {

            throw new RuntimeException(
                    "Apellido obligatorio"
            );
        }

        if (
                user.getAge() == null ||
                        user.getAge() <= 0
        ) {

            throw new RuntimeException(
                    "Edad inválida"
            );
        }

        if (
                user.getPassword() == null ||
                        user.getPassword().length() < 4
        ) {

            throw new RuntimeException(
                    "La contraseña debe tener al menos 4 caracteres"
            );
        }

        // VALIDAR DUPLICADOS
        boolean exists =
                userRepository
                        .findByUsername(
                                user.getUsername()
                        )
                        .isPresent();

        if (exists) {

            throw new RuntimeException(
                    "El username ya existe"
            );
        }

        // ENCRIPTAR PASSWORD
        user.setPassword(
                passwordEncoder.encode(
                        user.getPassword()
                )
        );

        // ROLE POR DEFECTO
        user.setRole(
                "USER"
        );

        return userRepository.save(
                user
        );
    }

    //
    // LOGIN
    //
    public AuthResponse login(
            AuthRequest request
    ) {

        User user =
                userRepository
                        .findByUsername(
                                request.getUsername()
                        )
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Usuario no encontrado"
                                )
                        );

        boolean valid =
                passwordEncoder.matches(
                        request.getPassword(),
                        user.getPassword()
                );

        if (!valid) {

            throw new RuntimeException(
                    "Credenciales incorrectas"
            );
        }

        // TOKEN CON ROLE
        String token =
                jwtService.generateToken(
                        user.getUsername(),
                        user.getRole()
                );

        return new AuthResponse(

                token,

                user.getUsername(),

                user.getRole()
        );
    }
}