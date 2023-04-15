<!DOCTYPE html>
<html>

<head>
  <!--Import Google Icon Font-->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <!--Import materialize.css-->
  <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection" />
  <link type="text/css" rel="stylesheet" href="css/adminStyle2.css" media="screen,projection" />
  <link type="text/css" rel="stylesheet" href="css/animate.min.css" media="screen,projection" />

  <!--Let browser know website is optimized for mobile-->
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>

<body>

  <nav>
    <div class="nav-wrapper blue-grey z-depth-5">
      <a href="#" class="brand-logo right">
        <div class="chip">
          <img src="Assets/MUJERES/alisado y permanente/(2).jpg" alt="Contact Person">
          Generic Person
        </div>
      </a>
      <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
      <ul class="left  hide-on-med-and-down">
        <li><a href="#"><i class="material-icons left">home</i>Home</a></li>
        <li><a href="#"><i class="material-icons left">dehaze</i>Content</a></li>
        <li><a href="#"><i class="material-icons left">settings</i>Settings</a></li>
      </ul>
    </div>
  </nav>

  <!--viasta de menu mobil-->
  <ul class="sidenav" id="mobile-demo">
    <li><a href="#"><i class="material-icons left">home</i>Home</a></li>
    <li><a href="#"><i class="material-icons left">dehaze</i>Content</a></li>
    <li><a href="#"><i class="material-icons left">settings</i>Settings</a></li>
  </ul>


  <div class="row contenedor">
    <div class="row col s2 menu blue-grey z-depth-5">
      <br>
      <div class="row col s3">
        <img src="Assets/logo.jpeg" class="circle responsive-img">
      </div>
      <br>
      <div class="col s8">
        <span class="white-text">
          SMART SALON
        </span>
      </div>
      <!--Contenido del menu lateral-->

      <div class="row col s12 center">
        <a class="waves-effect waves-light btn white black-text"><i
            class="material-icons left">add_circle_outline</i>Inicicio</a>
      </div>
      <div class="itemsMenu col s12">
        <ul class="collapsible z-depth-5">
          <li>
            <div class="collapsible-header">
              <i class="material-icons">perm_contact_calendar
              </i>
              Agendar cita
              <span class="badge"><i class="material-icons deep-purple-text" style="font-size: 30px;">archive</i></span>
            </div>
            <div class="collapsible-body white">
              <div class="collection">
                <a href="#!" class="collection-item black-text" onclick="mostrasDiv('calendarioCita');"><span
                    class="badge"><i class="material-icons deep-purple-text"
                      style="font-size: 30px;">chevron_right</i></span>Calendario</a>
                <a href="#!" class="collection-item black-text" onclick="mostrasDiv('cita');"><span class="badge"><i
                      class="material-icons deep-purple-text" style="font-size: 30px;">chevron_right</i></span>Cita</a>
              </div>
            </div>
          </li>
          <li>
            <div class="collapsible-header">
              <i class="material-icons">business_center</i>
              Inventario
              <span class="badge"><i class="material-icons deep-purple-text" style="font-size: 30px;">archive</i></span>
            </div>
            <div class="collapsible-body white">
              <div class="collection">
                <a href="#!" class="collection-item black-text"
                  onclick="mostrasDiv('reporte');con.cargarInventario();"><span class="badge"><i
                      class="material-icons deep-purple-text"
                      style="font-size: 30px;">chevron_right</i></span>Productos</a>
                <a href="#!" class="collection-item black-text"
                  onclick="mostrasDiv('servicios');con.cargarServicios();"><span class="badge"><i
                      class="material-icons deep-purple-text"
                      style="font-size: 30px;">chevron_right</i></span>Servicios</a>
              </div>
            </div>
          </li>
          <li>
            <div class="collapsible-header">
              <i class="material-icons">group</i>
              Usuarios
              <span class="badge"><i class="material-icons deep-purple-text" style="font-size: 30px;">archive</i></span>
            </div>
            <div class="collapsible-body white">
              <div class="collection">
                <a href="#!" class="collection-item black-text"
                  onclick="mostrasDiv('usuariosEdit');con.cargarUsuarios();"><span class="badge"><i
                      class="material-icons deep-purple-text"
                      style="font-size: 30px;">chevron_right</i></span>Registrar/Editar</a>
                <a href="#!" class="collection-item black-text" onclick="mostrasDiv('usuariosCont');"><span
                    class="badge"><i class="material-icons deep-purple-text"
                      style="font-size: 30px;">chevron_right</i></span>Cambiar contrasena</a>
              </div>
            </div>
          </li>
          <li>
            <div class="collapsible-header">
              <i class="material-icons">settings_applications</i>
              Reportes
              <span class="badge"><i class="material-icons deep-purple-text" style="font-size: 30px;">archive</i></span>
            </div>
            <div class="collapsible-body white center"><b><i class="material-icons deep-purple-text"
                  style="font-size: 30px;">security</i>
                <p>Soon...</p>
              </b></div>
          </li>
        </ul>
      </div>

    </div>


    <!--Contenido de la pagina administrativa-->

    <div class="col s10 contenido">

      <br>

      <!--Calendario citas-->
      <div class="col s8 calendarioCita z-depth-5">
        <div class="col s6">
          <form>
            <div class="row col s12">
              <div class="row col s12 black-text">
                <h3>Fecha</h3>
                <input type="text" class="datepicker"><label>Chose</label></input>
                <a class="waves-effect waves-light btn right blue">Buscar</a>
              </div>
              <div class="row col s12">
                <div class="input-field col s12">
                  <i class="material-icons prefix">access_time</i>
                  <input id="icon_prefix" type="text" class="validate" value="5">
                  <label for="icon_prefix">Citas hoy</label>
                </div>
              </div>

              <div class="row col s12">
                <div class="input-field col s12">
                  <i class="material-icons prefix">access_alarm</i>
                  <input id="icon_prefix" type="text" class="validate" value="5">
                  <label for="icon_prefix">Citas pendientes</label>
                </div>
              </div>
              <div class="row">
                <a class="btn-floating btn-large waves-effect waves-light red" onclick="ocultarDiv();"><i
                    class="material-icons">close</i></a>
              </div>

            </div>
          </form>
        </div>


        <div class="col s4 CalendarioGen right">
          <br><br>
          <div class="calendar">
            <div class="calendar__picture">
              <h2>12, Miercoles</h2>
              <h3>Abril</h3>
            </div>
            <div class="calendar__date">
              <div class="calendar__day">M</div>
              <div class="calendar__day">T</div>
              <div class="calendar__day">W</div>
              <div class="calendar__day">T</div>
              <div class="calendar__day">F</div>
              <div class="calendar__day">S</div>
              <div class="calendar__day">S</div>
              <div class="calendar__number"></div>
              <div class="calendar__number"></div>
              <div class="calendar__number"></div>
              <div class="calendar__number">1</div>
              <div class="calendar__number">2</div>
              <div class="calendar__number">3</div>
              <div class="calendar__number">4</div>
              <div class="calendar__number">5</div>
              <div class="calendar__number">6</div>
              <div class="calendar__number">7</div>
              <div class="calendar__number">8</div>
              <div class="calendar__number">9</div>
              <div class="calendar__number">10</div>
              <div class="calendar__number">11</div>
              <div class="calendar__number calendar__number--current">12</div>
              <div class="calendar__number">13</div>
              <div class="calendar__number">14</div>
              <div class="calendar__number">15</div>
              <div class="calendar__number">16</div>
              <div class="calendar__number">17</div>
              <div class="calendar__number">18</div>
              <div class="calendar__number">19</div>
              <div class="calendar__number">20</div>
              <div class="calendar__number">21</div>
              <div class="calendar__number">22</div>
              <div class="calendar__number">23</div>
              <div class="calendar__number">24</div>
              <div class="calendar__number">25</div>
              <div class="calendar__number">26</div>
              <div class="calendar__number">27</div>
              <div class="calendar__number">28</div>
              <div class="calendar__number">29</div>
              <div class="calendar__number">30</div>
            </div>
          </div>
        </div>
      </div>

      <!--Citas citas-->
      <div class="col s8 cita z-depth-5">
        <div class="col s6">
          <h3>Cita</h3>
          <form>
            <div class="row">
              <div class="input-field col s12">
                <input id="first_name" type="text" class="validate">
                <label for="first_name">Nombre</label>
              </div>
            </div>
            <div class="row">
              <label>Servicio</label>
              <select class="browser-default">
                <option value="" disabled selected>Seleccione una opcion</option>
                <option value="1">Option 1</option>
                <option value="2">Option 2</option>
                <option value="3">Option 3</option>
              </select>
            </div>
            <div class="row">
              <div class="input-field col s6">
                <input id="fecha" type="text" class="datepicker" value="Seleccione una fecha">
                <label for="fecha"></label>
              </div>
              <div class="input-field col s6">
                <input id="hora" type="text" class="validate">
                <label for="hora">Hora</label>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <textarea id="textarea1" class="materialize-textarea"></textarea>
                  <label for="textarea1">Comentarios</label>
                </div>
              </div>
            </div>
          </form>
          <div class="row">
            <a class="btn-floating btn-large waves-effect waves-light red" onclick="ocultarDiv();"><i
                class="material-icons">close</i></a>
          </div>
        </div>

        <div class="col s4 right">
          <h3>Buscar cita</h3>
          <form>
            <div class="row">
              <div class="input-field col s12">
                <input id="first_name2" type="text" class="validate">
                <label for="first_name2">Nombre</label>
              </div>
            </div>
            <div class="row">
              <label>Estado</label>
              <select class="browser-default">
                <option value="" disabled selected>Seleccione una opcion</option>
                <option value="1">Aprobar</option>
                <option value="2">Cancelar</option>
              </select>
            </div>
            <div class="row">
              <div class="input-field col s12">
                <textarea id="textarea2" class="materialize-textarea"></textarea>
                <label for="textarea2">Comentarios</label>
              </div>
            </div>
            <div class="row">
              <div class="col s12">
                <a class="waves-effect waves-light btn blue">Buscar</a>
              </div>
            </div>
          </form>
        </div>
      </div>




      <!--Reportes-->
      <div class="col s9 reporte z-depth-5">
        <div class="col s12">
          <h3>Registro de ventas</h3>
          <form>
            <div class="row">
              <div class="input-field col s2">
                <h6>Fecha del:</h6>
              </div>
              <div class="input-field col s3">
                <input id="fecha" type="text" class="datepicker" value="fecha">
              </div>
              <div class="input-field col s2">
                <h6>Al:</h6>
              </div>
              <div class="input-field col s3">
                <input id="fecha" type="text" class="datepicker" value="fecha">
              </div>
              <br>
              <div class="col s2">
                <a class="waves-effect waves-light btn blue">Buscar</a>
              </div>
            </div>
            <div class="row">
              <div class="col s12">
                <table>
                  <thead>
                    <tr>
                      <th>Producto</th>
                      <th>Cantidad</th>
                      <th>Precio(unitario)</th>
                      <th>Descripcion</th>
                    </tr>
                  </thead>

                  <tbody id="tablaInventario">

                  </tbody>
                </table>
              </div>
            </div>
          </form>
          <div class="row">
            <a class="btn-floating btn-large waves-effect waves-light red" onclick="ocultarDiv();"><i
                class="material-icons">close</i></a>
          </div>
        </div>
        </form>
      </div>


      <!---Servicios-->
      <div class="col s9 servicios z-depth-5">
        <div class="col s12">
          <h3>Servicios</h3>
          <form>
            <div class="row">
              <div class="col s12">
                <table>
                  <thead>
                    <tr>
                      <th>Servicio</th>
                      <th>Precio</th>
                    </tr>
                  </thead>

                  <tbody id="tablaServicios">

                  </tbody>
                </table>
              </div>
            </div>
          </form>
          <div class="row">
            <a class="btn-floating btn-large waves-effect waves-light red" onclick="ocultarDiv();"><i
                class="material-icons">close</i></a>
          </div>
        </div>
        </form>
      </div>




      <!--Usuarios modificar-->
      <div class="col s6 usuariosEdit z-depth-5">
        <div class="col s12">
          <h3>Registrar modificar</h3>
          <br>
          <h4><b>Nuevo usuario</b></h4>
          <form>
            <div class="row">
              <div class="input-field col s6">
                <input id="first_name3" type="text" class="validate" value="Nombre de usuario">
                <label for="first_name3">Nombre</label>
              </div>
              <div class="input-field col s6">
                <input id="first_name9" type="text" class="validate" disabled="true">
                <label for="first_name9"></label>
              </div>
            </div>
            <div class="row">
              <div class="col s12">
                <h6>Tipo de usuario</h6>
              </div>
            </div>
            <div class="row">
              <div class="col s12">
                <select class="browser-default" id="selecUsuario">
                  <option value="" disabled selected>Seleccione una opcion</option>
                  <option value="administrador">Administrador</option>
                  <option value="contador">Contador</option>
                  <option value="usuario">Usuario</option>
                </select>
              </div>
            </div>
            <div class="row">
              <div class="input-field col s6">
                <input id="first_name4" type="text" class="validate">
                <label for="first_name4">Usuario</label>
              </div>
              <div class="input-field col s6">
                <input id="first_name5" type="password" class="validate">
                <label for="first_name5">Contrasena</label>
              </div>
            </div>
            <div class="row">
              <a class="waves-effect waves-light btn left blue" onclick="con.actualizarUsuario();">Guardar</a>
            </div>




            <div class="row">
              <div class="col s12">





                <table>
                  <thead>
                    <tr>
                      <th>Usuario</th>
                      <th>Nombre</th>
                      <th>Tipo de usuario</th>
                      <th>Modificar</th>
                      <th>Borar</th>
                    </tr>
                  </thead>

                  <tbody id="tablaUsuarios">

                  </tbody>
                </table>





              </div>
            </div>
          </form>
          <div class="row">
            <a class="btn-floating btn-large waves-effect waves-light red" onclick="ocultarDiv();"><i
                class="material-icons">close</i></a>
          </div>
        </div>
        </form>
      </div>


      <!--Usuarios Cambiar contraseña-->
      <div class="col s6 usuariosCont z-depth-5">
        <div class="col s12">
          <h3>Modificar contrasena</h3>
          <br>
          <h4><b>Nueva contrasena</b></h4>
          <form>
            <div class="row">
              <div class="input-field col s6">
                <input id="first_name3" type="text" class="validate">
                <label for="first_name3">Usuario</label>
              </div>
            </div>
            <div class="row">
              <div class="input-field col s6">
                <input id="first_name6" type="password" class="validate">
                <label for="first_name6">Nueva Contrasena</label>
              </div>
              <div class="input-field col s6">
                <input id="first_name7" type="password" class="validate">
                <label for="first_name7">Confirmar Contrasena</label>
              </div>
            </div>
            <div class="row">
              <a class="waves-effect waves-light btn left blue">Guardar</a>
            </div>
          </form>
          <div class="row">
            <a class="btn-floating btn-large waves-effect waves-light red" onclick="ocultarDiv();"><i
                class="material-icons">close</i></a>
          </div>
        </div>
        </form>
      </div>









    </div>
  </div>







  </div>
  </div>


  <!--JavaScript at end of body for optimized loading-->
  <script type="text/javascript" src="js/materialize.min.js"></script>
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script type="text/javascript">
    M.AutoInit();

  </script>
  <script src="js/adminPanel2.js"></script>
  <script src="js/conexion.js"></script>
  <script>
    var con = new conexion();



  </script>
</body>

</html>