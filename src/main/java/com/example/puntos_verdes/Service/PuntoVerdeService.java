package com.example.puntos_verdes.Service;

import com.example.puntos_verdes.DTO.PuntoVerdeDTO;
import com.example.puntos_verdes.Entity.PuntoVerde;
import com.example.puntos_verdes.Repository.PuntoVerdeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PuntoVerdeService {

    @Autowired
    private PuntoVerdeRepository puntoVerdeRepository;

    public List<PuntoVerdeDTO> getPuntoVerdeList() {
        return puntoVerdeRepository.findAll().stream()
                .map(PuntoVerdeDTO::new)
                .toList();
    }
    public void createPuntoVerde(PuntoVerde puntoVerde) {
        puntoVerdeRepository.save(puntoVerde);
    }

    public void deletePuntoVerde(Long id) {
        puntoVerdeRepository.deleteById(id);
    }

}
