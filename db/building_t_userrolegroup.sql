-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: building
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.13-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_userrolegroup`
--

DROP TABLE IF EXISTS `t_userrolegroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_userrolegroup` (
  `userRoleGroupId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `startDay` date DEFAULT '0000-00-00',
  `endDay` date NOT NULL DEFAULT '9999-12-31',
  `roleGroupId` int(11) NOT NULL,
  `memo` varchar(250) DEFAULT NULL,
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `lastUpdate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `createId` int(11) NOT NULL DEFAULT '0',
  `updateId` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`userRoleGroupId`),
  UNIQUE KEY `userRoleGroupId` (`userRoleGroupId`),
  UNIQUE KEY `userId` (`userId`),
  KEY `roleGroupId` (`roleGroupId`),
  CONSTRAINT `T_USERROLEGROUP_ibfk_2` FOREIGN KEY (`roleGroupId`) REFERENCES `t_rolegroup` (`roleGroupId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `T_USERROLEGROUP_ibfk_3` FOREIGN KEY (`userId`) REFERENCES `t_user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=914 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_userrolegroup`
--

LOCK TABLES `t_userrolegroup` WRITE;
/*!40000 ALTER TABLE `t_userrolegroup` DISABLE KEYS */;
INSERT INTO `t_userrolegroup` VALUES (1,1,'0000-00-00','9999-12-31',1,NULL,'2016-11-03 19:40:28','2016-11-03 19:40:28',0,0);
/*!40000 ALTER TABLE `t_userrolegroup` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-03 22:23:02
