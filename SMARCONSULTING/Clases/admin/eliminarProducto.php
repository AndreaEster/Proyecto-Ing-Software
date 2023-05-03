<?php

include "../conexion2.php";
$db = new BaseDatos();
$id = $_POST["id"];

$sql = "DELETE FROM producto WHERE `producto`.`id` = ".$id."";

$data[] = ($db->insertar($sql)) ? array(
        'mensaje' => 'Producto Eliminado exitosamente'
    ) : array(
        'mensaje' => 'Error al Eliminar el producto'
    );

$jsonData = json_encode($data);

print_r($jsonData);


?>