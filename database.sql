CREATE DATABASE `portfolio` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE portfolio;


CREATE TABLE `assets` (
  `name` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `customer` (
  `username` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `cash` float DEFAULT NULL,
  `realized_pnl` float DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `purchase` (
  `id` int NOT NULL AUTO_INCREMENT,
  `owner` varchar(255) NOT NULL,
  `price` float NOT NULL,
  `purchase_date` float DEFAULT NULL,
  `asset` varchar(255) NOT NULL,
  `amount` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `asset` (`asset`),
  KEY `owner` (`owner`),
  CONSTRAINT `purchase_ibfk_1` FOREIGN KEY (`asset`) REFERENCES `assets` (`name`),
  CONSTRAINT `purchase_ibfk_2` FOREIGN KEY (`owner`) REFERENCES `customer` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `portfolio` (
  `average_cost` float NOT NULL,
  `amount` float NOT NULL,
  `asset` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `realized_pnl` float DEFAULT NULL,
  PRIMARY KEY (`asset`,`username`),
  KEY `username` (`username`),
  CONSTRAINT `portfolio_ibfk_1` FOREIGN KEY (`asset`) REFERENCES `assets` (`name`),
  CONSTRAINT `portfolio_ibfk_2` FOREIGN KEY (`username`) REFERENCES `customer` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO assets
VALUES ("BTC" , "cyrpto");

INSERT INTO assets
VALUES ("AVAX" , "cyrpto");

INSERT INTO assets
VALUES ("ETH" , "cyrpto");

INSERT INTO assets
VALUES ("FTT" , "cyrpto");

INSERT INTO assets
VALUES ("GRT" , "cyrpto");

INSERT INTO assets
VALUES ("HNT" , "cyrpto");

INSERT INTO assets
VALUES ("SOL" , "cyrpto");

INSERT INTO assets
VALUES ("UNI" , "cyrpto");

INSERT INTO assets
VALUES ("XRP" , "cyrpto");

INSERT INTO customer
VALUES ("cagatay" , "cagatay", "iba", "1234", 0,0);

INSERT INTO portfolio
VALUES (30000 , 2, "BTC", "cagatay",0);

INSERT INTO purchase
VALUES ( 1, "cagatay", 29000, 1654367823, "BTC", 1);

INSERT INTO purchase
VALUES ( 2, "cagatay" ,31000, 1654281423, "BTC", 1);





