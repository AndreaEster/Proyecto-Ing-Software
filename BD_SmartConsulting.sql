DROP DATABASE IF EXISTS smartconsultingbd;
CREATE DATABASE smartconsultingbd;
USE smartconsultingbd;

CREATE TABLE empleados (
    id INT(11) NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    email VARCHAR(50),
    telefono VARCHAR(20),
    fecha_contratacion DATE NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE producto (
    id INT(11) NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    cantidad INT(11) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    descripcion TEXT,
    PRIMARY KEY (id)
);


CREATE TABLE servicios (
    id INT(11) NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    imagen_url VARCHAR(255),
    PRIMARY KEY (id),
    UNIQUE KEY (nombre)
);

CREATE TABLE imagenes (
  id int(11) NOT NULL AUTO_INCREMENT,
  nombre varchar(50) NOT NULL,
  url varchar(250) NOT NULL,
  PRIMARY KEY (id)
);



CREATE TABLE usuarios (
    id INT(11) NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    id_empleado INT(11) NOT NULL,
    rol ENUM('administrador', 'usuario', 'contador') NOT NULL DEFAULT 'usuario',
    img VARCHAR(250),
    PRIMARY KEY (id),
    UNIQUE KEY (username),
    FOREIGN KEY (id_empleado) REFERENCES empleados(id)
);

CREATE TABLE citas (
    id INT(11) NOT NULL AUTO_INCREMENT,
    id_usuario INT(11) NOT NULL,
    id_servicio INT(11) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    telefono VARCHAR(20),
    fecha DATE NOT NULL,
    dia VARCHAR(50) NOT NULL,
    estado ENUM('confirmada', 'cancelada', 'realizada') NOT NULL DEFAULT 'confirmada',
    comentario TEXT,
    PRIMARY KEY (id),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
    FOREIGN KEY (id_servicio) REFERENCES servicios(id)
);


CREATE TABLE pagos (
    id INT(11) NOT NULL AUTO_INCREMENT,
    id_usuario INT(11) NOT NULL,
    id_cita INT(11) NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    fecha DATETIME NOT NULL DEFAULT NOW(),
    forma_pago ENUM('efectivo', 'tarjeta_credito', 'tarjeta_debito') NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
    FOREIGN KEY (id_cita) REFERENCES citas(id)
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

CREATE TABLE servicios_por_cita (
    id INT(11) NOT NULL AUTO_INCREMENT,
    id_cita INT(11) NOT NULL,
    id_servicio INT(11) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_cita) REFERENCES citas(id),
    FOREIGN KEY (id_servicio) REFERENCES servicios(id)
);

CREATE TABLE productos_por_servicio (
    id INT(11) NOT NULL AUTO_INCREMENT,
    id_producto INT(11) NOT NULL,
    id_servicio INT(11) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_servicio) REFERENCES servicios(id),
    FOREIGN KEY (id_producto) REFERENCES producto(id)
);

CREATE TABLE producto_por_pago (
    id INT(11) NOT NULL AUTO_INCREMENT,
    id_pago INT(11) NOT NULL,
    id_producto INT(11) NOT NULL,
    cantidad INT(11) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_pago) REFERENCES pagos(id),
    FOREIGN KEY (id_producto) REFERENCES producto(id)
);

CREATE TABLE facturas (
    id INT(11) NOT NULL,
    id_pago INT(11) NOT NULL,
    fecha DATETIME NOT NULL DEFAULT NOW(),
    total DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_pago) REFERENCES pagos(id)
);

INSERT INTO imagenes (id, nombre, url) 
VALUES
(1, '1', './Assets/Carousel/1.jpg'),
(3, '3', './Assets/Carousel/3.jpg'),
(4, '4', './Assets/Carousel/4.jpg'),
(5, '5', './Assets/Carousel/5.jpg'),
(6, '6', './Assets/Carousel/6.jpg'),
(7, '7', './Assets/Carousel/7.jpg'),
(8, '8', './Assets/Carousel/8.jpg'),
(9, '9', './Assets/Carousel/9.jpg'),
(10, '10', './Assets/Carousel/10.jpg'),
(11, '11', './Assets/Carousel/11.jpg'),
(12, '12', './Assets/Carousel/12.jpg'),
(13, '13', './Assets/Carousel/13.jpg'),
(14, '14', './Assets/Carousel/14.jpg'),
(15, '15', './Assets/Carousel/15.jpg');

