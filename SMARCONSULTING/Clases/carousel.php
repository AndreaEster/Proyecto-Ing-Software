<?php

include('conexion2.php');
$db = new BaseDatos();

$result = array();

$result = $db->getDatos("SELECT * FROM imagenes");
$estado = false;

$data = array();
foreach ($result as $resultado) {
   $data[] = $resultado;

}

$jsonData = json_encode($data);

echo $jsonData;
?>