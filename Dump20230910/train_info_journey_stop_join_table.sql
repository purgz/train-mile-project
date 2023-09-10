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
-- Table structure for table `journey_stop_join_table`
--

DROP TABLE IF EXISTS `journey_stop_join_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `journey_stop_join_table` (
  `journey_id` int NOT NULL,
  `journey_stop_id` int NOT NULL,
  PRIMARY KEY (`journey_id`,`journey_stop_id`),
  KEY `journey_stop_id` (`journey_stop_id`),
  CONSTRAINT `journey_id` FOREIGN KEY (`journey_id`) REFERENCES `journey` (`journey_id`),
  CONSTRAINT `journey_stop_id` FOREIGN KEY (`journey_stop_id`) REFERENCES `journey_stops` (`journey_stop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `journey_stop_join_table`
--

LOCK TABLES `journey_stop_join_table` WRITE;
/*!40000 ALTER TABLE `journey_stop_join_table` DISABLE KEYS */;
INSERT INTO `journey_stop_join_table` VALUES (1,1),(1,2),(1,3),(1,4),(19,16),(19,17),(19,18),(19,19),(19,20),(19,21),(19,22),(19,23),(19,24),(19,25),(19,26),(19,27),(20,28),(20,29),(20,30),(20,31),(20,32),(20,33),(20,34),(20,35),(20,36),(20,37),(20,38),(20,39),(21,40),(21,41),(21,42),(21,43),(21,44),(21,45),(21,46),(21,47),(21,48),(21,49),(21,50),(21,51),(21,52),(21,53),(21,54),(21,55),(21,56),(21,57),(21,58),(21,59);
/*!40000 ALTER TABLE `journey_stop_join_table` ENABLE KEYS */;
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
