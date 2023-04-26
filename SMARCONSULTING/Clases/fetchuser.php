<?php

include_once "conexion2.php";
$db = new BaseDatos();

$limit = 5;
$page = 0;
$display = "";

if (isset($_POST['page'])) {
    $page = $_POST['page'];
} else {
    $page = 1;
}

$start_from = ((int) $page - 1) * (int) $limit;

$usuarios = $db->getMultiDatos("SELECT * FROM usuarios WHERE id != 1 ORDER BY id DESC LIMIT $start_from, $limit");

$count_user = $db->getDatos("SELECT COUNT(id) FROM usuarios");

$display .= '
    <div class="table-responsive">
        <table class="table">
                <tr>
                    <th>Usuario</th>
                    <th>Nombre</th>
                    <th>Tipo de usuario</th>
                    <th>Modificar</th>
                    <th>Borrar</th>
                </tr>
';
if ($count_user > 0) {
    foreach ($usuarios as $usuario) {
        $temp = $usuario['id_empleado'];
        $empleados = $db->getMultiDatos("SELECT * FROM empleados WHERE id = $temp");
        foreach ($empleados as $empleado) {
            $display .= '
                <tr>
                    <td>' . $usuario['username'] . '</td>
                    <td>' . $empleado['nombre'] . '</td>
                    <td>' . $usuario['rol'] . '</td>
                    <td>
                        <a href="#" onclick=con.editarUsuario(' . $usuario['id'] . ');>
                        <i class="material-icons blue-text">edit</i>
                        </a>
                    </td>
                    <td>
                        <a href="#" onclick=con.liminarUsuario(' . $usuario['id'] . ');>
                        <i class="material-icons red-text">delete</i>
                        </a>
                    </td>
                </tr>
        ';
        }
    }
} else {
    $display .= '
    <tr>
        <td>Al pareces la tabla esta vacia</td>
    </tr>
    ';
}

$display .= '
    </table>
</div>
';

$total_rows = $db->getDatos("SELECT COUNT(id) FROM usuarios");

$total_pages = ceil($total_rows / $limit);

$display .= '
        <ul class= "pagination">';

if ($page > 1) {
    $previous = (int) $page - 1;
    $display .= '
            <li class="page-item" id="1"><span class="page-link">Primera Pag.</span></li>
        ';

    $display .= '
            <li class="page-item" id="' . $previous . '"></li>
        ';
}

for ($i = 1; $i <= $total_pages; $i++) {
    $active_class = "";
    if ($i == $page) {
        $active_class = "active";
    }
    $display .= '
            <li class="page-item ' . $active_class . '" id =' . $i . '"><span class="page-link">' . $i . '</span></li>
        ';
}

if ($page < $total_pages) {
    $page++;
    $display .= '<li class="page-item" id="' . $page . '"></li>';
    $display .= '<li class="page-item" id="' . $total_pages . '"><span class="page-link">Ultima pag.</span></li>';

}

$display .= '</ul>';

echo $display;

?>