

function crearCita(cita) {
    return new Promise((resolve, reject) => {
        $.ajax({
            url: "Clases/crearcita.php",
            type: 'POST',
            data: JSON.stringify(cita),
            contentType: 'application/json',
            success: function (data) {
                resolve(data);
            },
            error: function (error) {
                reject(error);
            }
        });
    });
}