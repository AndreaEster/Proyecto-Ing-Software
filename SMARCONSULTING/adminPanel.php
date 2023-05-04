<!DOCTYPE html>
<html lang="es">
<head>
  <!--Import Google Icon Font-->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <!--Import materialize.css-->
  <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection" />
  <link type="text/css" rel="stylesheet" href="css/adminStyle3.css" media="screen,projection" />
  <link type="text/css" rel="stylesheet" href="css/animate.min.css" media="screen,projection" />
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.min.css">
  <style type="text/css" class="init"></style>

  <script type="text/javascript" language="javascript" src="js/jquery.dataTables.min.js"></script>
  <script type="text/javascript" language="javascript" class="init">
    /**
     * Se cargan la tabla de Inventario
     */

    $(document).ready(function () {

      con.cargarInventario();

      setTimeout(() => {
        $('#tableInvent').DataTable({

        });
        $('select').addClass("browser-default");
      }, 100);
    });

    $(document).ready(function () {

      con.cargarUsuarios();

      setTimeout(() => {
        $('#tableUsuarios').DataTable({

        });
        $('select').addClass("browser-default");
      }, 100);
    });

    $(document).ready(function () {

      con.cargarServicios();

      setTimeout(() => {
        $('#tableServicio').DataTable({

        });
        $('select').addClass("browser-default");
      }, 100);
    });

    $(document).ready(function () {

      con.cargarCitas();

      setTimeout(() => {
        $('#tableCita').DataTable({

        });
        $('select').addClass("browser-default");
      }, 100);
    });

    $(document).ready(function () {

      con.cargarEmpleados();

      setTimeout(() => {
        $('#tableEmpleados').DataTable({

        });
        $('select').addClass("browser-default");
      }, 100);
    });
  </script>
  <!--Let browser know website is optimized for mobile-->
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>

