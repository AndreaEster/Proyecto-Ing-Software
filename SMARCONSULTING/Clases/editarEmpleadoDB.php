<?php

include "./conexion2.php";
$db = new BaseDatos();

$id = $_POST["id"];
$nombre= $_POST["nombre"];
$email= $_POST["email"];
$tel = $_POST["tel"];


$sql = "UPDATE `empleados` SET `nombre` = '".$nombre."', `email` = '".$email."', `telefono` = '".$tel."', `fecha_contratacion` = '22-05-2023' WHERE `empleados`.`id` = ".$id."";

if ($db->insertar($sql)) {
    $data[] = array(
        'mensaje' => 'Empleado Actualizado exitosamente'
    );
} else {
    $data[] = array(
        'mensaje' => 'Error al Actualizar Empleado'
    );
}

$jsonData = json_encode($data);

print_r($jsonData);


?>