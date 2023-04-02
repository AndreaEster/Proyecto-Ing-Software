<?php
include "conexion2.php";
$db = new BaseDatos();

$resultados = $db->getDatos("SELECT * FROM citas");

// Creamos un array vacío que iremos llenando con los datos de las citas
$citas = array();

foreach ($resultados as $resultado) {
    $cita = array(
        "id" => $resultado["id"],
        "id_usuario" => $resultado["id_usuario"],
        "id_servicio" => $resultado["id_servicio"],
        "nombre" => $resultado["nombre"],
        "email" => $resultado["email"],
        "telefono" => $resultado["telefono"],
        "fecha" => $resultado["fecha"],
        "hora" => $resultado["hora"],
        "duracion" => $resultado["duracion"],
        "estado" => $resultado["estado"],
        "comentario" => $resultado["comentario"]
    );
    $citas[] = $cita;
}

// Convertimos el array a formato JSON
$jsonCitas = json_encode($citas);

// Devolvemos la respuesta al cliente
header("Content-Type: application/json");
echo $jsonCitas;

?>