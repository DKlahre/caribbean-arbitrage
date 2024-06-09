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
-- Table structure for table `product3`
--

DROP TABLE IF EXISTS `product3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product3` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(40) DEFAULT NULL,
  `product_description` varchar(40) DEFAULT NULL,
  `product_price` decimal(10,2) DEFAULT NULL,
  `trans_available` varchar(40) DEFAULT NULL,
  `country_id` int unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=134 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product3`
--

LOCK TABLES `product3` WRITE;
/*!40000 ALTER TABLE `product3` DISABLE KEYS */;
INSERT INTO `product3` VALUES (1,'Bulgar Wheat - Medium Grind','521344654762',16.96,'sell',1),(2,'Yellow Cornmeal - Medium Grind','503899122653',18.98,'sell',1),(3,'Machete - Stainless Steel 15 inch','385096579122',40.21,'sell',1),(4,'Tire - Bridgestone - 195/65R15','798501223965',150.96,'buy',2),(5,'Tire - Bridgestone - 205/65R15','850173969225',155.94,'buy',2),(6,'Tire - Bridgestone - 235/75R15','591786903225',172.95,'buy',2),(7,'Flour - Brother Ben\'s Flour 80 oz','903225591786',8.98,'sell',3),(8,'Bullets - 22mm 20 pack','559017863229',52.15,'sell',3),(9,'Bullets - 9mm 20 pack','325625901789',53.87,'sell',3),(10,'Neopsporin 1 oz','017893256259',13.96,'sell',4),(11,'Athletes Foot Cream 0.4 oz','780325625199',12.89,'sell',4),(12,'Socks - Medium - Hanes 12 pair pack','870392256519',12.95,'sell',5),(13,'Socks - Large Hanes 12 pair pack','565103928729',13.23,'sell',5),(15,'Underwear - Medium Men\'s 6 pack','725928591036',14.99,'sell',6),(16,'Underwear - Large Men\'s 6 pack','928572591036',16.99,'sell',6),(17,'Smartphone - Galaxy 5G Samsung A54','591850369227',166.99,'sell',7),(18,'Smartphone - Galaxy 5G Samsung A14','359229187550',86.99,'sell',7),(19,'Bulgar Wheat - Medium Grind','521344654762',26.95,'buy',8),(20,'Yellow Cornmeal - Medium Grind','503899122653',28.98,'buy',8),(21,'Machete - Stainless Steel 15 inch','385096579122',55.26,'buy',8),(22,'Tire - Bridgestone - 195/65R15','798501223965',105.95,'sell',9),(23,'Tire - Bridgestone - 205/65R15','850173969225',110.97,'sell',9),(25,'Tire - Bridgestone - 235/75R15','591786903225',115.95,'sell',9),(26,'Flour - Brother Ben\'s Flour 80 oz','903225591786',16.98,'buy',10),(27,'Bullets - 22mm 20 pack','559017863229',70.55,'buy',10),(28,'Bullets - 9mm 20 pack','325625901789',72.75,'buy',10),(29,'Neopsporin 1 oz','017893256259',22.23,'buy',11),(30,'Athletes Foot Cream 0.4 oz','780325625199',19.96,'buy',11),(31,'Socks - Medium - Hanes 12 pair pack','870392256519',22.99,'buy',12),(32,'Socks - Large Hanes 12 pair pack','565103928729',23.98,'buy',12),(33,'Underwear - Medium Men\'s 6 pack','725928591035',24.56,'buy',13),(34,'Underwear - Large Men\'s 6 pack','928572591036',27.99,'buy',13),(36,'Smartphone - Galaxy 5G Samsung A14','359229187550',123.99,'buy',13),(38,'Smartphone - Galaxy 5G Samsung A54','591850369227',245.97,'buy',13),(74,'Bulgar Wheat - Medium Grind','521344654762',19.97,'sell',4),(76,'Neopsporin 1 oz','017893256259',16.97,'sell',4),(77,'Bulgar Wheat - Medium Grind	','521344654762',16.95,'buy',12),(78,'Yellow Cornmeal - Medium Grind','503899122653',17.50,'buy',13),(79,'Machete - Stainless Steel 15 inch','385096579122',31.25,'buy',11),(81,'Machete - Stainless Steel 15 inch','385096579122',38.74,'sell',7),(82,'Tire - Bridgestone - 195/65R15','798501223965',151.24,'buy',5),(84,'Tire - Bridgestone - 195/65R15	','798501223965',104.67,'buy',1),(85,'Tire - Bridgestone - 195/65R15	','798501223965',103.86,'sell',11),(86,'Tire - Bridgestone - 205/65R15','850173969225',158.90,'sell',13),(87,'Tire - Bridgestone - 235/75R15','591786903225',110.64,'sell',12),(88,'Tire - Bridgestone - 235/75R15','591786903225',174.95,'sell',4),(89,'Tire - Bridgestone - 235/75R15','591786903225',113.29,'buy',13),(90,'Flour - Brother Ben\'s Bread Flour 80 oz','903225591786',4.92,'sell',7),(91,'Flour - Brother Ben\'s Bread Flour 80 oz','903225591786',5.97,'buy',5),(92,'Flour - Brother Ben\'s Bread Flour 80 oz','903225591786',15.26,'buy',1),(93,'Bullets - 22mm 20 pack','559017863229',60.16,'sell',8),(94,'Bullets - 22mm 20 pack','559017863229',50.21,'buy',2),(95,'Bullets - 22mm 20 pack','559017863229',49.45,'buy',5),(96,'Bullets - 9mm 20 pack','325625901789',51.79,'buy',1),(97,'Bullets - 9mm 20 pack','325625901789',49.95,'sell',6),(98,'Neopsporin 1 oz	','017893256259',14.51,'buy',8),(99,'Neopsporin 1 oz','017893256259',25.10,'buy',7),(100,'Athletes Foot Cream 0.4 oz','780325625199',7.22,'buy',9),(101,'Athletes Foot Cream 0.4 oz	','780325625199',24.79,'buy',2),(102,'Socks - Medium - Hanes 12 pair pack','870392256519',9.94,'buy',4),(103,'Socks - Medium - Hanes 12 pair pack','870392256519',18.23,'buy',11),(104,'Socks - Medium - Hanes 12 pair pack	','870392256519',19.94,'sell',13),(105,'Socks - Large Hanes 12 pair pack','565103928729',11.72,'buy',3),(106,'Socks - Large Hanes 12 pair pack','565103928729',12.39,'sell',1),(107,'Underwear - Medium Men\'s 6 pack	','725928591036',13.28,'buy',8),(108,'Underwear - Large Men\'s 6 pack','928572591036',29.97,'buy',8),(110,'Bulgar Wheat - Medium Grind	','521344654762	',13.76,'buy',13),(111,'Bulgar Wheat - Medium Grind	','521344654762',13.76,'buy',11);
/*!40000 ALTER TABLE `product3` ENABLE KEYS */;
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
