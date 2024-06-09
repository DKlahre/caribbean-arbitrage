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
-- Table structure for table `barb_toiletry`
--

DROP TABLE IF EXISTS `barb_toiletry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `barb_toiletry` (
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
-- Dumping data for table `barb_toiletry`
--

LOCK TABLES `barb_toiletry` WRITE;
/*!40000 ALTER TABLE `barb_toiletry` DISABLE KEYS */;
INSERT INTO `barb_toiletry` VALUES (1,'Martinique','Produits Du Matin','King Size Bed Sheet Set(W) ',90.00,0.00,0,0.00,'',0.00),(2,'Martinique','Produits Du Matin','Bath Towel(W) - 24 x 50',51.95,0.00,0,0.00,'',0.00),(3,'Martinique','Produits Du Matin','Coffee Filters - 20 pack ',9.76,0.00,0,0.00,'',0.00),(4,'Martinique','Produits Du Matin','Safety Razors - 10 pack ',13.95,0.00,0,0.00,'',0.00),(5,'Martinique','Produits Du Matin','Anihana Shampoo 8.46 oz',12.34,0.00,0,0.00,'',0.00),(6,'Martinique','Produits Du Matin','Jabon del Tio Soap',4.97,0.00,0,0.00,'',0.00),(7,'Martinique','Produits Du Matin','Vibora Soap',5.25,0.00,0,0.00,'',0.00),(8,'Martinique','Produits Du Matin','Azufre Jabon Soap',5.55,0.00,0,0.00,'',0.00),(9,'Martinique','Produits Du Matin','Diablo Toilet Paper - single',5.62,0.00,0,0.00,'',0.00);
/*!40000 ALTER TABLE `barb_toiletry` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-09 16:22:24
