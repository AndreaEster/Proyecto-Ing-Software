<?php

include "conexion2.php";
$db = new BaseDatos();
$id = $_POST['id'];
$result = array();

$resultProductos = $db->getDatos("SELECT * FROM producto WHERE id = {$id}");

foreach ($resultProductos as $result) {
    
    $productos[] = array(
        "id" => $result['id'],
        "nombre" => $result['nombre'],
        "cantidad" => $result['cantidad'],
        "precio" => $result['precio'],
        "descripcion" => $result['descripcion']

    );

}


$jsonData = json_encode($productos);

print_r($jsonData);


?>
