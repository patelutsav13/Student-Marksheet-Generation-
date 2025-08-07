-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 07, 2025 at 02:05 PM
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
-- Database: `marksheet`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteStudentById` (IN `in_delete` INT(10))   BEGIN
    DELETE FROM student_marks WHERE id = in_delete;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `student_marks`
--

CREATE TABLE `student_marks` (
  `id` int(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `mark1` int(10) NOT NULL,
  `mark2` int(10) NOT NULL,
  `mark3` int(10) NOT NULL,
  `mark4` int(10) NOT NULL,
  `mark5` int(10) NOT NULL,
  `totalMarks` int(10) NOT NULL,
  `percentage` double NOT NULL,
  `grade` varchar(2) NOT NULL,
  `phoneNumber` varchar(10) NOT NULL,
  `gk` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_marks`
--

INSERT INTO `student_marks` (`id`, `name`, `mark1`, `mark2`, `mark3`, `mark4`, `mark5`, `totalMarks`, `percentage`, `grade`, `phoneNumber`, `gk`) VALUES
(181, 'Utsav Patel', 99, 100, 100, 100, 100, 499, 99.8, 'A+', '6351325407', 100);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student_marks`
--
ALTER TABLE `student_marks`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student_marks`
--
ALTER TABLE `student_marks`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=211;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
