/*
SQLyog Community v12.5.0 (64 bit)
MySQL - 5.7.22-log : Database - professionaltoeic
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

/*Table structure for table `history` */

DROP TABLE IF EXISTS `history`;

CREATE TABLE `history` (
  `user_name` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `point` int(3) NOT NULL,
  `date` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `history` */

insert  into `history`(`user_name`,`point`,`date`,`id`) values 
('kdcuong',500,'2018-04-25',1),
('kdcuong',200,'2018-04-25',2);

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
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `question` */

insert  into `question`(`question_id`,`question_type`,`question_content`,`question_img`,`question_audio`,`answer_1`,`answer_2`,`answer_3`,`answer_4`,`paragraph_id`,`question_flag`,`question_answer`,`question_explain`) values 
(1,3,'ABCTEST',NULL,NULL,'True','False','Not Given',NULL,NULL,9,'True',NULL),
(2,1,'CuongTest','432156','1234456','a','b','c','d',NULL,9,'b','123'),
(23,3,'Like restaurants, caterers are subject to _____ concerning safe food handling.',NULL,NULL,'regulate','regulations','regulatory','regulating',0,1,'regulations','GM1.PNG'),
(24,3,'The _____ was a success; the patient will fully recover in a month\'s time.',NULL,NULL,'operate','operation','operator','operating',0,9,'operation',NULL),
(25,3,'We bought this car at a very _____ price.',NULL,NULL,'reason','reasonable','reasonably','reasoning',0,1,'reasonable','GM2.PNG'),
(26,3,'Standardized products are _____ in appearance.',NULL,NULL,'uniforms','uniformly','uniform','unformed',0,1,'uniform','GM3.PNG'),
(27,3,'The boss doesn\'t _____ to playing the radio at your desk if the music is low,',NULL,NULL,'mind','refuse','negate','object',0,1,'object','GM4.PNG'),
(28,3,'Your advice was very _____.',NULL,NULL,'cooperating','contributive','helpful','improving',0,1,'helpful','GM5.PNG'),
(29,3,'Come to our next picnic if you _____ the chance.',NULL,NULL,'have','will have','had','don\'t have',0,1,'have','GM7.PNG'),
(30,3,'The sales invoice all the terms and conditions _____ by the buyer and seller.',NULL,NULL,'agreeing upon','agreement','agree','agreed to',0,1,'agreed to','GM8.PNG'),
(31,3,'Orchestra music is wonderfully conductive to _____.',NULL,NULL,'relaxation','relaxed','relaxes','relax',0,1,'relaxation','GM9.PNG'),
(32,3,'There\'s really no _____ for my behaviour last night. I can only think that i\'d had too much to drink.',NULL,NULL,'exception','escape','excuse','exclusion',0,1,'excuse','GM10.PNG'),
(33,3,'Like restaurants, caterers are subject to _____ concerning safe food handling.',NULL,NULL,'regulate','regulations','regulatory','regulating',0,9,'regulations',NULL),
(34,2,'Thank you for choosing to fly Trinata Airlines. We ask all passengers _____ their itinerary with\nTrinata Airlines within 48 hours of your flight time, as it is possible that weather conditions and\nother unforeseen events could lead to flight cancellations.',NULL,NULL,'confirmation','confirming','confirmed','to confirm',1,9,'to confirm',NULL),
(35,2,'To improve service in the future, at each _____ that Trinata serves, we are distributing short\nsatisfaction surveys to arriving passengers.',NULL,NULL,'location','locate','locating','located',1,9,'location',NULL),
(36,2,'These surveys are completely optional. We hope you a satisfactory experience flying with\nTrinata, and we will do our best to serve you _____ you arrive at your final destination.',NULL,NULL,'although','therefore','until','nevertheles',1,9,'until',NULL),
(37,2,'In order to stay competitive in today\'s market, companies must continually work to develop\nnew products. Through _____ research, a company can ascertain what consumers are\ninterested in buying.',NULL,NULL,'system','systemize','systematic','systematically',2,1,'systematic',NULL),
(38,2,'Then products that match those interests can be developed. Nothing should _____ about\nconsumer interests.',NULL,NULL,'assume','assumes','assumed','be assumed',2,1,'be assumed',NULL),
(39,2,'Product developers need _____ all the data carefully before spending money on a new \nproduct.',NULL,NULL,'examine','to examine','examining','will examine',2,1,'to examine',NULL),
(40,1,NULL,'image1.png','audio1.mp3','A','B','C','D',NULL,1,'C','She is working in a copy room.'),
(41,1,NULL,'image2.png','audio2.mp3','A','B','C','D',NULL,1,'A','People are walking across the bridge.'),
(42,1,NULL,'image3.png','audio3.mp3','A','B','C','D',NULL,1,'B','The address is above the entrance.'),
(43,1,NULL,'2','1','A','B','C','D',NULL,9,'A',NULL),
(44,1,NULL,'3123123123','1','A','B','C','D',NULL,9,'A',NULL),
(45,2,'test complete check',NULL,NULL,'1','2','3','',99,9,'1',NULL),
(46,3,'asdasdasd',NULL,NULL,'asdas','asdasd','asdasd','asdsa',0,9,'asdas',NULL),
(47,2,'When your company has a job opening, it is important to hire the right person for the job. The job interview offers you, the employer, an opportunity to get to know each _____ and assess his or her ability to do the job.',NULL,NULL,'expert','supervisor','candidate','mentor',3,1,'candidate',NULL),
(48,2,'You will have many questions for the applicants, but you should also _____ ready for questions from them.',NULL,NULL,'be','do','have','will be',3,1,'be',''),
(49,2,'In addition to understanding the job duties, they may want to know about _____ offered by your company such as vacations and health care.',NULL,NULL,'benificial','beneficent','benefit','beneficiaries',3,1,'benefit',''),
(50,2,'Our job here in the Quality Control Department is to make sure that no garment leaves the factory in less than perfect condition. This means that each garment _____ carefully by a trained garment inspector.',NULL,NULL,'inspects','is inspected','is inspecting','has inspected',4,1,'is inspected',''),
(51,2,'We throw out all _____ garments.',NULL,NULL,'defect','defects','defective','detective',4,1,'defective',NULL),
(52,2,'It is important to protect our _____ and make sure that the name of our company is always associated with top-quality products.',NULL,NULL,'lobby','research','brand','wrinkle',4,1,'brand',NULL),
(53,2,'Many employees have been complaining recently that the refreshment area is often left untidy. It is in everyone\'s interest that this space should remain clean and orderly, so please do your best to keep it that way. _____ instance, after you use the cups or dishes, do your best to clean them and put them away.\n',NULL,NULL,'By','In','For','Of',5,1,'For',NULL),
(54,2,'To make sure that we do not have any further problems, I will introduce an employee roster system for kitchen area duties. This means that you will all have to take _____ looking after the area.',NULL,NULL,'turns','rides','tries','efforts',5,1,'turns',NULL),
(55,2,'Duties will include making sure the bench is clean, restocking the coffee and milk, and washing any leftover dishes. I will send you each a copy of the roster _____ I have finished drawing it up.',NULL,NULL,'during','when','while','by',5,1,'when',NULL),
(56,2,'Thank you for choosing to fly Trinata Airlines. We ask all passengers _____ their itinerary with Trinata Air within 48 hours of your flight time, as it is possible that weather conditions and other unforeseen events could lead to flight cancellations.',NULL,NULL,'confirmation','confirming','to confirm','confirmed',6,1,'to confirm',NULL),
(57,2,'To improve service in the future, at each _____ that Trinata serves, we are distributing short satisfaction surveys to arriving passengers.',NULL,NULL,'location','locate','locating','located',6,1,'location',NULL),
(58,2,'These surveys are completely optional. We hope you have a satisfactory experience flying with Trinata, and we will do our best to serve you _____ you arrive at your final destination.',NULL,NULL,'although','therefore','until','nevertheles',6,1,'until',NULL),
(59,3,'Some people always ______ for the easy way out.',NULL,NULL,'opt','option','optional','options',0,1,'opt','GM11.PNG'),
(60,3,'All the representatives are allowed to spend money for entertaining with their ______ account.',NULL,NULL,'expensive','expending','expense','expenses',0,1,'expense','GM12.PNG'),
(61,3,'A ______ and hard-working employee can look forward to rapid promotions.',NULL,NULL,'dedicate','dedication','dedicating','dedicated',0,1,'dedicated','GM13'),
(62,3,'We should be responsible for the ______ humans are doing to the enviroment.',NULL,NULL,'destroy','destructive','destruction','destructibility',0,1,'destruction','GM14.PNG'),
(63,3,'It\'s a new business, so I\'m sure they would appreciate the ______.',NULL,NULL,'public','publicity','publication','publicize',0,1,'publicity','GM15.PNG'),
(64,3,'It\'s worth ______ in the memo that we\'re finished the draft of the proposal.',NULL,NULL,'mentionable','mentioning','mentions','mentioned',0,1,'mentioning','GM16.PNG'),
(65,3,'He is ______ out of the employment.',NULL,NULL,'regrettable','regrettably','regretful','with regret',0,1,'regrettably','GM17.PNG'),
(66,3,'Drevno flooring products are designed for ______ in industrial settings.',NULL,NULL,'user','used','useful','use',0,1,'use','GM18.PNG'),
(67,3,'Plants are ______ economic and medical importance.',NULL,NULL,'bothh great','greater','of great','some great',0,1,'of great','GM19.PNG'),
(68,3,'The applicant\'s unique ______ enabled her to have almost any job that she wanted.',NULL,NULL,'expertise','experts','expertly','expert',0,1,'expertise','GM20.PNG'),
(69,3,'The company\'s ______ earnings over the next six months were exciting.',NULL,NULL,'project','projects','projection','projected',0,1,'projected','GM21.PNG'),
(70,3,'Due to the store\'s success, the owners began to plan an ______ into a larger location.',NULL,NULL,'expansion','expand','expanse','expanded',0,1,'expansion','GM22.PNG'),
(71,3,'I\'m very ______ that I\'m late but there is a train strike on at the moment.',NULL,NULL,'sore','sorry','sorrow','sorrowful',0,1,'sorry','GM23.PNG'),
(72,3,'The designer made the ______ that people are attracted to boxes in primary colors.',NULL,NULL,'assumption','assumed','assming','assume',0,1,'assumption','GM24.PNG'),
(73,3,'As the chairman stood to give his ______, everyone in the room was listening.',NULL,NULL,'conclusion','conclude','conclusive','concluding',0,1,'conclusion','GM25.PNG'),
(74,3,'She is a dancer, so you should buy a pair of ______ shoes as a present for her birthday.',NULL,NULL,'dacing','dance','dances','dancer\'s',0,1,'dance','GM26.PNG'),
(75,3,'Once again the company has had to make a ______ in the number of office staff to try and recoup their losses',NULL,NULL,'reducing','reduction','reduce','reduces',0,1,'reduction','GM27.PNG'),
(76,3,'Headlines magazine is a very successful ______ that has continued to grow in popularity over the past seven years.',NULL,NULL,'public','publication','publicize','publicly',0,1,'publication','GM28.PNG'),
(77,3,'We only offer broadband internet service in ______ areas due to lack of technical capability.',NULL,NULL,'selected','selecting','selection','selects',0,1,'selected','GM29.PNG'),
(78,3,'I have attached the ______ customer service survey you sent me, but i would like to make some additional comments.',NULL,NULL,'complete','completes','completing','completed',0,1,'complete','GM30.PNG'),
(79,3,'Job seekers may benefit from the increasing ______ among venture businesses.',NULL,NULL,'compete','competitive','competition','competitively',0,1,'competition','GM31.PNG'),
(80,1,NULL,'image10.PNG','audio10.mp3','A','B','C','D',NULL,1,'D','The men are standing in their boats.'),
(81,1,NULL,'image11.PNG','audio11.mp3','A','B','C','D',NULL,1,'C','The hay is piled neatly on the ground.'),
(82,1,NULL,'image12.PNG','audio12.mp3','A','B','C','D',NULL,1,'B','The passengers are closing the overhead bins.'),
(83,1,NULL,'image13.PNG','audio13.mp3','A','B','C','D',NULL,1,'B','You can see mountains in the background.'),
(84,1,NULL,'image14.PNG','audio14.mp3','A','B','C','D',NULL,1,'D','They\'re shaking hands.'),
(85,1,NULL,'image15.PNG','audio15.mp3','A','B','C','D',NULL,1,'B','It is still snowing.'),
(86,1,NULL,'image16.jpg','audio16.mp3','A','B','C','D',NULL,1,'B','These are dice.'),
(87,1,NULL,'image17.jpg','audio17.mp3','A','B','C','D',NULL,1,'D','There\'s a fence near a building.'),
(88,1,NULL,'image18.jpg','audio18.mp3','A','B','C','D',NULL,1,'C','The women are wearing coats.'),
(89,1,NULL,'image19.jpg','audio19.mp3','A','B','C','D',NULL,1,'C','Some men are waiting near a vehicle.'),
(90,1,NULL,'image20.PNG','audio20.mp3','A','B','C','D',NULL,1,'B','He\'s holding the lid open.'),
(91,1,NULL,'image21.jpg','audio21.mp3','A','B','C','D',NULL,1,'C','They\'re carrying a box.'),
(92,1,NULL,'image22.jpg','audio22.mp3','A','B','C','D',NULL,1,'A','The people are reading the menu.'),
(93,1,NULL,'image23.jpg','audio23.mp3','A','B','C','D',NULL,1,'B','The man is carrying a box.'),
(94,1,NULL,'image24.jpg','audio24.mp3','A','B','C','D',NULL,1,'D','The woman is weight-lifting.'),
(95,1,NULL,'image25.jpg','audio25.mp3','A','B','C','D',NULL,1,'C','The person is working with clay.'),
(96,1,NULL,'image4.jpg','audio4.mp3','A','B','C','D',NULL,1,'C','The man is carrying bags in both of his hands.'),
(97,1,NULL,'image5.jpg','audio5.mp3','A','B','C','D',NULL,1,'A','Chairs have been placed around the tables.'),
(98,1,NULL,'image6.jpg','audio6.mp3','A','B','C','D',NULL,1,'C','The passengers are boarding the bus.'),
(99,1,NULL,'image7.jpg','audio7.mp3','A','B','C','D',NULL,1,'C','There are buildings standing on either side of the road.'),
(100,1,NULL,'image8.jpg','audio8.mp3','A','B','C','D',NULL,1,'A','The woman is listening to music.'),
(101,1,NULL,'image9.PNG','audio9.mp3','A','B','C','D',NULL,1,'C','He is holding a plate.');

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_fullname`,`user_name`,`password`,`type`,`email`,`flag`,`point`) values 
(1,'curly','curly','123456',2,'curly@gmail.com',1,NULL),
(2,'Cuong','kdcuong','123456',2,'1451010022cuong@gmail.com',1,NULL),
(3,NULL,'admin','123456',1,'admin@gmail.com',1,NULL),
(4,'','kdcuong1','',2,'',9,NULL),
(5,'','kdcuong2','1',2,'',1,NULL),
(6,'','kdcuong3','123456',2,'',1,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
