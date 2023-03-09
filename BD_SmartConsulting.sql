DROP DATABASE IF EXISTS smartconsultingbd;
CREATE DATABASE smartconsultingbd;
USE smartconsultingbd;


CREATE TABLE servicios (
    id INT(11) NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
	imagen_url VARCHAR(255),
    PRIMARY KEY (id),
    UNIQUE KEY (nombre)
);

CREATE TABLE usuarios (
    id INT(11) NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    rol ENUM('administrador', 'usuario') NOT NULL DEFAULT 'usuario',
    PRIMARY KEY (id),
    UNIQUE KEY (username)
);

CREATE TABLE citas (
    id INT(11) NOT NULL AUTO_INCREMENT,
    id_usuario INT(11) NOT NULL,
    id_servicio INT(11) NOT NULL,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    duracion INT(11) NOT NULL,
    estado ENUM('confirmada', 'cancelada', 'realizada') NOT NULL DEFAULT 'confirmada',
    comentario TEXT,
    PRIMARY KEY (id),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
    FOREIGN KEY (id_servicio) REFERENCES servicios(id)
);

/*
CREATE TABLE clientes (
    id INT(11) NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    email VARCHAR(50),
    telefono VARCHAR(20),
    direccion VARCHAR(100),
    preferencias TEXT,
    PRIMARY KEY (id)
);
*/

CREATE TABLE pagos (
    id INT(11) NOT NULL AUTO_INCREMENT,
    id_usuario INT(11) NOT NULL,
    id_cita INT(11) NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    forma_pago ENUM('efectivo', 'tarjeta_credito', 'tarjeta_debito', 'transferencia_bancaria') NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
    FOREIGN KEY (id_cita) REFERENCES citas(id)
);

CREATE TABLE empleados (
    id INT(11) NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    email VARCHAR(50),
    telefono VARCHAR(20),
    fecha_contratacion DATE NOT NULL,
    roles TEXT,
    PRIMARY KEY (id)
);

CREATE TABLE horarios (
    id INT(11) NOT NULL AUTO_INCREMENT,
    id_empleado INT(11) NOT NULL,
    dia_semana ENUM('lunes', 'martes', 'miercoles', 'jueves', 'viernes', 'sabado', 'domingo') NOT NULL,
    hora_inicio TIME NOT NULL,
    hora_fin TIME NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_empleado) REFERENCES empleados(id)
);

CREATE TABLE inventario (
    id INT(11) NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    cantidad INT(11) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    descripcion TEXT,
    PRIMARY KEY (id)
);
