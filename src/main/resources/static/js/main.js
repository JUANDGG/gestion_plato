import {uriConexion}  from './uriConexion';
import {plantillaPlato} from './plantillaPlato';

console.log("asdasd");


const peticion =async(uri)=>{
    return await (await fetch(uri)).json();
    
}


const cargarPlato =()=>{
    const form = document.querySelector('.formulario');
  
    form.addEventListener('submit', async (event) => {
      event.preventDefault(); 
  
      const nombrePlato = document.querySelector('#nombrePlato').value;
      const descripcion = document.querySelector('#descripcion').value;
      const precio = parseFloat(document.querySelector('#precio').value);
      
  
      const plato = {
        nombrePlato,
        descripcion,
        precio
      };
  
      try {
        const response = await fetch(uriConexion, {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(plato)
        });
  
      
        const data = await response.json();
        console.log('Plato creado exitosamente:', data);
        
        
      } catch (error) {
        console.error('Error al crear el plato:', error);
        
      }
    });
}


const listarPlato = async(uri)=>{
    const datosPlato = await peticion(uri);
    const tbody = document.getElementById("tbody");


    datosPlato.forEach(plato => {
        tbody.innerHTML +=plantillaPlato(plato.idPlato,plato.nombrePlato,plato.descripcion,plato.descripcion)
    });

}

document.addEventListener("DOMContentLoaded", () => {

    listarPlato(uriConexion+"/all");
    cargarPlato()
})


