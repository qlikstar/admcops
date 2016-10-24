CREATE DATABASE  IF NOT EXISTS `admcops` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `admcops`;
-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: localhost    Database: admcops
-- ------------------------------------------------------
-- Server version	5.6.22

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
-- Table structure for table `app`
--

DROP TABLE IF EXISTS `app`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app_name` varchar(45) NOT NULL,
  `app_version` varchar(10) NOT NULL,
  `app_desc` varchar(45) DEFAULT NULL,
  `app_owner` varchar(45) DEFAULT NULL,
  `app_location` varchar(45) DEFAULT NULL,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app`
--

LOCK TABLES `app` WRITE;
/*!40000 ALTER TABLE `app` DISABLE KEYS */;
INSERT INTO `app` VALUES (1,'tech_fair_demo_app','1.7.2','Demo Application for Tech Fair 2016','Xenmobile@citrix.com',NULL,'2016-10-08 17:42:14','2016-10-09 02:21:41'),(2,'new_test_demo_app','1.2.1','Test Demo App','sanket@citrix.com',NULL,'2016-10-08 17:42:14','2016-10-09 02:21:24');
/*!40000 ALTER TABLE `app` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cloud`
--

DROP TABLE IF EXISTS `cloud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cloud` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cloud_provider` varchar(45) NOT NULL,
  `availability_zone` varchar(45) DEFAULT NULL,
  `notes` varchar(45) DEFAULT NULL,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `app_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_idx` (`app_id`),
  CONSTRAINT `FKbx3iqamq6rs5xgr84r6jayyqj` FOREIGN KEY (`app_id`) REFERENCES `app` (`id`),
  CONSTRAINT `app_id` FOREIGN KEY (`app_id`) REFERENCES `app` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cloud`
--

LOCK TABLES `cloud` WRITE;
/*!40000 ALTER TABLE `cloud` DISABLE KEYS */;
INSERT INTO `cloud` VALUES (1,'AWS','us-west-01',NULL,'2016-10-08 17:47:49',1),(2,'AWS','us-west-02',NULL,'2016-10-08 17:47:49',1),(3,'Azure','West US',NULL,'2016-10-08 17:47:49',1),(4,'Azure','West US 2',NULL,'2016-10-08 17:47:49',1);
/*!40000 ALTER TABLE `cloud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `control`
--

DROP TABLE IF EXISTS `control`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `control` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip_address` varchar(45) NOT NULL,
  `host_name` varchar(45) DEFAULT NULL,
  `default_user` varchar(45) NOT NULL,
  `ssh_key` varchar(45) NOT NULL,
  `cloud_id` int(11) NOT NULL,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ip_address_UNIQUE` (`ip_address`),
  UNIQUE KEY `hostname_UNIQUE` (`host_name`),
  KEY `cloud_id_idx` (`cloud_id`),
  CONSTRAINT `FK9psvjpge1jtavhtw61cgdo1f3` FOREIGN KEY (`cloud_id`) REFERENCES `cloud` (`id`),
  CONSTRAINT `cloud_id` FOREIGN KEY (`cloud_id`) REFERENCES `cloud` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `control`
--

LOCK TABLES `control` WRITE;
/*!40000 ALTER TABLE `control` DISABLE KEYS */;
INSERT INTO `control` VALUES (1,'52.53.152.198','aws-control-01','ubuntu','sanketm_awsdev',1,'2016-10-08 17:48:35'),(2,'104.40.71.117','azure-control-01','ubuntu','sanketm_azuredev',3,'2016-10-08 17:51:17');
/*!40000 ALTER TABLE `control` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instance`
--

DROP TABLE IF EXISTS `instance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip_address` varchar(45) NOT NULL,
  `host_name` varchar(45) DEFAULT NULL,
  `default_user` varchar(45) NOT NULL,
  `ssh_key` varchar(45) NOT NULL,
  `app_version` int(11) NOT NULL,
  `os_name` varchar(45) DEFAULT NULL,
  `os_version` varchar(45) DEFAULT NULL,
  `control_id` int(11) NOT NULL,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `id_idx` (`control_id`),
  KEY `id_idx1` (`app_version`),
  CONSTRAINT `FK3sx8af6c8htbnhsk2vt6ihnaa` FOREIGN KEY (`control_id`) REFERENCES `control` (`id`),
  CONSTRAINT `id` FOREIGN KEY (`control_id`) REFERENCES `control` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instance`
--

LOCK TABLES `instance` WRITE;
/*!40000 ALTER TABLE `instance` DISABLE KEYS */;
INSERT INTO `instance` VALUES (1,'10.0.2.142','aws-inst-01','ubuntu','sanketm_awsdev',1,'Ubuntu','16.04',1,'2016-10-08 17:52:33','2016-10-10 21:19:20'),(2,'10.0.4.251','aws-inst-02','ubuntu','sanketm_awsdev',1,'Ubuntu','16.04',1,'2016-10-08 17:53:23','2016-10-10 21:19:20'),(3,'172.17.1.4','azure-inst-01','ubuntu','sanketm_azuredev',1,'Ubuntu','16.04',2,'2016-10-08 17:55:14','2016-10-08 18:17:29'),(4,'172.17.1.5','azure-inst-02','ubuntu','sanketm_azuredev',1,'Ubuntu','16.04',2,'2016-10-08 17:55:14','2016-10-08 18:17:29');
/*!40000 ALTER TABLE `instance` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-17 14:24:39
