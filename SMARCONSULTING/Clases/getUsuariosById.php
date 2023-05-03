<?php

include "conexion2.php";
$db = new BaseDatos();
$id = $_POST['id'];
$result = array();

$resultUsuarios = $db->getDatos("SELECT * FROM usuarios WHERE id = {$id}");

foreach ($resultUsuarios as $result) {
    
    $usuarios[] = array(
        "id" => $result['id'],
        "username" => $result['username'],
        "password" => $result['password'],
        "tipo" => $result['rol'],
        "id_empleado"=>$result['id_empleado']

    );

}


$jsonData = json_encode($usuarios);

print_r($jsonData);


?>
