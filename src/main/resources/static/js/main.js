import {LISTAR_PLATO}  from './listarPlato.js';
import {ENVIAR_PLATO} from './enviarPlato.js';
import {EDITAR_PLATO} from './editarPlato.js';
import {ELIMINAR_PLATO} from './eliminarPlato.js';


document.addEventListener("DOMContentLoaded", () => {
    LISTAR_PLATO()
    ENVIAR_PLATO()

    setTimeout(()=>{
        EDITAR_PLATO()
        ELIMINAR_PLATO()
    },100)
    

})


