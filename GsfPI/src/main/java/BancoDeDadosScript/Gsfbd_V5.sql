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
  `Senha` varchar(20) NOT NULL,
  `Telefone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`CnpjFaccao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faccao`
--

LOCK TABLES `faccao` WRITE;
/*!40000 ALTER TABLE `faccao` DISABLE KEYS */;
INSERT INTO `faccao` VALUES (11111111111111,'f','f','f','123'),(11111111111112,'f','f@gmail.com','f','(47) 99999-9999'),(12245375000197,'Marcos','marcos@gmail.com','marcos','47923426789'),(12325467000107,'Marcos','Marcos@gmail.com','marcos','47999124578'),(12345546000106,'Marcos Aurelio','Marcos@gmail.com','marcos','47998703256'),(12345678901234,'Felipe','banana','banana',NULL),(13478924000196,'Artur Silva dos Santos','arturS@gmail.com','Artur','(47) 97486-7542'),(13965746000186,'Roberto Silva','roberto34@gmail.com','roberto','(47) 95378-0572'),(22222222222222,'f','felipe.w28@gmail.com','f','47999122334');
/*!40000 ALTER TABLE `faccao` ENABLE KEYS */;
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
  `Senha` varchar(20) NOT NULL,
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
INSERT INTO `fornecedor` VALUES (12123123123123,'Ana Maria','Ana@gmail.com','ana234','(47) 99745-5432','Rua Portugal '),(12321675486533,'Marcus Rogério','Rogerio@gmail.com','roger','(47) 99912-2334','Rua dali'),(13425673000156,'Bonifacio Almeida','Almeida@gmail.com','al123','(47) 994327593','Rua Santorion, nº 475'),(13536965000176,'Fausto Souza','faustos@gmail.com','faustao','(47) 99324-0865','Avenida das comunidades, nº 1147'),(13546893000175,'Pedro Silva','pedro@gmail.com','pedro','47568976342','Rua escandina'),(13549350000154,'Rafael Perreira','perreira1@gmail.com','Rafa','(47) 947289223','Rua alemanha, nº 81');
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
INSERT INTO `funcionario` VALUES (10087956734,'Eduardo Lopes','2006-04-24','(45) 98765-0943','EduLopes@gmail.com',8.50,'Costureira',NULL),(12378956076,'Alessandra M. Silva','2007-03-28','(28) 99876-7645','Silva@gmail.com',12.30,'Manual',NULL),(13342022906,'William Presley','1996-05-28','(47) 99674-8534','presley32@gmail.com',9.50,'Manual',NULL),(23465734576,'Romulo B. Arragão','2020-01-21','(67) 90765-8754','Beninga@gmail.com',13.00,'Costureira',NULL);
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
  CONSTRAINT `referenciaLote` FOREIGN KEY (`referenciaLote`) REFERENCES `lote` (`Referencia`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemlote`
--

LOCK TABLES `itemlote` WRITE;
/*!40000 ALTER TABLE `itemlote` DISABLE KEYS */;
INSERT INTO `itemlote` VALUES (1,1326,213,'1','Preto'),(2,1243,117,'P','Preto'),(3,1243,116,'G','Preto');
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
  `QuantidadeT` int NOT NULL,
  `NomeFornecedor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Referencia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lote`
--

LOCK TABLES `lote` WRITE;
/*!40000 ALTER TABLE `lote` DISABLE KEYS */;
INSERT INTO `lote` VALUES (1243,'2025-07-05','2025-07-01',2.40,'Algodão','Aluisio','Outono','Short',213,'Marcus Rogério'),(1326,'2025-07-11','2025-06-30',2.40,'algodão','Fantoni','Primavera','Blusa',235,'Pedro Silva'),(1453,'2025-07-10','2025-07-01',2.54,'Algodão','Gucci','Primavera','Blusa',243,'Bonifacio Almeida');
/*!40000 ALTER TABLE `lote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `perfil` (
  `CNPJ` bigint NOT NULL,
  `email` varchar(30) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `tipoPerfil` varchar(10) NOT NULL,
  PRIMARY KEY (`CNPJ`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil`
--

LOCK TABLES `perfil` WRITE;
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` VALUES (12321,'ff','f','Fornecedor'),(11111111111111,'f','f','Faccao'),(11111111111112,'f@gmail.com','f','Faccao'),(12123123123123,'Ana@gmail.com','ana234','Fornecedor'),(12245375000197,'marcos@gmail.com','marcos','Faccao'),(12321675486533,'Marcus Rogério','roger','Fornecedor'),(12325467000107,'Marcos@gmail.com','marcos','Faccao'),(12345546000106,'Marcos@gmail.com','marcos','Faccao'),(12345678901234,'banana','banana','Faccao'),(13425673000156,'Almeida@gmail.com','al123','Fornecedor'),(13478924000196,'arturS@gmail.com','Artur','Faccao'),(13536965000176,'faustos@gmail.com','faustao','Fornecedor'),(13546893000175,'pedro@gmail.com','pedro','Fornecedor'),(13549350000154,'perreira1@gmail.com','Rafa','Fornecedor'),(13965746000186,'roberto34@gmail.com','roberto','Faccao'),(22222222222222,'felipe.w28@gmail.com','f','Faccao');
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;
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
  `SalarioDoDia` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`idRegistroHora`),
  KEY `Cpf_idx` (`Cpf`),
  CONSTRAINT `Cpf` FOREIGN KEY (`Cpf`) REFERENCES `funcionario` (`Cpf`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registrohora`
--

LOCK TABLES `registrohora` WRITE;
/*!40000 ALTER TABLE `registrohora` DISABLE KEYS */;
INSERT INTO `registrohora` VALUES (0,10087956734,'2025-06-08','07:30:00','09:30:00','13:05:00','14:05:00','07:00:00',NULL,25.50),(1,10087956734,'2025-06-21','22:39:00','23:39:00',NULL,NULL,NULL,NULL,8.50),(2,13342022906,'2025-06-07','11:58:00',NULL,NULL,NULL,NULL,NULL,NULL),(3,13342022906,'2025-07-06','12:20:00','14:20:00','17:00:00','18:00:00',NULL,NULL,28.50);
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

-- Dump completed on 2025-07-06 15:16:09
