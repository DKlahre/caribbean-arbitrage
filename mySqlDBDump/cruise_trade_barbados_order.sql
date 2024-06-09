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
-- Table structure for table `barbados_order`
--

DROP TABLE IF EXISTS `barbados_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `barbados_order` (
  `id` int NOT NULL DEFAULT '0',
  `country` varchar(40) DEFAULT NULL,
  `provisioner` varchar(40) DEFAULT NULL,
  `item` varchar(40) DEFAULT NULL,
  `item_cost_nat` decimal(10,2) DEFAULT NULL,
  `item_cost_us` decimal(10,2) DEFAULT NULL,
  `quantity` int unsigned DEFAULT NULL,
  `item_total_cost_us` decimal(10,2) DEFAULT NULL,
  `purch_date` varchar(15) DEFAULT NULL,
  `all_items_cost` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `barbados_order`
--

LOCK TABLES `barbados_order` WRITE;
/*!40000 ALTER TABLE `barbados_order` DISABLE KEYS */;
INSERT INTO `barbados_order` VALUES (1,'Barbados','Barbados Prov. Inc.','Indio - 6 pack',22.00,10.78,0,0.00,'',0.00),(2,'Barbados','Barbados Prov. Inc.','Tecate - 6 pack',29.99,14.70,0,0.00,'',0.00),(3,'Barbados','Barbados Prov. Inc.','Dos Equis - 6 pack',31.95,15.66,0,0.00,'',0.00),(4,'Barbados','Barbados Prov. Inc.','Lagunitas - 6 pack',30.00,14.70,0,0.00,'',0.00),(5,'Barbados','Barbados Prov. Inc.','Carta Blanca - 6 pack',33.65,16.49,0,0.00,'',0.00),(6,'Barbados','Barbados Prov. Inc.','Pacifico Clara - 6 pack',33.46,16.40,0,0.00,'',0.00),(7,'Barbados','Barbados Prov. Inc.','Indio - 6 pack',28.86,14.14,0,0.00,'',0.00),(8,'Barbados','Barbados Prov. Inc.','Bohemia - 6 pack',29.00,14.21,0,0.00,'',0.00),(9,'Barbados','Barbados Prov. Inc.','Harpoon IPA - 6 pack',39.00,19.11,0,0.00,'',0.00),(10,'Barbados','Barbados Prov. Inc.','Blue Moon - 6 pack',37.98,18.61,0,0.00,'',0.00),(11,'Barbados','Barbados Prov. Inc.','Night Shift - 6 pack',41.00,20.09,0,0.00,'',0.00),(12,'Barbados','Barbados Prov. Inc.','LandShark - 6 pack',37.99,18.62,0,0.00,'',0.00),(13,'Barbados','Barbados Prov. Inc.','Odell IPA - 6 pack',35.99,17.64,0,0.00,'',0.00);
/*!40000 ALTER TABLE `barbados_order` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-09 16:22:22
