import {PETICION_HTTP} from './peticion.js'
import{
    URI_COMPLETA
} from './config.js';

const ALERTA_ERROR =(descripcionError)=>{
    return swal("ERROR!",descripcionError , "error");
}

const ALERTA_INPUT = (idPlato) => {
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
            
        }
    });
}


export {
    ALERTA_INPUT,
    ALERTA_ERROR
}