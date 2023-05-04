
var Panel = function() {
  return{
    getCarousel:getCarousel,
    getEmpleados:getEmpleados,
    getHorario:getHorario,
    getServicios:getServicios,
    setCita:setCita,
    agregarCita:agregarCita
  }
  
}
  /**
   * author Ramon Rivera
   * Esta funcion llama las imagenes desde la base de datos para cargarlas en el carrusel
   */
function getCarousel(){

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
function getEmpleados() {

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

function  getHorario(idEmpleado){
      
    $("#horarios01").html("<option value='' disabled selected>Selecione un Horario</option>");

  $.post("./Clases/obtenerhorario.php",{
    "id":idEmpleado
  },
    function (data,status) {
      const horarios = JSON.parse(data);
          
        for (let index = 0; index < horarios.length; index++) {
              $("#horarios01").append("<option value='"+horarios[index].id+"'>"+horarios[index].dia_semana+" Hora de inicio:"+horarios[index].hora_inicio+" Hora final:"+horarios[index].hora_fin+"</option>");
            }
      
    });

  }

  
  /**
   * author Ramon Rivera
   * Devuelve los servicios registrados en la base de datos
   */
function  getServicios(){
      
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

function  setCita(){
    $.post("./Clases/validarCita.php", {
      id_horario:$("#horarios01").val()
    },
      function (data, status) {
        const result = JSON.parse(data);
        
        if (result[0].status=="true") {
          agregarCita(result[0].contador);
        }else{
          M.toast({ html: "Este empleado no puede atender mas citas :'(", classes: 'rounded', displayLength: 3000 });
        }
        
      }
    );
   
      
  }

function agregarCita(contador){
    $.post("./Clases/crearcita.php", {
      id_servicio:$("#servicios").val(),
      id_empleado:$("#empleados01").val(),
      nombre:$(".nombre").val(),
      telefono:$(".telefono").val(),
      dia:$("#horarios01").val(),
      fecha: "03-05-2023",
      comentario:$("#textarea2").val(),
      contador: contador
    },
      function (data, status) {
        const result = JSON.parse(data);
          M.toast({ html: result[0].mensaje, classes: 'rounded', displayLength: 3000 });
          $("#servicios").val("");
          $("#empleados01").val("");
          $(".nombre").val("");
          $(".telefono").val("");
          $("#horarios01").val("");
          $("#textarea2").val("");
        
      });
  }
