<?php

include "../conexion2.php";
$db = new BaseDatos();
$id = $_POST["id"];

$sql = "DELETE FROM servicios WHERE `servicios`.`id` = ".$id."";

$data[] = ($db->insertar($sql)) ? array(
        'mensaje' => 'Servicio removido exitosamente'
    ) : array(
        'mensaje' => 'Error al Eliminar servicio'
    );

$jsonData = json_encode($data);

print_r($jsonData);


?>