-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: db_student
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `s_student`
--

DROP TABLE IF EXISTS `s_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `s_student` (
  `studentId` int NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `classId` int NOT NULL,
  `password` varchar(32) NOT NULL,
  `sex` varchar(8) NOT NULL,
  PRIMARY KEY (`studentId`),
  KEY `class_foreign` (`classId`),
  CONSTRAINT `class_foreign` FOREIGN KEY (`classId`) REFERENCES `s_class` (`ClassId`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_student`
--

LOCK TABLES `s_student` WRITE;
/*!40000 ALTER TABLE `s_student` DISABLE KEYS */;
INSERT INTO `s_student` VALUES (1,'卢家业',1,'1','男'),(2,'吴灿',1,'11','女'),(3,'李国栋',1,'111','保密'),(4,'丘昌鑫',1,'1111','男'),(5,'农小豪',1,'11111','男'),(6,'韦栎文',1,'12345','女'),(7,'聂任康',10,'666666','保密'),(8,'叶舒怡',6,'1','女'),(9,'温雅婷',6,'1','女'),(10,'黄兰盈',6,'1','女'),(11,'白浩然',14,'88888888','女'),(12,'黄家乐',16,'54665','保密'),(13,'覃庆烽',12,'111','男'),(14,'梁昌弘',17,'5641312','男'),(15,'樊鑫宇',15,'87513','男'),(16,'陆俊峰',12,'89746152','保密'),(17,'梁芝翠',10,'9845','女'),(18,'李天进',1,'978465','男'),(19,'冯兴洪',15,'32','男'),(20,'杨文静',8,'5741','女'),(21,'李艺璇',9,'6523','女'),(22,'胡怡君',13,'8465','女'),(23,'梁彬',2,'984651','女'),(24,'刘菊',4,'7894651','男'),(25,'翁小超',4,'123','男'),(26,'潘洪国',13,'451','男'),(27,'黄燕锦',12,'123','男'),(28,'钟幸玲',1,'6532','女'),(29,'欧阳婉丽',16,'874','女'),(30,'岳丽欣',14,'78451','女'),(31,'巫鑫怡',12,'89465','女'),(32,'李先婷',8,'798465','女'),(33,'张三',17,'13223','女'),(34,'李四',7,'1324','保密'),(35,'王五',9,'152','保密');
/*!40000 ALTER TABLE `s_student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-02 23:11:01
