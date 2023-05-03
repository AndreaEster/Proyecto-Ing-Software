<?php

include "conexion2.php";
$db = new BaseDatos();

$result = array();

$result = $db->getDatos("SELECT * FROM producto");

/**
 * Se rellena el arreglo relacional unicamente con los
 * nombres de los productos
 * 
 */
foreach ($result as $resultado) {
    $nombres[] = array(
        "id" => $resultado['id'],
        "nombre" => $resultado['nombre']

    );
}

/***
 * se pasa de un arreglo relacional a un archivo tipo JSON
 */
$jsonData = json_encode($nombres);

print_r($jsonData);


?>