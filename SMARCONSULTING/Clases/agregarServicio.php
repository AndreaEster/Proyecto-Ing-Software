<?php

include "conexion2.php";
$db = new BaseDatos();

$nombre = $_POST["nombre"];
$precio = $_POST["precio"];
$idproductos = $_POST["id_producto"];

$sql = "INSERT INTO servicios (`nombre`, `precio`) VALUES ($nombre, $precio);";
if ($db->insertar($sql)) {
    $data[] = array(
        'mensaje' => 'Se a agregado un nuevo servicio al Catalogo'
    );
    $id_servicio = mysqli_insert_id($db->conexion());

    foreach ($id_productos as $id_producto) {
        $sqlInsertar = "INSERT INTO producto_por_servicio (id_producto,id_servicio,) VALUES ($id_producto ,$id_servicio);";
        $db->insertar($sqlInsertar);
    }
} else {
    $data[] = array(
        'mensaje' => 'Error al agregar Servicio'
    );
}

$jsonData = json_encode($data);




print_r($jsonData);


?>