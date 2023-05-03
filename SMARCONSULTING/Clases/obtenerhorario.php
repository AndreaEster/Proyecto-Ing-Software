<?php

include "conexion2.php";
$db = new BaseDatos();
$id = $_POST['id'];

$result = array();

$result = $db->getDatos("SELECT * FROM horarios");

/**
 * Se rellena el arreglo relacional unicamente con los
 * nombres de los empleados
 * 
 */
foreach ($result as $resultado) {

    if ($id == $resultado['id_empleado']) {
        $horarios[] = array(
            "id" => $resultado['id'],
            "dia_semana" => $resultado['dia_semana'],
            "hora_inicio" => $resultado['hora_inicio'],
            "hora_fin" => $resultado['hora_fin']
        );
    }
}

/***
 * se pasa de un arreglo relacional a un archivo tipo JSON
 */
$jsonData = json_encode($horarios);

print_r($jsonData);


?>