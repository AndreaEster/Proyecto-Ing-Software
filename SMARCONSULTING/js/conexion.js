class conexion {
    conexion() {
        this.dataUser2 = 0;
    }


    cargarUsuarios() {
        $("#tablaUsuarios").html("");
        $.post("Clases/getUsuarios.php", null,
            function (data, status) {

                this.dataUser = JSON.parse(data);


                for (let index = 0; index < this.dataUser.length; index++) {
                    $("#tablaUsuarios").append("<tr><td>" + this.dataUser[index].username + "</td><td>" + this.dataUser[index].nombre + "</td><td>" + this.dataUser[index].tipo + "</td><td><a href='#' onclick=con.editarUsuario('" + this.dataUser[index].id + "');><i class='material-icons blue-text'>edit</i></a></td><td><a href='#' onclick=con.liminarUsuario('" + this.dataUser[index].id + "');><i class='material-icons red-text'>delete</i></a></td></tr>");

                }


            },);

    }

    editarUsuario(id) {

        $.post("Clases/getUsuariosById.php", {
            "id": id
        },
            function (data, status) {

                const user = JSON.parse(data);

                $("#first_name9").val(user[0].id);
                $("#first_name3").val(user[0].username);
                $("#selecUsuario").val(user[0].tipo);
                $("#first_name4").val(user[0].username);
                $("#first_name5").val(user[0].password);
            },
        );


        /**
         * 
         *  
         * 
         * 
         */


    }

    liminarUsuario(id) {
        alert("Se va a eliminar el usuario:" + id);
    }

    actualizarUsuario() {

        $.post("Clases/setUsuariosById.php", {
            "id": $("#first_name9").val(),
            "username": $("#first_name3").val(),
            "password": $("#first_name4").val(),
            "tipo": $("#selecUsuario").val()
        },
            function (data, status) {

                const user = JSON.parse(data);
                alert(user[0].mensaje);
            },
        );
    }

    cargarInventario() {
        $("#tablaInventario").html("");
        $.post("Clases/getInventario.php", null,
            function (data, status) {

                this.dataProd = JSON.parse(data);


                for (let index = 0; index < this.dataProd.length; index++) {
                    $("#tablaInventario").append("<tr><td>" + this.dataProd[index].nombre + "</td><td>" + this.dataProd[index].cantidad + "</td><td>" + this.dataProd[index].precio + "<td><td>" + this.dataProd[index].descripcion + "</td><td><a href='#'><i class='material-icons blue-text'>edit</i></a></td><td><a href='#'><i class='material-icons red-text'>delete</i></a></td></tr>");

                }


            },);

    }



    cargarServicios() {
        $("#tablaServicios").html("");
        $.post("Clases/getServicio.php", null,
            function (data, status) {

                this.dataServ = JSON.parse(data);


                for (let index = 0; index < this.dataServ.length; index++) {
                    $("#tablaServicios").append("<tr><td>" + this.dataServ[index].nombre + "</td><td>" + this.dataServ[index].precio + "</td><td><a href='#'><i class='material-icons blue-text'>edit</i></a></td><td><a href='#'><i class='material-icons red-text'>delete</i></a></td></tr>");

                }


            },);

    }



}