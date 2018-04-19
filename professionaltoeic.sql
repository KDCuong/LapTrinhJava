/*
SQLyog Community v12.5.0 (64 bit)
MySQL - 5.7.21-log : Database - professionaltoeic
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`professionaltoeic` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `professionaltoeic`;

/*Table structure for table `question` */

DROP TABLE IF EXISTS `question`;

CREATE TABLE `question` (
  `question_id` int(3) NOT NULL AUTO_INCREMENT,
  `question_type` int(11) NOT NULL,
  `question_content` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `question_img` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `question_audio` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `answer_1` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `answer_2` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `answer_3` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `answer_4` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `paragraph_id` int(11) DEFAULT NULL,
  `question_flag` int(1) NOT NULL,
  `question_answer` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `question_explain` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `question` */

insert  into `question`(`question_id`,`question_type`,`question_content`,`question_img`,`question_audio`,`answer_1`,`answer_2`,`answer_3`,`answer_4`,`paragraph_id`,`question_flag`,`question_answer`,`question_explain`) values 
(1,3,'ABCTEST',NULL,NULL,'True','False','Not Given',NULL,NULL,1,'True',NULL),
(2,1,'CuongTest','4321','1234','1','2','3','4',NULL,1,'2',NULL),
(15,1,NULL,'1','2','3','312','4213','123',NULL,1,'312',NULL),
(16,1,NULL,'a','b','312','123','432','123',NULL,1,'123',NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_fullname` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `type` int(11) NOT NULL,
  `email` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `flag` int(11) NOT NULL,
  `point` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_fullname`,`user_name`,`password`,`type`,`email`,`flag`,`point`) values 
(1,NULL,'curly','123456',2,'curly@gmail.com',1,NULL),
(2,'Phu Cuong','kdcuong','c12345',2,'1451010022cuong@gmail.com',1,NULL),
(3,NULL,'admin','123456',1,'admin@gmail.com',1,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
