const URI ={
    protocol :"http://",
    hostName: "localhost",
    port: "8080",
    path :"/api/plato"
};

const URI_LISTAR_TODO =  {
    ...URI,
    path :URI.path + "/all"
}




const URI_COMPLETA =`${URI.protocol}${URI.hostName}:${URI.port}${URI.path}`
const URI_LISTAR =`${URI_LISTAR_TODO.protocol}${URI_LISTAR_TODO.hostName}:${URI_LISTAR_TODO.port}${URI_LISTAR_TODO.path}`



export {
    URI_COMPLETA,
    URI_LISTAR 
}



