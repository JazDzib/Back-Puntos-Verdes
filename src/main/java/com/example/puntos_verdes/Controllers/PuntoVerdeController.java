package com.example.puntos_verdes.Controllers;

import com.example.puntos_verdes.DTO.PuntoVerdeDTO;
import com.example.puntos_verdes.Entity.PuntoVerde;
import com.example.puntos_verdes.Service.PuntoVerdeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/PuntoVerde")
@Tag(name  =  "Administracion de puntos verdes", description =  "Controlador de actividades realcionadas a los puntos verdes")
@RequiredArgsConstructor
public class PuntoVerdeController {

    @Autowired
     private  PuntoVerdeService puntoVerdeService;

    @GetMapping
    @Operation(summary = "ci")
    public List<PuntoVerdeDTO> getPuntoVerde(){
        return puntoVerdeService.getPuntoVerdeList();
    }

    @PostMapping("insertPV")
    @Transactional
     public ResponseEntity<Long> insertPuntoVerde(@RequestBody  PuntoVerdeDTO puntoVerde){
        Long id = puntoVerdeService.createPuntoVerde(puntoVerde);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("{puntoId}")
    @Transactional
    public ResponseEntity<Void> deletePuntoVerde(@PathVariable Long puntoId){
        puntoVerdeService.deletePuntoVerde(puntoId);
        return ResponseEntity.noContent().build();
    }
}
