<?php

include "conexion2.php";
$db = new BaseDatos();

$result = array();

$result = $db->getDatos("SELECT * FROM empleados WHERE id != 1");

/**
 * Se rellena el arreglo relacional unicamente con los
 * nombres de los empleados
 * 
 */
foreach ($result as $resultado) {
    $nombres[] = array(
        "nombre"=>$resultado['nombre'],
        "id"=>$resultado['id']
    );
}

/***
 * se pasa de un arreglo relacional a un archivo tipo JSON
 */
$jsonData = json_encode($nombres);

print_r($jsonData);


?>