INSERT INTO empleados (nombre, email, telefono, fecha_contratacion)
VALUES 
('Online', 'Online@empresa.com', '9988-1234', '2022-01-01'),
('Juan Pérez', 'juan.perez@empresa.com', '9988-1234', '2022-01-01'),
('María García', 'maria.garcia@empresa.com', '9977-5678', '2022-01-02'),
('Pedro González', 'pedro.gonzalez@empresa.com', '9966-9012', '2022-01-03');

INSERT INTO horarios (id_empleado, dia_semana, hora_inicio, hora_fin)
VALUES 
(1, 'lunes', '0:00:01', '23:59:59'),

(2, 'lunes', '09:00:00', '17:00:00'),
(2, 'martes', '09:00:00', '17:00:00'),
(2, 'miercoles', '09:00:00', '17:00:00'),
(2, 'sabado', '10:00:00', '14:00:00'),
(2, 'domingo', '10:00:00', '14:00:00'),

(3, 'miercoles', '08:00:00', '16:00:00'),
(3, 'jueves', '08:00:00', '16:00:00'),
(3, 'viernes', '08:00:00', '16:00:00'),
(3, 'sabado', '09:00:00', '13:00:00'),
(3, 'domingo', '09:00:00', '13:00:00'),

(4, 'lunes', '09:00:00', '17:00:00'),
(4, 'martes', '09:00:00', '17:00:00'),
(4, 'sabado', '10:00:00', '14:00:00'),
(4, 'domingo', '10:00:00', '14:00:00');

INSERT INTO producto (nombre, cantidad, precio, descripcion)
VALUES 
('Tijeras de peluquería', 5, 150.00, 'Tijeras de acero inoxidable para cortar cabello.'),
('Cepillo de pelo', 10, 25.00, 'Cepillo redondo de cerdas naturales para alisar el cabello.'),
('Peine de cola', 7, 18.00, 'Peine de cola para seccionar el cabello y hacer peinados.'),
('Pinzas para el cabello', 20, 5.00, 'Pinzas de plástico para sujetar el cabello durante el corte o peinado.'),
('Capas de peluquería', 3, 20.00, 'Capas de nylon para proteger la ropa del cliente durante el corte de cabello.'),
('Rulos para cabello', 15, 10.00, 'Rulos de plástico para crear ondas o rizos en el cabello.'),
('Secador de pelo', 2, 1200.00, 'Secador de pelo profesional de alta potencia.'),
('Plancha de pelo', 2, 2200.00, 'Plancha para alisar el cabello de cerámica y turmalina.'),
('Tintes para cabello', 8, 250.00, 'Tintes semipermanentes para el cabello en diferentes tonos.'),
('Esmaletes', 20, 40.00, 'Esmaletes de colores.'),
('Acetona', 1, 300.00, 'Desmaquillador de uñas.'),
('Alicate', 6, 100.00, 'Corta unias de uso profesional.'),
('Algodon', 2, 400.00, 'Son Bolas de Algodon.'),
('Polimeros de unias', 3, 400.00, 'Polimero especializado en el decorado de uñas.');

INSERT INTO usuarios (username, password, id_empleado, rol) 
VALUES 
('admin', 'password123', 2, '1'),
('admin-online', 'pass123', 1,'2'),
('mg-corp1', 'pass456', 3, '3'),
('pg-corp2', 'pass567', '2');


INSERT INTO servicios (nombre, precio, imagen_url) 
VALUES 
('Corte de pelo', 50.00, null),
('manicura', 150.00, null),
('Pedicura', 250.00, null);


INSERT INTO productos_por_servicio (id_servicio, id_producto)
VALUES 
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(2, 10),
(2, 11),
(2, 13),
(3, 10),
(3, 11),
(3, 13);

