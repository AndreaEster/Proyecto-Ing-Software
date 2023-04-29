<?php

include "conexion2.php";
$db = new BaseDatos();
$nombre = $_POST["nombre"];
$email = $_POST["email"];
$telefono = $_POST["telefono"];


$sql = "INSERT INTO empleados (nombre, email, telefono, fecha_contratacion) VALUES ('".$nombre."', '".$email."', '".$telefono."', GETDATE());";

if ($db->insertar($sql)) {
    $data[] = array(
        'mensaje' => 'Se a agregado al empleado '+$nombre
    );
} else {
    $data[] = array(
        'mensaje' => 'Error al agregar empleado'
    );
}

$jsonData = json_encode($data);

print_r($jsonData);


?>