-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 12, 2024 at 02:02 AM
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
(3, 'active', 'watch', 8, '2024-12-12 13:25:43.000000', 'This is a watch', 'f-105w_watch.webp', 5, 'Casio Watch', 303),
(4, 'active', 'music', 31.29, '2025-01-08 13:25:00.000000', 'This is a record player. PLEASE BUY IT!', 'victrola-record-player.jpeg', 30, 'Victorola Record Player', 252),
(352, 'completed', 'auction', 5, '2024-12-07 19:15:00.000000', 'This is an auction', 'imagePath', 0, 'An Auction', 302),
(402, 'active', 'goodProduct', 1, '2024-12-13 13:15:00.000000', 'This is great, buy now', 'imagePath', 1, 'Really good product', 453),
(452, 'active', 'guitar', 137, '2024-12-12 19:00:00.000000', 'This is a guitar. It works.', 'acoustic-guitar.webp', 130, 'Black Acoustic Guitar', 552),
(502, 'completed', 'headphone', 25, '2024-12-11 16:15:00.000000', 'This is a pair of sony headphones.', 'sony-headphones.webp', 20, 'Sony Headphones', 302);

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
(601);

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

--
-- Dumping data for table `bid`
--

INSERT INTO `bid` (`id`, `amount`, `auction_id`, `user_id`) VALUES
(1, 7, 3, 252),
(3, 3, 352, 252),
(4, 5, 352, 252),
(6, 31.29, 4, 552),
(102, 135, 452, 252),
(152, 137, 452, 252),
(153, 8, 3, 252),
(155, 25, 502, 252);

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
(251);

-- --------------------------------------------------------

--
-- Table structure for table `reply`
--

