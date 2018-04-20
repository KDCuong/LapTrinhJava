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
  `question_content` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `question` */

insert  into `question`(`question_id`,`question_type`,`question_content`,`question_img`,`question_audio`,`answer_1`,`answer_2`,`answer_3`,`answer_4`,`paragraph_id`,`question_flag`,`question_answer`,`question_explain`) values 
(1,3,'ABCTEST',NULL,NULL,'True','False','Not Given',NULL,NULL,9,'True',NULL),
(2,1,'CuongTest','432156','1234456','a','b','c','d',NULL,9,'b','123'),
(23,3,'Like restaurants, caterers are subject to _____ concerning safe food handling.',NULL,NULL,'regulate','regulations','regulatory','regulating',0,1,'regulations',NULL),
(24,3,'The _____ was a success; the patient will fully recover in a month\'s time.',NULL,NULL,'operate','operation','operator','operating',0,9,'operation',NULL),
(25,3,'We bought this car at a very _____ price.',NULL,NULL,'reason','reasonable','reasonably','reasoning',0,1,'reasonable',NULL),
(26,3,'Standardized products are _____ in appearance.',NULL,NULL,'uniforms','uniformly','uniform','unformed',0,1,'uniform',NULL),
(27,3,'The boss doesn\'t _____ to playing the radio at your desk if the music is low,',NULL,NULL,'mind','refuse','negate','object',0,1,'object',NULL),
(28,3,'Your advice was very _____.',NULL,NULL,'cooperating','contributive','helpful','improving',0,1,'helpful',NULL),
(29,3,'Come to our next picnic if you _____ the chance.',NULL,NULL,'have','will have','had','don\'t have',0,1,'have',NULL),
(30,3,'The sales invoice all the terms and conditions _____ by the buyer and seller.',NULL,NULL,'agreeing upon','agreement','agree','agreed to',0,1,'agreed to',NULL),
(31,3,'Orchestra music is wonderfully conductive to _____.',NULL,NULL,'relaxation','relaxed','relaxes','relax',0,1,'relaxation',NULL),
(32,3,'There\'s really no _____ for my behaviour last night. I can only think that i\'d had too much to drink.',NULL,NULL,'exception','escape','excuse','exclusion',0,1,'excuse',NULL),
(33,3,'Like restaurants, caterers are subject to _____ concerning safe food handling.',NULL,NULL,'regulate','regulations','regulatory','regulating',0,1,'regulations',NULL),
(34,2,'Thank you for choosing to fly Trinata Airlines. We ask all passengers _____ their itinerary with\nTrinata Airlines within 48 hours of your flight time, as it is possible that weather conditions and\nother unforeseen events could lead to flight cancellations.',NULL,NULL,'confirmation','confirming','confirmed','to confirm',1,1,'to confirm',NULL),
(35,2,'To improve service in the future, at each _____ that Trinata serves, we are distributing short\nsatisfaction surveys to arriving passengers.',NULL,NULL,'location','locate','locating','located',1,1,'location',NULL),
(36,2,'These surveys are completely optional. We hope you a satisfactory experience flying with\nTrinata, and we will do our best to serve you _____ you arrive at your final destination.',NULL,NULL,'although','therefore','until','nevertheles',1,1,'until',NULL),
(37,2,'In order to stay competitive in today\'s market, companies must continually work to develop\nnew products. Through _____ research, a company can ascertain what consumers are\ninterested in buying.',NULL,NULL,'system','systemize','systematic','systematically',2,1,'systematic',NULL),
(38,2,'Then products that match those interests can be developed. Nothing should _____ about\nconsumer interests.',NULL,NULL,'assume','assumes','assumed','be assumed',2,1,'be assumed',NULL),
(39,2,'Product developers need _____ all the data carefully before spending money on a new \nproduct.',NULL,NULL,'examine','to examine','examining','will examine',2,1,'to examine',NULL),
(40,1,NULL,'/image/image1.png','/audio/audio1.mp3','A','B','C','D',NULL,1,'A',''),
(41,1,NULL,'/image/image2.png','/audio/audio2.mp3','A','B','C','D',NULL,1,'A',''),
(42,1,NULL,'/image/image3.png','/audio/audio3.mp3','A','B','C','D',NULL,1,'B','');

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
(2,'Cuong','kdcuong','c12345',2,'1451010022cuong@gmail.com',1,NULL),
(3,NULL,'admin','123456',1,'admin@gmail.com',1,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
