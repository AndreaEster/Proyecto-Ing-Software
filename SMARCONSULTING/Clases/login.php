<?php
include "conexion2.php";
$db = new BaseDatos();
$usuarioGET = $_POST["usuario"];
$contrasenaGET = $_POST["password"];

$result = array();

$result = $db->getDatos("SELECT * FROM usuarios");
$estado = false;

foreach ($result as $resultado) {
    if($resultado["username"]==$usuarioGET && $resultado["password"]==$contrasenaGET){
        $estado = true;
        
    }
   
}

$data = array(
    'estado' => $estado,
    'url' => 'adminPanel.php'
);
$jsonData = json_encode($data);

echo $jsonData;

?>
