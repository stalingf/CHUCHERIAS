$(document).ready(function () {

    /*
     var dt = new Date();
     var year = dt.getFullYear();
     var month = "0" + (dt.getMonth() + 1);
     var day = dt.getDate();
     var hora = dt.getHours();
     var minuto = dt.getMinutes();
     var fechaActual = year + "" + "" + month + "" + day + "" + hora + "" + minuto;
     var fechaActualInt = parseInt(fechaActual);
     
     var fechas = document.querySelectorAll(".fecha");
     var tamaño = fechas.length;
     var caracter = 0;
     var elhtml2 = "";
     
     
     for (var i = 0; true; i++) {
     var pid = fechas[i].id;
     
     var elhtml = $("#" + pid).html();
     
     for (var k = 0; k < elhtml.length; k++) {
     if (caracter = elhtml.charAt(k) == ".") {
     elhtml2 = elhtml.substring(0, k - 3).replace("-", "").replace("-", "").replace(":", "").replace(":", "");
     
     }
     }
     var fechaHtml = parseInt(elhtml2);
     
     var total = fechaActualInt - fechaHtml;
     alert(fechaActualInt + " - " + elhtml2 + " total " + total);
     
     ////alert(pid.toString().replace("-","").replace("-","").replace(".","").replace(":","").replace(":","").replace(" ",""));
     
     if (i == tamaño) {
     break;
     }
     }*/

    /////////////////////// Campo Email  ///////////////////////
    var camposEmail = document.querySelectorAll(".email");
    for (var i = 0; camposEmail.length > i; i++) {
        camposEmail[i].type = "email";
    }

    ///////////////////////Campos Numericos ///////////////////////
    /*var camposNumericos = document.querySelectorAll(".numerico");
     for (var i = 0; camposNumericos.length > i; i++) {
     camposNumericos[i].type = "number";
     camposNumericos[i].min = 0;
     }*/

    ///////////////////////Campos lislider ///////////////////////
    var lislider = document.querySelectorAll(".lislider");
    lislider[0].setAttribute("class", " slide-current");

    ///////////////////////Olcurtar Mensajes ///////////////////////
    var mensajes = document.querySelectorAll(".mensajes");
    for (var i = 0; mensajes.length > i; i++) {
        mensajes[i].hiden();



    }
    /////////////////////// Mouse Over  ///////////////////////
    $('ul.nav li.dropdown').hover(function () {
        $(this).find('.dropdown-menu').stop(true, true).delay(150).fadeIn(200);
    }, function () {
        $(this).find('.dropdown-menu').stop(true, true).delay(150).fadeOut(200);
    });
    ///////////////////////

}
);


/*
 function renderizaslider() {
 var imagenesw = document.querySelectorAll(".slider");
 
 var saber = imagenesw.length;
 $(".poner").prepend('<canvas class=" img-responsive canvasslider" ></canvas>');
 var canvass = document.querySelectorAll(".canvasslider");
 var cantidad = canvass.length;
 var parar = true;
 for (var i = 0; parar; i++) {
 if (cantidad == i) {
 parar = false;
 } else {
 var selectcanva = canvass[i];
 var ctx = selectcanva.getContext("2d");
 ctx.drawImage(imagenesw[i], 0, 0, 400, 150);
 
 }
 }
 }
 function renderizacatalogo() {
 var imagenesw = document.querySelectorAll(".novista");
 
 var saber = imagenesw.length;
 $(".renderizar").prepend('<canvas class="img-responsive canvass img-thumbnail" ></canvas>');
 var canvass = document.querySelectorAll(".canvass");
 var cantidad = canvass.length;
 var parar = true;
 for (var i = 0; parar; i++) {
 if (cantidad == i) {
 parar = false;
 } else {
 var selectcanva = canvass[i];
 var ctx = selectcanva.getContext("2d");
 ctx.drawImage(imagenesw[i], 0, 0, 300, 150);
 }
 }
 }*/




function actualizanumero(div, componente) {

    var valorcomponente = document.getElementById(componente).value;
    if (valorcomponente != 0) {

        $("#" + div).fadeOut(1000);
    } else {
        $("#" + div).fadeIn(2000);




    }
}
function actualizacedula(div, componente) {

    var valorcomponente = document.getElementById(componente).value;



    if (valorcomponente != 0) {

        $("#" + div).fadeOut(1000);



    } else {
        $("#" + div).fadeIn(2000);
    }

}
function actualizarelementos(div, componente) {
    var valorcomponente = document.getElementById(componente).value;


    if (valorcomponente == 0) {


        $("#" + div).fadeIn(2000);


    } else {


        $("#" + div).fadeOut(1000);



    }
}

function validamelogin() {
    $(".mensajes").hide();

    var crearCuenta = document.querySelectorAll(".login");
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
                        $("#" + el_id.substring(k + 1, el_id.length) + "div").fadeIn(2000);
                    }
                }

            }
        } else {
            parar = false;
            if (contador > 0) {
                return false;
            } else {
                $(".cargandoLogin").show();

                return true;

            }

        }
    }

}


function validarCrearcuenta() {
    $("#clavesdefirentes").hide();
    $(".mendajes").hide();

    var crearCuenta = document.querySelectorAll(".crear_cuenta");
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
                        $("#" + el_id.substring(k + 1, el_id.length) + "div").fadeIn(2000);
                    }
                }

            }
        } else {
            parar = false;
            if (contador > 0) {
                return false;
            } else {
                var clave1 = crearCuenta[cantidad - 2].value;
                var clave2 = crearCuenta[cantidad - 1].value;
                if (clave1 == clave2) {
                    $(".cargando").show();
                    return true;

                } else {

                    $("#clavesdefirentes").fadeIn(2000);


                    return false;
                }

            }

        }
    }
}

var numero = 1;
function paginas(parametro) {
    if (parametro == "+") {
        numero++;
        $("#paginador p").html(numero + " /100");
    } else if (parametro == "-") {
        numero--;
        $("#paginador p").html(numero + " /100");
    }

}

function buscar() {
   

    var busqueda = document.querySelectorAll(".buscador");
    var cantidad = busqueda.length;
    var parar = true, valor = null, el_id = null, caracter = null, i = null, contador = 0;

    for (i = 0; parar; i++) {
        if (cantidad != i) {
            valor = busqueda[i].value;
            if (valor == 0) {
                contador++;
                el_id = busqueda[i].id;
                for (var k = 0; k < el_id.length; k++) {
                    if (caracter = el_id.charAt(k) == ":") {
                        $("#" + el_id.substring(k + 1, el_id.length) + "div2").fadeIn(2000);
                        
                        return false;
                    }
                }

            }else{
                parar = false;
                
                return true;
                
            }
        } 
    }

}