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
-- Table structure for table `bus`
--

DROP TABLE IF EXISTS `bus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bus` (
  `id` varchar(255) NOT NULL,
  `agency` varchar(255) DEFAULT NULL,
  `capacity` int NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `make` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bus`
--

LOCK TABLES `bus` WRITE;
/*!40000 ALTER TABLE `bus` DISABLE KEYS */;
INSERT INTO `bus` VALUES ('06a346cb-4e8f-4cff-94b9-49a6c32f1b7a','fd011aa9-9382-4b5f-98eb-b1ea59408426',43,'Coba lagi','Bus ompreng'),('22bb2fe9-d33d-4d53-a5b4-a3a8a862ee67','f08946fb-241f-4d30-8116-73bee2f37ae9',30,'BCAF002','Busway'),('2b30bd11-107d-4250-a7a6-19bf3b9d02ae','9e50f99a-142c-42b0-b731-fd1e3c91ef5a',20,'AB123','Busway'),('4bd0a8fb-41d9-43d6-88fa-ca6381b86937','fd011aa9-9382-4b5f-98eb-b1ea59408426',500,'Cobabuatedit','Bus busan'),('6704fac4-638f-407f-aba6-723cefc90082','fd011aa9-9382-4b5f-98eb-b1ea59408426',50,'BCAF001','Bus Pariwisata'),('bd9b41aa-762f-4fb2-b29a-630a4d073866','fd011aa9-9382-4b5f-98eb-b1ea59408426',40,'BCAF002','Bukan'),('c4d23d1e-8164-4a39-a4c5-f55f8a36d817','9e50f99a-142c-42b0-b731-fd1e3c91ef5a',25,'AB123','Bus Pariwisata'),('d1d4f921-4fab-474b-87b3-6f32d91b600a','f08946fb-241f-4d30-8116-73bee2f37ae9',50,'BCAF001','Bus Pariwisata'),('f8dc29a9-3085-4a29-a8c1-15cf926e4283','fd011aa9-9382-4b5f-98eb-b1ea59408426',5,'Coba','Mini Bus');
/*!40000 ALTER TABLE `bus` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-22  9:39:37
