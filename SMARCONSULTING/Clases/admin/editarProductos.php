<?php

include "../conexion2.php";
$db = new BaseDatos();
$id = $_POST['id'];
$nombre= $_POST["nombre"];
$cantidad= $_POST["cantidad"];
$precio= $_POST["precio"];
$descripcion= $_POST["descripcion"];

$sql = "UPDATE `producto` SET `nombre` = '".$nombre."', `cantidad` = '".$cantidad."', `precio` = '".$precio."', `descripcion` = '".$descripcion."' WHERE `producto`.`id` = ".$id."; ";

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