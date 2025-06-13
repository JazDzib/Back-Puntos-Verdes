package com.example.puntos_verdes.Repository;

import com.example.puntos_verdes.Entity.PuntoVerde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface PuntoVerdeRepository extends JpaRepository<PuntoVerde, Long> {

}
