<?php

include "./conexion2.php";
$db = new BaseDatos();

$id = $_POST['id'];
$estado = $_POST['estado'];


$sql = "UPDATE `citas` SET `estado` = '".$estado."' WHERE `citas`.`id` = ".$id."";

if ($db->insertar($sql)) {
    $data[] = array(
        'mensaje' => 'Cita Actualizado exitosamente'
    );
} else {
    $data[] = array(
        'mensaje' => 'Error al Actualizar Cita'
    );
}

$jsonData = json_encode($data);

print_r($jsonData);


?>