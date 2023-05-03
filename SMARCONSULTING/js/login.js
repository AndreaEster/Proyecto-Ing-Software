
function login() {
  var usuario = $('input:text[name=usuario]').val();
  var contrasena = $('input:password[name=password]').val()

  $.post("Clases/login.php",
    {
      usuario: usuario,
      password: contrasena
    },
    function (data, status) {

      const user = JSON.parse(data);
      if (user.estado) {
        alert("Bienvenido " + usuario);
        $(location).attr('href', "" + user.url + "");
      } else {
        $("#error").html("Usuario o contraseña inconrrectos" + " Login:" + user.estado);
      }


    });

}