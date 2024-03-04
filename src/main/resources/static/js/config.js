const uri ={
    protocol :"http://",
    hostName: "localhost",
    port: "8080",
    path :"/api/plato"
};





const uriConexion  =`${uri.protocol}${uri.hostName}:${uri.port}${uri.path}` ;

console.log(uriConexion);

export {
    uriConexion
}