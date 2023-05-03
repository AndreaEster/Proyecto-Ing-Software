
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
        editarServicio: editarServicio,
        editarProducto: editarProducto,
        liminarUsuario: liminarUsuario,
        eliminarEmpleado: eliminarEmpleado,
        eliminarProducto: eliminarProducto,
        eliminarServicio: eliminarServicio,
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
        editarProductoDB: editarProductoDB,
        SeleccionarCita: SeleccionarCita,
        generarReporte: generarReporte,
        editarServcioDB: editarServcioDB,
        editarEmpleadoDB: editarEmpleadoDB
    }
}


function generarReporte() {

    switch ($("#selectReporte").val()) {
        case "citas":

            $.post("Clases/obtenercita.php", null,
                function (data, status) {
                    const citas = JSON.parse(data);

                    reporteCitas(citas);
                },
            );

            break;
        case "facturas":
            $.post("Clases/obtenerFactura.php", null,
                function (data, status) {
                    const facturas = JSON.parse(data);

                    reporteFacturas(facturas);
                },
            );
            break;


        case "empleados":
            $.post("Clases/getEmpleados.php", null,
                function (data, status) {
                    const empleados = JSON.parse(data);

                    reporteEmpleados(empleados);
                },
            );

            break;

        case "usuarios":
            $.post("Clases/getUsuarios.php", null,
                function (data, status) {
                    const usuarios = JSON.parse(data);

                    reporteUsuarios(usuarios);
                },
            );
            break;

        default:
            alert("No se a seleccionado un tipo de reporte");
            break;
    }


}




function reporteUsuarios(data) {

    var result = [];

    for (var i = 0; i < data.length; i++) {
        data2 = {
            id: data[i].id,
            username: data[i].username,
            nombre: data[i].nombre,
            tipo: data[i].tipo

        };
        result.push(Object.assign({}, data2));
    }

    function createHeaders(keys) {
        var result = [];
        for (var i = 0; i < keys.length; i += 1) {
            result.push({
                id: keys[i],
                name: keys[i],
                prompt: keys[i],
                width: 65,
                align: "left",
                padding: 0
            });
        }
        return result;
    }

    var headers = createHeaders([
        "id",
        "username",
        "nombre",
        "tipo"
    ]);


    var doc = new jsPDF('p', 'mm', [300, 300]);
    doc.table(1, 1, result, headers, { autoSize: true });
    doc.setDisplayMode({ zoom: 1, layout: "continuous", pmode: "UseOutlines" });

    doc.save("" + $("#selectReporte").val() + ".pdf");

}



function reporteEmpleados(data) {

    var result = [];

    for (var i = 0; i < data.length; i++) {
        data2 = {
            id: data[i].id,
            nombre: data[i].nombre,
            email: data[i].email,
            telefono: data[i].telefono,
            fecha_contratacion: data[i].fecha_contratacion

        };
        result.push(Object.assign({}, data2));
    }

    function createHeaders(keys) {
        var result = [];
        for (var i = 0; i < keys.length; i += 1) {
            result.push({
                id: keys[i],
                name: keys[i],
                prompt: keys[i],
                width: 65,
                align: "left",
                padding: 0
            });
        }
        return result;
    }

    var headers = createHeaders([
        "id",
        "nombre",
        "email",
        "telefono",
        "fecha_contratacion"
    ]);


    var doc = new jsPDF('p', 'mm', [450, 450]);
    doc.table(1, 1, result, headers, { autoSize: true });
    doc.setDisplayMode({ zoom: 1, layout: "continuous", pmode: "UseOutlines" });

    doc.save("" + $("#selectReporte").val() + ".pdf");

}


function reporteFacturas(data) {

    var result = [];

    for (var i = 0; i < data.length; i++) {
        data2 = {
            id: data[i].id,
            id_pago: data[i].id_pago,
            fecha: data[i].fecha,
            hora: data[i].hora,
            total: data[i].total + " Lps"

        };
        result.push(Object.assign({}, data2));
    }





    function createHeaders(keys) {
        var result = [];
        for (var i = 0; i < keys.length; i += 1) {
            result.push({
                id: keys[i],
                name: keys[i],
                prompt: keys[i],
                width: 65,
                align: "left",
                padding: 0
            });
        }
        return result;
    }

    var headers = createHeaders([
        "id",
        "id_pago",
        "fecha",
        "hora",
        "total"
    ]);


    var doc = new jsPDF('p', 'mm', [400, 400]);
    doc.table(1, 1, result, headers, { autoSize: true });
    doc.setDisplayMode({ zoom: 1, layout: "continuous", pmode: "UseOutlines" });

    doc.save("" + $("#selectReporte").val() + ".pdf");

}


