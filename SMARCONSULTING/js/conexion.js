class conexion{
    conexion(){
        this.dataUser2 = 0;
    }


 cargarUsuarios(){
    $("#tablaUsuarios").html("");
        $.post("Clases/getUsuarios.php", null,
            function (data, status) {
              
                 this.dataUser = JSON.parse(data);


                for (let index = 0; index < this.dataUser.length; index++) {
                    $("#tablaUsuarios").append("<tr><td>"+this.dataUser[index].username+"</td><td>"+this.dataUser[index].nombre+"</td><td>"+this.dataUser[index].tipo+"</td><td><a href='#' onclick=con.editarUsuario('"+this.dataUser[index].id+"');><i class='material-icons blue-text'>edit</i></a></td><td><a href='#' onclick=con.liminarUsuario('"+this.dataUser[index].id+"');><i class='material-icons red-text'>delete</i></a></td></tr>");
                
                  }

                
            },);
    
    }

    editarUsuario(id){

        $.post("Clases/getUsuariosById.php", {
            "id":id
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

    liminarUsuario(id){
        alert("Se va a eliminar el usuario:" + id);
    }

    actualizarUsuario(){
        
        $.post("Clases/setUsuariosById.php", {
            "id":$("#first_name9").val(),
            "username": $("#first_name3").val(),
            "password" : $("#first_name4").val(),
            "tipo" : $("#selecUsuario").val()
        },
            function (data, status) {

                const user = JSON.parse(data);
                    alert(user[0].mensaje);
            },
        );
    }
}