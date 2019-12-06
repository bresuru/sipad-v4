function iniciar() {

	var tipo_user = document.getElementById("tipo_user").value;
	var documento = document.getElementById("usuario").value;
	var pass = document.getElementById("pass").value;

	if (documento == 'supervisor' && pass == '12345' && tipo_user == 'Supervisor') {

		window.location.href = "si/indexSupervisor.html";

	}else if (documento == 'profesor' && pass == '12345' && tipo_user == 'Profesor'){

		window.location.href = "si/indexProfesor.html";

	}else if (documento == 'deportista' && pass == '12345' && tipo_user == 'Estudiante'){

		window.location.href = "si/indexDeportista.html";

	}else{
		Swal.fire({
		  type: 'error',
		  title: 'Oops...',
		  text: 'Los datos ingresados no son validos, Por favor intente nuevamente',
		})
	}
}

function iniciar1() {

	var tipo_user = document.getElementById("tipo_user").value;
	var documento = document.getElementById("usuario").value;
	var pass = document.getElementById("pass").value;

	if (documento == 'supervisor' && pass == '12345' && tipo_user == 'Supervisor') {

		window.location.href = "../../indexSupervisor.html";

	}else if (documento == 'profesor' && pass == '12345' && tipo_user == 'Profesor'){

		window.location.href = "si/client.html";

	}else if (documento == 'deportista' && pass == '12345' && tipo_user == 'Estudiante'){

		window.location.href = "../../indexDeportista.html";

	}else{
		Swal.fire({
		  type: 'error',
		  title: 'Oops...',
		  text: 'Los datos ingresados no son validos, Por favor intente nuevamente',
		})
	}
}

function iniciarPE() {

	var documento = document.getElementById("usuario").value;
	var pass = document.getElementById("pass").value;

	if (documento == 'supervisor' && pass == '12345') {

		window.location.href = "indexSupervisor.html";

	}else if (documento == 'Profesor' && pass == '12345'){

		window.location.href = "client.html";

	}else if (documento == 'deportista' && pass == '12345'){

		window.location.href = "client.html";

	}else{
		Swal.fire({
		  type: 'error',
		  title: 'Oops...',
		  text: 'Los datos ingresados no son validos, Por favor intente nuevamente',
		})
	}
}

function registro (){
	Swal.fire({
	  title: 'Para tener un usuario se debe inscribir a una categoria deportiva',
	  type: 'info',
	  showCancelButton: true,
	  confirmButtonColor: '#3085d6',
	  cancelButtonColor: '#d33',
	  cancelButtonText: 'Cancelar',
	  confirmButtonText: 'Inscribirse',
	  reverseButtons: true
	}).then((result) => {
	  if (result.value) {
	    return "inscripcion_index.xhtml";
	  }
	})

}

function registroIni (){
	Swal.fire({
	  title: 'Para tener un usuario se debe inscribir a una categoria deportiva',
	  type: 'info',
	  showCancelButton: true,
	  confirmButtonColor: '#3085d6',
	  cancelButtonColor: '#d33',
	  cancelButtonText: 'Cancelar',
	  confirmButtonText: 'Inscribirse',
	  reverseButtons: true
	}).then((result) => {
	  if (result.value) {
	    window.location.href = "si/html/inscripcion/inscripcion.html";
	  }
	})

}

function cambiar_contra() {

	var correo = document.getElementById("correo").value;

	if (correo != '') {

		Swal.fire({
		  type: 'success',
		  title: 'Se ha enviado un correo con una contraseña temporal',
		  text: 'Los datos ingresados no son validos, Por favor intente nuevamente',
		})

	}else{
		Swal.fire({
		  type: 'error',
		  title: 'Oops...',
		  text: 'Los datos ingresados no son validos, Por favor intente nuevamente',
		})
	}
}