<body>

  <?php
  session_start();

  if (!isset($_SESSION['usuarioNombre'])) {
    header('Location: login.html');
  } 
  ?>



  <nav>
    <div class="nav-wrapper blue-grey z-depth-5">
      <a href="#" class="brand-logo right">
        <div class="chip">
          <img src=<?php if ($_SESSION['urlIMG'] == " ") {
            print_r("'./Assets/usersIMG/default.jpg'");
          } else {
            print_r("'" . $_SESSION['urlIMG'] . "'");
          } ?> alt="Contact Person">
          <?php print_r($_SESSION['usuarioNombre'] . " " . $_SESSION["rol"]); ?>
        </div>
      </a>
      <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
      <ul class="left  hide-on-med-and-down">
        <li><a href="#"><i class="material-icons left">home</i>Home</a></li>
        <li><a href="#"><i class="material-icons left">dehaze</i>Content</a></li>
        <li><a href="#"><i class="material-icons left">settings</i>Settings</a></li>
        <li><a href="./Clases/admin/logout.php"><i class="material-icons left">close</i>Cerrar sesion</a></li>
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
            class="material-icons left">add_circle_outline</i>Inicio</a>
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
                <a href="#!" class="collection-item black-text" onclick="apanel.mostrasDiv('calendarioCita');apanel.getDate();"><span
                    class="badge"><i class="material-icons deep-purple-text"
                      style="font-size: 30px;">chevron_right</i></span>Facturar</a>
                <a href="#!" class="collection-item black-text"
                  onclick="apanel.mostrasDiv('cita');con.cargarCitas();"><span class="badge"><i
                      class="material-icons deep-purple-text" style="font-size: 30px;">chevron_right</i></span>Cita</a>
              </div>
            </div>
          </li>
          <?php if ($_SESSION["rol"] == "administrador" || $_SESSION["rol"] == "contador"): ?>
            <li>
              <div class="collapsible-header">
                <i class="material-icons">business_center</i>
                Inventario
                <span class="badge"><i class="material-icons deep-purple-text" style="font-size: 30px;">archive</i></span>
              </div>
              <div class="collapsible-body white">
                <div class="collection">
                  <a href="#!" class="collection-item black-text" onclick="apanel.mostrasDiv('reporteCont');"><span
                      class="badge"><i class="material-icons deep-purple-text"
                        style="font-size: 30px;">chevron_right</i></span>Agregar
                    Productos</a>
                  <a href="#!" class="collection-item black-text"
                    onclick="apanel.mostrasDiv('reporte');con.cargarInventario();"><span class="badge"><i
                        class="material-icons deep-purple-text" style="font-size: 30px;">chevron_right</i></span>Lista de
                    Productos</a>
                  <a href="#!" class="collection-item black-text" onclick="apanel.mostrasDiv('servicioCont');"><span
                      class="badge"><i class="material-icons deep-purple-text"
                        style="font-size: 30px;">chevron_right</i></span>Agregar
                    Servicios</a>
                  <a href="#!" class="collection-item black-text"
                    onclick="apanel.mostrasDiv('servicios');con.cargarServicios();"><span class="badge"><i
                        class="material-icons deep-purple-text" style="font-size: 30px;">chevron_right</i></span>Servicios
                    Disponibles</a>
                </div>
              </div>
            </li>
          <?php endif; ?>
          <?php if ($_SESSION["rol"] == "administrador"): ?>
            <li>
              <div class="collapsible-header">
                <i class="material-icons">group</i>
                Usuarios
                <span class="badge"><i class="material-icons deep-purple-text" style="font-size: 30px;">archive</i></span>
              </div>
              <div class="collapsible-body white">
                <div class="collection">
                  <a href="#!" class="collection-item black-text"
                    onclick="apanel.mostrasDiv('empleadoEdit');con.cargarEmpleados();"><span class="badge"><i
                        class="material-icons deep-purple-text"
                        style="font-size: 30px;">chevron_right</i></span>Eliminar/Editar Empleados</a>
                  <a href="#!" class="collection-item black-text" onclick="apanel.mostrasDiv('empleadoCont');"><span
                      class="badge"><i class="material-icons deep-purple-text"
                        style="font-size: 30px;">chevron_right</i></span>Agregar Empleado</a>
                  <a href="#!" class="collection-item black-text"
                    onclick="apanel.mostrasDiv('usuariosEdit');con.cargarUsuarios();"><span class="badge"><i
                        class="material-icons deep-purple-text"
                        style="font-size: 30px;">chevron_right</i></span>Eliminar/Editar Usuario</a>
                  <a href="#!" class="collection-item black-text" onclick="apanel.mostrasDiv('usuariosCont');"><span
                      class="badge"><i class="material-icons deep-purple-text"
                        style="font-size: 30px;">chevron_right</i></span>Agregar Usuarios</a>
                </div>
              </div>
            </li>
          <?php endif; ?>
          <?php if ($_SESSION["rol"] == "administrador" || $_SESSION["rol"] == "contador"): ?>
            <li>
              <div class="collapsible-header">
                <i class="material-icons">settings_applications</i>
                Reportes
                <span class="badge"><i class="material-icons deep-purple-text" style="font-size: 30px;">archive</i></span>
              </div>

              <div class="collapsible-body white center">
                <div class="collection">
                  <a href="#!" class="collection-item black-text left" onclick="apanel.mostrasDiv('reportes1');"><span
                      class="badge"><i class="material-icons deep-purple-text"
                        style="font-size: 30px;">chevron_right</i></span>Generar reporte</a>
                </div>
              </div>
            </li>
          <?php endif; ?>
        </ul>
      </div>

    </div>


    <!--Contenido de la pagina administrativa-->

    <div class="col s10 contenido">

      <br>

      <!--Calendario citas-->
      <div class="col s8 calendarioCita z-depth-5">
        <div class="row">
          <h1>Facturacion</h1>

          <div class="col s12">
            <div class="row">
              <div class="input-field col s6">
                <input id="numeroFactura" type="text" class="validate" disabled value="0000000-001-01-0001">
                <label for="numeroFactura">Numero de factura</label>
              </div>
            </div>
            <div class="row">
              <div class="input-field col s6">
                <input id="fechaEmision" type="text" class="validate" disabled value="03-05-2023">
                <label for="fechaEmision">Fecha de emison</label>
              </div>
            </div>
            <div class="row">
            <div class="input-field col s6">
                <input id="nombreClienteFac" type="text" class="validate">
                <label for="nombreClienteFac">Nombre del cliente</label>
              </div>
            </div>
            <div class="row">
            <div class="col s6">
            <label>Citas</label>
            <select class="browser-default">
              <option value="" disabled selected>Seleccione una cita</option>
              <option value="1">Option 1</option>
              <option value="2">Option 2</option>
              <option value="3">Option 3</option>
            </select>
            </div>
            </div>
            <div class="row">
              <div class="col s12">
                <table class="striped">
                      <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Descripcion</th>
                            <th>Cantidad</th>
                            <th>Precio unitario</th>
                            <th>Total</th>
                        </tr>
                      </thead>

                      <tbody>
                        <tr>
                          <td>1</td>
                          <td>secadora</td>
                          <td>para sercar pelo</td>
                          <td>1</td>
                          <td>50.00</td>
                          <td>50.00</td>
                        </tr>
                        <tr>
                        <td>2</td>
                          <td>Corte de pelo</td>
                          <td>n/a</td>
                          <td>1</td>
                          <td>500.00</td>
                          <td>50.00</td>
                        </tr>
                        
                      </tbody>
                    </table>
            


              </div>
            </div>
            <div class="row">
              <div class="col s6">
              <a class="waves-effect waves-light btn-large green darken-4"><i class="material-icons right">add_circle</i>Agregar producto</a>
              <a class="waves-effect waves-light btn-large green darken-4"><i class="material-icons right">add_circle</i>Agregar servicio</a>
              </div>
              <div class="col s6">
              <a class="waves-effect waves-light btn-large green darken-4 right"><i class="material-icons right">add_shopping_cart</i>Facturar</a>
              </div>
            </div>
            <div class="row col s12 left">
              <a class="btn-floating btn-large waves-effect waves-light red" onclick="apanel.ocultarDiv();"><i
                  class="material-icons">close</i></a>
            </div>


          </div>
            

        </div>


        
      </div>

      <!--Citas citas-->
      <div class="col s8 cita z-depth-5">
        <div class="col s12">
          <h3>Lista de Citas</h3>
          <form>
            <div class="row">
              <div class="col s12">
                <table id="tableCita" class="display" style="width:100%">
                  <thead>
                    <tr>
                      <th>Id</th>
                      <th>Nombre</th>
                      <th>Telefono</th>
                      <th>Fecha</th>
                      <th>Estado</th>
                      <th>Comentario</th>
                      <th>Seleccionar</th>
                    </tr>
                  <tbody id="tablaCitas"></tbody>
                  </thead>
                </table>
              </div>
            </div>
          </form>
        </div>

        <div class="row col s6 left">
            <div class="row">
              <div class="input-field col s6">
                <input id="idCitas" type="text" class="validate" disabled value="Id cita">
                <label for="idCitas">Id cita</label>
              </div>
            </div>

          <div class="row">
            <label>Estado</label>
            <select class="browser-default" id="citaSelect">
              <option value="" disabled selected>Seleccione una opcion</option>
              <option value="confirmada">Confirmada</option>
              <option value="realizada">Finalizar</option>
              <option value="cancelada">Cancelar</option>
            </select>
          </div>
          <div class="row">
            <a class="waves-effect waves-light btn left blue" onclick="con.actualizarCita();">Guardar</a>
          </div>
        </div>

        <div class="row col s12 left">
          <a class="btn-floating btn-large waves-effect waves-light red" onclick="apanel.ocultarDiv();"><i
              class="material-icons">close</i></a>
        </div>
      </div>




      <!--Reportes1-->
      <div class="col s8 reportes1 z-depth-5">
        <div class="col s12">
          <h3>Reportes</h3>
        </div>

        <form>
          <div class="row col s6 left">
            <div class="row">
              <label>Tipos de reportes</label>
              <select class="browser-default" id="selectReporte" required>
                <option value="" disabled selected>Seleccione una opcion</option>
                <option value="citas">Citas</option>
                <option value="facturas">Facturas</option>
                <option value="empleados">Empleados</option>
                <option value="usuarios">Usuarios</option>
              </select>
            </div>
            <div class="row">
              <a class="waves-effect waves-light btn left orange" onclick="con.generarReporte();" type="submit"><i
                  class="material-icons right">save</i>Generar</a>
            </div>
          </div>
        </form>
        <div class="row col s12 left">
          <a class="btn-floating btn-large waves-effect waves-light red" onclick="apanel.ocultarDiv();"><i
              class="material-icons">close</i></a>
        </div>
      </div>







      <!--Reportes-->
      <div class="col s9 reporte z-depth-5">
        <div class="col s12">
          <h3>Modificar/Eliminar Producto del Inventario</h3>
          <form>
            <div class="row">
              <div class="row">
                <div class="input-field col s6">
                  <input id="reporteNombre" type="text" class="validate" value="Nombre de usuario">
                  <label for="reporteNombre">Nombre del producto</label>
                </div>
                <div class="input-field col s6">
                  <input id="idproductoM" type="text" class="validate" value="Id del producto" disabled>
                  <label for="idproductoM">Id</label>
                </div>
                <div class="input-field col s6">
                  <input id="reporteCant" type="text" class="validate" value="0">
                  <label for="reporteCant">Cantidad</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s6">
                  <input id="reportePrecio" type="text" class="validate" value="0.00">
                  <label for="reportePrecio">Precio</label>
                </div>
                <div class="input-field col s6">
                  <input id="reporteDesc" type="text" class="validate" value="none">
                  <label for="reporteDesc">Descripcion</label>
                </div>
              </div>
            </div>
            <div class="row">
              <a class="waves-effect waves-light btn left blue" onclick="con.editarProductoDB();">Guardar</a>
            </div>
            <div class="row">
              <div class="col s12">

                <table id="tableInvent" class="display" style="width:100%">
                  <thead>
                    <tr>
                      <th>Producto</th>
                      <th>Cantidad</th>
                      <th>Precio(unitario)</th>
                      <th>Descripcion</th>
                      <th>Editar</th>
                      <th>Borrar</th>
                    </tr>
                  </thead>
                  <tbody id="tablaInventario">

                  </tbody>
                </table>

              </div>
            </div>
          </form>
          <div class="row">
            <a class="btn-floating btn-large waves-effect waves-light red" onclick="apanel.ocultarDiv();"><i
                class="material-icons">close</i></a>
          </div>
        </div>
        </form>
      </div>


      <!---Servicios-->
      <div class="col s9 servicios z-depth-5">
        <div class="col s12">
          <h3>Modificar/Eliminar Servicios</h3>
          <form>
            <div class="row">
              <div class="row">
                <div class="input-field col s6">
                  <input id="nombreServicio" type="text" class="validate" value="Nombre servicio">
                  <label for="nombreServicio">Nombre Servicio</label>
                </div>
                <div class="input-field col s6">
                  <input id="idServicioM" type="text" class="validate" value="Id del servicio" disabled>
                  <label for="idServicioM">Id Servicio</label>
                </div>
                <div class="input-field col s6">
                  <input id="precioServicio" type="text" class="validate" value="0.00">
                  <label for="precioServicio">Precio</label>
                </div>
              </div>
            </div>
            <div class="row">
              <a class="waves-effect waves-light btn left blue" onclick="con.editarServcioDB();">Guardar</a>
            </div>
            <div class="row">
              <div class="col s12">
                <table id="tableServicio" class="display" style="width:100%">
                  <thead>
                    <tr>
                      <th>Servicio</th>
                      <th>Precio</th>
                      <th>Editar</th>
                      <th>Borrar</th>
                    </tr>
                  </thead>

                  <tbody id="tablaServicios">

                  </tbody>
                </table>
              </div>
            </div>
          </form>
          <div class="row">
            <a class="btn-floating btn-large waves-effect waves-light red" onclick="apanel.ocultarDiv();"><i
                class="material-icons">close</i></a>
          </div>
        </div>
        </form>
      </div>




      <!--Usuarios modificar-->
      <div class="col s6 usuariosEdit z-depth-5">
        <div class="col s12">
          <h3>Modificar/Eliminar Usuarios</h3>
          <form>
            <div class="row">
              <div class="input-field col s6">
                <input id="first_name3" type="text" class="validate" value="Nombre de usuario" disabled="true">
                <label for="first_name3">Nombre Actual</label>
              </div>
              <div class="input-field col s3">
                <input id="first_name9" type="text" class="validate" disabled="true" value="none">
                <label for="first_name9">id usuario</label>
              </div>
              <div class="input-field col s3">
                <input id="idEmpleadoEditar" type="text" class="validate" disabled="true" value="none">
                <label for="idEmpleadoEditar">id empleado</label>
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
                  <option value="administrador">administrador</option>
                  <option value="usuario">usuario</option>
                  <option value="contador">contador</option>
                </select>
              </div>
            </div>
            <div class="row">
              <div class="input-field col s6">
                <input id="first_name4" type="text" class="validate" value="Nombre de usuario">
                <label for="first_name4">Usuario</label>
              </div>
              <div class="input-field col s6">
                <input id="first_name5" type="password" class="validate" value="Contrasena">
                <label for="first_name5">Contrasena</label>
              </div>
            </div>
            <div class="row">
              <a class="waves-effect waves-light btn left blue" onclick="con.editarUsuarioDB();">Guardar</a>
            </div>
            <div class="row">
              <div class="col s12">
                <table id="tableUsuarios" class="display" style="width:100%">
                  <thead>
                    <tr>
                      <th>Usuario</th>
                      <th>Nombre</th>
                      <th>Tipo de usuario</th>
                      <th>Modificar</th>
                      <th>Borrar</th>
                    </tr>
                  </thead>

                  <tbody id="tablaUsuarios">

                  </tbody>
                </table>
              </div>
            </div>
          </form>
          <div class="row">
            <a class="btn-floating btn-large waves-effect waves-light red" onclick="apanel.ocultarDiv();"><i
                class="material-icons">close</i></a>
          </div>
        </div>
        </form>
      </div>


      <!--Usuarios Nuevos-->
      <div class="col s6 usuariosCont z-depth-5">
        <div class="col s12">
          <h3>Agregar Usuario</h3>
          <br>
          <h4><b>Nuevo Usuario al sistema</b></h4>
          <form>
            <div class="row">
              <div class="input-field col s6">
                <input id="NuevoUsuario" type="text" class="validate" required="true">
                <label for="NuevoUsuario">Nuevo Usuario</label>
              </div>
            </div>
            <div class="row">
              <div class="input-field col s6">
                <input id="NuevaContra" type="password" class="validate" required="true">
                <label for="NuevaContra">Nueva Contrasena</label>
              </div>
            </div>
            <div class="row">
              <div class="col s12">
                <h6>Rol de usuario</h6>
                <select class="browser-default" id="selectRol">
                  <option value="" disabled selected required="true">Seleccione una opcion</option>
                  <option value="administrador">Administrador</option>
                  <option value="contador">Contador</option>
                  <option value="usuario">Usuario</option>
                </select>
              </div>
            </div>
            <div class="row">
              <div class="col s12">
                <h6>Empleado</h6>
                <select class="browser-default" id="empleados1">
                  <option value="" disabled selected required="true">Selecione un empleado</option>
                </select>
              </div>
            </div>
            <div class="row">
              <a class="waves-effect waves-light btn left blue" onclick="con.guardarUsuario();">Guardar</a>
            </div>
          </form>
          <div class="row">
            <a class="btn-floating btn-large waves-effect waves-light red" onclick="ocultarDiv();"><i
                class="material-icons">close</i></a>
          </div>
        </div>
        </form>
      </div>


      <!---Empleados Edit--->
      <div class="col s6 empleadoEdit z-depth-5">
        <div class="col s12">
          <h3>Modificar/Eliminar Empleados</h3>
          <form>
            <div class="row">
              <div class="input-field col s3">
                <input id="empleadoName" type="text" class="validate" value="Nombre de empleado" >
                <label for="empleadoName">Nombre Completo</label>
              </div>
              <div class="input-field col s3">
                <input id="idEmpleadoM" type="text" class="validate" value="Id empleado" disabled="true">
                <label for="idEmpleadoM">Id empleado</label>
              </div>
              <div class="input-field col s3">
                <input id="empleadoEmail" type="email" class="validate" value="algo@email.com">
                <label for="empleadoEmail">Email</label>
              </div>
              <div class="input-field col s3">
                <input id="telefonoEmpleado" type="tel" class="validate" value="telefono">
                <label for="telefonoEmpleado">Telefono</label>
              </div>
            </div>
            <div class="row">
              <a class="waves-effect waves-light btn left blue" onclick="con.editarEmpleadoDB();">Guardar</a>
            </div>
            <div class="row">
              <div class="col s12">
                <table id="tableEmpleados" class="display" style="width:100%">
                  <thead>
                    <tr>
                      <th>Nombre</th>
                      <th>Email</th>
                      <th>Telefono</th>
                      <th>Fecha de Contratacion</th>
                      <th>Modificar</th>
                      <th>Borrar</th>
                    </tr>
                  </thead>

                  <tbody id="tablaEmpleados">

                  </tbody>
                </table>
              </div>
            </div>
          </form>
          <div class="row">
            <a class="btn-floating btn-large waves-effect waves-light red" onclick="apanel.ocultarDiv();"><i
                class="material-icons">close</i></a>
          </div>
        </div>
        </form>
      </div>


      <!---Agregar Empleados--->
      <div class="col s6 empleadoCont z-depth-5">
        <div class="col s12">
          <h3>Agregar Empleado</h3>
          <br>
          <h4><b>Nuevo Usuario al sistema</b></h4>
          <form>
            <div class="row">
              <div class="input-field col s6">
                <input id="NuevoEmpleado" type="text" class="validate" required="true">
                <label for="NuevoEmpleado">Nombre Empleado</label>
              </div>
            </div>
            <div class="row">
              <div class="input-field col s6">
                <input id="NuevaEmail" type="email" class="validate" required="true">
                <label for="NuevaEmail">Email</label>
              </div>
            </div>
            <div class="row">
              <div class="input-field col s6">
                <input id="NuevaTel" type="text" class="validate" required="true">
                <label for="NuevaTel">Telefono</label>
              </div>
            </div>
            <div class="row">
              <a class="waves-effect waves-light btn left blue" onclick="con.guardarEmpleado();">Guardar</a>
            </div>
          </form>
          <div class="row">
            <a class="btn-floating btn-large waves-effect waves-light red" onclick="ocultarDiv();"><i
                class="material-icons">close</i></a>
          </div>
        </div>
        </form>
      </div>


      <!---Agregar Servicios--->
      <div class="col s10 servicioCont z-depth-5">
        <div class="col s12">
          <h3>Agregar Servicio</h3>
          <br>
          <h4><b>Nuevo Servicio al sistema</b></h4>
          <form>
            <div class="row">
              <div class="input-field col s6">
                <input id="NuevoServicio" type="text" class="validate" required="true">
                <label for="NuevoServicio">Nombre Servicio</label>
              </div>
            </div>
            <div class="row">
              <div class="input-field col s6">
                <input id="NuevaPrecio" type="text" class="validate" required="true">
                <label for="NuevaPrecio">Precio</label>
              </div>
            </div>
            <div class="row">
              <div class="col s12">
                <h6>Productos a usar</h6>
                <select id="productos1" class="browser-default">
                  <option value='' disabled selected>Seleccione los Productos Usados</option>
                </select>
              </div>
            </div>
            <div class="row">
              <a id="Sub" class="waves-effect waves-light btn left blue" onclick="con.guardarServicio();">Guardar</a>
            </div>
          </form>
          <div class="row">
            <a class="btn-floating btn-large waves-effect waves-light red" onclick="ocultarDiv();"><i
                class="material-icons">close</i></a>
          </div>



        </div>
        </form>
      </div>


      <!--Agregar Productos-->
      <div class="col s8 reporteCont z-depth-5">
        <div class="col s10">
          <h3>Agregar Producto</h3>
          <br>
          <h4><b>Nuevo Producto</b></h4>
          <form>
            <div class="row">
              <div class="input-field col s6">
                <input id="NuevoProducto" type="text" class="validate" required="true">
                <label for="NuevoProducto">Nombre</label>
              </div>
            </div>
            <div class="row">
              <div class="input-field col s6">
                <input id="CantidadProducto" type="text" class="validate" required="true">
                <label for="CantidadProducto">Cantidad</label>
              </div>
            </div>
            <div class="row">
              <div class="input-field col s6">
                <input id="PrecioProducto" type="text" class="validate" required="true">
                <label for="PrecioProducto">Precio</label>
              </div>
            </div>
            <div class="row">
              <div class="input-field col s6">
                <input id="DescripcionProducto" type="text" class="validate" required="true">
                <label for="DescripcionProducto">Descripcion</label>
              </div>
            </div>
            <div class="row">
              <a class="waves-effect waves-light btn left blue" onclick="con.guardarProducto();">Guardar</a>
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
  <script src="js/adminPanel3.js"></script>
  <script src="js/conexion3.js"></script>
  <script src="js/jspdf.min.js"></script>
  <script src="js/SingleTon.js"></script>
  <script type="text/javascript">
    M.AutoInit();
    var apanel = new SingleTon(AdminPanel).getInstance();
    $(document).ready(function () {
      apanel.getEmpleados();
      apanel.getProductos();

    });
  </script>
  <script>
    var con = new SingleTon(Conexion).getInstance();
  </script>
</body>

</html>