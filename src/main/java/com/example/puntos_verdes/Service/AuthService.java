package com.example.puntos_verdes.Service;

import com.example.puntos_verdes.DTO.AuthResponse;
import com.example.puntos_verdes.DTO.LoginDTO;
import com.example.puntos_verdes.DTO.UsuarioDTO;
import com.example.puntos_verdes.Entity.Enums.RolUsuario;
import com.example.puntos_verdes.Entity.Usuario;
import com.example.puntos_verdes.Repository.UsuarioRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    private UsuarioRespository usuarioRespository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthResponse login(LoginDTO loginDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
        UserDetails usuario = usuarioRespository.findByCorreo(loginDTO.getEmail()).orElseThrow();
        String token = jwtService.getToken(usuario);
        return AuthResponse.builder()
                .token(token)
                .build();

    }

    public AuthResponse register( UsuarioDTO usuarioDTO) {
        Usuario usuario = Usuario.builder()
                .nombre(usuarioDTO.getNombre())
                .correo(usuarioDTO.getCorreo())
                .contrasenia(passwordEncoder.encode(usuarioDTO.getContrasenia()))
                .rol_usuario(RolUsuario.USER)
                .build();
        usuarioRespository.save(usuario);

        return AuthResponse.builder()
                .token(jwtService.getToken(usuario))
                .build();
    }
}
