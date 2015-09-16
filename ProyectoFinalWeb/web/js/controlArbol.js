/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function obtieneArbol(nombre){
    var arbol;
    $.ajax({
                                   url: "getArbol",
                                   type: "POST",
                                   data: {solicitud : "arbolfallas",nombre:nombre},
                                   dataType: "json", 
                                  success: function(respuesta)                          
                                  {                                  
                                        
                                          /*$.each(respuesta, function(i, item) {
                                            
                                            encabezadosTablaC[i]=item;
                                            
                                            
                                          });*/
                                      arbol=JSON.stringify(respuesta);                                        
                                      alert(arbol);
                                      
                                      },
                                     error: function(XMLHttpRequest, textStatus, errorThrown) {
                                        alert("No se encontro el servicio solicitado"+errorThrown);
                                        //Se puede obtener informacion útil inspecionando el Objeto XMLHttpRequest
                                        console.log(XMLHttpRequest.status);
                                        }
                                     ,
                                     
                                 });   
                                 return arbol;
    
}