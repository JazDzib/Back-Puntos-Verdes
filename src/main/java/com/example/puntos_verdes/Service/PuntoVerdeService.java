package com.example.puntos_verdes.Service;

import com.example.puntos_verdes.Entity.PuntoVerde;
import com.example.puntos_verdes.Repository.PuntoVerdeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PuntoVerdeService {

    @Autowired
    private PuntoVerdeRepository puntoVerdeRepository;

    public List<PuntoVerde> getPuntoVerde() {
        return puntoVerdeRepository.findAll();
    }
    public void createPuntoVerde(PuntoVerde puntoVerde) {
        puntoVerdeRepository.save(puntoVerde);
    }
    public void deletePuntoVerde(Long id) {
        puntoVerdeRepository.deleteById(id);
    }

}
