DROP TABLE IF EXISTS empleado;
CREATE TABLE empleado (
    id BIGSERIAL PRIMARY KEY,
    legajo VARCHAR NOT NULL UNIQUE,
    nombre VARCHAR NOT NULL,
    apellido VARCHAR NOT NULL,
    sucursal VARCHAR NOT NULL,
    numero_documento VARCHAR NOT NULL,
    tipo_documento VARCHAR NOT NULL
);
