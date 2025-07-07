package com.example.puntos_verdes.DTO;

import com.example.puntos_verdes.Entity.Enums.RolUsuario;
import com.example.puntos_verdes.Entity.Usuario;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO {
    private  Long id;
    private String nombre;
    @NotBlank
    private String correo;
    @NotBlank
    private String contrasenia;
    private RolUsuario rol_usuario;

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nombre = usuario.getNombre();
        this.correo = usuario.getCorreo();
        this.contrasenia = usuario.getContrasenia();
        this.rol_usuario = usuario.getRol_usuario();
    }
}
