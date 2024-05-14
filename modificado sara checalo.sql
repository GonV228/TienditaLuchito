
create database TLuchito;
use TLuchito;

	CREATE TABLE IF NOT EXISTS Categorias (
		ID_Categoria INT AUTO_INCREMENT PRIMARY KEY,
		NombreCat VARCHAR(255) NOT NULL UNIQUE
	);

	-- Productos
	CREATE TABLE IF NOT EXISTS Productos (
		ID_Producto INT AUTO_INCREMENT PRIMARY KEY,
		Nombre VARCHAR(255) NOT NULL,
		Stock INT NOT NULL,
		Informacion TEXT,
        Precio DECIMAL(10, 2),
		Imagen VARCHAR(255),
		ID_Categoria INT,
        
		FOREIGN KEY (ID_Categoria) REFERENCES Categorias(ID_Categoria)
	);
    select * from productos;
-- Insertar categorías de comestibles
INSERT INTO Categorias (NombreCat) VALUES ('Comestibles');

-- Insertar categorías de bebidas
INSERT INTO Categorias (NombreCat) VALUES ('Bebidas');

-- Insertar categorías de productos de limpieza
INSERT INTO Categorias (NombreCat) VALUES ('Productos de limpieza');

-- Insertar categorías de artículos de cuidado personal
INSERT INTO Categorias (NombreCat) VALUES ('Artículos de cuidado personal');
-- Insertamos un producto de la categoría "Comestibles"
INSERT INTO Productos (Nombre, Stock, Informacion, Precio, ID_Categoria)
VALUES ('Arroz', 100, 'Arroz blanco de grano largo', 2.99, 1); -- El ID de la categoría "Comestibles" es 1

-- Insertamos un producto de la categoría "Bebidas"
INSERT INTO Productos (Nombre, Stock, Informacion, Precio, ID_Categoria)
VALUES ('Agua mineral', 50, 'Agua mineral natural', 1.50, 2); -- El ID de la categoría "Bebidas" es 2

-- Insertamos un producto de la categoría "Productos de limpieza"
INSERT INTO Productos (Nombre, Stock, Informacion, Precio, ID_Categoria)
VALUES ('Detergente', 20, 'Detergente líquido para lavadora', 4.99, 3); -- El ID de la categoría "Productos de limpieza" es 3

-- Insertamos un producto de la categoría "Artículos de cuidado personal"
INSERT INTO Productos (Nombre, Stock, Informacion, Precio, ID_Categoria)
VALUES ('Champú', 30, 'Champú suave para todo tipo de cabello', 3.49, 4); -- El ID de la categoría "Artículos de cuidado personal" es 4

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
    Imagen LONGBLOB
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
INSERT INTO Usuarios (Nombres, Apellidos, Correo_Electronico, Contraseña, Rol, Tipo_Documento, N_Documento, Telefono, Imagen) 
VALUES 
('Admin1', 'Apellido1', 'admin1@example.com', 'admin123', 'Administrador', 'DNI', '12345678', '12345678', 'admin1.jpg'),
('Admin2', 'Apellido2', 'admin2@example.com', 'admin456', 'Administrador', 'DNI', '87654321', '98765432', 'admin2.jpg');

-- Insertar empleados
INSERT INTO Usuarios (Nombres, Apellidos, Correo_Electronico, Contraseña, Rol, Tipo_Documento, N_Documento, Telefono, Imagen) 
VALUES 
('Empleado1', 'Apellido1', 'empleado1@example.com', 'empleado123', 'Empleado', 'DNI', '11111111', '11111111', 'empleado1.jpg'),
('Empleado2', 'Apellido2', 'empleado2@example.com', 'empleado456', 'Empleado', 'DNI', '22222222', '22222222', 'empleado2.jpg'),
('Empleado3', 'Apellido3', 'empleado3@example.com', 'empleado789', 'Empleado', 'DNI', '33333333', '33333333', 'empleado3.jpg'),
('Empleado4', 'Apellido4', 'empleado4@example.com', 'empleado012', 'Empleado', 'DNI', '44444444', '44444444', 'empleado4.jpg');

select * from Usuarios;
