import{
    URI_COMPLETA
} from './config.js';

import {
    PETICION_HTTP
}from './peticion.js'

const ELIMINAR_PLATO =()=>{
    document.addEventListener("click", async event => {
        if (event.target.matches("[id^='btnEliminar']")) {
            const idPlato = event.target.id.split('-')[1];
            const result = await Swal.fire({
                title: '¿Estás seguro?',
                text: "No podrás revertir esto!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Sí, bórralo!'
            })
            if (result.isConfirmed) {
                const uri = `${URI_COMPLETA}/${idPlato}`;
                console.log(uri);
                 PETICION_HTTP(uri, 'DELETE');
                // Recargar la lista de platos después de eliminar
                
            }
        }
    });
    
}

export {
    ELIMINAR_PLATO
}