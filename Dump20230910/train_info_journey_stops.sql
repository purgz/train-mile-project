-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: train_info
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
-- Table structure for table `journey_stops`
--

DROP TABLE IF EXISTS `journey_stops`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `journey_stops` (
  `journey_stop_id` int NOT NULL AUTO_INCREMENT,
  `stop_order` int DEFAULT '0',
  `crs_code` varchar(45) DEFAULT NULL,
  `via_station` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`journey_stop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `journey_stops`
--

LOCK TABLES `journey_stops` WRITE;
/*!40000 ALTER TABLE `journey_stops` DISABLE KEYS */;
INSERT INTO `journey_stops` VALUES (1,1,'BMO',1),(2,2,'BAN',1),(3,3,'WAR',0),(4,4,'BMO',1),(16,1,'BIT',0),(17,2,'ISP',0),(18,3,'OXP',1),(19,4,'ISP',0),(20,5,'BIT',0),(21,6,'HDM',0),(22,7,'PRR',0),(23,8,'SDR',0),(24,9,'HWY',0),(25,10,'BCF',0),(26,11,'GER',0),(27,12,'MYB',0),(28,1,'BIT',0),(29,2,'ISP',0),(30,3,'OXP',1),(31,4,'ISP',0),(32,5,'BIT',0),(33,6,'HDM',0),(34,7,'PRR',0),(35,8,'SDR',0),(36,9,'HWY',0),(37,10,'BCF',0),(38,11,'GER',0),(39,12,'MYB',0),(40,1,'BIT',0),(41,2,'ISP',0),(42,3,'OXP',1),(43,4,'BIT',0),(44,5,'HDM',0),(45,6,'PRR',0),(46,7,'HWY',0),(47,8,'BCF',0),(48,9,'SRG',0),(49,10,'GER',0),(50,11,'DNM',0),(51,12,'WCX',0),(52,13,'MYB',1),(53,14,'GER',0),(54,15,'BCF',0),(55,16,'HWY',0),(56,17,'SDR',0),(57,18,'PRR',0),(58,19,'HDM',0),(59,20,'BIT',0);
/*!40000 ALTER TABLE `journey_stops` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-10 11:20:57
