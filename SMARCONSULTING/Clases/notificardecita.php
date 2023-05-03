<?php

include '../Clases/conexion2.php';
$db = new BaseDatos();

$id_cita = $_POST['id_cita'];
$id_factura = $_POST['id'];
$fecha_pago = date("Y-m-d");
$time_pago = time("H:i:s");
$monto = $_POST['monto'];

$conexion = $db->conexion();

//Insertar en la tabla pagos
$sql_insert_pago = "INSERT INTO pagos (id_cita, fecha, hora, monto) VALUES ('$id_cita', '$fecha_pago','$hora_pago', '$monto')";

if (mysqli_query($conexion, $sql_insert_pago)) {
    //Obtener el ID del pago insertado
    $id_pago = mysqli_insert_id($conexion);

    //Insertar en la tabla facturas
    $sql_insert_factura = "INSERT INTO facturas (id, id_pago, fecha, hora, total) VALUES ('$id_factura','$id_pago', '$fecha_pago','$hora_pago', '$monto')";
    
    if (mysqli_query($conexion, $sql_insert_factura)) {
        echo json_encode(array("mensaje" => "Pago y factura creados correctamente."));
    } else {
        echo json_encode(array("mensaje" => "Error al crear la factura."));
    }

} else {
    echo json_encode(array("mensaje" => "Error al crear el pago."));
}

mysqli_close($conexion);

?>
