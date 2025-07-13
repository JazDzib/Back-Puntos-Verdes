package com.example.puntos_verdes.DTO;

import com.example.puntos_verdes.Entity.Enums.TipoResiduo;
import com.example.puntos_verdes.Entity.PuntoVerde;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
public class PuntoVerdeDTO {
    @NotBlank
    private String nombre;
    private String descripcion;
    @NonNull
    private BigDecimal latitud;
    @NonNull
    private BigDecimal longitud;
    @NotBlank
    private String direccion;
    @NotBlank
    private TipoResiduo tipo_residuo;
    private String imagen_url;


    public PuntoVerdeDTO(PuntoVerde punto) {

        this.nombre = punto.getNombre();
        this.descripcion = punto.getDescripcion();
        this.latitud = punto.getLatitud();
        this.longitud = punto.getLongitud();
        this.direccion = punto.getDireccion();
        this.tipo_residuo = punto.getTipo_residuo();
        this.imagen_url = punto.getImagen_url();
    }


}

