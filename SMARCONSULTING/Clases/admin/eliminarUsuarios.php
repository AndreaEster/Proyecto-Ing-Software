<?php
include "../conexion2.php";
$db = new BaseDatos();

$id = $_GET['id'];

$sql = "DELETE FROM usuarios WHERE id = '{$id}'";

if ($db->eliminar($sql)) {
    echo "Registro eliminado correctamente.";
} else {
    echo "Error al eliminar el registro.";
}

?>