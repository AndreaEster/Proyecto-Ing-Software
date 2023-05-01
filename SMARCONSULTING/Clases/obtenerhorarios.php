<?php

include "conexion2.php";
$db = new BaseDatos();
$id = $_POST['id'];

$result = array();

$result = $db->getDatos("SELECT * FROM horarios");

foreach ($result as $resultado) {

    $horarios[] = array(
        "id" => $resultado['id'],
        "dia_semana"=>$resultado['dia_semana'],

    );

}

/***
 * se pasa de un arreglo relacional a un archivo tipo JSON
 */
$jsonData = json_encode($horarios);

print_r($jsonData);


?>