CREATE TABLE `reply` (
  `id` int(11) NOT NULL,
  `previous_reply_id` int(11) DEFAULT NULL,
  `review_id` int(11) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reply`
--

INSERT INTO `reply` (`id`, `previous_reply_id`, `review_id`, `comment`) VALUES
(252, NULL, 1, 'Sorry about the shipping. USPS is awful :(');

-- --------------------------------------------------------

--
-- Table structure for table `reply_seq`
--

CREATE TABLE `reply_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reply_seq`
--

INSERT INTO `reply_seq` (`next_val`) VALUES
(351);

-- --------------------------------------------------------

--
-- Table structure for table `review`
--

CREATE TABLE `review` (
  `id` int(11) NOT NULL,
  `rating` double NOT NULL,
  `provider_id` int(11) DEFAULT NULL,
  `reviewer_id` int(11) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `review`
--

INSERT INTO `review` (`id`, `rating`, `provider_id`, `reviewer_id`, `comment`) VALUES
(1, 3, 252, 303, 'The product looked great, but took forever to get here.'),
(2, 5, 252, 302, 'The seller was great. Everything was delivered quickly and the product was in mint condition.'),
(3, 5, 252, 352, 'The seller was great would buy from them again.');

-- --------------------------------------------------------

--
-- Table structure for table `review_completed`
--

CREATE TABLE `review_completed` (
  `id` int(11) NOT NULL,
  `review_completed` bit(1) NOT NULL,
  `auction_id` int(11) DEFAULT NULL,
  `review_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `review_completed`
--

INSERT INTO `review_completed` (`id`, `review_completed`, `auction_id`, `review_id`) VALUES
(2, b'0', 352, NULL),
(52, b'0', 402, NULL),
(102, b'0', 452, NULL),
(152, b'0', 502, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `review_completed_seq`
--

CREATE TABLE `review_completed_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `review_completed_seq`
--

INSERT INTO `review_completed_seq` (`next_val`) VALUES
(251);

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
(401);

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
(1, 'johnmclean@gmail.com', 'imagePath', 'Raleigh, NC', 'John McLean', '$2a$10$7pnXnMvJmK/YJ5bAnioKQuoUwQy3YkO8HeSrU5CmgsCF06GuAIe8.', 0, 'admin', 'johnmclean'),
(252, 'impoptic@gmail.com', 'random-profile-pic.jpg', 'Greensboro, NC', 'Hazel Victor', '$2a$10$7pnXnMvJmK/YJ5bAnioKQuoUwQy3YkO8HeSrU5CmgsCF06GuAIe8.', 4.333333333333333, 'user', 'impoptic'),
(302, 'shademap@gmail.com', 'random-profile-pic-2.jpg', 'Greensboro, NC', 'Jenny Harvey', '$2a$10$7pnXnMvJmK/YJ5bAnioKQuoUwQy3YkO8HeSrU5CmgsCF06GuAIe8.', 5, 'user', 'shademap'),
(303, 'overstudy@gmail.com', 'imagePath', 'Raleigh, NC', 'Edward Quast', 'password', 0, 'user', 'overstudy'),
(352, 'colossaldairy@gmail.com', 'imagePath', ' ', 'Makenzie Crofton', 'password1', 0, 'user', 'colossaldairy'),
(402, 'jsmith1@gmail.com', 'meme-profile-pic.jpg', ' Wilmington, NC', 'Jackson Smith', 'password1', 0, 'user', 'jsmith1'),
(453, 'johndoe1@gmail.com', 'imagePath', ' Greensboro, NC', 'John Doe', 'password1', 0, 'user', 'johndoe1'),
(502, 'usability1@gmail.com', 'imagePath', ' New York, NY', 'Steve Krug', 'password1', 0, 'user', 'usability1'),
(552, 'julieandrews@gmail.com', 'imagePath', ' ', 'Julie Andrews', '$2a$10$zFIX6K26YLZ7cuY.0t.frOeUdiee.Mv3nWEKF//dOwsy3Yx7TA.rC', 0, 'user', 'julieandrews'),
(602, 'matthewrow@gmail.com', NULL, NULL, 'Matthew Row', 'password', 0, 'admin', 'matthewrow'),
(652, 'zachlee@gmail.com', 'imagePath', 'Greensboro, NC', 'Zach Lee', '$2a$10$N.1hAloo8F0pfaGk7TkP..RXaOzuUNqCU1hC0.M29ZRyR0KYJUXV2', 0, 'user', 'zachlee'),
(702, 'admin@gmail.com', 'imagePath', 'Greensboro, NC', 'Jane Doe', '$2a$10$2t2z5UGZ092IEOmRLUG1Z.S7o4wgvRvdjijlYkVrunX9yiNbaK8US', 0, 'admin', 'admin'),
(752, 'fredjohnson@gmail.com', 'imagePath', 'Greensboro, NC', 'Fred Johnson', '$2a$10$4K2zvMK8vYKjqNkv2sLw8.XGPz/GCO4JnOFeHgSQ/sV5igUb53ZFu', 0, 'user', 'fredjohnson');

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
(851);

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
-- Indexes for table `reply`
--
ALTER TABLE `reply`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK61nsmknwbutohvuvgu4qpnclh` (`previous_reply_id`),
  ADD KEY `FKd5ckwt38d4ibe84wlfc3o8jw8` (`review_id`);

--
-- Indexes for table `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKi913970b83vivoxn5dbnso3mg` (`provider_id`),
  ADD KEY `FKt58e9mdgxpl7j90ketlaosmx4` (`reviewer_id`);

--
-- Indexes for table `review_completed`
--
ALTER TABLE `review_completed`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKp6uys3fmja4kte1i95ncfvkq4` (`auction_id`),
  ADD UNIQUE KEY `UKb8wewfhcwgm14ivggn2uk7a9h` (`review_id`);

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
-- Constraints for table `reply`
--
ALTER TABLE `reply`
  ADD CONSTRAINT `FK61nsmknwbutohvuvgu4qpnclh` FOREIGN KEY (`previous_reply_id`) REFERENCES `reply` (`id`),
  ADD CONSTRAINT `FKd5ckwt38d4ibe84wlfc3o8jw8` FOREIGN KEY (`review_id`) REFERENCES `review` (`id`);

--
-- Constraints for table `review`
--
ALTER TABLE `review`
  ADD CONSTRAINT `FKi913970b83vivoxn5dbnso3mg` FOREIGN KEY (`provider_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKt58e9mdgxpl7j90ketlaosmx4` FOREIGN KEY (`reviewer_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `review_completed`
--
ALTER TABLE `review_completed`
  ADD CONSTRAINT `FKob5t6401d9hdlcjp81m7w8x02` FOREIGN KEY (`auction_id`) REFERENCES `auction` (`id`),
  ADD CONSTRAINT `FKthekx1aqn8bir9hh3drseqt2e` FOREIGN KEY (`review_id`) REFERENCES `review` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
