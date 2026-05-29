package sv.udb.eventbooking.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import sv.udb.eventbooking.dto.AuthRequest;
import sv.udb.eventbooking.dto.AuthResponse;
import sv.udb.eventbooking.entity.User;
import sv.udb.eventbooking.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    // REGISTER
    @PostMapping("/register")
    public User register(
            @Valid
            @RequestBody User user
    ) {

        return authService.register(user);
    }

    // LOGIN
    @PostMapping("/login")
    public AuthResponse login(
            @RequestBody AuthRequest request
    ) {

        return authService.login(request);
    }
}