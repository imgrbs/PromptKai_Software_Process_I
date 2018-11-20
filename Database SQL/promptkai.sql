-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Generation Time: Nov 20, 2018 at 04:20 PM
-- Server version: 10.2.18-MariaDB-1:10.2.18+maria~bionic
-- PHP Version: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `promptkai`
--

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `order_date` date NOT NULL,
  `amount` int(4) NOT NULL,
  `total` float NOT NULL,
  `location` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`order_id`, `order_date`, `amount`, `total`, `location`) VALUES
(1, '2018-11-14', 2, 360, ''),
(2, '2018-11-20', 1, 150, ''),
(3, '2018-11-20', 1, 150, ''),
(4, '2018-11-20', 1, 150, ''),
(5, '2018-11-20', 1, 150, ''),
(6, '2018-11-20', 1, 150, ''),
(7, '2018-11-20', 1, 150, ''),
(8, '2018-11-20', 1, 150, ''),
(9, '2018-11-20', 1, 150, 'asdasdsad'),
(10, '2018-11-20', 1, 150, 'asdasdasddas'),
(11, '2018-11-20', 1, 150, 'sadsad');

-- --------------------------------------------------------

--
-- Table structure for table `order_details`
--

CREATE TABLE `order_details` (
  `order_detail_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `payment_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `sub_total_price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `order_details`
--

INSERT INTO `order_details` (`order_detail_id`, `product_id`, `order_id`, `payment_id`, `amount`, `sub_total_price`) VALUES
(1, 1, 11, 9, 1, 150);

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `payment_id` int(11) NOT NULL,
  `payment_method` varchar(30) NOT NULL,
  `paid_date` date NOT NULL,
  `user_id` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `payments`
--

INSERT INTO `payments` (`payment_id`, `payment_method`, `paid_date`, `user_id`) VALUES
(2, 'Credit Card', '2018-11-20', '1076104752563889'),
(3, 'Credit Card', '2018-11-20', '1076104752563889'),
(4, 'Credit Card', '2018-11-20', '1076104752563889'),
(5, 'Credit Card', '2018-11-20', '1076104752563889'),
(6, 'Credit Card', '2018-11-20', '1076104752563889'),
(7, 'Credit Card', '2018-11-20', '1076104752563889'),
(8, 'Credit Card', '2018-11-20', '1076104752563889'),
(9, 'Credit Card', '2018-11-20', '1076104752563889');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `product_name` varchar(45) DEFAULT NULL,
  `product_detail` varchar(255) NOT NULL,
  `product_price` double NOT NULL,
  `product_type` varchar(50) NOT NULL,
  `img_path` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `product_name`, `product_detail`, `product_price`, `product_type`, `img_path`) VALUES
(1, 'กระเป๋าใส่เหรียญ', 'กระเป๋าใส่เหรียญ ดีไซน์เก๋ๆ ขนาดสามารถใส่บัตรได้ มีซิปเพื่อความปลอดภัย วัสดุทนทาน ทำความสะอาดง่าย', 150, 'bag', 'assets/img/bag.png'),
(2, 'แว่นสายตาแฟชั่น', 'แว่นสายตาแฟชั่น สวยๆ เหมาะสำหรับคนชิคๆ', 199, 'accessory', 'assets/img/glasses.png');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`);

--
-- Indexes for table `order_details`
--
ALTER TABLE `order_details`
  ADD PRIMARY KEY (`order_detail_id`),
  ADD KEY `order_id` (`order_id`),
  ADD KEY `payment_id` (`payment_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`payment_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `order_details`
--
ALTER TABLE `order_details`
  MODIFY `order_detail_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `payments`
--
ALTER TABLE `payments`
  MODIFY `payment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `order_details`
--
ALTER TABLE `order_details`
  ADD CONSTRAINT `order_details_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
  ADD CONSTRAINT `order_details_ibfk_2` FOREIGN KEY (`payment_id`) REFERENCES `payments` (`payment_id`),
  ADD CONSTRAINT `order_details_ibfk_3` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
