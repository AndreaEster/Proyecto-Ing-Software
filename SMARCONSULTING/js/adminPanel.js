function mostrasDiv(clase){
        ocultarDiv();
	    $("."+clase).css("visibility", "visible");
}

function ocultarDiv(){
    $(".calendarioCita").css("visibility", "hidden");
    $(".cita").css("visibility", "hidden");
    $(".reporte").css("visibility", "hidden");
    $(".usuariosEdit").css("visibility", "hidden");
    $(".usuariosCont").css("visibility", "hidden");
}

function cargarUsuarios(){

    $.post("Clases/getUsuarios.php", data,
        function (data, status) {
          
            alert (data);
            
        },);

}