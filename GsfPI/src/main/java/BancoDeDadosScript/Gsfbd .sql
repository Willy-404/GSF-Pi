CREATE DATABASE  IF NOT EXISTS `gsf` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `gsf`;
-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: gsf
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cartaoponto`
--

DROP TABLE IF EXISTS `cartaoponto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cartaoponto` (
  `idCartaoPonto` int(11) NOT NULL AUTO_INCREMENT,
  `Mes` varchar(15) NOT NULL,
  `Cpf` char(14) NOT NULL,
  PRIMARY KEY (`idCartaoPonto`,`Cpf`),
  KEY `Cpf_idx` (`Cpf`),
  CONSTRAINT `Cpf` FOREIGN KEY (`Cpf`) REFERENCES `funcionario` (`Cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartaoponto`
--

LOCK TABLES `cartaoponto` WRITE;
/*!40000 ALTER TABLE `cartaoponto` DISABLE KEYS */;
/*!40000 ALTER TABLE `cartaoponto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `empresa` (
  `Cnpj` int(11) NOT NULL,
  `NomeEmpresa` varchar(45) NOT NULL,
  `Telefone` varchar(45) NOT NULL,
  `EmailContato` varchar(45) NOT NULL,
  `DataFundacao` varchar(45) NOT NULL,
  `idEndereco` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cnpj`),
  KEY `idEndereco_idx` (`idEndereco`),
  CONSTRAINT `idEndereco` FOREIGN KEY (`idEndereco`) REFERENCES `endereco` (`idEndereco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (515,'956','15','hujhuj','2020-10-10',NULL);
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `endereco` (
  `idEndereco` int(11) NOT NULL,
  `Cep` char(9) NOT NULL,
  `Rua` varchar(40) DEFAULT NULL,
  `Complemento` varchar(30) DEFAULT NULL,
  `Bairro` varchar(30) DEFAULT NULL,
  `Numero` int(11) NOT NULL,
  `Cidade` varchar(30) NOT NULL,
  `Estado` varchar(20) NOT NULL,
  PRIMARY KEY (`idEndereco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faccao`
--

DROP TABLE IF EXISTS `faccao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `faccao` (
  `CnpjFaccao` int(11) NOT NULL,
  `NomeRepreFaccao` varchar(30) NOT NULL,
  `EmailAcesso` varchar(30) NOT NULL,
  `Senha` varchar(10) NOT NULL,
  PRIMARY KEY (`CnpjFaccao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faccao`
--

LOCK TABLES `faccao` WRITE;
/*!40000 ALTER TABLE `faccao` DISABLE KEYS */;
INSERT INTO `faccao` VALUES (13945,'Felipe','banana','banana');
/*!40000 ALTER TABLE `faccao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `fornecedor` (
  `CnpjFornecedor` int(11) NOT NULL,
  `NomeRepreFornecedor` varchar(45) NOT NULL,
  `UsuarioFornecedor` varchar(30) NOT NULL,
  `Senha` varchar(10) NOT NULL,
  PRIMARY KEY (`CnpjFornecedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedor`
--

LOCK TABLES `fornecedor` WRITE;
/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `funcionario` (
  `Cpf` char(14) NOT NULL,
  `NomeFuncionario` varchar(30) NOT NULL,
  `DataNascimento` date NOT NULL,
  `Telefone` char(12) NOT NULL,
  `Email` varchar(40) NOT NULL,
  `ValorHora` decimal(4,2) NOT NULL,
  `Cargo` varchar(30) NOT NULL,
  `CnpjFaccao` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cpf`),
  KEY `CnpjFaccao_idx` (`CnpjFaccao`),
  CONSTRAINT `CnpjFaccao` FOREIGN KEY (`CnpjFaccao`) REFERENCES `faccao` (`CnpjFaccao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registrohora`
--

DROP TABLE IF EXISTS `registrohora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `registrohora` (
  `idRegistroHora` int(11) NOT NULL,
  `Data` date NOT NULL,
  `HorarioEntrada` time NOT NULL,
  `HorarioSaida` time NOT NULL,
  `idCartaoPonto` int(11) DEFAULT NULL,
  PRIMARY KEY (`idRegistroHora`),
  KEY `idCartaoPonto_idx` (`idCartaoPonto`),
  CONSTRAINT `idCartaoPonto` FOREIGN KEY (`idCartaoPonto`) REFERENCES `cartaoponto` (`idCartaoPonto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registrohora`
--

LOCK TABLES `registrohora` WRITE;
/*!40000 ALTER TABLE `registrohora` DISABLE KEYS */;
/*!40000 ALTER TABLE `registrohora` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-01  9:56:29
