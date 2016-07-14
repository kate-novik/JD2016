CREATE DATABASE  IF NOT EXISTS `sinkevich` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sinkevich`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sinkevich
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.10-MariaDB

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
-- Table structure for table `bets`
--

DROP TABLE IF EXISTS `bets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bets` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT 'Время ставки',
  `fk_race` int(10) unsigned NOT NULL COMMENT 'Забег',
  `horse` varchar(45) NOT NULL COMMENT 'Имя лошади',
  `betSum` decimal(7,2) NOT NULL COMMENT 'Сумма ставки',
  `fk_user` int(10) unsigned NOT NULL COMMENT 'Пользователь',
  PRIMARY KEY (`id`),
  KEY `race_idx` (`fk_race`),
  KEY `user_idx` (`fk_user`),
  CONSTRAINT `race` FOREIGN KEY (`fk_race`) REFERENCES `races` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user` FOREIGN KEY (`fk_user`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='Ставки';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bets`
--

LOCK TABLES `bets` WRITE;
/*!40000 ALTER TABLE `bets` DISABLE KEYS */;
INSERT INTO `bets` VALUES (1,'2016-07-07 09:33:07.666',1,'Эклипс',10.50,2),(2,'2016-07-07 09:35:41.013',1,'Сметанка',5.00,2),(3,'2016-07-07 09:40:00.000',1,'Сухарь',100.34,2);
/*!40000 ALTER TABLE `bets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `races`
--

DROP TABLE IF EXISTS `races`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `races` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT 'Время забега',
  `horse1` varchar(45) NOT NULL COMMENT 'Лошадь номер 1',
  `horse2` varchar(45) NOT NULL COMMENT 'Лошадь номер 2',
  `horse3` varchar(45) NOT NULL COMMENT 'Лошадь номер 3',
  `horse4` varchar(45) NOT NULL COMMENT 'Лошадь номер 4',
  `horse5` varchar(45) NOT NULL COMMENT 'Лошадь номер 5',
  `horse6` varchar(45) NOT NULL COMMENT 'Лошадь номер 6',
  `horse7` varchar(45) NOT NULL COMMENT 'Лошадь номер 7',
  `horse8` varchar(45) NOT NULL COMMENT 'Лошадь номер 8',
  `winner` varchar(45) NOT NULL COMMENT 'Победитель забега',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='Забеги';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `races`
--

LOCK TABLES `races` WRITE;
/*!40000 ALTER TABLE `races` DISABLE KEYS */;
INSERT INTO `races` VALUES (1,'2016-07-07 10:00:00.000','Эклипс','Сметанка','Сухарь','Будулай','Секретариат','Резвая','Абсент','Анилин','Сметанка');
/*!40000 ALTER TABLE `races` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL COMMENT 'Название',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='Роли	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Bookmaker'),(2,'Client');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT 'Ф.И.О.',
  `dateOfBirth` date NOT NULL COMMENT 'Дата рождения',
  `email` varchar(100) NOT NULL COMMENT 'Почта',
  `fk_role` int(10) unsigned NOT NULL COMMENT 'Роль',
  `login` varchar(100) NOT NULL COMMENT 'Логин',
  `password` varchar(100) NOT NULL COMMENT 'Пароль',
  PRIMARY KEY (`id`),
  KEY `role_idx` (`fk_role`),
  CONSTRAINT `role` FOREIGN KEY (`fk_role`) REFERENCES `roles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='Пользователи';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Синкевич Денис Сергеевич','1986-11-08','SleePokeR@gmail.com',1,'Admin','Admin'),(2,'Иванов Иван Иванович','1991-07-07','Gambler@mail.ru',2,'Gambler','qwerty');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-07 12:28:21
