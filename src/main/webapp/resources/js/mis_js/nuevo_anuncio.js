
 $(document).ready(actualizar());
 
 
 

 function actualizar() {

    var camposEmail = document.querySelectorAll(".precio");
    for (var i = 0; camposEmail.length > i; i++) {
        camposEmail[i].value = "";

    }

    var botonesmodificadores = document.querySelectorAll(".modificar");
    var cambio = true;
    for (var i = 0; cambio; i++) {
        botonesmodificadores[i].setAttribute("data-toggle", "modal");
        botonesmodificadores[i].setAttribute("href", "#modificar");
        if (i == botonesmodificadores.length) {

            break;
        }

    }
    var elemento = document.getElementById("#fecha");
   

    elemento.value = new Date();
    
}


function actualizarelementos(div, componente, div2) {
    var valorcomponente = document.getElementById(componente).value;




    if (valorcomponente == 0) {

        $("#" + div2).fadeIn(2000);


    } else {

        $("#" + div).fadeOut(1000);
        $("#" + div2).fadeOut(1000);


    }
}
function actualizarelementosdescripcion(div, componente, div2) {
    var valorcomponente = document.getElementById(componente).value;
    var longitud = 1500 - valorcomponente.length;



    if (valorcomponente == 0) {
        $("#descripciontxt p").html(longitud + " caracteres Restantes");
        $("#" + div2).fadeIn(2000);


    } else {
        $("#descripciontxt p").html(longitud + " caracteres Restantes");
        $("#" + div).fadeOut(1000);
        $("#" + div2).fadeOut(1000);


    }
}

function crearAnuncioValidar() {

    var crearCuenta = document.querySelectorAll(".nuevo_anuncio");
    var cantidad = crearCuenta.length;
    var parar = true, valor = null, el_id = null, caracter = null, i = null, contador = 0;

    for (i = 0; parar; i++) {
        if (cantidad != i) {
            valor = crearCuenta[i].value;
            if (valor == 0) {
                contador++;
                el_id = crearCuenta[i].id;
                for (var k = 0; k < el_id.length; k++) {
                    if (caracter = el_id.charAt(k) == ":") {
                        $("#" + el_id.substring(k + 1, el_id.length) + "div2").fadeIn(2000);
                    }
                }

            }
        } else {
            parar = false;
            if (contador > 0) {
                return false;
            } else {
                $("#cargandoCrearAnuncio").show();
                $("#pregreso").show();
                $(".mensajess").hide();
                
                return true;

            }

        }
    }


}


function ttfoto(event, foto, siguiente) {
    var salida = document.getElementById(foto);
    salida.src = URL.createObjectURL(event.target.files[0]);
    $("#" + siguiente).show();
}
function ttfoto2(event, foto) {
    var salida = document.getElementById(foto);
    salida.src = URL.createObjectURL(event.target.files[0]);
}




