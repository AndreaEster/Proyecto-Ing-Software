<?php 
include("conexion2.php");
$db = new BaseDatos();

$id_Horario = $_POST['id_horario'];

$result1 = array();

$resultHorarios = $db->getDatos("SELECT * FROM `horarios` WHERE id =".$id_Horario."");

foreach ($resultHorarios as $result1) {
    
    $servicios[] = array(
        "contador" => $result1['contador'],
        "capacidad_cita" => $result1['capacidad_cita']
    );

}


if ($servicios[0]["contador"]<$servicios[0]["capacidad_cita"]) {
    $mensaje[] = array(
        "status" => "true",
        "contador" => $servicios[0]["contador"]
    );
}else{
    $mensaje[] = array(
        "status" => "false",
        "contador" => $servicios[0]["contador"]
    );
}

$jsonData = json_encode($mensaje);

print_r($jsonData);

?>