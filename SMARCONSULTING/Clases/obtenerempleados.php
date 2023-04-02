<?php

    include('conexion.php');


    $query = "SELECT id, nombre FROM empleados";
    $resultset = mysqli_query($conn, $query);
    $data = array();

    while ($row = mysqli_fetch_assoc($resultset)) {
        $data[] = array(
            'id' => $row['id'],
            'nombre' => $row['nombre']
        );
    }

    $jsonstring = json_encode($data);
    echo $jsres;



 
?>