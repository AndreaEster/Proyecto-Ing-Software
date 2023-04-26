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

$servicios = $db->getDatos("SELECT * FROM servicios ORDER BY id DESC LIMIT $start_from, $limit");

$count_serv = $db->getDatos("SELECT COUNT(id) FROM servicios");

$display .= '
    <div class="table-responsive">
            <table>
                <thead>
                    <tr>
                        <th>Servicio</th>
                        <th>Precio</th>
                    </tr>
                </thead>
';
if ($count_serv > 0) {
    foreach ($servicios as $servicio) {
        $display .= '
        <tr><td>' . $servicio['nombre'] . '</td><td>' . $servicio['precio'] .'</td></tr>
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

$total_rows = $db->getDatos("SELECT COUNT(id) FROM servicios");

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