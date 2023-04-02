// Llamada AJAX al servidor PHP para obtener los datos
function obtempleado() {
    $.ajax({
        url: 'Clases/obtenerempleados.php',
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            /*
            // Recorre los datos devueltos y agrega las opciones al select
            $.each(data, function (key, value) {
                $('#select-options').append($('<option>', {
                    value: value.id,
                    text: value.nombre
                }));
            });
            // Inicializa el select de Materialize
            $('select').FormSelect();
            */
           console.log(data);
        }
    });
}