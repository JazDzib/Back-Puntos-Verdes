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
    public Long createPuntoVerde(PuntoVerdeDTO puntoVerde) {
        PuntoVerde entity = new PuntoVerde(puntoVerde);
        puntoVerdeRepository.save(entity);
        return entity.getId();
    }

    public void deletePuntoVerde(Long id) {
        puntoVerdeRepository.deleteById(id);
    }

}
