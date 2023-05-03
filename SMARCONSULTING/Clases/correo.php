<?php

if (isset($_POST['submit-cita'])){
    $nombre = $_POST['nombre'];
    $telefono = $_POST['telefono'];
    $email = $_POST['email'];
    $empleado = $_POST['empleado'];
    $horario = $_POST['horario'];
    $fecha = $_POST['fecha'];

    if ($nombre=''|| $email='' || $telefono='' || $empleado=''|| $fecha=''|| $horario=''){
        echo "<script>alert('todos los campos deben llenarse')</script>";
    }else {
        $from = "";
        $webmaster = "salon";
        $to = "wgcllhronnnaeinvzp@tcwlm.com";

        $subject = "Conact Us From Amantechsol";

        $headers = "From: " . $from . "<" .$webmaster . ">\r\n";
        $headers .= "X-Mailer: PHP/" . phpversion() . "\r\n";
        $headers .= "MIME-Version: 1.0" . "\r\n";
        $headers .= "Content-Type: text/html; charset=ISO-8859-1\r\n";

        $message = "<html><body>";
        $message .="<p>esto es una prueba</p>";

        $message = "</body></html>";

        $sendmail = mail($to, $subject, $message, $headers);

        echo "<script>alert('ThankYou for Contact')<script>";
        echo "<script>window.open('index.php?sent=Your Form has been submitted','_self')</script>";
    }


}
?>