function reporteCitas(data) {


    var result = [];

    for (var i = 0; i < data.length; i++) {
        data2 = {
            id: data[i].id,
            nombre: data[i].nombre,
            email: data[i].email,
            telefono: data[i].telefono,
            fecha: data[i].fecha,
            estado: data[i].estado,
            comentario: data[i].comentario

        };
        result.push(Object.assign({}, data2));
    }





    function createHeaders(keys) {
        var result = [];
        for (var i = 0; i < keys.length; i += 1) {
            result.push({
                id: keys[i],
                name: keys[i],
                prompt: keys[i],
                width: 65,
                align: "left",
                padding: 0
            });
        }
        return result;
    }

    var headers = createHeaders([
        "id",
        "nombre",
        "email",
        "telefono",
        "fecha",
        "estado",
        "comentario"
    ]);


    var doc = new jsPDF('p', 'mm', [400, 400]);
    doc.table(1, 1, result, headers, { autoSize: true });
    doc.setDisplayMode({ zoom: 1, layout: "continuous", pmode: "UseOutlines" });

    doc.save("" + $("#selectReporte").val() + ".pdf");

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

function cargarEmpleados() {
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
                    "</td><td>" + this.dataCita[index].telefono +
                    "</td><td>" + this.dataCita[index].fecha +
                    "</td><td>" + this.dataCita[index].estado +
                    "</td><td>" + this.dataCita[index].comentario +
                    "</td><td><a href='#' onclick=con.SeleccionarCita('" + this.dataCita[index].id + "');><i class='material-icons orange-text'>edit</i></a></td></tr>"
                );

            }


        },);

}


function SeleccionarCita(id) {
    alert("Cita seleccionada:" + id);

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

function eliminarProducto(id) {


    var respuesta = confirm("El producto se va a eliminar. Desea continuar ?");

    if (respuesta) {
        $.post("./Clases/admin/eliminarProducto.php",
            { "id": id },
            function (data, status) {
                const result = JSON.parse(data);
                M.toast({ html: result[0].mensaje, classes: 'rounded', displayLength: 3000 });
            },
        );
        setTimeout(() => {
            this.cargarInventario();
        }, 1000);

    }



}

function eliminarServicio(id) {


    var respuesta = confirm("El servicio se va a eliminar. Desea continuar ?");

    if (respuesta) {
        $.post("./Clases/admin/eliminarServicio.php",
            { "id": id },
            function (data, status) {
                const result = JSON.parse(data);
                M.toast({ html: result[0].mensaje, classes: 'rounded', displayLength: 3000 });
            },
        );
        setTimeout(() => {
            this.cargarServicios();
        }, 1000);

    }



}


function editarEmpleado(id) {

    $.post("Clases/getEmpleadosById.php", {
        "id": id
    },
        function (data, status) {

            const emp = JSON.parse(data);
            $("#idEmpleadoM").val(emp[0].id);
            $("#empleadoName").val(emp[0].nombre);
            $("#empleadoEmail").val(emp[0].email);
            $("#telefonoEmpleado").val(emp[0].telefono);
        },
    );

}


function editarProducto(id) {

    $.post("Clases/getProductosById.php", {
        "id": id
    },
        function (data, status) {

            const prod = JSON.parse(data);
            $("#idproductoM").val(prod[0].id);
            $("#reporteNombre").val(prod[0].nombre);
            $("#reporteCant").val(prod[0].cantidad);
            $("#reportePrecio").val(prod[0].precio);
            $("#reporteDesc").val(prod[0].descripcion);
        },
    );

}

function editarServicio(id) {

    $.post("Clases/getServiciosById.php", {
        "id": id
    },
        function (data, status) {

            const serv = JSON.parse(data);
            $("#idServicioM").val(serv[0].id);
            $("#nombreServicio").val(serv[0].nombre);
            $("#precioServicio").val(serv[0].precio);
        },
    );

}

function editarServcioDB(){
    $.post("Clases/editarServicioByID.php", {
        id: $("#idServicioM").val(),
        nombre: $("#nombreServicio").val(),
        precio: $("#precioServicio").val()

    },
    
        function (data, status) {
            
                const result = JSON.parse(data);
                M.toast({ html: result[0].mensaje, classes: 'rounded', displayLength: 3000 });
                
                $("#idServicioM").val("Id servicio"),
                $("#nombreServicio").val("Nombre del servicio"),
                $("#precioServicio").val("0.00");
        
        },
    );

    setTimeout(() => {
        this.cargarServicios();
    }, 1000);

}



function editarEmpleadoDB(){
    $.post("Clases/editarEmpleadoDB.php", {
        id: $("#idEmpleadoM").val(),
        nombre: $("#empleadoName").val(),
        tel: $("#telefonoEmpleado").val(),
        email: $("#empleadoEmail").val()

    },
    
        function (data, status) {
            
            const result = JSON.parse(data);
            M.toast({ html: result[0].mensaje, classes: 'rounded', displayLength: 3000 });
            $("#idEmpleadoM").val("");
            $("#empleadoName").val("");
            $("#telefonoEmpleado").val("");
            $("#empleadoEmail").val("");
        
        },
    );

    setTimeout(() => {
        this.cargarEmpleados();
    }, 1000);

}









function eliminarEmpleado(id) {


    var respuesta = confirm("El empleado sera eliminado. Desea continuar ?");

    if (respuesta) {
        $.post("./Clases/admin/eliminarEmpleado.php",
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
                    "</td><td><a href='#' onclick=con.editarProducto('" + this.dataProd[index].id +
                    "')><i class='material-icons blue-text'>edit</i></a></td><td><a href='#' onclick=con.eliminarProductoDB('" + this.dataProd[index].id +
                    "');><i class='material-icons red-text'>delete</i></a></td></tr>");

            }

        },);

}



