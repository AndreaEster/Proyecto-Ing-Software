<?php
 $usuario = "root";
 $contrasena = "";
 $servidor = "localhost";
 $database = "smartconsultingbd";



 $mysqli = new mysqli($servidor,$usuario,$contrasena,$database);
 $query = $mysqli->query("SELECT * FROM usuarios");
 $objArray= array();

 if ($result= $query){
     while($row = $result->fetch_assoc()){
        $objArray[] = $row;
     }
     $result->free();
 }else{
    echo "error en la consulta";
 }

 print_r($objArray);
?>
