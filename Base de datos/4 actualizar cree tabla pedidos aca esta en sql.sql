use TLuchito;

CREATE TABLE pedidos (
    ID_Pedidos INT PRIMARY KEY NOT NULL,
    ID_Producto INT,
    Cantidad INT,
    CostoTotal DECIMAL(10,2),
    PrecioVenta DECIMAL(10,2),
    FechaPedido DATE,
    FechaEntrega DATE,
    Estado ENUM('En proceso', 'Recibido', 'Cancelado'),
    FOREIGN KEY (ID_Producto) REFERENCES productos(ID_Producto)
);
ALTER TABLE pedidos MODIFY COLUMN ID_Pedidos INT AUTO_INCREMENT ;

INSERT INTO pedidos (ID_Pedidos, ID_Producto, Cantidad, CostoTotal, PrecioVenta, FechaPedido, FechaEntrega, Estado)
VALUES (
    1,  -- ID_Pedidos
    (SELECT ID_Producto FROM productos WHERE Nombre = 'Carne de res'),  -- Subconsulta para obtener ID_Producto
    10,  -- Cantidad
    50,  -- CostoTotal
    200.00,  -- PrecioVenta
    '2024-07-15',  -- FechaPedido
    '2024-07-20',  -- FechaEntrega
    'En proceso'  -- Estado
);

select ID_Pedidos, p.ID_Producto, pr.Nombre ,Cantidad, CostoTotal, PrecioVenta, pr.Precio, FechaPedido, FechaEntrega, Estado from pedidos p
inner join productos pr on p.ID_Producto=pr.ID_Producto;

select * from productos;
select * from categorias;

