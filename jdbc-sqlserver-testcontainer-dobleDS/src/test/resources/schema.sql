CREATE DATABASE Configurations;
USE Configurations;

DROP TABLE IF EXISTS empleado;
CREATE TABLE empleado (
    id                  INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    legajo              VARCHAR(10) NOT NULL UNIQUE,
    nombre              VARCHAR(50) NOT NULL,
    apellido            VARCHAR(50) NOT NULL,
    sucursal            VARCHAR(4) NOT NULL,
    numero_documento    VARCHAR(10) NOT NULL,
    tipo_documento      VARCHAR(3) NOT NULL
);

CREATE DATABASE Operations;
USE Operations;

DROP TABLE IF EXISTS sucursal;
CREATE TABLE sucursal (
    id                  INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    codigo              VARCHAR(10) NOT NULL UNIQUE,
    descripcion         VARCHAR(50) NOT NULL
);
