<?php

include("conexion2.php");
$db = new BaseDatos();

$idservicio = $_POST["id_servicio"];
$nombre = $_POST['nombre'];
$telefono = $_POST['telefono'];
$fecha = $_POST["fecha"];
$idHorario = $_POST["dia"];
$comentario = $_POST["comentario"];
$id_empleado=$_POST["id_empleado"];
$contador = $_POST["contador"] + 1;


$query = "INSERT INTO `citas` (`id`, `id_usuario`, `id_servicio`, `nombre`, `email`, `telefono`, `fecha`, `hora`, `duracion`, `estado`, `comentario`) VALUES (NULL, '1', '".$idservicio."', '".$nombre."', 'generic@gmail.com', '".$telefono."', '2023-05-10', '28:11:15', '30', 'confirmada', '".$comentario."')";
$queryHorarios = "UPDATE `horarios` SET `contador` = '".$contador."' WHERE `horarios`.`id` = ".$idHorario."";

if ($db->insertar($query)) {
    
    $data[] = array(
        'mensaje' => 'Cita agregada exitosamente',
        'statusH' => $db->insertar($queryHorarios)
    );
} else {
    $data[] = array(
        'mensaje' => 'Error al agregar la cita',
        'statusH' => 'false'
    );
}

$jsonData = json_encode($data);

print_r($jsonData);

?>