<?php 

session_start();

/***
 * 
 * Se borran las sessiones
 * 
 * 
 */

 unset($_SESSION["usuarioNombre"]);
 unset($_SESSION["rol"]);
 unset($_SESSION["estado"]);

 header( 'Location: ../../login.html' );
        


?>