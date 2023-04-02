<?php

include("conexion2.php");
$db = new BaseDatos();

$idusuario = $_POST["id_usuario"];
$idservicio = $_POST["id_servicio"];
$fecha = $_POST["fecha"];
$hora = $_POST["hora"];
$duracion = $_POST["duracion"];
$estado = $_POST["estado"];
$comentario = $_POST["comentario"];

$db->insertarCita("INSERT INTO citas (id_usuario, id_servicio, fecha, hora, duracion, estado, comentario)
    VALUES ('$idusuario', '$idservicio', '$fecha', '$hora', '$duracion', '$estado', '$comentario')");

$data = array(
    'mensaje' => 'Cita agregada exitosamente'
);
$jsonData = json_encode($data);

echo $jsonData;
?>