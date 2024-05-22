-- actualizar la tabla productos para que acepte bytes en imagen
use tluchito;

ALTER TABLE productos MODIFY Imagen LONGBLOB;

