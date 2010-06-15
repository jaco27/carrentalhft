-- MySQL dump 10.13  Distrib 5.1.46, for Win64 (unknown)
--
-- Host: localhost    Database: carrental
-- ------------------------------------------------------
-- Server version	5.1.46-community

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
-- Table structure for table `agency`
--

DROP TABLE IF EXISTS `agency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agency` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agency`
--

LOCK TABLES `agency` WRITE;
/*!40000 ALTER TABLE `agency` DISABLE KEYS */;
INSERT INTO `agency` VALUES (1,'First Agency'),(2,'Agency Bond');
/*!40000 ALTER TABLE `agency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `booking` (
  `BOOKING_NUMBER` int(11) NOT NULL AUTO_INCREMENT,
  `CUSTOMER_ID` int(11) NOT NULL,
  `AGENCY_ID` int(11) NOT NULL,
  `CAR_ID` int(11) NOT NULL,
  `BOOKING_DATE` date NOT NULL,
  `RETURN_DATE` date NOT NULL,
  `TIME_STAMP` varchar(19) NOT NULL DEFAULT '',
  PRIMARY KEY (`BOOKING_NUMBER`),
  KEY `fk_Order_Customer1` (`CUSTOMER_ID`),
  KEY `fk_Order_Agency1` (`AGENCY_ID`),
  KEY `fk_Order_Car1` (`CAR_ID`),
  CONSTRAINT `fk_Order_Agency1` FOREIGN KEY (`AGENCY_ID`) REFERENCES `agency` (`ID`) ON UPDATE CASCADE,
  CONSTRAINT `fk_Order_Car1` FOREIGN KEY (`CAR_ID`) REFERENCES `car` (`ID`) ON UPDATE CASCADE,
  CONSTRAINT `fk_Order_Customer1` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `customer` (`ID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (1,1,1,1,'2002-01-01','2002-02-01','2010-06-15 20:10:03'),(2,2,1,2,'2009-04-22','2009-04-23','2010-06-15 20:10:03'),(3,3,2,1,'2003-02-02','2003-02-20','2010-06-15 20:10:03'),(4,4,2,2,'1945-05-20','1945-05-21','2010-06-15 20:10:03'),(8,1,1,4,'3000-02-03','3002-03-03','2010-06-15 20:10:03'),(9,1,2,3,'2002-02-02','2002-02-03','2010-06-15 20:10:03'),(10,1,2,4,'2002-02-03','2002-02-04','2010-06-15 20:12:25');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `carrental`.`INSERT_TRIGGER`
BEFORE INSERT ON `carrental`.`booking`
FOR EACH ROW
BEGIN
    SET NEW.TIME_STAMP = NOW();
    INSERT INTO LOGGING(MESSAGE) VALUES ('New booking was inserted.');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER DELETE_TRIGGER
    AFTER DELETE ON BOOKING
    FOR EACH ROW
BEGIN
    INSERT INTO LOGGING(MESSAGE) VALUES ('Booking was deleted.');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `branch` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `AGENCY_ID` int(11) NOT NULL,
  `NAME` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_Branch_Agency1` (`AGENCY_ID`),
  CONSTRAINT `fk_Branch_Agency1` FOREIGN KEY (`AGENCY_ID`) REFERENCES `agency` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` VALUES (1,1,'Spain'),(2,1,'Germany'),(3,2,'Germany'),(4,2,'USA');
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `branch_address`
--

DROP TABLE IF EXISTS `branch_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `branch_address` (
  `BRANCH_ID` int(11) NOT NULL,
  `STREET_NAME` varchar(45) NOT NULL,
  `CITY_NAME` varchar(45) NOT NULL,
  `STREET_NUMBER` varchar(5) NOT NULL,
  `POSTAL_CODE` varchar(10) NOT NULL,
  `COUNTRY` varchar(45) NOT NULL,
  `PHONE_NUMBER` varchar(45) NOT NULL,
  PRIMARY KEY (`BRANCH_ID`),
  KEY `fk_BRANCH_ADDRESS_BRANCH1` (`BRANCH_ID`),
  CONSTRAINT `fk_BRANCH_ADDRESS_BRANCH1` FOREIGN KEY (`BRANCH_ID`) REFERENCES `branch` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch_address`
--

LOCK TABLES `branch_address` WRITE;
/*!40000 ALTER TABLE `branch_address` DISABLE KEYS */;
INSERT INTO `branch_address` VALUES (1,'Spain Street','Madrid','032','443020S','Spain','2020 / 2399'),(2,'New Street','Hamburg','43','343023','Germany','903403'),(3,'Other Street','Frankfurt','33a','9402 ','Germany','0232393'),(4,'Liberty Street','New York','53a','123344','USA','84398');
/*!40000 ALTER TABLE `branch_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `car` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CAR_TYPE_ID` int(11) NOT NULL,
  `BRANCH_ID` int(11) NOT NULL,
  `REGISTRATION_NUMBER` varchar(30) NOT NULL,
  `COLOR` varchar(30) NOT NULL,
  `DATE_OF_MANUFACTURING` date NOT NULL,
  `BASE_PRICE_PER_DAY` float NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_Car_CarDetail1` (`CAR_TYPE_ID`),
  KEY `fk_Car_Branch1` (`BRANCH_ID`),
  CONSTRAINT `fk_Car_Branch1` FOREIGN KEY (`BRANCH_ID`) REFERENCES `branch` (`ID`) ON UPDATE CASCADE,
  CONSTRAINT `fk_Car_CarDetail1` FOREIGN KEY (`CAR_TYPE_ID`) REFERENCES `car_type` (`ID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES (1,1,1,'X23-234','green','1999-02-01',20),(2,2,2,'BC-343','red','2002-02-21',15),(3,3,3,'TW-435','blue','2001-03-11',23),(4,4,4,'232-444','pink','1945-04-03',100);
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car_type`
--

DROP TABLE IF EXISTS `car_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `car_type` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `PRODUCER` varchar(45) NOT NULL,
  `TYPE` varchar(45) NOT NULL,
  `AUTOMATIC` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car_type`
--

LOCK TABLES `car_type` WRITE;
/*!40000 ALTER TABLE `car_type` DISABLE KEYS */;
INSERT INTO `car_type` VALUES (1,'Kaefer','VW','PKW',0),(2,'E90','BMW','PKW',1),(3,'Fiesta','Ford','PKW',0),(4,'Tank','Army','Military',0);
/*!40000 ALTER TABLE `car_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `LOGIN_NAME` varchar(45) NOT NULL,
  `REGISTER_DATE` date NOT NULL,
  `EMAIL` varchar(45) NOT NULL,
  `CUSTOMER_TYPE` varchar(10) NOT NULL,
  `FIRST_NAME` varchar(45) DEFAULT NULL,
  `SURNAME` varchar(45) DEFAULT NULL,
  `DATE_OF_BIRTH` date DEFAULT NULL,
  `PASSWORD` varchar(45) NOT NULL,
  `COMPANY_NAME` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Alex','2010-06-06','alex@hft.de','private','Alexander','Weickmann','1000-01-01','none',NULL),(2,'Matthias','2008-02-02','matze@hft.de','private','Matthias','Ruszala','3000-01-02','none',NULL),(3,'Priya','1999-06-03','priya@hft.com','private','Priya','S','1999-03-05','none',NULL),(4,'Radhika','1803-04-05','radhika@hft.com','private','Radhika','Mohan','1938-04-22','none',NULL),(5,'HFT','1001-02-04','hft@stuttgart.de','company',NULL,NULL,NULL,'none','HFT Stuttgart');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_address`
--

DROP TABLE IF EXISTS `customer_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_address` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `STREET_NAME` varchar(45) NOT NULL,
  `CITY_NAME` varchar(45) NOT NULL,
  `STREET_NUMBER` varchar(5) NOT NULL,
  `POSTAL_CODE` varchar(10) NOT NULL,
  `COUNTRY` varchar(45) NOT NULL,
  `PHONE_NUMBER` varchar(45) NOT NULL,
  `CUSTOMER_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_CUSTOMER_ADDRESS_CUSTOMER1` (`CUSTOMER_ID`),
  CONSTRAINT `fk_CUSTOMER_ADDRESS_CUSTOMER1` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `customer` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_address`
--

LOCK TABLES `customer_address` WRITE;
/*!40000 ALTER TABLE `customer_address` DISABLE KEYS */;
INSERT INTO `customer_address` VALUES (2,'Matthias Street','Matthias City','11','3254','Germany','23443',2),(3,'Priya Street','Priya City','23','347687','India','6436547',3),(4,'Radhika Street','Radhika City','443','8673','India','5434',4),(5,'HFT Street','HFT City','32a','6342','Germany','3423 / 3432',5);
/*!40000 ALTER TABLE `customer_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logging`
--

DROP TABLE IF EXISTS `logging`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `logging` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MESSAGE` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logging`
--

LOCK TABLES `logging` WRITE;
/*!40000 ALTER TABLE `logging` DISABLE KEYS */;
INSERT INTO `logging` VALUES (1,'Booking was deleted.'),(2,'New booking was inserted.'),(3,'New booking was inserted.');
/*!40000 ALTER TABLE `logging` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2010-06-15 20:16:09
