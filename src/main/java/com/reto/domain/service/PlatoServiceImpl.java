package com.reto.domain.service;


import com.reto.domain.repositoy.PlatoRepository;
import com.reto.persistence.entity.Plato;
import jakarta.transaction.Transactional;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Getter @Setter
public class PlatoServiceImpl implements  PlatoService{

    @Autowired
    private PlatoRepository platoRepository;


    @Override
    public Optional<Plato> buscarPlato(long idPlato) {
        return platoRepository.findById(idPlato);
    }

    @Override
    public List<Plato> listarPlato() {
        return platoRepository.findAll();
    }

    @Override
    public Plato listarPlatoId(long idPlato) {
        Optional<Plato> buscarPlato =buscarPlato(idPlato) ;
        if (!buscarPlato.isPresent()) {
            throw new RuntimeException("!☢️ plato no encontrado ...");
        }
        return buscarPlato.get();
    }

    @Override
    public void crearPlato(Plato plato) {
        List<Plato> buscarPlato = platoRepository.buscar_x_nombre(plato.getNombrePlato());
        if (!buscarPlato.isEmpty()) {
            throw new RuntimeException("!☢️ el plato que desea crear ya ha sido creado ...");
        }
        else {
            platoRepository.save(plato);
        }
    }

    @Override
    public void modificarPlato(long idPlato , Plato plato) {
        Optional<Plato> miPlato = buscarPlato(idPlato);
        if (!miPlato.isPresent()) {
            throw new RuntimeException("!☢️ el plato que desea modificar no ha sido creado todavía ...");
        } else {
            var objPlato = miPlato.get();
            if(!plato.getDescripcion().equals("")){
                objPlato.setDescripcion(plato.getDescripcion());
                platoRepository.save(objPlato); // Guarda objPlato después de cambiar la descripción
            }
            // Si la descripción está vacía, no se hace nada
        }
    }

        



  @Override
public ResponseEntity<Void> eliminarPlato(long idPlato) {
    Optional<Plato> buscarPlato = buscarPlato(idPlato);
    if (!buscarPlato.isPresent()) {
        throw new RuntimeException("!☢️ el plato que desea eliminar no a sido creado todavia ...");
    } else {
        platoRepository.deleteById(idPlato);
    }
    return ResponseEntity.noContent().build();
}
}
