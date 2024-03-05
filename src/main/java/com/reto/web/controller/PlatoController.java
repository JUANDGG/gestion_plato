package com.reto.web.controller;

import com.reto.domain.service.PlatoService;
import com.reto.persistence.entity.Plato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class PlatoController {

    @Autowired
    private PlatoService platoService ;

    //@RequestMapping(value = Ruta.RUTA_PRINCIPAL); falta la creacion de la ruta principal

    @RequestMapping(value = Ruta.RUTA_PLATO_TODOS, method = RequestMethod.GET)
    public List<Plato> listadoPlatos (){
        return  platoService.listarPlato();
    }

    @RequestMapping(value =Ruta.RUTA_PLATO_ID , method = RequestMethod.GET)
    public Plato listarPlatoId (@PathVariable long idPlato){
        return  platoService.listarPlatoId(idPlato);
    }


    @RequestMapping(value =Ruta.RUTA_PLATO_POST , method = RequestMethod.POST)
    public void cargarPlato(@RequestBody Plato plato){
        platoService.crearPlato(plato);
    }


    @RequestMapping(value = Ruta.RUTA_PLATO_ID, method = RequestMethod.PUT)
    public void modificarPlato(@PathVariable long idPlato, @RequestBody Plato plato) {
        platoService.modificarPlato(idPlato, plato);
    }



    @DeleteMapping(value = Ruta.RUTA_PLATO_ID)
    public ResponseEntity<Void> eliminarPlato(@PathVariable long idPlato) {
        platoService.eliminarPlato(idPlato);
        return ResponseEntity.noContent().build();
    }

    







}
