package com.example.puntos_verdes.DTO;

import com.example.puntos_verdes.Entity.Enums.TipoResiduo;
import com.example.puntos_verdes.Entity.PuntoVerde;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class PuntoVerdeDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal latitud;
    private BigDecimal longitud;
    private String direccion;
    private TipoResiduo tipo_residuo;
    private String imagen_url;


    public PuntoVerdeDTO(PuntoVerde punto) {
        this.id = punto.getId();
        this.nombre = punto.getNombre();
        this.descripcion = punto.getDescripcion();
        this.latitud = punto.getLatitud();
        this.longitud = punto.getLongitud();
        this.direccion = punto.getDireccion();
        this.tipo_residuo = punto.getTipo_residuo();
        this.imagen_url = punto.getImagen_url();
    }
}