function cargarServicios() {
    $("#tablaServicios").html("");
    $.post("Clases/getServicio.php", null,
        function (data, status) {

            this.dataServ = JSON.parse(data);


            for (let index = 0; index < this.dataServ.length; index++) {
                $("#tablaServicios").append(
                    "<tr><td>" + this.dataServ[index].nombre +
                    "</td><td>" + this.dataServ[index].precio +
                    "</td><td><a href='#' onclick=con.editarServicio('" + this.dataServ[index].id +
                    "')><i class='material-icons blue-text'>edit</i></a></td><td><a href='#' onclick=con.eliminarServicio('" + this.dataServ[index].id +
                    "');><i class='material-icons red-text'>delete</i></a></td></tr>");

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

            $("#NuevoProducto").val("");
            $("#CantidadProducto").val("");
            $("#PrecioProducto").val("");
            $("#DescripcionProducto").val("");

        },
    );
}

function guardarEmpleado() {
    $.post("Clases/agregarEmpleado.php", {
        nombre: $("#NuevoEmpleado").val(),
        email: $("#NuevaEmail").val(),
        telefono: $("#NuevaTel").val(),


    },
        function (data, status) {

            const result = JSON.parse(data);
            M.toast({ html: result[0].mensaje, classes: 'rounded', displayLength: 3000 });

            $("#NuevoEmpleado").val("");
            $("#NuevaEmail").val("");
            $("#NuevaTel").val("");

        },
    );
}

function guardarServicio() {
    $.post("Clases/agregarServicio.php", {
        nombre: $("#NuevoServicio").val(),
        precio: $("#NuevaPrecio").val(),
        id_producto: $("#productos1").val(),

    },
        function (data, status) {

            const result = JSON.parse(data);
            M.toast({ html: result[0].mensaje, classes: 'rounded', displayLength: 3000 });
            
            $("#NuevoServicio").val("Nombre de servicio");
            $("#NuevaPrecio").val("0.00");
            $("#productos1").val("");

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
        id: $("#idServicioM").val(),
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
        id: $("#idproductoM").val(),
        nombre: $("#reporteNombre").val(),
        cantidad: $("#reporteCant").val(),
        precio: $("#reportePrecio").val(),
        descripcion: $("#reporteDesc").val(),

    },
        function (data2, status) {

            const result = JSON.parse(data2);
            M.toast({ html: result[0].mensaje, classes: 'rounded', displayLength: 3000 });

            $("#idproductoM").val("ID del producto");
            $("#reporteNombre").val("Nombre");
            $("#reporteCant").val("0");
            $("#reportePrecio").val("0.00");
            $("#reporteDesc").val("");

        },
    );

    setTimeout(() => {
        this.cargarInventario();
    }, 1000);

}

