CREATE DATABASE ExamenRecuperacion;

USE ExamenRecuperacion;

CREATE TABLE usuarios (
  id_usuario INT PRIMARY KEY AUTO_INCREMENT,
  usuario VARCHAR(50) NOT NULL,
  password VARCHAR(255) NOT NULL,
  tipo_usuario ENUM('administrador', 'estudiante') NOT NULL
);

CREATE TABLE materias (
  id_materia INT PRIMARY KEY AUTO_INCREMENT,
  nombre_materia VARCHAR(100) NOT NULL,
  descripcion TEXT
);
INSERT INTO usuarios (usuario, password, tipo_usuario) VALUES ('EMorales','12345','administrador')