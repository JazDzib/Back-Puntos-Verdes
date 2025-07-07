package com.example.puntos_verdes.Repository;

import com.example.puntos_verdes.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRespository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreo(String correo);
}
