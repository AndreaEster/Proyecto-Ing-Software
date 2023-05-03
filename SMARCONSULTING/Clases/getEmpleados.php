<?php

include "conexion2.php";
$db = new BaseDatos();
$result = array();

$resultEmpleados = $db->getDatos("SELECT * FROM empleados");

foreach ($resultEmpleados as $result) {
    
    $empleados[] = array(
        "id" => $result['id'],
        "nombre" => $result['nombre'],
        "email" => $result['email'],
        "telefono" => $result['telefono'],
        "fecha_contratacion" => $result['fecha_contratacion']
    );

}


$jsonData = json_encode($empleados);

print_r($jsonData);


?>
