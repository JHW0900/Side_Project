-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: teamproject
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `identify`
--

DROP TABLE IF EXISTS `identify`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `identify` (
  `name` varchar(20) NOT NULL,
  `sex` int NOT NULL,
  `phone_num` varchar(20) NOT NULL,
  `e-mail` varchar(50) NOT NULL,
  `id` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `card_num` varchar(20) NOT NULL,
  `card_com` varchar(10) NOT NULL,
  `isreservation` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `identify`
--

LOCK TABLES `identify` WRITE;
/*!40000 ALTER TABLE `identify` DISABLE KEYS */;
INSERT INTO `identify` VALUES ('7890',1,'7890','7890','7890','7890','7890','IBK기업',0);
/*!40000 ALTER TABLE `identify` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation_info`
--

DROP TABLE IF EXISTS `reservation_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation_info` (
  `primary_id` int NOT NULL,
  `seat` int NOT NULL,
  `user_id` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation_info`
--

LOCK TABLES `reservation_info` WRITE;
/*!40000 ALTER TABLE `reservation_info` DISABLE KEYS */;
INSERT INTO `reservation_info` VALUES (1013,7,'1234'),(1003,9,'jhw0900');
/*!40000 ALTER TABLE `reservation_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_info`
--

DROP TABLE IF EXISTS `service_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service_info` (
  `service_name` varchar(40) NOT NULL,
  `service_type` varchar(20) NOT NULL,
  `service_location` varchar(100) NOT NULL,
  `service_tel` varchar(15) NOT NULL,
  `primary_id` int NOT NULL,
  PRIMARY KEY (`primary_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_info`
--

LOCK TABLES `service_info` WRITE;
/*!40000 ALTER TABLE `service_info` DISABLE KEYS */;
INSERT INTO `service_info` VALUES ('롯데리아 김해어방점','식당','경남 김해시 인제로 190 선교빌딩','055-321-3415',1001),('유키돈까스 인제대점','식당','경남 김해시 인제로200번길 6 대우빌딩','055-323-0781',1002),('청년다방 인제대점','식당','경남 김해시 인제로188번길 3-16','0507-1475-1589',1003),('코이코이 인제대점','식당','경남 김해시 인제로210번길 5-3','0507-1404-5960',1004),('공부의신 독서실','독서실','경남 김해시 삼안로 309 가야청','055-326-1310',1005),('다솔 독서실','독서실','경남 김해시 인제로 163 새마을금고','055-335-0035',1006),('르하임 스터디카페 김해인제대점','독서실','경남 김해시 인제로 182 3층 302호','010-3101-3303',1007),('지니24 스터디카페 김해인제대점','독서실','경남 김해시 인제로 196 401호','010-4542-8802',1008),('락휴 코인노래연습장 김해 인제대점','노래방','경남 김해시 인제로188번길 12 2층','055-339-5009',1009),('준코노래타운 김해인제대점','노래방','경남 김해시 인제로170번길 9-26 지하2층','055-337-5917',1010),('텐텐 동전 노래방','노래방','경남 김해시 인제로188번길 10 금호빌딩','x',1011),('힐튼코인노래연습장','노래방','경남 김해시 인제로188번길 6 힐튼타워','x',1012),('라이킷pc 김해삼방점','pc방','경남 김해시 삼안로 309 1층','0507-1371-6696',1013),('인스타pc카페 인제대점','pc방','경남 김해시 인제로169번길 27','x',1014),('인싸이더pc카페 1호점','pc방','경남 김해시 인제로188번길 3-16 2층','055-724-2429',1015),('인싸이더pc카페 2호점','pc방','경남 김해시 인제로200번길 2 3층','055-724-2429',1016);
/*!40000 ALTER TABLE `service_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-01 13:37:45
