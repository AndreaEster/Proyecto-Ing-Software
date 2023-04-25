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

$start_from = ((int)$page - 1) * (int)$limit;

$productos = $db->getDatos("SELECT * FROM producto ORDER BY id DESC LIMIT $start_from, $limit");

$count_prod = $db->getDatos("SELECT COUNT(id) FROM producto");

$display .= '
    <div class="table-responsive">
        <table class="table">
                <tr>
                    <th>Producto</th>
                    <th>Cantidad</th>
                    <th>Precio(unitario)</th>
                    <th>Descripcion</th>
                </tr>
';
if ($count_prod > 0) {
    foreach ($productos as $producto) {
        $display .= '
        <tr><td>' . $producto['nombre'] . '</td><td>' . $producto['cantidad'] . '</td><td>' . $producto['precio'] . '</td><td>' . $producto['descripcion'] . '</td></tr>
        ';
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

$total_rows = $db->getDatos("SELECT COUNT(id) FROM producto");

$total_pages = ceil($total_rows / $limit);

$display .= '
        <ul class= "pagination">';

if ($page > 1) {
    $previous = (int)$page - 1;
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

$display .='</ul>';

echo $display;

?>