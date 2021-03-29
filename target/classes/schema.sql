drop table if exists account;

CREATE TABLE `account` (
  `account_id` int NOT NULL,
  `account_number` int NOT NULL,
  `account_type` varchar(45) NOT NULL,
  `balance` int NOT NULL,
  `account_name` varchar(45) NOT NULL,
  `fk_customer_id` int DEFAULT NULL,
  PRIMARY KEY (`account_number`),
  KEY `fk_customer_id_idx` (`fk_customer_id`),
  CONSTRAINT `fk_customer_id` FOREIGN KEY (`fk_customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci