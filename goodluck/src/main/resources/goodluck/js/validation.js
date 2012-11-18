
$(function(){

    var name = $('#nombre-nuevacuenta');
    name.blur(function(e){
        validarNombre(true);
        formularioEsValido(false);
    });
    var nameInfo = $('#nameInfo');

    var ape = $('#apellidos-nuevacuenta');
    ape.blur(function(e){
        validarApellidos(true);
        formularioEsValido(false);
    });
    var apeInfo = $('#apellidosInfo');

    var email = $('#email-nuevacuenta');
    email.blur(function(e){
        validarEmail(true);
        formularioEsValido(false);
    });
    var emailInfo = $('#emailInfo');

    var nameUser = $('#nombre-usuario-nuevacuenta');
    nameUser.blur(function(e){
        validarNombreUsuario(true);
        formularioEsValido(false);
    });
    var nameUserInfo = $('#usuarioInfo');

    var clave = $('#clave-nuevacuenta');
    clave.blur(function(e){
        validarClave(true);
        formularioEsValido(false);
    });
    var claveInfo = $('#claveInfo');

    var boton = $('#registroCuenta_boton');

    var acuerdo = $('#terminosCondiciones');
    acuerdo.change(function(){
        console.log('cambio el check');
        formularioEsValido(false);
    });

    $('#registroCuenta').submit(function(){
        return formularioEsValido(true);
    });

    function validarNombre(evalua){
        if(name.val().length < 1){
            if(evalua){
                name.removeClass('no-error');
                nameInfo.text("Escriba su nombre");
                nameInfo.addClass("mensaje-error");
            }
            return false;
        }else {
            if(evalua){
                nameInfo.text("");
                nameInfo.removeClass("mensaje-error");
                name.addClass("no-error");
            }
            return true;
        }
    }

    function validarApellidos(evalua){
        if(ape.val().length < 1){
            if(evalua){
                ape.removeClass('no-error');
                apeInfo.text("Escriba sus apellidos");
                apeInfo.addClass("mensaje-error");
            }
            return false;
        }else {
            if(evalua){
                apeInfo.text("");
                apeInfo.removeClass("mensaje-error");
                ape.addClass("no-error");
            }
            return true;
        }
    }

    function validarEmail(evalua){

        if(email.val().length < 1){
            if(evalua){
                email.removeClass('no-error');
                emailInfo.text("Escriba su direccion de correo");
                emailInfo.addClass("mensaje-error");
            }
            return false;
        }else if(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email.val())){
            if(evalua){
                emailInfo.text("");
                emailInfo.removeClass("mensaje-error");
                email.addClass("no-error");
            }
            return true;
        }else{
            if(evalua){
                email.removeClass('no-error');
                emailInfo.text("Esta direccion no es valida");
                emailInfo.addClass("mensaje-error");
            }
            return false;
        }
    }

    function validarNombreUsuario(evalua){
        if(nameUser.val().length < 1){
            if(evalua){
                nameUser.removeClass('no-error');
                nameUserInfo.text("Escriba un nombre de usuario");
                nameUserInfo.addClass("mensaje-error");
            }
            return false;
        }else {
            if(evalua){
                nameUserInfo.text("");
                nameUserInfo.removeClass("mensaje-error");
                nameUser.addClass("no-error");
            }
            return true;
        }
    }

    function validarClave(evalua){
        
        if(clave.val().length < 1){
            if(evalua){
                clave.removeClass('no-error');
                claveInfo.text("Escriba una contraseña");
                claveInfo.addClass("mensaje-error");
            }
            return false;
        }else if(clave.val().length < 6){
            if(evalua){
                clave.removeClass('no-error');
                claveInfo.text("Escriba una contraseña de almenos 6 caracteres");
                claveInfo.addClass("mensaje-error");
            }
            return false;
        }else {
            if(evalua){
                claveInfo.text("");
                claveInfo.removeClass("mensaje-error");
                clave.addClass("no-error");
            }
            return true;
        }
    }

    function formularioEsValido(evaluar){
        if(validarNombre(evaluar) && validarApellidos(evaluar) && validarEmail(evaluar) 
            && validarNombreUsuario(evaluar) && validarClave(evaluar) && acuerdo.is(':checked')){
            boton.removeClass('disabled');
            return true;
        }else{
            boton.addClass('disabled');
            return false;
        }
    }
})