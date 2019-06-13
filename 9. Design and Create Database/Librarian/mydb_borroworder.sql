-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `borroworder`
--

DROP TABLE IF EXISTS `borroworder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `borroworder` (
  `BorrowOrder_id` int(11) NOT NULL,
  `date_order` date DEFAULT NULL,
  `date_return` date DEFAULT NULL,
  `Book_Book_id` int(11) NOT NULL,
  `Students_id` int(11) NOT NULL,
  PRIMARY KEY (`BorrowOrder_id`,`Book_Book_id`,`Students_id`),
  KEY `fk_BorrowOrder_Book_idx` (`Book_Book_id`),
  KEY `fk_BorrowOrder_Students1_idx` (`Students_id`),
  CONSTRAINT `fk_BorrowOrder_Book` FOREIGN KEY (`Book_Book_id`) REFERENCES `book` (`Book_id`),
  CONSTRAINT `fk_BorrowOrder_Students1` FOREIGN KEY (`Students_id`) REFERENCES `students` (`Students_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borroworder`
--

LOCK TABLES `borroworder` WRITE;
/*!40000 ALTER TABLE `borroworder` DISABLE KEYS */;
INSERT INTO `borroworder` VALUES (1,'2001-01-19','2001-02-19',1,111),(1,'2019-10-01','2019-10-04',2,115),(1,'2019-10-01','2019-10-04',3,115),(2,'2019-10-07','2019-10-09',2,114),(5,'2019-06-06','2019-06-08',3,113),(6,'2019-01-19','2019-02-19',1,111),(7,'2019-10-01','2019-10-04',3,115);
/*!40000 ALTER TABLE `borroworder` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-13 17:10:26
