$(document).ready(function(){

	$('#calendario_ver').fullCalendar({

		header:{
			left:   'title',
			center: '',
			right:  'today prev,  next', 	
			center: 'month,agendaFourDay'

		},

		eventLimit: true, // for all non-TimeGrid views
		  views: {
		    timeGrid: {
		      eventLimit: 4 // adjust to 6 only for timeGridWeek/timeGridDay
		  }
		},

		dayClick: function(date, jsEvent, view) {
			$('#txtfecha_inicio').val(date.format());
			$('#txtfecha_fin').val(date.format());
			$('#modal_calendar').modal();
		}, 
		
		editable: false, // event resources editable by default


		eventSources:[{
			events: [

				{
					title: 'Entrenamiento de futbol',
					descripcion: "Entrenamiento",
					start: '2019-06-05T15:45:00',
					allDay: false
				},

				{
					title: 'Festival del deportite',
					descripcion: "Se hara una fiesta a los deportitsta de la academia",
					start: '2019-06-10',
					end: '2019-06-13',
					color: "green",
				},

				{
					title: 'Torneo juvenil',
					descripcion: "Se frentara a los wolf black",
					start: '2019-06-24T13:30:00',
					allDay: false,
					color: "red",
					textColor: "white"
				},

				{
					title: 'Entrenamiento de futbol',
					descripcion: "Entrenamiento",
					start: '2019-06-28T15:45:00',
					allDay: false
				}


			],

			color: "blue",
			textColor: "white"
		}],

		eventClick:function(calEvent,jsEvent,view){
			$('#tituloEvent').html(calEvent.title);
			$('#fechaEvent').html(calEvent.start);
			$('#descripcionEvent').html(calEvent.descripcion);

			$('#modal_info').modal();
		}

	});

});


$('#btnmodificar').click(function(){
	recolectar_datos();
	Swal.fire({
		type: 'error',
		title: 'Oops...',
		text: 'No hay una base de datos',
	})
});

$('#btnEliminar').click(function(){
	recolectar_datos();
	Swal.fire({
		type: 'error',
		title: 'Oops...',
		text: 'No hay una base de datos',
	})
});

$('#btnEliminar').click(function(){
	recolectar_datos();
	Swal.fire({
		type: 'error',
		title: 'Oops...',
		text: 'No hay una base de datos',
	})
});

var nuevo_evento;

$('#btnguardar').click(function(){

	var nombre = document.getElementById("txttitulo").value;

	if (nombre != '') {
		recolectar_datos();

		$('#calendario_ver').fullCalendar('renderEvent',nuevo_evento );
		$('#modal_calendar').modal('toggle');

	}else{
		Swal.fire({
			type: 'error',
			title: 'Oops...',
			text: 'Faltan casillas por llenar, Por favor intente nuevamente',
		})
	}

});



function recolectar_datos(){

	nuevo_evento= {
		id: 1,
		title: $('#txttitulo').val(),
		start: $('#txtfecha_inicio').val() + " " + $('#txthora').val(),
		end: $('#txtfecha_fin').val() + " " + $('#txthora_fin').val(),
		color: $('#txtcolor').val(),
		descripcion: $('#txtdescripcon_event').val(),
		textColor: $('#text_color').val()

	};

};


function error_base_datos(){

	

};



