
/**
 * author Ramon Rivera
 * Esta funcion llama las imagenes desde la base de datos para cargarlas en el carrusel
 */
function carousel(){

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