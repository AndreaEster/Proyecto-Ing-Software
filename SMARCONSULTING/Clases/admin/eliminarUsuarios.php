<?php
include "conexion2.php";
$db = new BaseDatos();

if (isset($_GET['uid'])){
    $user_id = $_GET['uid'];
    
    $sql = "DELETE FROM usuarios WHERE id = '{$user_id}'";
    
    $conn = $db->getDatos($sql);

    if (!empty($conn)){
        
    }


}




?>