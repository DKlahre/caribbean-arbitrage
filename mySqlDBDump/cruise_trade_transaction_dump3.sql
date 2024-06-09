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
-- Table structure for table `transaction_dump3`
--

DROP TABLE IF EXISTS `transaction_dump3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_dump3` (
  `id` int NOT NULL AUTO_INCREMENT,
  `provisioner_name` varchar(40) DEFAULT NULL,
  `country_of_business` varchar(40) DEFAULT NULL,
  `product_quantity` int unsigned DEFAULT NULL,
  `purchase_total` decimal(10,2) DEFAULT NULL,
  `trans_type` varchar(20) DEFAULT NULL,
  `purch_date` varchar(40) DEFAULT NULL,
  `country_id` int unsigned DEFAULT NULL,
  `product_id` int unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=285 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_dump3`
--

LOCK TABLES `transaction_dump3` WRITE;
/*!40000 ALTER TABLE `transaction_dump3` DISABLE KEYS */;
INSERT INTO `transaction_dump3` VALUES (225,'Kitts Prov. Inc.','ST_KITTS',1000,12950.00,'buy','2023-11-13 20:05:49.227',5,12),(226,'Vincent Prov. Co.','ST_VINCENT',1000,22990.00,'sell','2023-11-13 20:05:49.314',12,31),(227,'Vincent Prov Co.','ST_VINCENT',400,44256.00,'buy','2023-11-13 20:15:17.698',12,87),(228,'US Virginantes Prov','USVI',400,69180.00,'sell','2023-11-13 20:15:17.734',2,6),(229,'Anguilla Trading Co.','ANGUILLA',950,16112.00,'buy','2023-11-13 20:25:04.503',1,1),(230,'Island Prov. ','DOMINICA',950,25602.50,'sell','2023-11-13 20:25:04.534',8,19),(231,'Sembora Trade Co.','GUADALOUPE',700,116893.00,'buy','2023-11-14 10:23:50.483',7,17),(232,'Halifax Provisioning','TRINIDAD',700,172179.00,'sell','2023-11-14 10:23:50.604',13,38),(233,'Anguilla Pathways','ANGUILLA',670,11363.20,'buy','2023-11-19 13:13:42.446',1,1),(234,'Dominica Trade Co','DOMINICA',670,18056.50,'sell','2023-11-19 13:13:42.519',8,19),(235,'Montserrat Tradeup','MONTSERRAT',400,6796.00,'buy','2023-11-19 18:33:39.922',6,16),(236,'Republic Provisioning','DOMINICA',400,11988.00,'sell','2023-11-19 18:33:40.091',8,108),(237,'fghjk','ANGUILLA',45,763.20,'buy','2024-01-27 17:38:46.652',1,1),(238,'yhtgrfedw','DOMINICA',45,1212.75,'sell','2024-01-27 17:38:46.749',8,19),(239,'tvybu','ANTIGUA',20,279.20,'buy','2024-06-06 13:56:55.984',4,10),(240,'lmknj','BARBADOS',20,444.60,'sell','2024-06-06 13:56:56.127',11,29),(241,'rctvybuni','MARTINIQUE',400,44388.00,'buy','2024-06-06 14:02:23.314',9,23),(242,'fgvhbjn','USVI',400,62376.00,'sell','2024-06-06 14:02:23.362',2,5),(243,'yctv','ANGUILLA',30,1206.30,'buy','2024-06-06 19:18:02.777',1,3),(244,'gfd','ANGUILLA',56,2251.76,'buy','2024-06-06 23:35:46.156',1,3),(245,'exrcfgv','DOMINICA',56,3094.56,'sell','2024-06-06 23:35:46.402',8,21),(246,'gfd','ANGUILLA',45,854.10,'buy','2024-06-06 23:39:37.457',1,2),(247,'gyhuj','ANGUILLA',56,1062.88,'buy','2024-06-07 00:24:11.346',1,2),(248,'gh','DOMINICA',56,1622.88,'sell','2024-06-07 00:24:11.404',8,20),(249,'gbhnj','ANGUILLA',34,645.32,'buy','2024-06-07 00:29:28.673',1,2),(250,'ihugy','DOMINICA',34,985.32,'sell','2024-06-07 00:29:28.719',8,20),(251,'nothing','ANGUILLA',67,1271.66,'buy','2024-06-07 11:36:48.193',1,2),(252,'dxcfv','DOMINICA',67,1941.66,'sell','2024-06-07 11:36:48.415',8,20),(253,'Provisioner','ANGUILLA',56,949.76,'buy','2024-06-07 11:43:11.906',1,1),(254,'xfcyguv','DOMINICA',56,1509.20,'sell','2024-06-07 11:43:11.94',8,19),(255,'fghjk','ANGUILLA',56,949.76,'buy','2024-06-07 13:41:20.505',1,1),(256,'cyvub','DOMINICA',56,1509.20,'sell','2024-06-07 13:41:20.619',8,19),(257,'tvybun','ANTIGUA',63,879.48,'buy','2024-06-07 19:31:02.495',4,10),(258,'koji','BARBADOS',63,1400.49,'sell','2024-06-07 19:31:02.595',11,29),(259,'buy','ANGUILLA',90,3618.90,'buy','2024-06-07 19:42:58.75',1,3),(260,'vbnhbjn','DOMINICA',90,4973.40,'sell','2024-06-07 19:42:58.783',8,21),(261,'blank','ANGUILLA',89,1689.22,'buy','2024-06-07 19:51:26.822',1,2),(262,'ctvyb','DOMINICA',89,2579.22,'sell','2024-06-07 19:51:26.867',8,20),(263,'blank','ANGUILLA',87,1651.26,'buy','2024-06-07 19:52:54.49',1,2),(264,'hgfdf','DOMINICA',87,2521.26,'sell','2024-06-07 19:52:54.52',8,20),(265,'kitts_prov_inc','BVI',34,305.32,'buy','2024-06-07 20:37:41.45',3,7),(266,'dominica_trade','ST_LUCIA',34,577.32,'sell','2024-06-07 20:37:41.534',10,26),(267,'halifax_provisioning','ANGUILLA',87,3498.27,'buy','2024-06-07 20:38:18.431',1,3),(268,'blank','DOMINICA',87,4807.62,'sell','2024-06-07 20:38:18.459',8,21),(269,'anguilla_pathways','ANGUILLA',23,924.83,'buy','2024-06-07 20:39:14.052',1,3),(270,'republic_provisioning','DOMINICA',23,1270.98,'sell','2024-06-07 20:39:14.077',8,21),(271,'Montserrat_Tradeup','MARTINIQUE',37,3920.15,'buy','2024-06-07 20:44:41.522',9,22),(272,'US_Virginantes','USVI',37,5585.52,'sell','2024-06-07 20:44:41.549',2,4),(273,'Kitts_Prov_Inc','ST_KITTS',200,2646.00,'buy','2024-06-09 14:15:27.449',5,13),(274,'Vincent_Cielo','ST_VINCENT',200,4796.00,'sell','2024-06-09 14:15:27.617',12,32),(275,'Dominica_Trade','MARTINIQUE',34,3602.30,'buy','2024-06-09 14:16:16.233',9,22),(276,'blank','USVI',34,5132.64,'sell','2024-06-09 14:16:16.318',2,4),(277,'Sembora_Trade','MARTINIQUE',300,31785.00,'buy','2024-06-09 14:20:22.151',9,22),(278,'US_Virginantes','USVI',300,45288.00,'sell','2024-06-09 14:20:22.201',2,4),(279,'Kitts_Prov_Inc','ST_KITTS',400,5180.00,'buy','2024-06-09 14:42:11.643',5,12),(280,'Vincent_Cielo','ST_VINCENT',400,9196.00,'sell','2024-06-09 14:42:11.781',12,31),(281,'Anguilla_Pathways','ANGUILLA',400,6784.00,'buy','2024-06-09 14:49:31.351',1,1),(282,'Dominica_Trade','DOMINICA',400,10780.00,'sell','2024-06-09 14:49:31.397',8,19),(283,'Island_Provisioning','GUADALOUPE',500,43495.00,'buy','2024-06-09 15:08:34.223',7,18),(284,'Halifax_Provisioning','TRINIDAD',500,61995.00,'sell','2024-06-09 15:08:34.372',13,36);
/*!40000 ALTER TABLE `transaction_dump3` ENABLE KEYS */;
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
