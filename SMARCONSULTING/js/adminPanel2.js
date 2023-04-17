
/**
 * Author Ramon Rivera
 * @returns JSON con las instacias de las funciones
 */

var AdminPanel = function(){
  return{
    mostrasDiv:mostrasDiv,
    ocultarDiv:ocultarDiv,
    getEmpleados:getEmpleados
  }
}

function mostrasDiv(clase){
        ocultarDiv();
        $("."+clase).addClass("animate__animated animate__backInUp");
	    $("."+clase).css("visibility", "visible");

}

function ocultarDiv(){
    $(".calendarioCita").css("visibility", "hidden");
    $(".cita").css("visibility", "hidden");
    $(".reporte").css("visibility", "hidden");
    $(".servicios").css("visibility", "hidden");
    $(".usuariosEdit").css("visibility", "hidden");
    $(".usuariosCont").css("visibility", "hidden");

    /***
     * Removiendo la animacion
     */

    $(".calendarioCita").removeClass("animate__animated animate__backInUp");
    $(".cita").removeClass("animate__animated animate__backInUp");
    $(".reporte").removeClass("animate__animated animate__backInUp");
    $(".servicios").removeClass("animate__animated animate__backInUp");
    $(".usuariosEdit").removeClass("animate__animated animate__backInUp");
    $(".usuariosCont").removeClass("animate__animated animate__backInUp");

}

function getEmpleados(){

    $.post("./Clases/obtenerempleados.php",{
      "null":null
    },
      function (data,status) {
        const empleados = JSON.parse(data);
            
          for (let index = 0; index < empleados.length; index++) {
                $("#empleados1").append("<option value='"+empleados[index].id+"'>"+empleados[index].nombre+"</option>");
              }
        
      });
  
    };
