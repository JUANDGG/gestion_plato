import{
    URI_COMPLETA
} from './config.js';
import {PETICION_HTTP} from './peticion.js'

const EDITAR_PLATO =()=>{
    document.addEventListener("click", event => {
        // Cambia 'btnEliminar' a 'btnEditar'
        if (event.target.matches("[id^='btnEditar']")) {
            const idPlato = event.target.id.split('-')[1];
            const content = document.createElement('div');

            const hiddenInput = document.createElement('input');
            hiddenInput.type = 'hidden';
            hiddenInput.id = 'hiddenInput';
            hiddenInput.value = idPlato;
            content.appendChild(hiddenInput);
        
            const textarea = document.createElement('textarea');
            textarea.placeholder = 'ingresa las nueva descripcion';
            textarea.id = 'descriptionInput';
            content.appendChild(textarea);
        
            return Swal.fire({
                title: "ingresa la nueva descripcion",
                html: content,
                preConfirm: async () => {
                    const descripcion = document.getElementById('descriptionInput').value;
                    const idPlato = document.getElementById('hiddenInput').value;
                    const uri = `${URI_COMPLETA}/${idPlato}`;
                    const data = { descripcion };
                    PETICION_HTTP(uri, 'PUT', data);
                    location.reload();
                }
            });
        }
    });
}

export {
    EDITAR_PLATO
}