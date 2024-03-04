package com.reto.web.controller;

public interface Ruta {


    String RUTA_PRINCIPAL ="/api";


    //Ruta para los plato

    //Con esta ruta listo todo los platos
    String RUTA_PLATO = "/api/plato/all";

    // esta ruta lista los plato por id
    String RUTA_BUSCAR_PLATO = "/api/plato/{idPlato}" ;


    // Esta ruta permite realizar operaciones como eliminar o modificar

    String RUTA_OPERACIONES_PLATO = "/api/plato" ;



}
