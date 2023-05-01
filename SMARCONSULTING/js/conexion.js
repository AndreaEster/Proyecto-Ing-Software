
/**
 * Author Ramon Rivera
 * @returns  JSON con las instacias de las funciones
 * 
 * 
 */

var Conexion = function () {
    return {
        cargarUsuarios: cargarUsuarios,
        editarUsuario: editarUsuario,
        editarEmpleado: editarEmpleado,
        liminarUsuario: liminarUsuario,
        eliminarEmpleado: eliminarEmpleado,
        cargarInventario: cargarInventario,
        cargarServicios: cargarServicios,
        cargarCitas: cargarCitas,
        cargarEmpleados: cargarEmpleados,
        guardarUsuario: guardarUsuario,
        guardarProducto: guardarProducto,
        guardarServicio: guardarServicio,
        guardarEmpleado: guardarEmpleado,
        editarUsuarioDB: editarUsuarioDB,
        editarServicioDB: editarServicioDB,
        editarProductoDB: editarProductoDB
    }
}


function cargarUsuarios() {
    $("#tablaUsuarios").html("");
    $.post("Clases/getUsuarios.php", null,
        function (data, status) {

            this.dataUser = JSON.parse(data);


            for (let index = 0; index < this.dataUser.length; index++) {
                $("#tablaUsuarios").append(
                    "<tr><td>" + this.dataUser[index].username +
                    "</td><td>" + this.dataUser[index].nombre +
                    "</td><td>" + this.dataUser[index].tipo +
                    "</td><td><a href='#' onclick=con.editarUsuario('" + this.dataUser[index].id +
                    "');><i class='material-icons blue-text'>edit</i></a></td><td><a href='#' onclick=con.liminarUsuario('" + this.dataUser[index].id +
                    "');><i class='material-icons red-text'>delete</i></a></td></tr>");

            }


        },);

}

function cargarEmpleados(){
    $("#tablaEmpleados").html("");
    $.post("Clases/obtenerempleados.php", null,
        function (data, status) {

            this.dataEmp = JSON.parse(data);


            for (let index = 0; index < this.dataEmp.length; index++) {
                $("#tablaEmpleados").append(
                    "<tr><td>" + this.dataEmp[index].nombre +
                    "</td><td>" + this.dataEmp[index].email +
                    "</td><td>" + this.dataEmp[index].telefono +
                    "</td><td>" + this.dataEmp[index].fecha_contratacion +
                    "</td><td><a href='#' onclick=con.editarEmpleado('" + this.dataEmp[index].id +
                    "');><i class='material-icons blue-text'>edit</i></a></td><td><a href='#' onclick=con.eliminarEmpleado('" + this.dataEmp[index].id +
                    "');><i class='material-icons red-text'>delete</i></a></td></tr>");

            }


        },);

}

function cargarCitas() {
    $("#tablaCitas").html("");
    $.post("Clases/obtenercita.php", null,
        function (data, status) {

            this.dataCita = JSON.parse(data);


            for (let index = 0; index < this.dataCita.length; index++) {
                $("#tablaCitas").append(
                    "<tr><td>" + this.dataCita[index].id +
                    "</td><td>" + this.dataCita[index].nombre +
                    "</td><td>" + this.dataCita[index].email +
                    "</td><td>" + this.dataCita[index].telefono +
                    "</td><td>" + this.dataCita[index].fecha +
                    "</td><td>" + this.dataCita[index].estado +
                    "</td><td>" + this.dataCita[index].comentario +
                    "</td><td><a href='#' onclick=con.SeleccionarCita('" + this.dataCita[index].id + "');><i class='material-icons blue-text'>edit</i></a></td></tr>"
                );

            }


        },);

}

function editarUsuario(id) {

    $.post("Clases/getUsuariosById.php", {
        "id": id
    },
        function (data, status) {

            const user = JSON.parse(data);

            $("#first_name9").val(user[0].id);
            $("#idEmpleadoEditar").val(user[0].id_empleado);
            $("#first_name3").val(user[0].username);
            $("#selecUsuario").val(user[0].tipo);
            $("#first_name4").val(user[0].username);
            $("#first_name5").val(user[0].password);
        },
    );

}

function liminarUsuario(id) {


    var respuesta = confirm("El usuario se va a eliminar. Desea continuar ?");

    if (respuesta) {
        $.post("./Clases/admin/eliminarUsuario.php",
            { "id": id },
            function (data, status) {
                const result = JSON.parse(data);
                M.toast({ html: result[0].mensaje, classes: 'rounded', displayLength: 3000 });
            },
        );
        setTimeout(() => {
            this.cargarUsuarios();
        }, 1000);

    }



}

function editarEmpleado(id) {

    $.post("Clases/getEmpleadosById.php", {
        "id": id
    },
        function (data, status) {

            const emp = JSON.parse(data);

            $("#empleadoName").val(emp[0].nombre);
            $("#empleadoEmail").val(emp[0].email);
            $("#telefonoEmpleado").val(emp[0].telefono);
        },
    );

}

