<?php

include "../conexion2.php";
$db = new BaseDatos();
$id = $_POST["id"];

$sql = "DELETE FROM empleados WHERE `empleados`.`id` = ".$id."";

$data[] = ($db->insertar($sql)) ? array(
        'mensaje' => 'Empleado Eliminado exitosamente'
    ) : array(
        'mensaje' => 'Error al Eliminar Empleado'
    );

$jsonData = json_encode($data);

print_r($jsonData);


?>