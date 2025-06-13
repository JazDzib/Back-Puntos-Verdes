package com.example.puntos_verdes.Controllers;

import com.example.puntos_verdes.Entity.PuntoVerde;
import com.example.puntos_verdes.Service.PuntoVerdeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/PuntoVerde")
@Tag(name  =  "Administracion de puntos verdes", description =  "Controlador de actividades realcionadas a los puntos verdes")
public class PuntoVerdeController {

    @Autowired
     private  PuntoVerdeService puntoVerdeService;

    @GetMapping
    @Operation(summary = "ci")
    public List<PuntoVerde> getPuntoVerde(){
        return puntoVerdeService.getPuntoVerde();
    }

    @PostMapping("insertPV")
     public void insertPuntoVerde(@RequestBody PuntoVerde puntoVerde){
        puntoVerdeService.createPuntoVerde(puntoVerde);
    }

    @DeleteMapping("{puntoId}")
    public void deletePuntoVerde(@PathVariable Long puntoId){
        puntoVerdeService.deletePuntoVerde(puntoId);
    }
}
