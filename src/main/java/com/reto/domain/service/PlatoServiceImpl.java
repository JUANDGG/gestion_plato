package com.reto.domain.service;


import com.reto.domain.repositoy.PlatoRepository;
import com.reto.persistence.entity.Plato;
import jakarta.transaction.Transactional;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
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
        Optional<Plato> buscarPlato =buscarPlato(plato.getIdPlato()) ;
        if (buscarPlato.isPresent()) {
            throw new RuntimeException("!☢️ el plato que desea crear ya a sido creado ...");
        }
        else {
            platoRepository.save(plato);
        }
    }

    @Override
    public void modificarPlato(Plato plato) {
        Optional<Plato> miPlato =buscarPlato(plato.getIdPlato()) ;
        if (!miPlato.isPresent()) {
            throw new RuntimeException("!☢️ el plato que desea modifica no a sido creado todavia ...");
        }
        else {
            var objPlato = buscarPlato(plato.getIdPlato()).get();
            objPlato.setDescripcion(plato.getDescripcion());
            platoRepository.save(plato);
        }
    }



    @Override
    public void eliminarPlato(long idPlato) {
        Optional<Plato> buscarPlato =buscarPlato(idPlato) ;
        if (!buscarPlato.isPresent()) {
            throw new RuntimeException("!☢️ el plato que desea eliminar no a sido creado todavia ...");
        }
        else {
            platoRepository.deleteById(idPlato);
        }
    }
}
