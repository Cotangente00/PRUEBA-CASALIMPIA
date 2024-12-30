-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 30, 2024 at 02:19 PM
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
-- Database: `crud_jsf_jpf`
--

-- --------------------------------------------------------

--
-- Table structure for table `detalleventa`
--

CREATE TABLE `detalleventa` (
  `id` int(11) NOT NULL,
  `idVenta` int(11) DEFAULT NULL,
  `idProducto` int(11) DEFAULT NULL,
  `nombreProducto` varchar(200) NOT NULL,
  `cantidad` tinyint(4) DEFAULT NULL,
  `precioProducto` decimal(7,0) NOT NULL,
  `montoProducto` decimal(10,0) NOT NULL,
  `fechaHora` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `fullName` varchar(200) NOT NULL,
  `numDoc` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `detalleventa`
--

INSERT INTO `detalleventa` (`id`, `idVenta`, `idProducto`, `nombreProducto`, `cantidad`, `precioProducto`, `montoProducto`, `fechaHora`, `fullName`, `numDoc`) VALUES
(1, 1, 8, 'monitor samsung 144hz', 2, 1500, 3000, '2024-12-30 09:37:10', 'Julian Camilo  Avila Alfonso', 1034276238),
(2, 1, 2, 'teclado Razer HuntsMan', 4, 300, 1200, '2024-12-30 09:37:10', 'Julian Camilo  Avila Alfonso', 1034276238),
(3, 1, 1, 'Mouse Razer', 5, 30, 150, '2024-12-30 09:37:10', 'Julian Camilo  Avila Alfonso', 1034276238),
(4, 2, 4, 'tv samsung', 5, 1000, 5000, '2024-12-30 10:44:10', 'José daniel avila cruz', 10212910291),
(5, 2, 8, 'monitor samsung 144hz', 4, 1500, 6000, '2024-12-30 10:44:10', 'José daniel avila cruz', 10212910291),
(6, 2, 3, 'mouse razar', 3, 30, 90, '2024-12-30 10:44:10', 'José daniel avila cruz', 10212910291),
(7, 2, 10, 'xpen table g43', 7, 100, 700, '2024-12-30 10:44:10', 'José daniel avila cruz', 10212910291);

-- --------------------------------------------------------

--
-- Table structure for table `persona`
--

CREATE TABLE `persona` (
  `id` int(11) NOT NULL,
  `numDocumento` bigint(20) DEFAULT NULL,
  `nombres` varchar(200) DEFAULT NULL,
  `apellidos` varchar(200) DEFAULT NULL,
  `sexo` char(1) DEFAULT NULL,
  `numCelular` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `persona`
--

INSERT INTO `persona` (`id`, `numDocumento`, `nombres`, `apellidos`, `sexo`, `numCelular`) VALUES
(1, 1034276238, 'Julian Camilo ', 'Avila Alfonso', 'M', 3138193027),
(2, 10212910291, 'José daniel', 'avila cruz', 'M', 3138293823),
(3, 102483934, 'omaira', 'alfonso sagun', 'F', 3114591551),
(4, 1049873477, 'Maria Luisa Fernanda ', 'Lopez Bravo', 'F', 3390283922);

-- --------------------------------------------------------

--
-- Table structure for table `producto`
--

CREATE TABLE `producto` (
  `id` int(11) NOT NULL,
  `nombre` varchar(200) DEFAULT NULL,
  `precio` decimal(7,0) DEFAULT NULL,
  `estado` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `producto`
--

INSERT INTO `producto` (`id`, `nombre`, `precio`, `estado`) VALUES
(1, 'Mouse Razer', 30, 2),
(2, 'teclado Razer HuntsMan', 300, 2),
(3, 'mouse razar', 30, 1),
(4, 'tv samsung', 1000, 1),
(7, 'celular apple', 1500, 1),
(8, 'monitor samsung 144hz', 1500, 1),
(9, 'touchpad', 500, 1),
(10, 'xpen table g43', 100, 1);

-- --------------------------------------------------------

--
-- Table structure for table `venta`
--

CREATE TABLE `venta` (
  `id` int(11) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `idPersona` tinyint(4) DEFAULT NULL,
  `nombresPersona` varchar(200) NOT NULL,
  `apellidosPersona` varchar(200) NOT NULL,
  `numDocumentoPersona` bigint(20) NOT NULL,
  `numCelularPersona` bigint(20) NOT NULL,
  `monto` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `venta`
--

INSERT INTO `venta` (`id`, `fecha`, `idPersona`, `nombresPersona`, `apellidosPersona`, `numDocumentoPersona`, `numCelularPersona`, `monto`) VALUES
(1, '2024-12-30 09:37:10', 1, 'Julian Camilo ', 'Avila Alfonso', 1034276238, 3138193027, 4350),
(2, '2024-12-30 10:44:10', 2, 'José daniel', 'avila cruz', 10212910291, 3138293823, 11790);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `detalleventa`
--
ALTER TABLE `detalleventa`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `detalleventa`
--
ALTER TABLE `detalleventa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `persona`
--
ALTER TABLE `persona`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `venta`
--
ALTER TABLE `venta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
