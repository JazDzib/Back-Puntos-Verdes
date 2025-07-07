package com.example.puntos_verdes.Controllers;

import com.example.puntos_verdes.DTO.AuthResponse;
import com.example.puntos_verdes.DTO.LoginDTO;
import com.example.puntos_verdes.DTO.UsuarioDTO;
import com.example.puntos_verdes.Service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class authController {
    @Autowired
    private AuthService authService;

    @PostMapping (value = "login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(authService.login(loginDTO));
    }

    @PostMapping (value = "register")
    public  ResponseEntity< AuthResponse> register( @Valid @RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(authService.register(usuarioDTO));
    }
}
