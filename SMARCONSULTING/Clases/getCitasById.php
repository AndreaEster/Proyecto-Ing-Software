<?php

include "conexion2.php";
$db = new BaseDatos();
$id = $_POST['id'];
$result = array();

$resultUsuarios = $db->getDatos("SELECT * FROM citas WHERE id = {$id}");

foreach ($resultUsuarios as $result) {
    
    $usuarios[] = array(
        "id" => $result['id'],
        "estado" => $result['estado']

    );

}


$jsonData = json_encode($usuarios);

print_r($jsonData);


?>
