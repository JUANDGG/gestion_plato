package com.reto.domain.service;

import com.reto.persistence.entity.Plato;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

public interface PlatoService {

    Optional<Plato> buscarPlato (long idPlato);
    List<Plato> listarPlato ();

    Plato listarPlatoId(long idPlato);

    void crearPlato (Plato plato);

    void modificarPlato(long idPlato,Plato plato) ;

    ResponseEntity<Void> eliminarPlato(long idPlato) ;
}
