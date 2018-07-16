CREATE DATABASE  IF NOT EXISTS `jauminadb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `jauminadb`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: jauminadb
-- ------------------------------------------------------
-- Server version	5.5.60

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `venta1`
--

DROP TABLE IF EXISTS `venta1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venta1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `destino` varchar(3) DEFAULT NULL,
  `direccionAEntregar` varchar(255) DEFAULT NULL,
  `entregado` varchar(3) DEFAULT NULL,
  `fecha_Venta` datetime NOT NULL,
  `id_cliente` bigint(20) DEFAULT NULL,
  `id_delivery` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9883CB85C819B9E4` (`id_cliente`),
  KEY `FK9883CB856635E8E` (`id_delivery`),
  CONSTRAINT `FK9883CB856635E8E` FOREIGN KEY (`id_delivery`) REFERENCES `delivery` (`id`),
  CONSTRAINT `FK9883CB85C819B9E4` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=142 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta1`
--

LOCK TABLES `venta1` WRITE;
/*!40000 ALTER TABLE `venta1` DISABLE KEYS */;
/*!40000 ALTER TABLE `venta1` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-15 20:19:01
