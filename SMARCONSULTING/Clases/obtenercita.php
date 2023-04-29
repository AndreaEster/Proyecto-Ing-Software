<?php

include "conexion2.php";
$db = new BaseDatos();

$result = array();

$result = $db->getDatos("SELECT * FROM citas");


foreach ($result as $resultado) {
    $Citas[] = array(
        "id" => $resultado["id"],
        "nombre" => $resultado["nombre"],
        "email" => $resultado["email"],
        "telefono" => $resultado["telefono"],
        "fecha" => $resultado["fecha"],
        "estado" => $resultado["estado"],
        "comentario" => $resultado["comentario"]
    );
}

/***
 * se pasa de un arreglo relacional a un archivo tipo JSON
 */
$jsonData = json_encode($Citas);

print_r($jsonData);


?>