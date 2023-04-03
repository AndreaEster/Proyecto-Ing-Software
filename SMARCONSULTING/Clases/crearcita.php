<?php

include("conexion2.php");
$db = new BaseDatos();

$idusuario = $_POST["id_usuario"];
$idservicio = $_POST["id_servicio"];
$nombre = $_POST['nombre'];
$email = $_POST['email'];
$telefono = $_POST['telefono'];
$fecha = $_POST["fecha"];
$hora = $_POST["hora"];
$duracion = $_POST["duracion"];
$estado = $_POST["estado"];
$comentario = $_POST["comentario"];



$query = "INSERT INTO `citas` (`id`, `id_usuario`, `id_servicio`, `nombre`, `email`, `telefono`, `fecha`, `hora`, `duracion`, `estado`, `comentario`) VALUES".""
."(NULL, '".$idusuario."', '".$idservicio."', '".$nombre."', '".$email."', '".$telefono."', '".$fecha."', '".$hora."', '".$duracion."', '".$estado."', '".$comentario."');";


if ($db->insertar($query)) {
    $data = array(
        'mensaje' => 'Cita agregada exitosamente'
    );
}else{
    $data = array(
        'mensaje' => 'Error al agregar la cita'
    );
}

$jsonData = json_encode($data);

echo $jsonData;

?>