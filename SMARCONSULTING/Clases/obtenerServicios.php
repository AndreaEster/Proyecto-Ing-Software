<?php

include "conexion2.php";
$db = new BaseDatos();

$result = array();

$result = $db->getDatos("SELECT * FROM servicios");


foreach ($result as $resultado) {
    $horarios[] = array(
        "id"=>$resultado['id'],
        "nombre"=>$resultado['nombre'],
        "precio"=>$resultado['precio']
    );
}

/***
 * se pasa de un arreglo relacional a un archivo tipo JSON
 */
$jsonData = json_encode($horarios);

print_r($jsonData);


?>