package com.example.puntos_verdes.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/PuntoVerde")
@Tag(name  =  "Administracion de puntos verdes", description =  "Controlador de actividades realcionadas a los puntos verdes")
public class PuntoVerdeController {

    @GetMapping
    @Operation(summary = "ci")

    public ResponseEntity<String> getPuntoVerde() {
        return ResponseEntity.ok("Punto Verde");
    }

}
