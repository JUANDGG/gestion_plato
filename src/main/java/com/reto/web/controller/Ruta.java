package com.reto.web.controller;

public interface Ruta {


    String RUTA_PRINCIPAL ="/api";


    //Ruta para los plato

    //Con esta ruta listo todo los platos

    

    String RUTA_PLATO_TODOS = "/api/plato/all";

    String RUTA_PLATO_POST ="/api/plato" ;

    // esta ruta lista los plato por id
    String RUTA_PLATO_ID = "/api/plato/{idPlato}" ;


    // Esta ruta permite realizar operaciones como eliminar o modificar


}
