-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: cruise_trade
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `country2`
--

DROP TABLE IF EXISTS `country2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country2` (
  `id` int NOT NULL AUTO_INCREMENT,
  `country_name` varchar(40) DEFAULT NULL,
  `nat_currency` varchar(40) DEFAULT NULL,
  `tax_rate` decimal(10,2) DEFAULT NULL,
  `port_name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country2`
--

LOCK TABLES `country2` WRITE;
/*!40000 ALTER TABLE `country2` DISABLE KEYS */;
INSERT INTO `country2` VALUES (1,'ANGUILLA','EC',13.00,'Sandy Ground'),(2,'USVI','USD',4.00,'Charlotte Amalie'),(3,'BVI','GBP',0.00,'Road Harbour'),(4,'ANTIGUA','EC',15.00,'St. Johns Harbour'),(5,'ST_KITTS','EC',10.00,'Port Zante'),(6,'MONTSERRAT','EC',5.00,'Little Bay'),(7,'GUADALOUPE','EUR',8.50,'Pointe-à-Pitre'),(8,'DOMINICA','EC',18.00,'Porte Roseau'),(9,'MARTINIQUE','EUR',8.50,'Forte De France'),(10,'ST_LUCIA','EC',12.50,'CASTRIES'),(11,'BARBADOS','BBD',12.50,'Port of Bridgetown'),(12,'ST_VINCENT','EC',16.00,'Kingstown Port'),(13,'TRINIDAD','TT',8.40,'Port-of-Spain');
/*!40000 ALTER TABLE `country2` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-09 16:22:23
