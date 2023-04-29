<?php

include("conexion2.php");
$db = new BaseDatos();

$idusuario = $_POST["id_usuario"];
$idservicio = $_POST["id_servicio"];
$nombre = $_POST['nombre'];
$email = $_POST['email'];
$telefono = $_POST['telefono'];
$fecha = $_POST["fecha"];
$estado = $_POST["estado"];
$comentario = $_POST["comentario"];



$query = "INSERT INTO `citas` (`id_usuario`, `id_servicio`, `nombre`, `email`, `telefono`, `fecha`, `estado`, `comentario`) VALUES".""
."(".$idusuario."', '".$idservicio."', '".$nombre."', '".$email."', '".$telefono."', '".$fecha."', '".$estado."', '".$comentario."');";


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