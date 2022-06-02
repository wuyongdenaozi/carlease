-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: carlease
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键自增长id',
  `username` varchar(50) NOT NULL COMMENT '用户名(登录帐号)',
  `password` varchar(50) NOT NULL COMMENT '登录密码',
  `create_datetime` datetime NOT NULL COMMENT '创建时间',
  `update_datetime` datetime NOT NULL COMMENT '修改时间',
  `delete_flag` tinyint(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `admin_id_uindex` (`id`),
  UNIQUE KEY `admin_username_uindex` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='管理员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin','admin','2021-12-19 14:20:17','2021-12-19 14:20:22',0);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键自增长id',
  `name` varchar(50) NOT NULL COMMENT '汽车名称',
  `address` varchar(50) NOT NULL COMMENT '所在地点',
  `price` double NOT NULL COMMENT '租赁价格',
  `user_id` bigint NOT NULL COMMENT '所属用户id',
  `type_id` bigint NOT NULL COMMENT '所属类型id',
  `flag` char(1) NOT NULL COMMENT '当前状态',
  `number` int DEFAULT '0' COMMENT '租赁次数',
  `create_datetime` datetime NOT NULL COMMENT '创建时间',
  `update_datetime` datetime NOT NULL COMMENT '修改时间',
  `delete_flag` tinyint(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `car_id_uindex` (`id`),
  KEY `car_car_type_id_fk` (`type_id`),
  KEY `car_user_id_fk` (`user_id`),
  CONSTRAINT `car_car_type_id_fk` FOREIGN KEY (`type_id`) REFERENCES `car_type` (`id`),
  CONSTRAINT `car_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb3 COMMENT='汽车信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES (1,'黑色奥迪A6','沈阳市和平区',140,1,1,'2',0,'2021-12-19 14:26:22','2022-05-30 11:21:37',0),(8,'广汽传祺GS8','沈阳市皇姑区',240,1,2,'0',3,'2022-01-11 09:02:26','2022-05-04 08:49:50',0),(9,'奔驰GLC','大连市旅顺口区',180,4,2,'0',1,'2022-01-12 09:14:24','2022-01-12 09:14:24',0),(10,'黑色福特汽车','营口市',210,5,3,'0',1,'2022-01-12 12:38:11','2022-05-04 08:49:50',0),(11,'五菱宏光','营口市',300,5,5,'2',1,'2022-01-12 12:39:41','2022-05-04 00:14:42',0),(12,'白色大型载客/载货汽车','营口市',370,5,5,'0',1,'2022-01-12 12:41:25','2022-01-12 12:41:25',0),(13,'途岳  2021款 280TSI 两驱风尚版','沈阳',320,1,2,'0',2,'2022-02-27 13:27:07','2022-02-27 13:27:07',0),(14,'昂科拉 2020款 15T 自动进取型','上海',140,1,2,'0',1,'2022-04-25 20:06:03','2022-04-25 20:06:03',0),(15,'创界 2019款 435T CVT两驱逸锐版 国VI','北京',280,1,2,'0',1,'2022-04-25 20:07:47','2022-04-25 20:07:47',0),(16,'奔驰GLC 2021款 GLC 260 L 4MATIC 动感型','大连',200,1,2,'0',0,'2022-04-25 20:09:10','2022-04-25 20:09:10',0),(17,'Polo 2021款 Plus 1.5L 手动全景乐享版','沈阳',150,1,1,'0',0,'2022-04-25 20:10:14','2022-04-25 20:10:14',0),(18,'迈凯伦GT 2019款 4.0T 标准型','上海',300,1,4,'2',0,'2022-04-25 20:12:58','2022-05-04 09:38:33',0),(19,'奥迪R8 2022款 V10 Coupe performance','河南',280,1,4,'0',0,'2022-04-25 20:13:47','2022-04-25 20:13:47',0),(20,'五菱荣光新卡','大连',100,1,5,'0',1,'2022-04-25 20:15:44','2022-04-25 20:15:44',0),(21,'长安星卡','沈阳',100,1,5,'0',1,'2022-04-25 20:16:31','2022-04-25 20:16:31',0),(22,'角斗士','上海',210,1,3,'0',1,'2022-04-25 20:18:03','2022-05-04 00:15:07',0),(23,'炮','上海',150,1,3,'0',1,'2022-04-25 20:18:53','2022-04-25 20:18:53',0),(24,'雅阁','大连',140,1,1,'0',0,'2022-04-25 20:20:05','2022-04-25 20:20:05',0);
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car_details`
--

DROP TABLE IF EXISTS `car_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car_details` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键自增长 id',
  `car_id` bigint DEFAULT NULL COMMENT '所属汽车 id',
  `describes` varchar(100) DEFAULT NULL COMMENT '汽车描述',
  `img` varchar(200) DEFAULT NULL COMMENT '封面图',
  `create_datetime` datetime NOT NULL COMMENT '创建时间',
  `update_datetime` datetime NOT NULL COMMENT '修改时间',
  `delete_flag` tinyint(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `car_details_id_uindex` (`id`),
  UNIQUE KEY `car_details_car_id_uindex` (`car_id`),
  CONSTRAINT `car_details_car_id_fk` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3 COMMENT='汽车详情表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car_details`
--

LOCK TABLES `car_details` WRITE;
/*!40000 ALTER TABLE `car_details` DISABLE KEYS */;
INSERT INTO `car_details` VALUES (1,1,'自用车，九成新，有保险','dcb72c81-f52f-4b80-bed7-d932b9fad0231.jpg','2022-01-11 08:05:19','2022-01-11 08:05:21',0),(3,8,'长期出租,有意者电话联系!','80bf0838-a22d-4b38-a9d3-628d58d620112.jpg','2022-01-11 09:02:26','2022-01-11 09:02:26',0),(4,9,'开了没几年','a3b7ee17-a9ca-4b99-bfb5-6508618460a73.jpg','2022-01-12 09:14:24','2022-01-12 09:14:24',0),(5,10,'黑色福特,型号F150,载货量大!!!','2abccda6-14b1-4e35-a88a-0affc596ef6c4.jpg','2022-01-12 12:38:11','2022-01-12 12:38:11',0),(6,11,'五菱宏光,国产之光,懂得都懂~','904c4844-d455-43f1-8a58-33d3d0b4a72d5.jpg','2022-01-12 12:39:41','2022-01-12 12:39:41',0),(7,12,'空间大,非常实用','d8c5b0ba-d8f7-4309-b5b6-002a472803906.jpg','2022-01-12 12:41:25','2022-01-12 12:41:25',0),(8,13,'新车','1d0edad9-8bae-4161-a572-ebcc549df7621.jpg','2022-02-27 13:27:07','2022-02-27 13:27:07',0),(9,14,'新车','966a9598-f6e9-44c1-b76d-eb30b66ea22f1400x0_1_q95_autohomecar__ChcCQ10sfn-AeYXDAAgFibLSZG8518.jpg','2022-04-25 20:06:03','2022-04-25 20:06:03',0),(10,15,'国际版','128d4806-eb32-46eb-bf38-f25d4216a89f1400x0_1_q95_autohomecar__ChsEel1ovvCAPqqQAAMUBlrQkbo273.jpg','2022-04-25 20:07:47','2022-04-25 20:07:47',0),(11,16,'新型车','23ce9c8a-7eef-44ed-8060-cce4c11475011400x0_1_q95_autohomecar__ChwEk1_gDAWAY_ayABcPsfMmW2M538.jpg','2022-04-25 20:09:10','2022-04-25 20:09:10',0),(12,17,'乐享版','4ddf0087-2bd5-4677-8c64-d289c155ee9b1400x0_1_q95_autohomecar__ChwEl2EvWeaAdzxBABGCZEJxaZ8483.jpg','2022-04-25 20:10:14','2022-04-25 20:10:14',0),(13,18,'标准版','b12deb14-88b3-4e87-a5e2-947e71e8a9781400x0_1_q95_autohomecar__ChsEfF54nhSAYftuAAaJLnPT1FQ249.jpg','2022-04-25 20:12:58','2022-04-25 20:12:58',0),(14,19,'新车','fc30369d-c1ac-4760-a1d5-8d677325fcf31400x0_1_q95_autohomecar__ChsFWWILU5OADBd0AB2lwOwailY486.jpg','2022-04-25 20:13:47','2022-04-25 20:13:47',0),(15,20,'二手','556296b1-4a70-4a44-b226-42481bf329921400x0_1_q95_autohomecar__Chtk3WC9wyuAKqxzACjCFNsIAR0998.jpg','2022-04-25 20:15:44','2022-04-25 20:15:44',0),(16,21,'二手','309f64f6-b9a9-4de0-9036-cee7fe703fa11400x0_1_q95_autohomecar__Chxkl2CJKmCAVsiwACwhFGlyojk279.jpg','2022-04-25 20:16:31','2022-04-25 20:16:31',0),(17,22,'新车','6df4afc2-2a12-4d82-844e-87312e4c37321400x0_1_q95_autohomecar__ChxkqWJgOCqAbkgQAFNRP4rfwlw940.jpg','2022-04-25 20:18:03','2022-04-25 20:18:03',0),(18,23,'新车','f1f25bba-a522-4e72-ba7d-2b2113182c791400x0_1_q95_autohomecar__ChwEl2E5me6APHUjADYFhQDSHMU300.jpg','2022-04-25 20:18:53','2022-04-25 20:18:53',0),(19,24,'新车','af40b40c-f47a-41e8-bbc9-5f4ee8e30df71400x0_1_q95_autohomecar__ChxkmGFUgyKAKXi_ABdDyaocoUs461.jpg','2022-04-25 20:20:05','2022-04-25 20:20:05',0);
/*!40000 ALTER TABLE `car_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car_type`
--

DROP TABLE IF EXISTS `car_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car_type` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键自增长id',
  `name` varchar(50) NOT NULL COMMENT '汽车类型名称',
  `create_datetime` datetime NOT NULL COMMENT '创建时间',
  `update_datetime` datetime NOT NULL COMMENT '修改时间',
  `delete_flag` tinyint(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `car_type_id_uindex` (`id`),
  UNIQUE KEY `car_type_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COMMENT='汽车类型表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car_type`
--

LOCK TABLES `car_type` WRITE;
/*!40000 ALTER TABLE `car_type` DISABLE KEYS */;
INSERT INTO `car_type` VALUES (1,'轿车','2021-12-19 14:22:48','2021-12-19 14:22:49',0),(2,'SUV','2021-12-19 14:22:58','2021-12-19 14:23:00',0),(3,'皮卡','2022-01-08 06:21:25','2022-01-08 06:21:25',0),(4,'跑车','2022-01-08 06:42:27','2022-01-08 06:42:27',0),(5,'货车','2022-01-08 06:45:28','2022-01-08 06:45:28',0),(6,'5','2022-04-25 09:58:48','2022-04-25 09:58:48',0);
/*!40000 ALTER TABLE `car_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login_log`
--

DROP TABLE IF EXISTS `login_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login_log` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键自增长id',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `login_datetime` datetime NOT NULL COMMENT '登录时间',
  `create_datetime` datetime NOT NULL COMMENT '创建时间',
  `update_datetime` datetime NOT NULL COMMENT '修改时间',
  `delete_flag` tinyint(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_log_id_uindex` (`id`),
  KEY `login_log_admin_id_fk` (`user_id`),
  CONSTRAINT `login_log_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8mb3 COMMENT='管理员登录日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_log`
--

LOCK TABLES `login_log` WRITE;
/*!40000 ALTER TABLE `login_log` DISABLE KEYS */;
INSERT INTO `login_log` VALUES (1,1,'2022-01-29 11:38:47','2022-01-29 11:38:47','2022-01-29 11:38:47',0),(2,1,'2022-02-27 13:17:56','2022-02-27 13:17:56','2022-02-27 13:17:56',0),(3,1,'2022-02-27 13:21:04','2022-02-27 13:21:04','2022-02-27 13:21:04',0),(4,1,'2022-02-27 13:24:53','2022-02-27 13:24:53','2022-02-27 13:24:53',0),(5,1,'2022-02-27 13:42:53','2022-02-27 13:42:53','2022-02-27 13:42:53',0),(6,1,'2022-03-08 14:34:16','2022-03-08 14:34:16','2022-03-08 14:34:16',0),(7,1,'2022-03-08 15:38:02','2022-03-08 15:38:02','2022-03-08 15:38:02',0),(8,1,'2022-03-08 15:45:01','2022-03-08 15:45:01','2022-03-08 15:45:01',0),(9,1,'2022-03-09 09:39:45','2022-03-09 09:39:45','2022-03-09 09:39:45',0),(10,1,'2022-03-09 09:40:57','2022-03-09 09:40:57','2022-03-09 09:40:57',0),(16,1,'2022-03-09 14:33:13','2022-03-09 14:33:13','2022-03-09 14:33:13',0),(18,1,'2022-03-09 14:33:33','2022-03-09 14:33:33','2022-03-09 14:33:33',0),(46,1,'2022-03-09 14:50:06','2022-03-09 14:50:06','2022-03-09 14:50:06',0),(63,1,'2022-04-09 14:23:56','2022-04-09 14:23:56','2022-04-09 14:23:56',0),(64,1,'2022-04-09 15:11:46','2022-04-09 15:11:46','2022-04-09 15:11:46',0),(65,1,'2022-04-09 15:35:41','2022-04-09 15:35:41','2022-04-09 15:35:41',0),(66,1,'2022-04-09 15:40:48','2022-04-09 15:40:48','2022-04-09 15:40:48',0),(67,1,'2022-04-09 15:53:25','2022-04-09 15:53:25','2022-04-09 15:53:25',0),(68,1,'2022-04-09 15:55:00','2022-04-09 15:55:00','2022-04-09 15:55:00',0),(69,1,'2022-04-24 23:17:43','2022-04-24 23:17:43','2022-04-24 23:17:43',0),(70,1,'2022-04-25 09:58:16','2022-04-25 09:58:16','2022-04-25 09:58:16',0),(71,1,'2022-04-25 10:37:50','2022-04-25 10:37:50','2022-04-25 10:37:50',0),(72,1,'2022-04-25 11:57:10','2022-04-25 11:57:10','2022-04-25 11:57:10',0),(73,1,'2022-04-25 11:58:57','2022-04-25 11:58:57','2022-04-25 11:58:57',0),(74,1,'2022-04-25 12:00:15','2022-04-25 12:00:15','2022-04-25 12:00:15',0),(76,1,'2022-04-25 16:37:37','2022-04-25 16:37:37','2022-04-25 16:37:37',0),(77,1,'2022-04-25 16:43:28','2022-04-25 16:43:28','2022-04-25 16:43:28',0),(78,1,'2022-04-25 16:58:44','2022-04-25 16:58:44','2022-04-25 16:58:44',0),(79,1,'2022-04-25 17:01:49','2022-04-25 17:01:49','2022-04-25 17:01:49',0),(80,1,'2022-04-25 19:50:29','2022-04-25 19:50:29','2022-04-25 19:50:29',0),(81,1,'2022-04-25 20:10:57','2022-04-25 20:10:57','2022-04-25 20:10:57',0),(82,1,'2022-04-25 20:20:12','2022-04-25 20:20:12','2022-04-25 20:20:12',0),(83,1,'2022-04-25 20:21:33','2022-04-25 20:21:33','2022-04-25 20:21:33',0),(84,1,'2022-04-26 15:23:04','2022-04-26 15:23:04','2022-04-26 15:23:04',0),(85,1,'2022-04-26 17:18:18','2022-04-26 17:18:18','2022-04-26 17:18:18',0),(86,1,'2022-04-27 14:06:06','2022-04-27 14:06:06','2022-04-27 14:06:06',0),(87,1,'2022-04-27 14:06:59','2022-04-27 14:06:59','2022-04-27 14:06:59',0),(88,1,'2022-04-28 21:14:19','2022-04-28 21:14:19','2022-04-28 21:14:19',0),(89,1,'2022-04-28 21:15:20','2022-04-28 21:15:20','2022-04-28 21:15:20',0),(90,1,'2022-04-28 21:17:14','2022-04-28 21:17:14','2022-04-28 21:17:14',0),(91,1,'2022-04-28 21:17:48','2022-04-28 21:17:48','2022-04-28 21:17:48',0),(92,1,'2022-05-03 23:11:15','2022-05-03 23:11:15','2022-05-03 23:11:15',0),(93,4,'2022-05-03 23:58:53','2022-05-03 23:58:53','2022-05-03 23:58:53',0),(94,6,'2022-05-04 08:48:47','2022-05-04 08:48:47','2022-05-04 08:48:47',0),(95,1,'2022-05-04 08:52:34','2022-05-04 08:52:34','2022-05-04 08:52:34',0),(96,6,'2022-05-04 08:55:12','2022-05-04 08:55:12','2022-05-04 08:55:12',0),(98,6,'2022-05-04 09:43:09','2022-05-04 09:43:09','2022-05-04 09:43:09',0),(99,6,'2022-05-04 09:47:54','2022-05-04 09:47:54','2022-05-04 09:47:54',0),(100,6,'2022-05-05 11:14:28','2022-05-05 11:14:28','2022-05-05 11:14:28',0),(101,6,'2022-05-11 12:25:19','2022-05-11 12:25:19','2022-05-11 12:25:19',0),(102,6,'2022-05-15 10:49:55','2022-05-15 10:49:55','2022-05-15 10:49:55',0),(103,1,'2022-05-15 12:11:46','2022-05-15 12:11:46','2022-05-15 12:11:46',0),(104,6,'2022-05-22 23:53:48','2022-05-22 23:53:48','2022-05-22 23:53:48',0),(105,6,'2022-05-27 12:06:36','2022-05-27 12:06:36','2022-05-27 12:06:36',0),(106,6,'2022-05-30 11:21:16','2022-05-30 11:21:16','2022-05-30 11:21:16',0);
/*!40000 ALTER TABLE `login_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键自增长id',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `car_id` bigint NOT NULL COMMENT '汽车id',
  `date` int NOT NULL COMMENT '租赁天数',
  `price` double NOT NULL COMMENT '租赁价格',
  `flag` tinyint(1) NOT NULL COMMENT '是否租赁完成',
  `create_datetime` datetime NOT NULL COMMENT '创建时间',
  `update_datetime` datetime NOT NULL COMMENT '修改时间',
  `delete_flag` tinyint(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `orders_id_uindex` (`id`),
  KEY `orders_car_id_fk` (`car_id`),
  KEY `orders_user_id_fk` (`user_id`),
  CONSTRAINT `orders_car_id_fk` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`),
  CONSTRAINT `orders_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 COMMENT='租赁订单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1,10,3,630,1,'2022-01-27 22:06:03','2022-01-27 22:06:03',0),(2,1,9,1,180,1,'2022-02-27 13:18:37','2022-02-27 13:18:37',0),(3,1,13,1,320,1,'2022-03-08 14:35:38','2022-03-08 14:35:38',0),(4,1,8,1,240,1,'2022-03-08 15:38:14','2022-03-08 15:38:14',0),(5,1,8,1,240,1,'2022-03-08 15:41:51','2022-03-08 15:41:51',0),(6,6,11,1,300,1,'2022-03-09 15:22:52','2022-03-09 15:22:52',0),(7,6,13,1,320,1,'2022-04-25 11:58:38','2022-04-25 11:58:38',0),(8,6,12,3,1110,1,'2022-04-25 16:58:35','2022-04-25 16:58:35',0),(9,1,15,2,560,1,'2022-04-25 20:10:45','2022-04-25 20:10:45',0),(10,1,14,4,560,1,'2022-04-25 20:10:52','2022-04-25 20:10:52',0),(11,20,22,1,210,1,'2022-04-27 14:06:30','2022-04-27 14:06:30',0),(12,6,21,1,100,1,'2022-04-28 21:14:56','2022-04-28 21:14:56',0),(13,4,20,1,100,1,'2022-05-03 23:58:57','2022-05-03 23:58:57',0),(14,6,23,2,300,1,'2022-05-04 08:48:54','2022-05-04 08:48:53',0),(15,6,8,1,240,1,'2022-05-15 12:10:20','2022-05-15 12:10:20',0);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键自增长id',
  `username` varchar(50) NOT NULL COMMENT '用户名(登录帐号)',
  `password` varchar(50) NOT NULL COMMENT '登录密码',
  `nick` varchar(20) NOT NULL COMMENT '用户昵称(显示名称)',
  `phone` char(11) NOT NULL COMMENT '用户电话',
  `email` varchar(50) DEFAULT NULL COMMENT '用户邮箱',
  `cd` char(18) DEFAULT NULL COMMENT '用户身份证号',
  `create_datetime` datetime NOT NULL COMMENT '创建时间',
  `update_datetime` datetime NOT NULL COMMENT '修改时间',
  `delete_flag` tinyint(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_uindex` (`id`),
  UNIQUE KEY `user_username_uindex` (`username`),
  UNIQUE KEY `user_email_uindex` (`email`),
  UNIQUE KEY `cd_UNIQUE` (`cd`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'lijiaming','123456','李嘉明','13323334333','lijiaming@qq.com','211103199801021415','2021-12-19 14:21:46','2021-12-19 14:21:48',0),(4,'zhangsan','123456','张三','15822223333','123456@qq.com',NULL,'2022-01-12 09:11:52','2022-01-12 09:11:52',0),(5,'lisi','123456','李四','13399887766','lisi-email@email.com',NULL,'2022-01-12 12:36:59','2022-01-12 12:36:59',0),(6,'wangwu','123456','wangwu','15822223333','wangwu@qq.com',NULL,'2022-03-09 14:44:38','2022-03-09 14:44:38',0),(7,'john','zhao555','John','13333355558','41561561@aad.com',NULL,'2022-04-09 14:23:24','2022-04-09 14:23:24',0),(18,'lisan','123456','李三','13050887135','41561522@qq.com',NULL,'2022-04-25 15:00:32','2022-04-25 15:00:32',0),(19,'lijiu','123455','李九','23456789876','1394322345@qq.com',NULL,'2022-04-25 15:07:38','2022-04-25 15:07:38',0),(20,'zengsi','123456','曾四','15787654311','6789345@qq.com',NULL,'2022-04-27 10:02:37','2022-04-27 10:02:37',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-02 13:48:20
