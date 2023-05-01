<?php

include("conexion2.php");
$db = new BaseDatos();

$idservicio = $_POST["id_servicio"];
$nombre = $_POST['nombre'];
$telefono = $_POST['telefono'];
$fecha = $_POST["fecha"];
$dia = $_POST["dia"];
$comentario = $_POST["comentario"];



$query = "INSERT INTO `citas` (`id_usuario`, `id_servicio`, `nombre`, `telefono`, `fecha`, `dia`, `estado`, `comentario`) VALUES ('1', '" . $idusuario . "', '" . $idservicio . "', '" . $nombre . "', '" . $telefono . "', '" . $fecha . "', '" . $dia . "', '1' , '" . $comentario . "');";


if ($db->insertar($query)) {
    $data = array(
        'mensaje' => 'Cita agregada exitosamente'
    );
} else {
    $data = array(
        'mensaje' => 'Error al agregar la cita'
    );
}

$jsonData = json_encode($data);

echo $jsonData;

?>