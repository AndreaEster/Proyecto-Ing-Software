
/**
 * Author Ramon Rivera
 * @returns JSON con las instacias de las funciones
 */

var AdminPanel = function () {
  return {
    mostrasDiv: mostrasDiv,
    ocultarDiv: ocultarDiv,
    getEmpleados: getEmpleados,
    getProductos: getProductos
  }
}

function mostrasDiv(clase) {
  ocultarDiv();
  $("." + clase).addClass("animate__animated animate__backInUp");
  $("." + clase).css("visibility", "visible");

}

function ocultarDiv() {
  $(".calendarioCita").css("visibility", "hidden");
  $(".cita").css("visibility", "hidden");
  $(".reporte").css("visibility", "hidden");
  $(".reporteCont").css("visibility", "hidden");
  $(".reporteEdit").css("visibility", "hidden");
  $(".servicios").css("visibility", "hidden");
  $(".servicioCont").css("visibility", "hidden");
  $(".servicioEdit").css("visibility", "hidden");
  $(".usuariosEdit").css("visibility", "hidden");
  $(".usuariosCont").css("visibility", "hidden");

  /***
   * Removiendo la animacion
   */

  $(".calendarioCita").removeClass("animate__animated animate__backInUp");
  $(".cita").removeClass("animate__animated animate__backInUp");
  $(".reporte").removeClass("animate__animated animate__backInUp");
  $(".reporteCont").removeClass("animate__animated animate__backInUp");
  $(".reporteEdit").removeClass("animate__animated animate__backInUp");
  $(".servicios").removeClass("animate__animated animate__backInUp");
  $(".servicioEdit").removeClass("animate__animated animate__backInUp");
  $(".servicioCont").removeClass("animate__animated animate__backInUp");
  $(".usuariosEdit").removeClass("animate__animated animate__backInUp");
  $(".usuariosCont").removeClass("animate__animated animate__backInUp");

}

function getEmpleados() {

  $.post("./Clases/obtenerempleados.php", {
    "null": null
  },
    function (data, status) {
      const empleados = JSON.parse(data);

      for (let index = 0; index < empleados.length; index++) {
        $("#empleados1").append("<option value='" + empleados[index].id + "'>" + empleados[index].nombre + "</option>");
      }

    });

};

function getProductos() {


  $.post("./Clases/obtenerproductos.php", {
    "null": null
  },
    function (data, status) {
      const productos = JSON.parse(data);

      for (let index = 0; index < productos.length; index++) {
        $('#productos1').append("<option value='" + productos[index].id + "'>" + productos[index].nombre + "</option>");
      }

    });

};