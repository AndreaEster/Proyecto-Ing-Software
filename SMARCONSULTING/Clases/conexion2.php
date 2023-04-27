<?php

class BaseDatos
{

    private $usuario = "root";
    private $contrasena = "";
    private $servidor = "localhost";
    private $database = "smartconsultingbd";

    public function __construct()
    {

    }

    public function conexion()
    {
        return mysqli_connect($this->servidor, $this->usuario, $this->contrasena, $this->database);
    }

    public function getDatos($stringQuery)
    {
        $conn = new mysqli($this->servidor, $this->usuario, $this->contrasena, $this->database);
        $query = $conn->query($stringQuery);
        $objArray = array();

        if ($result = $query) {
            while ($row = $result->fetch_assoc()) {
                $objArray[] = $row;
            }
            $result->free();
        }

        return $objArray;
    }

    public function insertarCita(
        $idusuario,
        $idservicio,
        $fecha,
        $hora,
        $duracion,
        $estado,
        $comentario
    ) {
        $mysqli = new mysqli($this->servidor, $this->usuario, $this->contrasena, $this->database);
        $query = $mysqli->prepare(
            "INSERT INTO citas (id_usuario, id_servicio,
            fecha, hora, duracion, estado, comentario) VALUES (?, ?, ?, ?, ?, ?, ?)"
        );
        $query->bind_param("iisssss", $idusuario, $idservicio, $fecha, $hora, $duracion, $estado, $comentario);
        $query->execute();
        $query->close();
        $mysqli->close();
    }

public function insertar($query){

    $estado = false;
// Create connection
$conn = mysqli_connect($this->servidor, $this->usuario, $this->contrasena, $this->database);
// Check connection
if (!$conn) {
      die("Connection failed: " . mysqli_connect_error());
}
$sql = $query;
if (mysqli_query($conn, $sql)) {
      $estado = true;
} 

/*

else {
      echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

*/
mysqli_close($conn);

return $estado;

}

public function eliminar($query){
    $estado = false;
    // Crear conexión
    $conn = mysqli_connect($this->servidor, $this->usuario, $this->contrasena, $this->database);
    // Verificar conexión
    if (!$conn) {
        die("Connection failed: " . mysqli_connect_error());
    }
    $sql = $query;
    if (mysqli_query($conn, $sql)) {
        $estado = true;
    } 
    
    mysqli_close($conn);
    return $estado;
}


}






?>