<?php

include "../conexion2.php";
$db = new BaseDatos();

$id = $_POST["id"];
$nombre= $_POST["nombre"];
$precio= $_POST["precio"];


$sql = "UPDATE `servicios` SET `nombre` = '".$nombre."', `precio` = '".$precio."' WHERE `servicios`.`id` = ".$id."";

if ($db->insertar($sql)) {
    $data[] = array(
        'mensaje' => 'Servicio Actualizado exitosamente'
    );
} else {
    $data[] = array(
        'mensaje' => 'Error al Actualizar Servicio'
    );
}

$jsonData = json_encode($data);

print_r($jsonData);


?>