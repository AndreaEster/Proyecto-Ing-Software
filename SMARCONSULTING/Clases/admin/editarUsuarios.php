<?php

include "../conexion2.php";
$db = new BaseDatos();

$id = $_POST["id"];
$username = $_POST["username"];
$password = $_POST["password"];
$idempleado = $_POST["id_empleado"];
$rol = $_POST["rol"];

$sql = "UPDATE `usuarios` SET `username` = '".$username."', `password` = '".$password."', `id_empleado` = '".$idempleado."', `rol` = '".$rol."' WHERE `usuarios`.`id` = ".$id.";";

if ($db->insertar($sql)) {
    $data[] = array(
        'mensaje' => 'Usuario '.$username.' Actualizado exitosamente'
    );
} else {
    $data[] = array(
        'mensaje' => 'Error al Actualizar usuario'
    );
}

$jsonData = json_encode($data);

print_r($jsonData);


?>