<?php

include "conexion2.php";
$db = new BaseDatos();
$nombre = $_POST["nombre"];
$email = $_POST["email"];
$telefono = $_POST["telefono"];


$sql = "INSERT INTO `empleados` (`id`, `nombre`, `email`, `telefono`, `fecha_contratacion`) VALUES (NULL, '".$nombre."', '".$email."', '".$telefono."', '".date("d-m-Y")."') ";

if ($db->insertar($sql)) {
    $data[] = array(
        'mensaje' => 'Se a agregado al empleado '.$nombre
    );
} else {
    $data[] = array(
        'mensaje' => 'Error al agregar empleado'
    );
}

$jsonData = json_encode($data);

print_r($jsonData);


?>