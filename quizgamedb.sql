-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 02, 2024 at 01:23 PM
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

--
-- Dumping data for table `player`
--

INSERT INTO `player` (`player_Id`, `user_Id`, `singlePlay_HighScore`, `multiPlay_HighScore`, `player_Name`) VALUES
(1, 1, 0, 0, 'AdminThingzzz111'),
(2, 4, 0, 0, 'cherryLabLabjanjan'),
(5, 30, 0, 0, 'jacinth123'),
(6, 27, 0, 0, 'Cherry_Mae'),
(8, 31, 0, 0, 'Meganduhhhh'),
(9, 32, 0, 0, 'Jacinth_Gwapo091');

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
(27, 'CherryPepito', 'CherryMae123', '2024-11-30 04:48:31'),
(30, 'jacinthcedric', 'jacinthcedric09213', '2024-11-30 05:16:31'),
(31, 'Megan09', 'Megan09213', '2024-11-30 06:01:13'),
(32, 'jacinthcedricbarral', '12345678', '2024-12-01 07:09:36');

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
  MODIFY `player_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

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
