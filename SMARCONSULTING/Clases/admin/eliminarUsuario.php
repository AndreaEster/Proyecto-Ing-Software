<?php

include "../conexion2.php";
$db = new BaseDatos();
$id = $_POST["id"];

$sql = "DELETE FROM usuarios WHERE `usuarios`.`id` = ".$id."";

$data[] = ($db->insertar($sql)) ? array(
        'mensaje' => 'Usuario Eliminado exitosamente'
    ) : array(
        'mensaje' => 'Error al Eliminar usuario'
    );

$jsonData = json_encode($data);

print_r($jsonData);


?>