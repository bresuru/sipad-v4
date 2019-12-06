
$(document).ready(function () {

    $('.alumnos').DataTable({
        
        responsive: "true",
        
        dom: 'Bfrtilp',
        
        buttons:[
            
            {
                
                extend: 'excelHtml5',
                text: '<i class="fas fa-file-excel bg-success"></i> ',
                titleAttr: 'Exportar a Excel',
                className: 'btn btn-dark bg-success'
                
            },
            
            {
                
                extend: 'pdfHtml5',
                text: '<i class="fas fa-file-pdf bg-secondary"></i> ',
                titleAttr: 'Exportar a PDF',
                className: 'btn btn-success bg-success'
                
            },
            
            {
                
                extend: 'print',
                text: '<i class="fas fa-print"></i> ',
                titleAttr: 'Imprimir',
                className: 'btn btn-success bg-dark'
                
            }
            
        ]
        

    });
});


