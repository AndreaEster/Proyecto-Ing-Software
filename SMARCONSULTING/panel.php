<!DOCTYPE html>
<html lang="en">

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>SMART CONSULTING SALON</title>

  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection" />
  <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection" />
  <link rel="stylesheet" href="css/main.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
<?php
session_start();

  if (!isset($_SESSION['usuarioNombre'])) {
    header( 'Location: login.html' );
}else{
  
  if ($_SESSION['estado']==false && $_SESSION['rol']=="administrador") {
    header( 'Location: login.html' );
  }
}
?>
  <nav>
    <div class="nav-wrapper brown lighten-3">
    <a href="#" class="brand-logo">CONSULTING SALON</a>
    <ul class="right  hide-on-med-and-down">
      <li><a href="./Clases/admin/logout.php" class="white-text"><i class="material-icons left">close</i>Cerar sesion</a></li>
    </ul>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        <li>
          <nav>
            <div class="nav-wrapper brown lighten-3">
              <form>
                <div class="input-field">
                  <input id="search" type="search" required>
                  <label class="label-icon" for="search"><i class="material-icons">search</i></label>
                  <i class="material-icons">close</i>
                </div>
              </form>
            </div>
          </nav>
        </li>
        <li><a class="waves-effect waves-light btn modal-trigger brown darken-1" href="#modal1">Haz tu cita aqui!</a>
        <div class="chip rigth">
          <img src=<?php if ($_SESSION['urlIMG']==" ") {
            print_r("'".$_SESSION['urlIMG']."'");
          }else{print_r("'./Assets/usersIMG/default.jpg'");}?> alt="Contact Person">
          <?php print_r($_SESSION['usuarioNombre']." ".$_SESSION["rol"]);?>
        </div>
        </li>
      </ul>
    </div>
  </nav>




  <div id="modal1" class="modal">
    <div class="modal-content">
      <h4>Reservaciones</h4>
      <div class="row">
        <form class="col s12">
          <div class="row">
            <div class="input-field col s6">
              <i class="material-icons prefix">account_circle</i>
              <input id="icon_prefix" type="text" class="validate nombre">
              <label for="icon_prefix">Nombre Y Apellidos</label>
            </div>
            <div class="input-field col s6">
              <i class="material-icons prefix">phone</i>
              <input id="icon_telephone" type="tel" class="validate telefono">
              <label for="icon_telephone">Telefono</label>
            </div>
            <div class="row">
              <div class="input-field col s12">
                <input id="email" type="email" class="validate email">
                <label for="email">Email</label>
              </div>
            </div>
            <div class="row">
              <div class="input-field col s12">
                <textarea id="textarea2" class="materialize-textarea" data-length="120"></textarea>
                <label for="textarea2">Comentarios</label>
              </div>
            </div>
            <div class="row">
              <label>Empleados</label>
              <select class="browser-default" id="empleados01">
                <option value="" disabled selected>Selecione un empleado</option>
              </select>
            </div>
            <div class="row">
              <label>Horarios</label>
              <select class="browser-default" id="horarios01">
                <option value="" disabled selected>Selecione un Horario</option>
              </select>
            </div>
            <div class="row">
              <label>Servicios</label>
              <select class="browser-default" id="servicios">
                <option value="" disabled selected>Selecione un Servicio</option>
              </select>
            </div>
            <div class="row">
              <label>Duracion</label>
              <p class="range-field">
                <input type="range" id="test5" min="0" max="100" class="duracion"/>
              </p>
            </div>
            
            <div class="row">
              <div class="input-field col s12">
                <input id="birthdate" type="text" class="datepicker fecha">
                <label for="birthdate">Fecha</label>
              </div>
            </div>
          </div>
        </form>
      </div>



    </div>
    <div class="modal-footer">
      <!--
       class modal-close
      -->
      <a class="modal-close btn-floating btn-large waves-effect waves-light red left"><i
          class="material-icons">close</i></a>
      <button class=" btn waves-effect waves-light" type="submit" name="action" onclick="panel.setCita();">Enviar
        <i class="material-icons right">send</i>
      </button>
    </div>



  </div>



  <div id="index-banner" class="parallax-container">

    <div class="section no-pad-bot">
      <div class="container">
        <div class="row center">


          <div class="carousel" id="carrusel01">



          </div>
        </div>
      </div>
    </div>
    <div class="parallax"><img src="fondo1.jpg" alt="Unsplashed background img 1"></div>
  </div>
  <div class="container">
    <div class="section">

      <!--   Icon Section   -->
      <div class="row">
        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center brown-text"><i class="material-icons">face</i></h2>
            <h5 class="center">Secado y planchado</h5>

            <p class="light">Protege tu cabello de las herramientas de calor y aprende a secar y planchar tu cabello
              como toda una profesional con nuestras técnicas.</p>
          </div>
        </div>

        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center brown-text"><i class="material-icons">airline_seat_flat_angled</i></h2>
            <h5 class="center">Tratamientos Faciales</h5>

            <p class="light">Hacemos que tus cejas se pongan en forma, sin hacer ejercicio. Una mujer solo es débil
              cuando tiene sus uñas recién pintadas. No subestimes el poder de un pintalabios rojo y de unas cejas
              perfectas.Nunca digas nunca a este color de esmalte.</p>
          </div>
        </div>

        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center brown-text"><i class="material-icons">content_cut</i></h2>
            <h5 class="center">Cortes de cabello para Hombres y Mujeres</h5>

            <p class="light">No pienses en las reglas, si te gusta ¡Hazlo! La vida es muy corta, pero tu cabello todavía
              tiene mucho que experimentar. ¿Qué te gustaría hacer si no tuvieras miedo? ¡Nada mejora tu estado de ánimo
              como un buen masaje! Tu color está de moda.</p>
          </div>
        </div>
      </div>

    </div>
  </div>


  <div class="parallax-container valign-wrapper">
    <div class="section no-pad-bot">
      <div class="container">
        <div class="row center">
          <h1 class="header col s12 light light-blue-text text-darken-2">Tu salon de belleza moderno y a la moda serca
            de ti!</h1>
        </div>
      </div>
    </div>
    <div class="parallax"><img src="fondo2.jpg" alt="Unsplashed background img 2"></div>
  </div>

  <div class="container">
    <div class="section">

      <div class="row">
        <div class="col s12 center">
          <h3><i class="mdi-content-send brown-text"></i></h3>
          <h4>Contactanos</h4>
          <ul class="ulredes">
            <a href="https://www.facebook.com/Sal%C3%B3n-Gen%C3%A9rico-N28-117332477950345">
              <li class="liredes" style="--i:#a955ff;--j:#ea51ff;">
                <span class="icon spanredes"><i class="fa fa-facebook iredes"></i></span>
                <span class="titulo spanredes">facebook</span>
              </li>
            </a>
            <li class="liredes" style="--i:#56CCF2;--j:#2F80ED;">
              <span class="icon spanredes"><i class="fa fa-twitter iredes"></i></span>
              <span class="titulo spanredes">twitter</span>
            </li>
            <li class="liredes" style="--i:#86be6b;--j:#1baf16;">
              <span class="icon spanredes"><i class="fa fa-whatsapp iredes"></i></span>
              <span class="titulo spanredes">whatsapp</span>
            </li>
            <li class="liredes" style="--i:#80FF72;--j:#5ec3d4;">
              <span class="icon spanredes"><i class="fa fa-linkedin iredes"></i></span>
              <span class="titulo spanredes">linkedin</span>
            </li>
            <li class="liredes" style="--i:#FFA9C6;--j:#F434E2;">
              <span class="icon spanredes"><i class="fa fa-instagram iredes"></i></span>
              <span class="titulo spanredes">instagram</span>
            </li>
          </ul>
        </div>
      </div>

    </div>
  </div>


  <div class="parallax-container valign-wrapper">
    <div class="section no-pad-bot">
      <div class="container">
        <div class="row center">
          <h5 class="header col s12 light">Amplios espacios y equipamiento de ultima generacion</h5>
        </div>
      </div>
    </div>
    <div class="parallax"><img src="fondo3.jpg" alt="Unsplashed background img 3"></div>
  </div>

  <footer class="page-footer teal">
    <div class="container">
      <div class="row">
        <div class="col l6 s12">
          <h5 class="white-text">Biografia de CONSULTING SALON</h5>
          <p class="grey-text text-lighten-4">Una empresa de asesoria que empezo como algo familiar para hoy ser una realidad</p>


        </div>
        <div class="col l3 s12">
          <h5 class="white-text">Satisfaccion</h5>

        </div>
        <div class="col l3 s12">
          <h5 class="white-text">Calidad</h5>

        </div>
      </div>
    </div>
    <div class="footer-copyright">
      <div class="container">
      </div>
    </div>
  </footer>


  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="js/materialize.js"></script>
  <script src="js/init.js"></script>
  <script src="js/panel.js"></script>
  <script src="js/obtenerempleados.js"></script>
  <script type="text/javascript">
    panel = new panel();
    $(document).ready(function () {
      panel.getEmpleados();
      panel.getCarousel();
      panel.getServicios();
    });

    $('#empleados01').change(e => panel.getHorario(e.target.value));

  </script>

</body>

<script>
  document.addEventListener('DOMContentLoaded', function () {
    var elems = document.querySelectorAll('select');
    var instances = M.FormSelect.init(elems);
  });

  // Or with jQuery

  $(document).ready(function () {
    $('select').formSelect();
  });
</script>

<script>
  document.addEventListener('DOMContentLoaded', function () {
    var elems = document.querySelectorAll('.modal');
    var instances = M.Modal.init(elems);
  });

  // Or with jQuery

  $(document).ready(function () {
    $('.modal').modal();
  });
</script>
<script>

  document.addEventListener('DOMContentLoaded', function () {
    var elems = document.querySelectorAll('.datepicker');
    var instances = M.Datepicker.init(elems);
  });

  // Or with jQuery

  $(document).ready(function () {
    $('.datepicker').datepicker();
  });

</script>

</html>