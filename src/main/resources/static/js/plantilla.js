const plantillaPlato = (nombre,descripcion,precio)=>{
    return `
    <tr>
        <td>nombre</td>
        <td>descripcion</td>
        <td>precio</td>
        <td>
            <img src="../img/btnEditar.png">
            <img src="../img/btnEliminar.png">
        </td>
  </tr>`
}


export {
    plantillaPlato
}