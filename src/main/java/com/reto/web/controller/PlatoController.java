package com.reto.web.controller;

import com.reto.domain.service.PlatoService;
import com.reto.persistence.entity.Plato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class PlatoController {

    @Autowired
    private PlatoService platoService ;

    //@RequestMapping(value = Ruta.RUTA_PRINCIPAL); falta la creacion de la ruta principal

    @RequestMapping(value = Ruta.RUTA_PLATO, method = RequestMethod.GET)
    public List<Plato> listadoPlatos (){
        return  platoService.listarPlato();
    }

    @RequestMapping(value =Ruta.RUTA_BUSCAR_PLATO , method = RequestMethod.GET)
    public Plato listarPlatoId (@PathVariable long idPlato){
        return  platoService.listarPlatoId(idPlato);
    }


    @RequestMapping(value =Ruta.RUTA_OPERACIONES_PLATO , method = RequestMethod.POST)
    public void cargarPlato(@RequestBody Plato plato){
        platoService.crearPlato(plato);
    }


    @RequestMapping(value =Ruta.RUTA_OPERACIONES_PLATO , method = RequestMethod.PUT)
    public void modificarPlato(@RequestBody Plato plato){
        platoService.modificarPlato(plato);
    }


    /*
    @RequestMapping(value =Ruta.RUTA_BUSCAR_PLATO , method = RequestMethod.DELETE)
    public void eliminarPlato(@RequestBody Plato plato){
        platoService.eliminarPlato(plato);
    }


     */







}
