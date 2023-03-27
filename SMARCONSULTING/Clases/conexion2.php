<?php

class BaseDatos{

    private $usuario = "root";
    private $contrasena = "";
    private $servidor = "localhost";
    private $database = "smartconsultingbd";

    public function __construct(){

    }

    public function conexion(){
        return $mysqli = new mysqli($this->servidor,$this->usuario,$this->contrasena,$this->database);
    }

    public function getDatos($stringQuery){
        $mysqli = new mysqli($this->servidor,$this->usuario,$this->contrasena,$this->database);
        $query = $mysqli->query($stringQuery);
        $objArray= array();

        if ($result= $query){
            while($row = $result->fetch_assoc()){
                $objArray[] = $row;
            }
            $result->free();
        }
    
        return $objArray;      
    }
}

?>
