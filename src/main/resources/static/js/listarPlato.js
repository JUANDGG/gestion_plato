import {PETICION_HTTP} from './peticion.js'
import{PLANTILLA_PLATO} from './plantilla.js'
import{
    URI_LISTAR 
} from './config.js';

console.log(URI_LISTAR);

const LISTAR_PLATO = async()=>{
    const CUERPO_TABLA = document.getElementById("tbody");
    const DATOS_PLATO = await PETICION_HTTP(URI_LISTAR,"GET");
    DATOS_PLATO.forEach(plato => {
        CUERPO_TABLA.innerHTML +=PLANTILLA_PLATO(plato.idPlato,plato.nombrePlato,plato.descripcion,plato.precio)
    });
}


export {
    LISTAR_PLATO,
}