<?php

include "../conexion2.php";
$db = new BaseDatos();

$result = array();

$resultUsuarios = $db->getDatos("SELECT * FROM usuarios WHERE id != 1");

foreach ($resultUsuarios as $result) {
    
    $resultEmpleados = $db->getDatos("SELECT * FROM empleados WHERE id = {$result['id_empleado']} ");
    $usuarios[] = array(
        "id" => $result['id'],
        "username" => $result['username'],
        "nombre" => $resultEmpleados[0]['nombre'],
        "tipo" => $result['rol']

    );

}


$jsonData = json_encode($usuarios);

print_r($jsonData);


?>
