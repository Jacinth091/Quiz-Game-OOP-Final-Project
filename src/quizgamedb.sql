-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 29, 2024 at 09:54 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quizgamedb`
--

-- --------------------------------------------------------

--
-- Table structure for table `leaderboards`
--

CREATE TABLE `leaderboards` (
  `leaderboard_Id` int(11) UNSIGNED NOT NULL,
  `player_id` int(11) NOT NULL,
  `game_Mode` enum('Single','Multi') NOT NULL,
  `player_Score` int(100) UNSIGNED NOT NULL,
  `game_Date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `player`
--

CREATE TABLE `player` (
  `player_Id` int(11) NOT NULL,
  `user_Id` int(11) NOT NULL,
  `singlePlay_HighScore` int(100) UNSIGNED NOT NULL,
  `multiPlay_HighScore` int(100) UNSIGNED NOT NULL,
  `player_Name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_Id` int(11) NOT NULL,
  `user_Name` varchar(100) NOT NULL,
  `user_Pass` varchar(255) NOT NULL,
  `dateCreated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_Id`, `user_Name`, `user_Pass`, `dateCreated`) VALUES
(1, 'admin', 'admin123', '2024-11-25 14:30:43'),
(4, 'janjan', 'cherry123', '2024-11-25 14:50:50'),
(6, 'jacinthcedric', 'jacinthgwapo', '2024-11-25 15:06:49'),
(18, 'admin1', 'admin123456', '2024-11-25 23:48:13'),
(19, 'admin2', 'admin091', '2024-11-25 23:51:39'),
(20, 'admin3', 'admin09123', '2024-11-25 23:53:14'),
(21, 'admin4', 'admin1234', '2024-11-25 23:54:11'),
(22, 'admin5', 'admin12345', '2024-11-25 23:55:55'),
(25, 'admin7', 'admin1234567', '2024-11-26 00:02:04');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `leaderboards`
--
ALTER TABLE `leaderboards`
  ADD PRIMARY KEY (`leaderboard_Id`),
  ADD KEY `leaderboards_PlayerID` (`player_id`);

--
-- Indexes for table `player`
--
ALTER TABLE `player`
  ADD PRIMARY KEY (`player_Id`) USING BTREE,
  ADD UNIQUE KEY `player_Name` (`player_Name`),
  ADD KEY `user_Id` (`user_Id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_Id`),
  ADD UNIQUE KEY `user_Name` (`user_Name`),
  ADD UNIQUE KEY `user_Pass` (`user_Pass`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `leaderboards`
--
ALTER TABLE `leaderboards`
  MODIFY `leaderboard_Id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `player`
--
ALTER TABLE `player`
  MODIFY `player_Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `leaderboards`
--
ALTER TABLE `leaderboards`
  ADD CONSTRAINT `leaderboards_PlayerID` FOREIGN KEY (`player_id`) REFERENCES `player` (`player_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `player`
--
ALTER TABLE `player`
  ADD CONSTRAINT `user_Id` FOREIGN KEY (`user_Id`) REFERENCES `user` (`user_Id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
