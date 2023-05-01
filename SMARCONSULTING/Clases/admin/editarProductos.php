<?php

include "../conexion2.php";
$db = new BaseDatos();

$nombre= $_POST["nombre"];
$cantidad= $_POST["cantidad"];
$precio= $_POST["precio"];
$descripcion= $_POST["descripcion"];

$sql = "UPDATE `productos` SET `nombre` = '".$nombre."', `cantidad` = '".$cantidad."', `precio` = '".$precio."', `descripcion` = '".$descripcion."' WHERE `productos`.`nombre` = ".$nombre.";";

if ($db->insertar($sql)) {
    $data[] = array(
        'mensaje' => 'Producto Actualizado exitosamente'
    );
} else {
    $data[] = array(
        'mensaje' => 'Error al Actualizar Producto'
    );
}

$jsonData = json_encode($data);

print_r($jsonData);


?>