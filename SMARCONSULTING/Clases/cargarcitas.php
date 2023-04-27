<?php

include "conexion2.php";
$db = new BaseDatos();

$limit = 5;
$page = 0;
$display = "";
$num_filas = 0;

if (isset($_POST['page'])) {
    $page = $_POST['page'];
} else {
    $page = 1;
}

$start_from = ((int) $page - 1) * (int) $limit;


if (isset($_POST['buscaCita'])) {
    $buscar = mysqli_real_escape_string($db->conexion(), $_POST['buscaCita']);

    $columns = ['id', 'nombre', 'email', 'telefono', 'fecha', 'estado', 'comentario'];
    $columnsWhere = ['nombre', 'telefono', 'estado'];
    $tabla = "citas";
    $where = "WHERE nombre LIKE '%" . $buscar . "%' OR telefono LIKE '%" . $buscar . "%' OR estado LIKE '%" . $buscar . "%'";
    $sql = "SELECT " . implode(", ", $columns) . " FROM $tabla $where ORDER BY id DESC LIMIT $start_from, $limit";
    $result = $db->getDatos($sql);
    $num_filas = $db->getDatos("SELECT COUNT(id) FROM citas ");
} else {
    $sql = "SELECT * FROM citas ORDER BY id DESC LIMIT $start_from, $limit";
    $result = $db->getDatos($sql);
    $num_filas = $db->getDatos("SELECT COUNT(id) FROM citas");
}

$resulta = mysqli_query($db->conexion(), $sql);




$display .= '
<div class="table-responsive">
<table class="table">
    <thead>
        <tr>
            <th>Id</th>
            <th>Nombre</th>
            <th>Email</th>
            <th>Telefono</th>
            <th>Fecha</th>
            <th>Estado</th>
            <th>Comentario</th>
        </tr>
        <tbody id = "contenido"></tbody>
    </thead>
';

if (mysqli_num_rows($resulta) > 0) {
    foreach ($result as $fila) {
        $display .= '
            <tr>
                <td>' . $fila['id'] . '</td>
                <td>' . $fila['nombre'] . '</td>
                <td>' . $fila['email'] . '</td>
                <td>' . $fila['telefono'] . '</td>
                <td>' . $fila['fecha'] . '</td>
                <td>' . $fila['estado'] . '</td>
                <td>' . $fila['comentario'] . '</td>
            </tr>
        ';
    }
} else {
    $display .= '
    <tr>
        <td>No hay Citas</td>
    </tr>
    ';
}

$total_pages = ceil($num_filas / $limit);

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