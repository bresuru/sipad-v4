

function sin_cupo() {

    Swal.fire({
        type: 'error',
        title: 'Oops...',
        text: 'EL torneo no esta abierto a inscripciones por el momento'
    });

}
;

function cupo() {
    
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn btn-success',
            cancelButton: 'btn btn-danger'
        },
        buttonsStyling: false,
    })

    swalWithBootstrapButtons.fire({
        title: '¿Estas seguro/a de inscribirse a este torneo?',
        text: "No hay vuelta atras depues de inscribirse!",
        type: 'warning',
        showCancelButton: true,
        confirmButtonText: ' Si, quiero inscribirme! ',
        cancelButtonText: ' No, cancelar! ',
        reverseButtons: true

    }).then((result) => {
        if (result.value) {
            swalWithBootstrapButtons.fire(
                    'Inscripto!',
                    'Se ha inscripto al torneo exitosamente.',
                    'success'
                    )
            table.row('.selected').remove().draw(false);
        } else if (
                result.dismiss === Swal.DismissReason.cancel
                ) {
            swalWithBootstrapButtons.fire(
                    'Cancelled',
                    'Se cancelo la inscriipcion al torneo',
                    'error'
                    )
        }
    })


}
;