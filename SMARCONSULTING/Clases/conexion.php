<?php

   $conn = mysqli_connect('localhost', 'root', 'password', 'smartconsultingbd');


   if ($conn) {
      echo "Conectado a la base de datos";
   }


?>