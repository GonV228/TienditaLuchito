use TLuchito;

-- -----------------------------------------------------
-- Table `mydb`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cliente` (
  `ID_Cliente` INT NOT NULL,
  `Nombres` VARCHAR(225) NOT NULL,
  `Apellidos` VARCHAR(225) NOT NULL,
  `Tipo_Documento` ENUM('DNI', 'Carnet de Extranjeria', 'Pasaporte') NOT NULL,
  `N_Documento` VARCHAR(20) NOT NULL,
  `Edad` INT NULL,
  `Genero` ENUM('F', 'M') NULL,
  `Telefono` VARCHAR(20) NULL,
  `Correo_Electronico` VARCHAR(225) NULL,
  PRIMARY KEY (`ID_Cliente`))
ENGINE = InnoDB;
  
  -- -----------------------------------------------------
-- Table `mydb`.`proveedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`proveedores` (
  `ID_Proveedores` INT NOT NULL,
  `Razon_Social` VARCHAR(225) NOT NULL,
  `RUC` VARCHAR(15) NOT NULL,
  `Direccion` VARCHAR(225) NOT NULL,
  `Pag_web` VARCHAR(225) NOT NULL,
  `N_Cuenta` VARCHAR(25) NOT NULL,
  `Nombre_Banco` VARCHAR(225) NOT NULL,
  `Telefono` VARCHAR(15) NOT NULL,
  `Correo_Electronico` VARCHAR(225) NOT NULL,
  PRIMARY KEY (`ID_Proveedores`))
  ENGINE = InnoDB;