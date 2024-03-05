const PLANTILLA_PLATO = (idPlato ,nombre,descripcion,precio) => {
    return `
    <tr>    
        <td>${idPlato}</td>
        <td>${nombre}</td>
        <td>${descripcion}</td>
        <td>${precio}</td>
        <td>
            <img src="../img/btnEditar.png" width="20px" id="btnEditar-${idPlato}" class="btnEditar">
            <img src="../img/btnEliminar.png" width="20px" id="btnEliminar-${idPlato}" class="btnEliminar">
        </td>
    </tr>
  `
}


export {
    PLANTILLA_PLATO
}