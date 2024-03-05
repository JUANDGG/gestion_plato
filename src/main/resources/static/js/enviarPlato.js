import {PETICION_HTTP} from './peticion.js'
import{
    URI_COMPLETA
} from './config.js';

const OBTENER_PLATO =()=>{
    const NOMBRE_PLATO = document.getElementById('nombrePlato').value;
    const DESCRIPCION = document.getElementById('descripcion').value;
    const PRECIO = parseFloat(document.getElementById('precio').value);

    if(NOMBRE_PLATO =="" || DESCRIPCION=="" || isNaN(PRECIO)){
        throw("ERROR DATOS REQUERIDOS EN EL FORMULARIO")
    }

    return {
        "nombrePlato" :NOMBRE_PLATO ,
        "descripcion" :DESCRIPCION ,
        "precio" :PRECIO
    }
}

const ENVIAR_PLATO =()=>{
    const BOTON_ENVIAR_PLATO = document.getElementById('boton_enviar_plato');
    BOTON_ENVIAR_PLATO.addEventListener("click", async (e) => {
        e.preventDefault()
        try {
            await PETICION_HTTP(URI_COMPLETA ,"POST", OBTENER_PLATO())
            location.reload();
        } catch (error) {
            Swal.fire("ERROR!","faltaron datos del formulario " , "error");

        }
    })
}

export {
    ENVIAR_PLATO
}