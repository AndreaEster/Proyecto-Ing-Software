<?php
include "conexion2.php";
session_start();
$db = new BaseDatos();
$usuarioGET = $_POST["usuario"];
$contrasenaGET = $_POST["password"];

$result = array();

$result = $db->getDatos("SELECT * FROM usuarios");
$estado = false;
$url = "www.google.com";
foreach ($result as $resultado) {
    if ($resultado["username"] == $usuarioGET && $resultado["password"] == $contrasenaGET) {
        $estado = true;
        $_SESSION["usuarioNombre"] = $usuarioGET;
        $_SESSION["rol"] = $resultado["rol"];
        $_SESSION["estado"] = $estado;
        $_SESSION["urlIMG"] = $resultado["img"];

        $url = "adminPanel.php";

    }

}

if ($estado) {

}

$data = array(
    'estado' => $estado,
    'url' => $url
);
$jsonData = json_encode($data);

echo $jsonData;

?>