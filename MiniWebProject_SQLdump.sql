-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: demo
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
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'Software Development',1),(2,'FPGA Manufacturing',1),(3,'DevOps',4),(4,'Human Resources',2),(5,'Economics',3);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `deptlocation`
--

LOCK TABLES `deptlocation` WRITE;
/*!40000 ALTER TABLE `deptlocation` DISABLE KEYS */;
INSERT INTO `deptlocation` VALUES (1,'Athens'),(2,'Thessaloniki'),(3,'Patras'),(4,'Heraklion');
/*!40000 ALTER TABLE `deptlocation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'2014-01-22 00:00:00',200,'kostas','engineer','stavrakakis',2000,1,1),(2,'2020-01-22 00:00:00',300,'razkey','engineer','papas',1800,1,1),(3,'2020-01-22 00:00:00',150,'nikos','developer','papadakis',1200,2,2),(4,'2020-02-23 00:00:00',100,'Giannis','developer','Pappas',1200,2,1),(5,'2018-02-23 00:00:00',200,'Giorgos','developer','Papadopoulos',1300,3,1),(6,'2016-12-13 00:00:00',100,'Stathis','developer','Nikas',2000,3,1),(7,'2020-06-15 00:00:00',159,'Vaggelis','Software Engineer','Georgiou',1500,2,2),(8,'2020-09-11 00:00:00',205,'Manos','Engineer','Theodorou',1000,3,3),(9,'2015-09-23 00:00:00',302,'Petros','Jr. developer','Neofyou',900,5,1),(12,'2017-01-23 00:00:00',111,'Thanos','Human Resources','Meletiou',1400,4,2);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-21 14:48:02
