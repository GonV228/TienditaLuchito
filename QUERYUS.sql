use tluchito;
DROP TABLE usuarios;

CREATE TABLE Usuarios (
    ID_Empleado INT AUTO_INCREMENT PRIMARY KEY,
    Nombres VARCHAR(255),
    Apellidos VARCHAR(255),
    Correo_Electronico VARCHAR(255),
    Contraseña VARCHAR(255),
    Rol ENUM('Administrador','Empleado'),
    Tipo_Documento ENUM('DNI','Carnet de Extranjeria','Pasaporte'),
    N_Documento VARCHAR(20) UNIQUE,
    Telefono VARCHAR(20),
    Imagen LONGBLOB,
    Token VARCHAR(100)
);

select * from usuarios;