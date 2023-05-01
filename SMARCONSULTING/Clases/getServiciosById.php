<?php

include "conexion2.php";
$db = new BaseDatos();
$id = $_POST['id'];
$result = array();

$resultServicios = $db->getDatos("SELECT * FROM servicios WHERE id = {$id}");

foreach ($resultServicios as $result) {
    
    $servicios[] = array(
        "nombre" => $result['nombre'],
        "precio" => $result['precio'],

    );

}


$jsonData = json_encode($servicios);

print_r($jsonData);


?>
