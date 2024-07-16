ALTER TABLE `tluchito`.`cliente` 
CHANGE COLUMN `ID_Cliente` `ID_Cliente` INT(11) NOT NULL AUTO_INCREMENT ,
CHANGE COLUMN `Tipo_Documento` `Tipo_Documento` ENUM('DNI', 'Carnet de Extranjeria', 'Pasaporte') NULL ;
