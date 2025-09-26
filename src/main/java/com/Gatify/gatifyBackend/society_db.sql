USE society_db;

CREATE TABLE `block` (
  `id` int NOT NULL AUTO_INCREMENT,
  `society_id` int NOT NULL,
  `block_name` char(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `society_id` (`society_id`),
  CONSTRAINT `block_ibfk_1` FOREIGN KEY (`society_id`) REFERENCES `society` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `complaint` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `society_id` int NOT NULL,
  `block_id` int NOT NULL,
  `flat_id` int NOT NULL,
  `complaint_type` enum('Electrician','Plumber','Launderer','Carpenter','PestControl') NOT NULL,
  `complaint_status` enum('Pending','Assigned','Resolved') DEFAULT 'Pending',
  `person_assigned_name` varchar(255) DEFAULT 'Not assigned yet',
  `person_assigned_number` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `chk_phone` CHECK (((`person_assigned_number` is null) or ((char_length(`person_assigned_number`) = 10) and regexp_like(`person_assigned_number`,_utf8mb4'^[0-9]{10}$'))))
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `entry_approval` (
  `id` int NOT NULL AUTO_INCREMENT,
  `company_name` varchar(255) NOT NULL,
  `flat_resident_id` int NOT NULL,
  `enterer_name` varchar(255) NOT NULL,
  `status` enum('Pending','Approved','Declined') DEFAULT 'Pending',
  PRIMARY KEY (`id`),
  KEY `flat_resident_id` (`flat_resident_id`),
  CONSTRAINT `entry_approval_ibfk_1` FOREIGN KEY (`flat_resident_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `flat` (
  `id` int NOT NULL AUTO_INCREMENT,
  `flat_number` varchar(4) NOT NULL,
  `block_id` int NOT NULL,
  `society_id` int NOT NULL,
  `type` enum('1BHK','2BHK','3BHK') NOT NULL,
  `carpet_area` decimal(10,2) NOT NULL,
  `block_area` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `block_id` (`block_id`),
  KEY `society_id` (`society_id`),
  CONSTRAINT `flat_ibfk_1` FOREIGN KEY (`block_id`) REFERENCES `block` (`id`) ON DELETE CASCADE,
  CONSTRAINT `flat_ibfk_2` FOREIGN KEY (`society_id`) REFERENCES `society` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `notice` (
  `id` int NOT NULL AUTO_INCREMENT,
  `notice_message` varchar(500) NOT NULL,
  `user_id` int NOT NULL,
  `user_mobile_number` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `pre_entry_approval` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` enum('Guest','Cab','Delivery','VisitingHelp') NOT NULL,
  `status` enum('SurpriseDelivery','UsualDelivery') NOT NULL,
  `date` varchar(10) NOT NULL COMMENT 'Format: DD:MM:YYYY',
  `starting_time` varchar(10) NOT NULL COMMENT 'Format: hh:mm AM/PM',
  `hours` int NOT NULL,
  `company_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `society` (
  `id` int NOT NULL AUTO_INCREMENT,
  `society_name` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `area` varchar(255) NOT NULL,
  `number_of_blocks` int NOT NULL,
  `pin_code` char(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `gmail` varchar(255) NOT NULL,
  `mobile_number` char(10) NOT NULL,
  `type` enum('Resident','Manager','SecurityGuard') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `gmail` (`gmail`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `user_flat_relation` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `society_id` bigint NOT NULL,
  `block_id` bigint NOT NULL,
  `flat_id` bigint NOT NULL,
  `status` enum('PENDING','ACTIVE','INACTIVE') NOT NULL DEFAULT 'PENDING',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci