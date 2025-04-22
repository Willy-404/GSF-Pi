-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema gsf
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gsf
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gsf` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `gsf` ;

-- -----------------------------------------------------
-- Table `gsf`.`faccao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gsf`.`faccao` (
  `CnpjFaccao` BIGINT(14) NOT NULL,
  `NomeRepreFaccao` VARCHAR(30) NOT NULL,
  `EmailAcesso` VARCHAR(30) NOT NULL,
  `Senha` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`CnpjFaccao`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gsf`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gsf`.`funcionario` (
  `Cpf` CHAR(14) NOT NULL,
  `NomeFuncionario` VARCHAR(30) NOT NULL,
  `DataNascimento` DATE NOT NULL,
  `Telefone` CHAR(12) NOT NULL,
  `Email` VARCHAR(40) NOT NULL,
  `ValorHora` DECIMAL(4,2) NOT NULL,
  `Cargo` VARCHAR(30) NOT NULL,
  `CnpjFaccao` BIGINT(14) NULL DEFAULT NULL,
  PRIMARY KEY (`Cpf`),
  INDEX `CnpjFaccao_idx` (`CnpjFaccao` ASC) VISIBLE,
  CONSTRAINT `CnpjFaccao`
    FOREIGN KEY (`CnpjFaccao`)
    REFERENCES `gsf`.`faccao` (`CnpjFaccao`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gsf`.`cartaoponto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gsf`.`cartaoponto` (
  `idCartaoPonto` INT(11) NOT NULL AUTO_INCREMENT,
  `Mes` VARCHAR(15) NOT NULL,
  `Cpf` CHAR(14) NOT NULL,
  PRIMARY KEY (`idCartaoPonto`, `Cpf`),
  INDEX `Cpf_idx` (`Cpf` ASC) VISIBLE,
  CONSTRAINT `Cpf`
    FOREIGN KEY (`Cpf`)
    REFERENCES `gsf`.`funcionario` (`Cpf`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gsf`.`fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gsf`.`fornecedor` (
  `CnpjFornecedor` BIGINT(14) NOT NULL,
  `NomeRepreFornecedor` VARCHAR(45) NOT NULL,
  `UsuarioFornecedor` VARCHAR(30) NOT NULL,
  `Senha` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`CnpjFornecedor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gsf`.`lote`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gsf`.`lote` (
  `Referencia` INT(11) NOT NULL,
  `Prazo` DATETIME NOT NULL,
  `Entrada` DATETIME NOT NULL,
  `Saida` DATETIME NOT NULL,
  `Preco` DECIMAL(3,2) NOT NULL,
  `Tecido` VARCHAR(30) NOT NULL,
  `MarcaLote` VARCHAR(30) NOT NULL,
  `Colecao` VARCHAR(15) NOT NULL,
  `Modelo` VARCHAR(30) NOT NULL,
  `CnpjFornecedor` BIGINT(14) NULL DEFAULT NULL,
  PRIMARY KEY (`Referencia`),
  INDEX `CnpjFornecedor_idx` (`CnpjFornecedor` ASC) VISIBLE,
  CONSTRAINT `CnpjFornecedor`
    FOREIGN KEY (`CnpjFornecedor`)
    REFERENCES `gsf`.`fornecedor` (`CnpjFornecedor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gsf`.`conjuntopecas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gsf`.`conjuntopecas` (
  `idConjuntoPecas` INT(11) NOT NULL AUTO_INCREMENT,
  `Quantidade` INT(11) NOT NULL,
  `Tamanho` CHAR(3) NOT NULL,
  `Cor` VARCHAR(30) NOT NULL,
  `Referencia` INT(11) NOT NULL,
  PRIMARY KEY (`idConjuntoPecas`, `Referencia`),
  INDEX `Referencia_idx` (`Referencia` ASC) VISIBLE,
  CONSTRAINT `Referencia`
    FOREIGN KEY (`Referencia`)
    REFERENCES `gsf`.`lote` (`Referencia`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gsf`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gsf`.`endereco` (
  `idEndereco` INT(11) NOT NULL,
  `Cep` CHAR(9) NOT NULL,
  `Rua` VARCHAR(40) NULL DEFAULT NULL,
  `Complemento` VARCHAR(30) NULL DEFAULT NULL,
  `Bairro` VARCHAR(30) NULL DEFAULT NULL,
  `Numero` INT(11) NOT NULL,
  `Cidade` VARCHAR(30) NOT NULL,
  `Estado` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idEndereco`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gsf`.`empresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gsf`.`empresa` (
  `Cnpj` BIGINT(14) NOT NULL,
  `NomeEmpresa` VARCHAR(45) NOT NULL,
  `Telefone` VARCHAR(45) NOT NULL,
  `EmailContato` VARCHAR(45) NOT NULL,
  `DataFundacao` VARCHAR(45) NOT NULL,
  `idEndereco` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`Cnpj`),
  INDEX `idEndereco_idx` (`idEndereco` ASC) VISIBLE,
  CONSTRAINT `idEndereco`
    FOREIGN KEY (`idEndereco`)
    REFERENCES `gsf`.`endereco` (`idEndereco`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gsf`.`fluxos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gsf`.`fluxos` (
  `idFluxos` INT(11) NOT NULL AUTO_INCREMENT,
  `EstadoProducao` VARCHAR(20) NOT NULL,
  `Descricao` VARCHAR(100) NULL DEFAULT NULL,
  `DataHora` DATETIME NOT NULL,
  `Referencia` INT(11) NOT NULL,
  PRIMARY KEY (`idFluxos`, `Referencia`),
  INDEX `Referencia_idx` (`Referencia` ASC) VISIBLE,
  CONSTRAINT `Referencia_fk`
    FOREIGN KEY (`Referencia`)
    REFERENCES `gsf`.`lote` (`Referencia`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gsf`.`linhas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gsf`.`linhas` (
  `RefLinha` INT(11) NOT NULL,
  `MarcaLinha` VARCHAR(30) NULL DEFAULT NULL,
  `TipoLinha` VARCHAR(20) NOT NULL,
  `idConjuntoPecas` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`RefLinha`),
  INDEX `idConjuntoPecas_idx` (`idConjuntoPecas` ASC) VISIBLE,
  CONSTRAINT `idConjuntoPecas`
    FOREIGN KEY (`idConjuntoPecas`)
    REFERENCES `gsf`.`conjuntopecas` (`idConjuntoPecas`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gsf`.`registrohora`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gsf`.`registrohora` (
  `idRegistroHora` INT(11) NOT NULL,
  `Data` DATE NOT NULL,
  `HorarioEntrada` TIME NOT NULL,
  `HorarioSaida` TIME NOT NULL,
  `idCartaoPonto` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idRegistroHora`),
  INDEX `idCartaoPonto_idx` (`idCartaoPonto` ASC) VISIBLE,
  CONSTRAINT `idCartaoPonto`
    FOREIGN KEY (`idCartaoPonto`)
    REFERENCES `gsf`.`cartaoponto` (`idCartaoPonto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
