
var aportesSelecionados = {};
var idAporteSeleccionado;
var numeroAportes=0;

$(function(){

var $window = $(window)

// Disable certain links in docs
    $('section [href^=#]').click(function (e) {
      e.preventDefault()
    })

    // side bar
    $('.bs-docs-sidenav').affix({
      offset: {
        top: function () { return $window.width() <= 980 ? 290 : 210 }
      , bottom: 270
      }
    })


  // popovers de la aplicacion
  $("#nombre-nuevacuenta").popover({
          trigger: 'focus', 
          content: 'Nos basta con que escribas tu primer nombre'
        })

  $("#apellidos-nuevacuenta").popover({
          trigger: 'focus', 
          content: 'Nos basta con que escribas tu primer apellido'
        })

  $("#nombre-usuario-nuevacuenta").popover({
          trigger: 'focus', 
          content: 'Tienes que ser creativo, escribe un nombre de usuario que te pueda identificar'
        })

  $("#clave-nuevacuenta").popover({
          trigger: 'focus', 
          content: 'Procura ser cuidado: escribe una clave con mas de 6 caracteres y que contengan letras, numeros y signos como -,_,#,$.'
        })

  $("#descripcion-buscar").popover({
          trigger: 'focus', 
          content: 'Escribe lo que quieras con respecto a lo que necesitas.',
          placement: 'bottom'
        })

  $(".aporte").popover({
    trigger: 'hover', 
    placement: 'top'
  });

// configuracion de la pantalla de gestion de aportes

$('#barraGrupoHerramientas').hide();

$('div.opcion-seleccion').on('click', function(e){
    var contenedor= $(this).parent();
    idAporteSeleccionado = contenedor.find('input[type="hidden"]').get(0).value;
    var mensajeOpcion = $(this).find('span').text('Desmarcar aporte');
     console.log(idAporteSeleccionado);
    if ($(contenedor).hasClass('aporte-seleccionado')){
        eliminarAporteDeLista(idAporteSeleccionado);
        console.log(aportesSelecionados);
        contenedor.removeClass('aporte-seleccionado');
        mensajeOpcion.text('Marcar este aporte');
        if(numeroAportes == 0){
          $('#barraGrupoHerramientas').hide();
        }
    }else{
        agregarAporteALista(idAporteSeleccionado);
        console.log(aportesSelecionados);
        contenedor.addClass('aporte-seleccionado');
        mensajeOpcion.text('Desmarcar este aporte');
        $('#barraGrupoHerramientas').show();
    }
  });
});

function eliminarAporteDeLista(valorEliminar){
  var arregloAuxiliar = [];
  for(i in aportesSelecionados){
    if(aportesSelecionados[i]!= valorEliminar){
      arregloAuxiliar[aportesSelecionados[i]] = aportesSelecionados[i];
    }
  }
  aportesSelecionados = arregloAuxiliar;
  numeroAportes--;
}

function agregarAporteALista(valorAgregado){
  aportesSelecionados[valorAgregado] = valorAgregado;
  numeroAportes++;
}
