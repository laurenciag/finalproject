-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: project_lgd
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `trip`
--

DROP TABLE IF EXISTS `trip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trip` (
  `id` varchar(255) NOT NULL,
  `agency` varchar(255) DEFAULT NULL,
  `bus_id` varchar(255) DEFAULT NULL,
  `fare` int NOT NULL,
  `journey_date` varchar(255) DEFAULT NULL,
  `dest_stop_id` varchar(255) DEFAULT NULL,
  `source_stop_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip`
--

LOCK TABLES `trip` WRITE;
/*!40000 ALTER TABLE `trip` DISABLE KEYS */;
INSERT INTO `trip` VALUES ('548e56cb-ec37-11ea-a844-0068eb40b125','fd011aa9-9382-4b5f-98eb-b1ea59408426','06a346cb-4e8f-4cff-94b9-49a6c32f1b7a',350000,'1','10ef4191-f0c0-11ea-a844-0068eb40b125','17b5c48d-f0c0-11ea-a844-0068eb40b125'),('7f807909-d07a-4c63-b6e1-f67a2872b54f','fd011aa9-9382-4b5f-98eb-b1ea59408426','06a346cb-4e8f-4cff-94b9-49a6c32f1b7a',3043900,'3','17b5c48d-f0c0-11ea-a844-0068eb40b125','10ef4191-f0c0-11ea-a844-0068eb40b125'),('9d6fbe78-6994-439f-914d-08c0e74ce589','fd011aa9-9382-4b5f-98eb-b1ea59408426','6704fac4-638f-407f-aba6-723cefc90082',732480,'2','17b5c48d-f0c0-11ea-a844-0068eb40b125','778ad0e1-f246-11ea-a844-0068eb40b125'),('c75d814e-bffb-48b1-92aa-0c5abdc80c19','fd011aa9-9382-4b5f-98eb-b1ea59408426','06a346cb-4e8f-4cff-94b9-49a6c32f1b7a',3043900,'3','17b5c48d-f0c0-11ea-a844-0068eb40b125','10ef4191-f0c0-11ea-a844-0068eb40b125'),('d4651da8-b8a8-48b1-b64a-f68f383f0d90','fd011aa9-9382-4b5f-98eb-b1ea59408426','6704fac4-638f-407f-aba6-723cefc90082',300000,'2','17b5c48d-f0c0-11ea-a844-0068eb40b125','10ef4191-f0c0-11ea-a844-0068eb40b125');
/*!40000 ALTER TABLE `trip` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-22  9:39:42