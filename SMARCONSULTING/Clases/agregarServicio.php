<?php

include "conexion2.php";
$db = new BaseDatos();

$nombre = $_POST["nombre"];
$precio = $_POST["precio"];
$idproductos = $_POST["id_producto"];

$sql = "INSERT INTO `servicios` (`id`, `nombre`, `precio`, `id_producto`, `imagen_url`) VALUES (NULL, '".$nombre."', '".$precio."', '".$idproductos."', 'null')";

if ($db->insertar($sql)) {
    $data[] = array(
        'mensaje' => 'Se a agregado un nuevo servicio al Catalogo'
    );
    
} else {
    $data[] = array(
        'mensaje' => 'Error al agregar Servicio'
    );
}

$jsonData = json_encode($data);




print_r($jsonData);


?>