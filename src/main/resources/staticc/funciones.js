
function eliminar(id) {
    swal({
        title: "Esta seguro de eliminar?",
        text: "La eliminacion sera permanente!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
            .then((OK) => {
                if (OK) {
                    $.ajax({
                        url: "/eliminarTarea/" + id,
                        success: function (res) {
                            console.log(res);
                        },
                    }),
                            swal("Eliminada correctamente!", {
                                icon: "success",
                            }).then((ok) => {
                        if (ok) {
                            location.href = "/";
                        }
                    });
                } else {
                    swal("No se ha eliminada nada!");
                }
            });
        }

function editar(id) {
      swal({
        title: "Esta seguro de editar?",
        text: "el cambio sera permanete",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
            .then((OK) => {
                if (OK) {
                            swal("a continuacion se le mostrar el formulario", {
                                icon: "success",
                            }).then((ok) => {
                        if (ok) {
                        $.ajax({
                        url: "/editar/" + id,
                        success: function (res) {
                            console.log(res);
                        },
                    })
                        }
                    });
                } else {
                    swal("No se ha eliminada nada!");
                }
            });
    }
    
    
function valor()
{
    var progreso=50;
    $('#bar').css('width', progreso + '%');
}