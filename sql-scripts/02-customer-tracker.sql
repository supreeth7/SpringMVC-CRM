CREATE DATABASE  IF NOT EXISTS `web_customer_tracker` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `web_customer_tracker`;
-- Table structure for table `customer`


DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/


-- Dumping data for table `customer`

INSERT INTO `customer` VALUES 
	(1,'David','Adams','david@gmail.com'),
	(2,'John','Doe','john@yahoo.com'),
	(3,'Ajay','Rao','ajay@gmail.com'),
	(4,'Mary','Public','mary@outlook.com'),
	(5,'Maxwell','Dixon','max@rediff.com');


UNLOCK TABLES;
