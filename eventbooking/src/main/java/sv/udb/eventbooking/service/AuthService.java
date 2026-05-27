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
    private JwtService jwtService;

    private BCryptPasswordEncoder passwordEncoder =
            new BCryptPasswordEncoder();

    // REGISTER
    public User register(User user) {

        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );

        return userRepository.save(user);
    }

    // LOGIN
    public AuthResponse login(AuthRequest request) {

        User user = userRepository.findByUsername(
                        request.getUsername()
                )
                .orElseThrow(() ->
                        new RuntimeException("Usuario no encontrado"));

        boolean valid = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        if (!valid) {
            throw new RuntimeException("Password incorrecto");
        }

        String token = jwtService.generateToken(
                user.getUsername()
        );

        return new AuthResponse(token);
    }
}