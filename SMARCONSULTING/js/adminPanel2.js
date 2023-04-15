function mostrasDiv(clase){
        ocultarDiv();
        $("."+clase).addClass("animate__animated animate__backInUp");
	    $("."+clase).css("visibility", "visible");

}

function ocultarDiv(){
    $(".calendarioCita").css("visibility", "hidden");
    $(".cita").css("visibility", "hidden");
    $(".reporte").css("visibility", "hidden");
    $(".usuariosEdit").css("visibility", "hidden");
    $(".usuariosCont").css("visibility", "hidden");

    /***
     * Removiendo la animacion
     */

    $(".calendarioCita").removeClass("animate__animated animate__backInUp");
    $(".cita").removeClass("animate__animated animate__backInUp");
    $(".reporte").removeClass("animate__animated animate__backInUp");
    $(".usuariosEdit").removeClass("animate__animated animate__backInUp");
    $(".usuariosCont").removeClass("animate__animated animate__backInUp");

}

function cargarUsuarios(){

    $.post("Clases/getUsuarios.php", data,
        function (data, status) {
          
            alert (data);
            
        },);

}