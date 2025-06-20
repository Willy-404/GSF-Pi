CREATE DATABASE  IF NOT EXISTS `gsf` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gsf`;
-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: gsf
-- ------------------------------------------------------
-- Server version	8.0.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `faccao`
--

DROP TABLE IF EXISTS `faccao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `faccao` (
  `CnpjFaccao` bigint NOT NULL,
  `NomeRepreFaccao` varchar(30) NOT NULL,
  `EmailAcesso` varchar(30) NOT NULL,
  `Senha` varchar(10) NOT NULL,
  `Telefone` varchar(20) DEFAULT NULL,
  `Perfil` varchar(10) NOT NULL,
  PRIMARY KEY (`CnpjFaccao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faccao`
--

LOCK TABLES `faccao` WRITE;
/*!40000 ALTER TABLE `faccao` DISABLE KEYS */;
INSERT INTO `faccao` VALUES (11111111111111,'f','f','f','123','Faccao'),(11111111111112,'f','f@gmail.com','f','(47) 99999-9999','Faccao'),(12345678901234,'Felipe','banana','banana',NULL,'Faccao');
/*!40000 ALTER TABLE `faccao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fluxos`
--

DROP TABLE IF EXISTS `fluxos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fluxos` (
  `idFluxos` int NOT NULL AUTO_INCREMENT,
  `EstadoProducao` varchar(20) NOT NULL,
  `Descricao` varchar(100) DEFAULT NULL,
  `DataHora` datetime NOT NULL,
  `Referencia` int NOT NULL,
  PRIMARY KEY (`idFluxos`,`Referencia`),
  KEY `Referencia_idx` (`Referencia`),
  CONSTRAINT `Referencia_fk` FOREIGN KEY (`Referencia`) REFERENCES `lote` (`Referencia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fluxos`
--

LOCK TABLES `fluxos` WRITE;
/*!40000 ALTER TABLE `fluxos` DISABLE KEYS */;
/*!40000 ALTER TABLE `fluxos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fornecedor` (
  `CnpjFornecedor` bigint NOT NULL,
  `NomeRepreFornecedor` varchar(45) NOT NULL,
  `UsuarioFornecedor` varchar(30) NOT NULL,
  `Senha` varchar(10) NOT NULL,
  `Contato` varchar(20) DEFAULT NULL,
  `endereco` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`CnpjFornecedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedor`
--

LOCK TABLES `fornecedor` WRITE;
/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
INSERT INTO `fornecedor` VALUES (12321,'felipe','ff','ff',NULL,NULL);
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `Cpf` bigint NOT NULL,
  `NomeFuncionario` varchar(30) NOT NULL,
  `DataNascimento` date NOT NULL,
  `Telefone` varchar(20) NOT NULL,
  `Email` varchar(40) NOT NULL,
  `ValorHora` decimal(4,2) NOT NULL,
  `Cargo` varchar(30) NOT NULL,
  `CnpjFaccao` bigint DEFAULT NULL,
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
INSERT INTO `funcionario` VALUES (10087956775,'lari','2020-05-20','(45) 98765-0943','Larissa@gmail.com',8.50,'Costureira',NULL),(12378956076,'felipe','2025-05-15','(28) 99876-7645','felipe@gmail.com',12.30,'Manual',NULL),(23465734576,'willian','2025-01-21','(67) 90765-8754','willian@gmail.com',13.00,'Costureira',NULL);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemlote`
--

DROP TABLE IF EXISTS `itemlote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itemlote` (
  `id` int NOT NULL AUTO_INCREMENT,
  `referenciaLote` int NOT NULL,
  `Quantidade` int NOT NULL,
  `Tamanho` varchar(45) NOT NULL,
  `Linha` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `referenciaLote_idx` (`referenciaLote`),
  CONSTRAINT `referenciaLote` FOREIGN KEY (`referenciaLote`) REFERENCES `lote` (`Referencia`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemlote`
--

LOCK TABLES `itemlote` WRITE;
/*!40000 ALTER TABLE `itemlote` DISABLE KEYS */;
INSERT INTO `itemlote` VALUES (1,12312313,500,'P','Azul'),(67,12,230,'PP','Preto');
/*!40000 ALTER TABLE `itemlote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lote`
--

DROP TABLE IF EXISTS `lote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lote` (
  `Referencia` int NOT NULL,
  `Prazo` date NOT NULL,
  `Entrada` date NOT NULL,
  `Preco` decimal(3,2) NOT NULL,
  `Tecido` varchar(30) NOT NULL,
  `Marca` varchar(30) NOT NULL,
  `Colecao` varchar(15) NOT NULL,
  `Modelo` varchar(30) NOT NULL,
  `CnpjFornecedor` bigint DEFAULT NULL,
  `QuantidadeT` int NOT NULL,
  PRIMARY KEY (`Referencia`),
  KEY `CnpjFornecedor_idx` (`CnpjFornecedor`),
  CONSTRAINT `CnpjFornecedor` FOREIGN KEY (`CnpjFornecedor`) REFERENCES `fornecedor` (`CnpjFornecedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lote`
--

LOCK TABLES `lote` WRITE;
/*!40000 ALTER TABLE `lote` DISABLE KEYS */;
INSERT INTO `lote` VALUES (12,'2025-06-05','2025-06-05',2.40,'Algoritmo','A','Inverno','Short',NULL,1233),(1234,'2025-06-26','2025-06-08',2.40,'Algodao','Alguem','Inverno','Short',NULL,460),(12344,'2025-07-02','2025-06-08',2.40,'A','A','Outono','Legging',NULL,1305),(12312313,'2222-12-22','2222-12-22',5.00,'oi','oi','oi','oi',12321,1230);
/*!40000 ALTER TABLE `lote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registrohora`
--

DROP TABLE IF EXISTS `registrohora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registrohora` (
  `idRegistroHora` int NOT NULL,
  `Cpf` bigint NOT NULL,
  `DataRegistro` date NOT NULL,
  `HorarioEntradaM` time DEFAULT NULL,
  `HorarioSaidaM` time DEFAULT NULL,
  `HorarioEntradaV` time DEFAULT NULL,
  `HorarioSaidaV` time DEFAULT NULL,
  `HorarioEntradaEx` time DEFAULT NULL,
  `HorarioSaidaEx` time DEFAULT NULL,
  PRIMARY KEY (`idRegistroHora`),
  KEY `Cpf_idx` (`Cpf`),
  CONSTRAINT `Cpf` FOREIGN KEY (`Cpf`) REFERENCES `funcionario` (`Cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registrohora`
--

LOCK TABLES `registrohora` WRITE;
/*!40000 ALTER TABLE `registrohora` DISABLE KEYS */;
INSERT INTO `registrohora` VALUES (0,10087956775,'2025-06-08','23:50:12','23:56:38',NULL,NULL,NULL,NULL);
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

-- Dump completed on 2025-06-21 22:13:15
