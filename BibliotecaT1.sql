CREATE DATABASE bibliotecat1_db;
USE bibliotecat1_db;

CREATE TABLE tbl_autor (
    id_autor INT AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(80) NOT NULL,
    apellidos VARCHAR(80) NOT NULL,
    nacionalidad VARCHAR(50)
);

CREATE TABLE tbl_categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(60) NOT NULL,
    descripcion VARCHAR(200)
);

CREATE TABLE tbl_libro (
    id_libro INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    isbn VARCHAR(20),
    anio_publicacion INT,
    stock_total INT NOT NULL DEFAULT 1,
    stock_disponible INT NOT NULL DEFAULT 1,
    id_autor INT NOT NULL,
    id_categoria INT NOT NULL,
    CONSTRAINT fk_libro_autor FOREIGN KEY (id_autor) REFERENCES tbl_autor(id_autor),
    CONSTRAINT fk_libro_categoria FOREIGN KEY (id_categoria) REFERENCES tbl_categoria(id_categoria)
);

CREATE TABLE tbl_socio (
    id_socio INT AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(80) NOT NULL,
    apellidos VARCHAR(80) NOT NULL,
    email VARCHAR(100) NOT NULL,
    tipo_socio VARCHAR(20) NOT NULL,        
    fecha_registro DATE NOT NULL,
    codigo_estudiante VARCHAR(20),          
    departamento VARCHAR(60)                
);

CREATE TABLE tbl_prestamo (
    id_prestamo INT AUTO_INCREMENT PRIMARY KEY,
    fecha_prestamo DATE NOT NULL,
    fecha_devolucion_esperada DATE NOT NULL,
    fecha_devolucion_real DATE,
    estado VARCHAR(20) NOT NULL DEFAULT 'ACTIVO',
    id_socio INT NOT NULL,
    id_libro INT NOT NULL,
    CONSTRAINT fk_prestamo_socio FOREIGN KEY (id_socio) REFERENCES tbl_socio(id_socio),
    CONSTRAINT fk_prestamo_libro FOREIGN KEY (id_libro) REFERENCES tbl_libro(id_libro)
);

SELECT *FROM tbl_autor;
SELECT *FROM tbl_categoria;
SELECT *FROM tbl_libro;
SELECT *FROM tbl_socio;
SELECT *FROM tbl_prestamo;

INSERT INTO tbl_prestamo (fecha_prestamo, fecha_devolucion_esperada, fecha_devolucion_real, estado, id_socio, id_libro)
VALUES ('2026-07-26', '2026-08-10', NULL, 'ACTIVO', 2, 2);