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
-- Table structure for table `product2`
--

DROP TABLE IF EXISTS `product2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product2` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(40) DEFAULT NULL,
  `product_description` varchar(40) DEFAULT NULL,
  `product_price` decimal(10,2) DEFAULT NULL,
  `country_id` int unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product2`
--

LOCK TABLES `product2` WRITE;
/*!40000 ALTER TABLE `product2` DISABLE KEYS */;
INSERT INTO `product2` VALUES (1,'Bulgar Wheat - Medium Grind','521344654762',20.95,1),(2,'Yellow Cornmeal - Medium Grind','503899122653',22.98,1),(3,'Machete - Stainless Steel 15 inch','385096579122',47.20,1),(4,'Tire - Bridgestone - 195/65R15','798501223965',120.95,2),(5,'Tire - Bridgestone - 205/65R15','850173969225',125.95,2),(6,'Tire - Bridgestone - 205/70R15','178596922503',130.95,2),(7,'Tire - Bridgestone - 235/75R15','591786903225',140.95,2),(8,'Flour - Brother Ben\'s Bread Flour 80 oz','903225591786',11.98,3),(9,'Bullets - 22mm 20 pack','559017863229',58.15,3),(10,'Bullets - 9mm 20 pack','325625901789',59.87,3),(11,'Neopsporin 1 oz','017893256259',16.97,4),(12,'Athletes Foot Cream 0.4 oz','780325625199',13.89,4),(13,'Socks - Medium - Hanes 12 pair pack','870392256519',16.94,5),(14,'Socks - Large Hanes 12 pair pack','565103928729',17.23,5),(15,'Underwear - Medium Men\'s 6 pack','725928591036',19.99,6),(16,'Underwear - Large Men\'s 6 pack','928572591036',20.99,6),(17,'Smartphone - Galaxy 5G Samsung A54','591850369227',199.99,7),(18,'Smartphone - Galaxy 5G Samsung A14','359229187550',99.99,7);
/*!40000 ALTER TABLE `product2` ENABLE KEYS */;
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
