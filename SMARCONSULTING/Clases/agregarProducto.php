<?php

include "conexion2.php";
$db = new BaseDatos();
$nombre = $_POST["nombre"];
$cantidad = $_POST["cantidad"];
$precio = $_POST["precio"];
$descripcion = $_POST["descripcion"];

$sql = "INSERT INTO producto (nombre, cantidad, precio, descripcion) VALUES ('".$nombre."', '".$cantidad."', '".$precio."', '".$descripcion."');";

if ($db->insertar($sql)) {
    $data[] = array(
        'mensaje' => 'Se a agregado un nuevo Producto al Catalogo'
    );
} else {
    $data[] = array(
        'mensaje' => 'Error al agregar producto'
    );
}

$jsonData = json_encode($data);

print_r($jsonData);


?>