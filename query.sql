create database TLuchito;
use TLuchito;

CREATE TABLE IF NOT EXISTS Categorias (
    ID_Categoria INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(255) NOT NULL UNIQUE
);

-- Productos
CREATE TABLE IF NOT EXISTS Productos (
    ID_Producto INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(255) NOT NULL,
    Codigo VARCHAR(50) NOT NULL UNIQUE,
    Sub_categoria VARCHAR(50),
    Stock INT NOT NULL,
    Informacion TEXT,
    Imagen VARCHAR(255),
    ID_Categoria INT,
    FOREIGN KEY (ID_Categoria) REFERENCES Categorias(ID_Categoria)
);

-- Ventas
CREATE TABLE IF NOT EXISTS Ventas (
    ID_Venta INT AUTO_INCREMENT PRIMARY KEY,
    ID_Producto INT NOT NULL,
    Fecha DATE NOT NULL,
    Hora TIME NOT NULL,
    Cantidad INT NOT NULL,
    Precio_Unitario DECIMAL(10, 2) NOT NULL,
    Total DECIMAL(10, 2) NOT NULL,
    Tipo_Comprobante ENUM('Boleta', 'Factura') NOT NULL,
    FOREIGN KEY (ID_Producto) REFERENCES Productos(ID_Producto)
);

-- Boletas
CREATE TABLE IF NOT EXISTS Boletas (
    ID_Boleta INT AUTO_INCREMENT PRIMARY KEY,
    ID_Venta INT NOT NULL,
    Fecha DATE NOT NULL,
    Hora TIME NOT NULL,
    Total DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (ID_Venta) REFERENCES Ventas(ID_Venta)
);

-- Facturas
CREATE TABLE IF NOT EXISTS Facturas (
    ID_Factura INT AUTO_INCREMENT PRIMARY KEY,
    ID_Venta INT NOT NULL,
    Fecha DATE NOT NULL,
    Hora TIME NOT NULL,
    Total DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (ID_Venta) REFERENCES Ventas(ID_Venta)
);

-- Empleados
CREATE TABLE IF NOT EXISTS Usuarios (
    ID_Empleado INT AUTO_INCREMENT PRIMARY KEY,
    Nombres VARCHAR(255) NOT NULL,
    Apellidos VARCHAR(255) NOT NULL,
    Correo_Electronico VARCHAR(255) NOT NULL UNIQUE,
    Contraseña VARCHAR(255) NOT NULL,
    Rol ENUM('Administrador', 'Empleado') NOT NULL,
    Tipo_Documento ENUM('DNI', 'Carnet de Extranjeria', 'Pasaporte') NOT NULL,
    N_Documento VARCHAR(20),
    Telefono VARCHAR(20),
    Imagen VARCHAR(255),
    Token VARCHAR(100)
);

-- Informes
CREATE TABLE IF NOT EXISTS Informes (
    ID_Informe INT AUTO_INCREMENT PRIMARY KEY,
    Fecha_Generacion DATE NOT NULL,
    Tipo ENUM('diario', 'semanal', 'mensual', 'anual') NOT NULL,
    Contenido TEXT,
    ID_Venta INT,
    FOREIGN KEY (ID_Venta) REFERENCES Ventas(ID_Venta)
);

-- Insertar administradores
INSERT INTO Usuarios (Nombres, Apellidos, Correo_Electronico, Contraseña, Rol, Tipo_Documento, N_Documento, Telefono, Imagen, Token) 
VALUES 
('Admin1', 'Apellido1', 'admin1@example.com', 'admin123', 'Administrador', 'DNI', '12345678', '12345678', 'admin1.jpg', 'token1'),
('Admin2', 'Apellido2', 'admin2@example.com', 'admin456', 'Administrador', 'DNI', '87654321', '98765432', 'admin2.jpg', 'token2');

-- Insertar empleados
INSERT INTO Usuarios (Nombres, Apellidos, Correo_Electronico, Contraseña, Rol, Tipo_Documento, N_Documento, Telefono, Imagen, Token) 
VALUES 
('Empleado1', 'Apellido1', 'empleado1@example.com', 'empleado123', 'Empleado', 'DNI', '11111111', '11111111', 'empleado1.jpg', 'token1'),
('Empleado2', 'Apellido2', 'empleado2@example.com', 'empleado456', 'Empleado', 'DNI', '22222222', '22222222', 'empleado2.jpg', 'token2'),
('Empleado3', 'Apellido3', 'empleado3@example.com', 'empleado789', 'Empleado', 'DNI', '33333333', '33333333', 'empleado3.jpg', 'token3'),
('Empleado4', 'Apellido4', 'empleado4@example.com', 'empleado012', 'Empleado', 'DNI', '44444444', '44444444', 'empleado4.jpg', 'token4');
