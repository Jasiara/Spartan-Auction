-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 12, 2024 at 05:03 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `spartan-auction`
--

-- --------------------------------------------------------

--
-- Table structure for table `auction`
--

CREATE TABLE `auction` (
  `id` int(11) NOT NULL,
  `auction_status` varchar(255) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `current_price` double NOT NULL,
  `date_and_time` datetime(6) NOT NULL,
  `description` varchar(255) NOT NULL,
  `image_path` varchar(255) NOT NULL,
  `starting_price` double NOT NULL,
  `title` varchar(255) NOT NULL,
  `seller_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `auction`
--

INSERT INTO `auction` (`id`, `auction_status`, `category`, `current_price`, `date_and_time`, `description`, `image_path`, `starting_price`, `title`, `seller_id`) VALUES
(1, 'active', 'phone', 915, '2024-11-23 13:25:43.000000', 'This is an iPhone', 'imagePath1', 915, 'iPhone 15', 2),
(2, 'active', 'headphone', 40, '2024-11-23 13:25:43.000000', 'These are headphones', 'imagePath2', 40, 'Sony Headphones', 1),
(3, 'active', 'watch', 5, '2024-11-23 13:25:43.000000', 'This is a watch', 'imagePath3', 5, 'Casio Watch', 3),
(4, 'active', 'jacket', 20, '2024-11-23 13:25:43.000000', 'This is a jean jacket', 'imagePath4', 20, 'Jean Jacket', 1),
(5, 'active', 'chair', 65, '2024-11-23 13:25:43.000000', 'This is a chair.', 'imagePath6', 65, 'Chair', 4);

-- --------------------------------------------------------

--
-- Table structure for table `auction_seq`
--

CREATE TABLE `auction_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `auction_seq`
--

INSERT INTO `auction_seq` (`next_val`) VALUES
(1),
(101);

-- --------------------------------------------------------

--
-- Table structure for table `bid`
--

CREATE TABLE `bid` (
  `id` int(11) NOT NULL,
  `amount` double NOT NULL,
  `auction_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `bid_seq`
--

CREATE TABLE `bid_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bid_seq`
--

INSERT INTO `bid_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `rating`
--

CREATE TABLE `rating` (
  `id` int(11) NOT NULL,
  `rating` double NOT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `rating_seq`
--

CREATE TABLE `rating_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rating_seq`
--

INSERT INTO `rating_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `review`
--

CREATE TABLE `review` (
  `id` int(11) NOT NULL,
  `rating` double NOT NULL,
  `review` varchar(255) DEFAULT NULL,
  `provider_id` int(11) DEFAULT NULL,
  `reviewer_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `review`
--

INSERT INTO `review` (`id`, `rating`, `review`, `provider_id`, `reviewer_id`) VALUES
(1, 2, 'Review', 4, 1),
(2, 3, 'Review', 4, 2),
(3, 4, 'Review', 3, 2),
(4, 3, 'Review', 3, 2),
(5, 3, 'Review', 1, 4),
(6, 5, 'Review', 4, 1);

-- --------------------------------------------------------

--
-- Table structure for table `review_seq`
--

CREATE TABLE `review_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `review_seq`
--

INSERT INTO `review_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `rating_average` double NOT NULL,
  `user_type` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `email`, `image_path`, `location`, `name`, `password`, `rating_average`, `user_type`, `username`) VALUES
(1, 'impoptic@gmail.com', 'imagePath1', 'Greensboro, NC', 'Hazel Victor', 'password1', 3.5, 'user', 'impoptic'),
(2, 'shademap@gmail.com', 'imagePath2', 'Greensboro, NC', 'Jenny Harvey', 'password2', 0, 'user', 'shademap'),
(3, 'colossaldairy@gmail.com', 'imagePath3', 'Greensboro, NC', 'Makenzie Crofton', 'password3', 0, 'user', 'colossaldairy'),
(4, 'overtstudy@gmail.com', 'imagePath4', 'Greensboro, NC', 'Edward Quast', 'password4', 0, 'user', 'overtstudy'),
(5, 'annoyedbeeswax@gmail.com', 'imagePath5', 'Greensboro, NC', 'Kimberly Lee', 'password5', 0, 'user', 'annoyedbeeswax');

-- --------------------------------------------------------

--
-- Table structure for table `user_seq`
--

CREATE TABLE `user_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_seq`
--

INSERT INTO `user_seq` (`next_val`) VALUES
(1),
(101);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `auction`
--
ALTER TABLE `auction`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKf69hwkicisgydruy5wyyj02k1` (`seller_id`);

--
-- Indexes for table `bid`
--
ALTER TABLE `bid`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhexc6i4j8i0tmpt8bdulp6g3g` (`auction_id`),
  ADD KEY `FK4abkntgv9nvsfi86p7kfl63au` (`user_id`);

--
-- Indexes for table `rating`
--
ALTER TABLE `rating`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpn05vbx6usw0c65tcyuce4dw5` (`user_id`);

--
-- Indexes for table `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKi913970b83vivoxn5dbnso3mg` (`provider_id`),
  ADD KEY `FKt58e9mdgxpl7j90ketlaosmx4` (`reviewer_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`),
  ADD UNIQUE KEY `UKsb8bbouer5wak8vyiiy4pf2bx` (`username`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `auction`
--
ALTER TABLE `auction`
  ADD CONSTRAINT `FKf69hwkicisgydruy5wyyj02k1` FOREIGN KEY (`seller_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `bid`
--
ALTER TABLE `bid`
  ADD CONSTRAINT `FK4abkntgv9nvsfi86p7kfl63au` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKhexc6i4j8i0tmpt8bdulp6g3g` FOREIGN KEY (`auction_id`) REFERENCES `auction` (`id`);

--
-- Constraints for table `rating`
--
ALTER TABLE `rating`
  ADD CONSTRAINT `FKpn05vbx6usw0c65tcyuce4dw5` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `review`
--
ALTER TABLE `review`
  ADD CONSTRAINT `FKi913970b83vivoxn5dbnso3mg` FOREIGN KEY (`provider_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKt58e9mdgxpl7j90ketlaosmx4` FOREIGN KEY (`reviewer_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
