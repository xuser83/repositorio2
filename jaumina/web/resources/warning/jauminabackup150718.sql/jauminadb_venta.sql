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
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) DEFAULT NULL,
  `cliente` varchar(100) DEFAULT NULL,
  `costo` int(11) DEFAULT NULL,
  `destino` varchar(3) DEFAULT NULL,
  `direccionAEntregar` varchar(255) DEFAULT NULL,
  `entregado` varchar(3) DEFAULT NULL,
  `fecha_Venta` datetime NOT NULL,
  `nroPedido` int(11) DEFAULT NULL,
  `salsa` varchar(255) DEFAULT NULL,
  `telefonoCliente` varchar(30) DEFAULT NULL,
  `ventacancelada` varchar(2) DEFAULT NULL,
  `id_produto` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4EB7A2CBBFF018B` (`id_produto`),
  CONSTRAINT `FK4EB7A2CBBFF018B` FOREIGN KEY (`id_produto`) REFERENCES `productosventa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=177 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (150,10,'Cliente 4 Apellido4',6000,'d','direccion 4','si','2017-04-30 18:32:48',1,'ajo, tomate','4444444','no',1),(151,10,'Mario Adalberto Acosta Amarilla',6000,'d','Calle 5 al lado de la comisaria. barrio obrero, en frente de la iglesia, al costado de la plaza, a una cuadra de la escuela.','no','2017-05-07 21:45:26',2,'ajo, tomate','0971 111 110','no',1),(152,4,'Cliente 4 Apellido4',12000,'d','direccion 4','no','2017-05-07 21:46:13',2,'ajo, tomate','4444444','si',3),(153,3,'Cliente 4 Apellido4',5500,'d','direccion 4','si','2017-05-07 21:46:16',2,'ajo, tomate','4444444','no',2),(154,10,'Cliente 5 Apellidos 5',6000,'d','direccion5','si','2017-09-27 21:06:54',3,'','55555555','no',1),(155,5,'Cliente 5 Apellidos 5',5500,'d','direccion5','si','2017-09-27 21:07:02',3,'','55555555','no',2),(156,2,'Diego Manuel Benítez Enciso',6000,'d','Calle Alonso casi Mexico','si','2018-06-23 15:49:37',4,'mayo sab','0971 555 111','no',1),(157,2,'Diego Manuel Benítez Enciso',5500,'d','Calle Alonso casi Mexico','si','2018-06-23 15:50:03',4,'mayo sab','0971 555 111','no',2),(158,2,'',6900,'d','','si','2018-06-24 19:15:25',5,'kkk',NULL,'no',1),(159,1,'Silvia Daniela Vargas Peña',6900,'d','Dirección 4','si','2018-06-24 19:27:41',6,'','0971 444 444','no',1),(160,3,'Silvia Daniela Vargas Peña',5500,'d','Dirección 4','si','2018-06-24 19:27:48',6,'','0971 444 444','no',2),(161,2,'Mirian Dana Britez Caceres',6900,'d','Calle Azara c Independencia Nacional - Rejas Verdes - al costado de la Iglesia - Entrar sobre el primer muro.','si','2018-06-24 19:32:38',7,'','0972 222 222','no',1),(162,1,'Milton David Alvares Armoa',6900,'d','Calle 58 - Frente a Copetrol','si','2018-06-24 19:40:01',8,'','0971 777 777','no',1),(163,2,'Mirian Dana Britez Caceres',6900,'d','Calle Azara c Independencia Nacional - Rejas Verdes - al costado de la Iglesia - Entrar sobre el primer muro.','si','2018-06-24 19:44:00',9,'','0972 222 222','no',1),(164,2,'Cecilia Maria Bus Colmena',5500,'d','Tte. Fossatti - Casi Las Residentas','si','2018-06-24 19:45:07',10,'','0972 999 999','no',2),(165,3,'Diego Manuel Benítez Enciso',5500,'d','Calle Alonso casi Mexico','no','2018-06-24 19:46:11',11,'','0971 555 111','no',2),(166,2,'Silvia Daniela Vargas Peña',6900,'d','Dirección 4','si','2018-06-24 22:54:12',12,'','0971 444 444','no',1),(167,2,'Silvia Daniela Vargas Peña',5500,'d','Dirección 4','si','2018-06-24 22:54:27',12,'','0971 444 444','no',2),(168,1,'Mirian Dana Britez Caceres',6900,'d','Calle Azara c Independencia Nacional - Rejas Verdes - al costado de la Iglesia - Entrar sobre el primer muro.','no','2018-06-24 22:55:11',12,'','0972 222 222','si',1),(169,1,'Diego Manuel Benítez Enciso',6900,'d','Calle Alonso casi Mexico','no','2018-06-24 22:56:52',12,'','0971 555 111','si',1),(170,1,'Milton David Alvares Armoa',6900,'d','Calle 58 - Frente a Copetrol','si','2018-06-24 22:57:12',12,'','0971 777 777','no',1),(171,1,'Milton David Alvares Armoa',19000,'d','Calle 58 - Frente a Copetrol','si','2018-06-24 22:57:33',12,'','0971 777 777','no',5),(172,2,'Cecilia Maria Bus Colmena',12000,'d','Tte. Fossatti - Casi Las Residentas','no','2018-06-24 22:58:17',12,'','0972 999 999','si',3),(173,4,'Cecilia Maria Bus Colmena',6900,'d','Tte. Fossatti - Casi Las Residentas','si','2018-06-24 22:59:51',13,'','0972 999 999','no',1),(174,2,'Cecilia Maria Bus Colmena',5500,'d','Tte. Fossatti - Casi Las Residentas','si','2018-06-24 22:59:58',13,'','0972 999 999','no',2),(175,1,'Marcos Aurelio Eno Pros',6900,'d','Dirección 3','no','2018-06-24 23:00:15',13,'','0973 333 333','no',1),(176,5,'Silvia Daniela Vargas Peña',6000,'d','Dirección 4','no','2018-06-24 23:00:31',13,'','0971 444 444','no',4);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-15 20:18:54
