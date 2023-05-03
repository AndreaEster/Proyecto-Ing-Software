<?php

include "conexion2.php";
$db = new BaseDatos();

$result2 = array();

$resultProductos = $db->getDatos("SELECT * FROM producto");

foreach ($resultProductos as $result2) {
    
    $productos[] = array(
        "id" => $result2['id'],
        "nombre" => $result2['nombre'],
        "cantidad" => $result2['cantidad'],
        "precio" => $result2['precio'],
        "descripcion" => $result2['descripcion']

    );

}


$jsonData = json_encode($productos);

print_r($jsonData);


?>
