<?php

include "../conexion2.php";
$db = new BaseDatos();
$username = $_POST["username"];
$password = $_POST["password"];
$idempleado = $_POST["id_empleado"];
$rol = $_POST["rol"];

$sql = "INSERT INTO `usuarios` (`id`, `username`, `password`, `id_empleado`, `rol`) VALUES (NULL, '".$username."', '".$password."', '".$idempleado."', '".$rol."');";

if ($db->insertar($sql)) {
    $data[] = array(
        'mensaje' => 'Usuario '.$username.' agregada exitosamente'
    );
} else {
    $data[] = array(
        'mensaje' => 'Error al agregar al usuario'
    );
}

$jsonData = json_encode($data);

print_r($jsonData);


?>