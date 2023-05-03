<?php

include "conexion2.php";
$db = new BaseDatos();
$id = $_POST['id'];
$result = array();

$resultEmpleados = $db->getDatos("SELECT * FROM empleados WHERE id = {$id}");

foreach ($resultEmpleados as $result) {
    
    $empleados[] = array(
        "id" => $result['id'],
        "nombre" => $result['nombre'],
        "email" => $result['email'],
        "telefono" => $result['telefono'],
    );

}


$jsonData = json_encode($empleados);

print_r($jsonData);


?>
