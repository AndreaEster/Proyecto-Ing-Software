
class panel{
    panel(){

    }

  /**
   * author Ramon Rivera
   * Esta funcion llama las imagenes desde la base de datos para cargarlas en el carrusel
   */
  getCarousel(){

    $.post("./Clases/carousel.php",
    {
      usuario: "usuario",
      password: "contrasena"
    },
    function(data,status){
        
      const user = JSON.parse(data);
      
      for (let index = 0; index < user.length; index++) {
        $("#carrusel01").append("<a class='carousel-item' href='#"+index+"''><img src="+user[index].url+"></a>"); 
      }

      /**
       * 
       * Aca se llama al carousel de materializecss para inicializarlo
       *  */    
      $(document).ready(function(){
        $('.carousel').carousel();
        setInterval(function(){
          $('.carousel').carousel('next');
        },2000);
      });


  });
  }

  /***
   * Author Ramon Rivera
   * 
   * Funcion para obtener los nombres y los codigos de los empleados
   * rrellena los campos de empleado
   * no recibe parametros
   */
  getEmpleados() {

  $.post("./Clases/obtenerempleados.php",{
    "null":null
  },
    function (data,status) {
      const empleados = JSON.parse(data);
          
        for (let index = 0; index < empleados.length; index++) {
              $("#empleados01").append("<option value='"+empleados[index].id+"'>"+empleados[index].nombre+"</option>");
            }
      
    });

  }

  /**
   * author Ramon Rivera
   * Devuelve los horarios de los empleados segun su id
   * recibe el id segun el selector de empleados
   * @param {*} idEmpleado 
   */

  getHorario(idEmpleado){
      
    $("#horarios01").html("<option value='' disabled selected>Selecione un Horario</option>");

  $.post("./Clases/obtenerhorario.php",{
    "id":idEmpleado
  },
    function (data,status) {
      const horarios = JSON.parse(data);
          
        for (let index = 0; index < horarios.length; index++) {
              $("#horarios01").append("<option value='"+horarios[index].hora_inicio+"'>"+horarios[index].dia_semana+" Hora de inicio:"+horarios[index].hora_inicio+" Hora final:"+horarios[index].hora_fin+"</option>");
            }
      
    });

  }

  
  /**
   * author Ramon Rivera
   * Devuelve los servicios registrados en la base de datos
   */
  getServicios(){
      
    $("#servicios").html("<option value='' disabled selected>Selecione un Servicio</option>");

  $.post("./Clases/obtenerServicios.php",{
    "id":"1"
  },
    function (data,status) {
      const servicios = JSON.parse(data);
          
        for (let index = 0; index < servicios.length; index++) {
              $("#servicios").append("<option value='"+servicios[index].id+"'>"+servicios[index].nombre+" Precio:"+servicios[index].precio+" Lps</option>");
            }
      
    });

  }

  /**
   * author Ramon Rivera
   * Registra la cita en la base de datos
   * no recibe parametros
   */

  setCita(){

    $.post("./Clases/crearcita.php", {
      id_usuario:"1",
      id_servicio:$("#servicios").val(),
      nombre:$(".nombre").val(),
      email:$(".email").val(),
      telefono:$(".telefono").val(),
      fecha: $(".fecha").val(),
      hora:$("#horarios01").val(),
      duracion:$(".duracion").val(),
      estado:"1",
      comentario:$("#textarea2").val()
    },
      function (data, status) {
        const mensaje = JSON.parse(data);
        alert(mensaje.mensaje);
        
      });
      
  }

}