function eliminarEmpleado(id) {


    var respuesta = confirm("El empleado sera eliminado. Desea continuar ?");

    if (respuesta) {
        $.post("Clases/admin/eliminarEmpleado.php",
            { "id": id },
            function (data, status) {
                const result = JSON.parse(data);
                M.toast({ html: result[0].mensaje, classes: 'rounded', displayLength: 3000 });
            },
        );
        setTimeout(() => {
            this.cargarEmpleados();
        }, 1000);

    }



}

function cargarInventario() {
    $("#tablaInventario").html("");
    $.post("Clases/getInventario.php", null,
        function (data, status) {

            this.dataProd = JSON.parse(data);

            for (let index = 0; index < this.dataProd.length; index++) {
                $("#tablaInventario").append(
                    "<tr><td>" + this.dataProd[index].nombre +
                    "</td><td>" + this.dataProd[index].cantidad +
                    "</td><td>" + this.dataProd[index].precio +
                    "</td><td>" + this.dataProd[index].descripcion +
                    "</td><td><a href='#');><i class='material-icons blue-text' onClick=con.editarProductoDB('"+this.dataProd[index].id+"');>pageview</i></a></td><td><a href='#'><i class='material-icons red-text'>delete</i></a></td></tr>");

            }

        },);

}



function cargarServicios() {
    $("#tablaServicios").html("");
    $.post("Clases/getServicio.php", null,
        function (data, status) {

            this.dataServ = JSON.parse(data);


            for (let index = 0; index < this.dataServ.length; index++) {
                $("#tablaServicios").append("<tr><td>" + this.dataServ[index].nombre + "</td><td>" + this.dataServ[index].precio + "</td><td><a href='#'><i class='material-icons blue-text'>edit</i></a></td><td><a href='#'><i class='material-icons red-text'>delete</i></a></td></tr>");

            }


        },);

}

function guardarUsuario() {
    $.post("Clases/admin/agregarUsuarios.php", {
        username: $("#NuevoUsuario").val(),
        password: $("#NuevaContra").val(),
        id_empleado: $("#empleados1").val(),
        rol: $("#selectRol").val()

    },
        function (data, status) {

            const result = JSON.parse(data);
            M.toast({ html: result[0].mensaje, classes: 'rounded', displayLength: 3000 });


        },
    );
}

function guardarProducto() {
    $.post("Clases/agregarProducto.php", {
        nombre: $("#NuevoProducto").val(),
        cantidad: $("#CantidadProducto").val(),
        precio: $("#PrecioProducto").val(),
        descripcion: $("#DescripcionProducto").val()

    },
        function (data, status) {

            const result = JSON.parse(data);
            M.toast({ html: result[0].mensaje, classes: 'rounded', displayLength: 3000 });


        },
    );
}

function guardarEmpleado() {
    $.post("Clases/agregarEmpleado.php", {
        nombre: $("#NuevoEmpleado").val(),
        email: $("#NuevaEmail").val(),
        telefono: $("#NuevaTel").val()
        

    },
        function (data, status) {

            const result = JSON.parse(data);
            M.toast({ html: result[0].mensaje, classes: 'rounded', displayLength: 3000 });


        },
    );
}

function guardarServicio() {
    $.post("Clases/agregarServicio.php", {
        nombre: $("#NuevoServicio").val(),
        precio: $("#NuevaPrecio").val(),
        id_producto: $("#productos1").val().join(',')

    },
        function (data, status) {

            const result = JSON.parse(data);
            M.toast({ html: result[0].mensaje, classes: 'rounded', displayLength: 3000 });


        },
    );
}

function editarUsuarioDB() {
    $.post("Clases/admin/editarUsuarios.php", {
        id: $("#first_name9").val(),
        id_empleado: $("#idEmpleadoEditar").val(),
        rol: $("#selecUsuario").val(),
        username: $("#first_name4").val(),
        password: $("#first_name5").val()

    },
        function (data2, status) {

            const result = JSON.parse(data2);
            M.toast({ html: result[0].mensaje, classes: 'rounded', displayLength: 3000 });

        },
    );

    setTimeout(() => {
        this.cargarUsuarios();
    }, 1000);

}

function editarServicioDB() {
    $.post("Clases/admin/editarServicios.php", {
        nombre: $("#nombreServicio").val(),
        precio: $("#precioServicio").val()

    },
        function (data2, status) {

            const result = JSON.parse(data2);
            M.toast({ html: result[0].mensaje, classes: 'rounded', displayLength: 3000 });

        },
    );

    setTimeout(() => {
        this.cargarServicios();
    }, 1000);

}

function editarProductoDB() {
    $.post("Clases/admin/editarProductos.php", {
        nombre: $("#reporteNombre").val(),
        cantidad: $("#reporteCant").val(),
        precio: $("#reportePrecio").val(),
        descripcion: $("#reporteDesc").val()

    },
        function (data2, status) {

            const result = JSON.parse(data2);
            M.toast({ html: result[0].mensaje, classes: 'rounded', displayLength: 3000 });

        },
    );

    setTimeout(() => {
        this.cargarInventario();
    }, 1000);

}

