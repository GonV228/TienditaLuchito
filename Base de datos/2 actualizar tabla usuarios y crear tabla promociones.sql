use tluchito;

alter table usuarios
add column Sueldo decimal(10,2);
-- hacer select a la tabla usuarios para verificar la creación de la columna Sueldo

select * from usuarios;
-- ok ahora que ya esta hay que hacer los inserts usando el sistema

-- creamos la tabla promociones
create table promociones(
ID_Promociones int auto_increment primary key,
NombrePromo varchar(225),
ID_Producto int,
PrecioPromo decimal(10,2),
Cantidad int,
FOREIGN KEY (ID_Producto) REFERENCES productos(ID_Producto) -- relacionamos promociones con productos
)

select p.Nombre from promociones pr
inner join productos p on p.ID_Producto=pr.ID_Producto;

select * from promociones;
select pr.NombrePromo,p.Nombre,pr.PrecioPromo,pr.Cantidad from promociones pr
inner join productos p on p.ID_Producto=pr.ID_Producto
where ID_Promociones=2;
