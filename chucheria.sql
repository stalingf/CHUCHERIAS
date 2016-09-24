-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 16, 2016 at 03:01 AM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 5.5.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `chucheria`
--

-- --------------------------------------------------------

--
-- Table structure for table `anuncio`
--

CREATE TABLE `anuncio` (
  `id` int(11) NOT NULL,
  `categoria` varchar(40) NOT NULL,
  `tipo` varchar(40) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `descripcion` varchar(1500) NOT NULL,
  `precio` decimal(10,0) NOT NULL,
  `moneda` varchar(10) NOT NULL,
  `whatsap` varchar(3) NOT NULL,
  `publicado` datetime NOT NULL,
  `idusuario` int(11) NOT NULL,
  `foto1` varchar(200) DEFAULT NULL,
  `foto2` varchar(200) DEFAULT NULL,
  `foto3` varchar(200) DEFAULT NULL,
  `foto4` varchar(200) DEFAULT NULL,
  `foto5` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `anuncio`
--

INSERT INTO `anuncio` (`id`, `categoria`, `tipo`, `titulo`, `descripcion`, `precio`, `moneda`, `whatsap`, `publicado`, `idusuario`, `foto1`, `foto2`, `foto3`, `foto4`, `foto5`) VALUES
(11, 'Electrodomestico', 'Celular', 'LG G4', 'Usado', '54321', '$RD', 'Si', '2016-07-15 00:17:38', 52, '52/FriJul15001738BOT2016', NULL, NULL, NULL, NULL),
(12, 'hogar', 'juegos de habitacion', 'Juego nitido', 'nuevo', '500', '$USA', 'Si', '2016-07-20 11:19:04', 52, '52/WedJul20111904BOT2016', NULL, NULL, NULL, NULL),
(13, 'Herramientas', 'Martillo', 'Martillo', 'xD', '500', '$RD', 'Si', '2016-07-20 11:42:50', 52, '52/WedJul20114250BOT2016', NULL, NULL, NULL, NULL),
(14, 'Herramientas', 'Alicate', 'Pinsas', 'sdf', '500', '$USA', 'Si', '2016-07-20 12:06:45', 52, '52/WedJul20120645BOT2016', NULL, NULL, NULL, NULL),
(15, 'Deporte', 'Bicicleta', 'BMX', 'Nueva', '574654', '$RD', 'Si', '2016-07-20 12:26:28', 52, '52/WedJul20122628BOT2016', NULL, NULL, NULL, NULL),
(16, 'Electrodomestico', 'Celular', 'Plasma LG', 'xD', '6432', '$USA', 'Si', '2016-07-20 12:27:00', 52, '52/WedJul20122700BOT2016', NULL, NULL, NULL, NULL),
(17, 'Electrodomestico', 'Celular', 'si', '5654', '4541', '$RD', 'Si', '2016-07-20 12:35:17', 52, '52/WedJul20123517BOT2016', NULL, NULL, NULL, NULL),
(18, 'Electrodomestico', 'Celular', 'LG G5', 'sldkfjlkj', '5000', '$RD', 'Si', '2016-07-22 16:46:44', 52, '52/FriJul22164644BOT2016', NULL, NULL, NULL, NULL),
(19, 'Herramientas', 'Martillo', 'Martillador', 'slkfj', '500', '$RD', 'Si', '2016-07-23 23:34:25', 52, '52/SatJul23233425BOT2016', NULL, NULL, NULL, NULL),
(20, 'hogar', 'juegos de habitacion', 'Nuevos', 'lkjlksjfs', '800', '$USA', 'Si', '2016-07-23 23:35:48', 52, '52/SatJul23233548BOT2016', NULL, NULL, NULL, NULL),
(21, 'Vehiculos', 'Camion', 'Usado Camion', 'y se da;a', '500', '$RD', 'Si', '2016-07-23 23:36:21', 52, '52/SatJul23233621BOT2016', NULL, NULL, NULL, NULL),
(22, 'Electrodomestico', 'Plasma', 'Plasma LG del 2017 esta como nueva Comprala hoy mismo mi gente', 'con usb', '700', '$USA', 'Si', '2016-07-23 23:37:42', 52, '52/SatJul23233742BOT2016', NULL, NULL, NULL, NULL),
(23, 'Vehiculos', 'Caminoneta', 'las bmx la tengo nuevas', 'lskdfjl', '24354', '$RD', 'Si', '2016-07-23 23:56:20', 52, '52/SatJul23235620BOT2016', NULL, NULL, NULL, NULL),
(24, 'hogar', 'mesas', 'Mesa de pino', 'lskdjf', '5454', '$RD', 'Si', '2016-07-23 23:58:07', 52, '52/SatJul23235807BOT2016', NULL, NULL, NULL, NULL),
(25, 'Vestimenta', 'Poloche', 'Nuevo poloche', 'kjfslkj', '25454', '$USA', 'Si', '2016-07-23 23:58:33', 52, '52/SatJul23235833BOT2016', NULL, NULL, NULL, NULL),
(26, 'Electrodomestico', 'Celular', 'LG G3 ', '<p> es nuevo para que lo usen </p>\r\n<p>todos le gusta la funcionalidades \r\nde este nuevo terminal el GL G3\r\nque aguanta memoria hasta de 3GB </p>', '545', '$RD', 'Si', '2016-07-23 23:59:02', 52, '52/SatJul23235902BOT2016', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `categoria`
--

CREATE TABLE `categoria` (
  `categoria` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categoria`
--

INSERT INTO `categoria` (`categoria`) VALUES
('Deporte'),
('Electrodomestico'),
('Herramientas'),
('hogar'),
('otros'),
('Vehiculos'),
('Vestimenta');

-- --------------------------------------------------------

--
-- Table structure for table `tipocategoria`
--

CREATE TABLE `tipocategoria` (
  `id` int(11) NOT NULL,
  `categoria` varchar(40) NOT NULL,
  `tipo_categoria` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipocategoria`
--

INSERT INTO `tipocategoria` (`id`, `categoria`, `tipo_categoria`) VALUES
(1, 'Herramientas', 'Martillo'),
(2, 'Vestimenta', 'Poloche'),
(3, 'Vestimenta', 'Zapatos'),
(4, 'Deporte', 'Bicicleta'),
(5, 'Vehiculos', 'Pasola'),
(6, 'Electrodomestico', 'Celular'),
(7, 'Electrodomestico', 'Plasma'),
(8, 'Herramientas', 'Alicate'),
(9, 'Vehiculos', 'Camion'),
(10, 'Vehiculos', 'Caminoneta'),
(11, 'Vestimenta', 'Interiores'),
(12, 'hogar', 'mesas'),
(13, 'hogar', 'comedor'),
(14, 'hogar', 'juegos de habitacion');

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `sexo` varchar(10) NOT NULL,
  `edad` int(11) NOT NULL,
  `telefono` varchar(14) NOT NULL,
  `email` varchar(50) NOT NULL,
  `clave` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `apellidos`, `sexo`, `edad`, `telefono`, `email`, `clave`) VALUES
(52, 'STALING', 'adriano', 'Otros', 20, '8098524689', '@gmail.com', '123'),
(53, 'Claudia', 'suarez', 'Femenino', 20, '5454654', 'c@gmail.com', '123'),
(54, 'Fulanito', 'no tiene', 'Masculino', 18, '54654654654', 'k@gmail.com', '12345'),
(57, 'stalinf', 'fff', 'Masculino', 20, '94568654', 't@gmail.com', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `anuncio`
--
ALTER TABLE `anuncio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idusuarioo` (`idusuario`);

--
-- Indexes for table `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`categoria`);

--
-- Indexes for table `tipocategoria`
--
ALTER TABLE `tipocategoria`
  ADD PRIMARY KEY (`id`),
  ADD KEY `categoria` (`categoria`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `telefono` (`telefono`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `anuncio`
--
ALTER TABLE `anuncio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT for table `tipocategoria`
--
ALTER TABLE `tipocategoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `anuncio`
--
ALTER TABLE `anuncio`
  ADD CONSTRAINT `anuncio_ibfk_1` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`id`);

--
-- Constraints for table `tipocategoria`
--
ALTER TABLE `tipocategoria`
  ADD CONSTRAINT `tipocategoria_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`categoria`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
