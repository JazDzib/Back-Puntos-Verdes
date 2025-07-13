package com.example.puntos_verdes.Controllers;

import com.example.puntos_verdes.DTO.AuthResponse;
import com.example.puntos_verdes.DTO.LoginDTO;
import com.example.puntos_verdes.DTO.UsuarioDTO;
import com.example.puntos_verdes.Entity.Usuario;
import com.example.puntos_verdes.Service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
@Tag(name  =  "Authentication", description =  "Allow authenticate and authorize clients")
@RequiredArgsConstructor
public class authController {
    @Autowired
    private AuthService authService;

    @PostMapping (value = "login")
    @Operation(summary = "Allow generate valid tokens with credentials to exist user")
    @ApiResponses(value = {
            @ApiResponse( responseCode = "200", description = "user login succesfully",
            content = @Content( schema = @Schema(implementation = AuthResponse.class))),
           @ApiResponse ( responseCode = "404", description = "user no found")
    })
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(authService.login(loginDTO));
    }

    @PostMapping (value = "register")
    @Operation (summary = "Allow generate a new user")
    @ApiResponses(value = {
            @ApiResponse( responseCode = "200", description = "user login succesfully",
                    content = @Content( schema = @Schema(implementation = AuthResponse.class))),
            @ApiResponse ( responseCode = "404", description = "user no found")
    })
    public  ResponseEntity< AuthResponse> register( @Valid @RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(authService.register(usuarioDTO));
    }


}
