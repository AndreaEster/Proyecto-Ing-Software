<?php

include "conexion2.php";
$db = new BaseDatos();

$result = array();

$result = $db->getDatos("SELECT * FROM facturas");


foreach ($result as $resultado) {
    $Citas[] = array(
        "id" => $resultado["id"],
        "id_pago" => $resultado["id_pago"],
        "fecha" => $resultado["fecha"],
        "hora" => $resultado["hora"],
        "total" => $resultado["total"]
    );
}

/***
 * se pasa de un arreglo relacional a un archivo tipo JSON
 */
$jsonData = json_encode($Citas);

print_r($jsonData);


?>