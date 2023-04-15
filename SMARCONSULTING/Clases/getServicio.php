<?php

include "conexion2.php";
$db = new BaseDatos();

$result2 = array();

$resultServicios = $db->getDatos("SELECT * FROM servicios");

foreach ($resultServicios as $result2) {
    
    $servicios[] = array(
        "id" => $result2['id'],
        "nombre" => $result2['nombre'],
        "precio" => $result2['precio'],


    );

}


$jsonData = json_encode($servicios);

print_r($jsonData);


?>
