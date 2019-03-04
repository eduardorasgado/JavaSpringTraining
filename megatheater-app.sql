-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Mar 04, 2019 at 04:26 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `megatheater-app`
--

-- --------------------------------------------------------

--
-- Table structure for table `Banners`
--

CREATE TABLE `Banners` (
  `id` int(11) NOT NULL,
  `titulo` varchar(250) NOT NULL,
  `fecha` date NOT NULL,
  `archivo` varchar(250) NOT NULL,
  `status` enum('Activo','Inactivo') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Detalles`
--

CREATE TABLE `Detalles` (
  `id` int(11) NOT NULL,
  `director` varchar(100) DEFAULT NULL,
  `actores` varchar(255) DEFAULT NULL,
  `sinopsis` text,
  `trailer` varchar(255) DEFAULT NULL COMMENT 'URL del video en Youtube\n'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Horarios`
--

CREATE TABLE `Horarios` (
  `id` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `sala` varchar(100) NOT NULL,
  `precio` double NOT NULL DEFAULT '0',
  `idPelicula` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Noticias`
--

CREATE TABLE `Noticias` (
  `id` int(11) NOT NULL,
  `titulo` varchar(250) NOT NULL,
  `fecha` date NOT NULL,
  `detalle` text NOT NULL,
  `status` enum('Activa','Inactiva') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Peliculas`
--

CREATE TABLE `Peliculas` (
  `id` int(11) NOT NULL,
  `titulo` varchar(150) NOT NULL,
  `duracion` int(11) NOT NULL,
  `clasificacion` enum('A','B','C') NOT NULL,
  `genero` varchar(45) NOT NULL,
  `imagen` varchar(200) DEFAULT NULL,
  `fechaEstreno` date NOT NULL,
  `status` enum('Activa','Inactiva') NOT NULL DEFAULT 'Activa',
  `idDetalle` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `UsuarioPerfil`
--

CREATE TABLE `UsuarioPerfil` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `perfil` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Usuarios`
--

CREATE TABLE `Usuarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `email` varchar(50) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Banners`
--
ALTER TABLE `Banners`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Detalles`
--
ALTER TABLE `Detalles`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Horarios`
--
ALTER TABLE `Horarios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Horarios_Peliculas1_idx` (`idPelicula`);

--
-- Indexes for table `Noticias`
--
ALTER TABLE `Noticias`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Peliculas`
--
ALTER TABLE `Peliculas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Peliculas_Detalles1_idx` (`idDetalle`);

--
-- Indexes for table `UsuarioPerfil`
--
ALTER TABLE `UsuarioPerfil`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Usuarios_Perfil1` (`username`);

--
-- Indexes for table `Usuarios`
--
ALTER TABLE `Usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Banners`
--
ALTER TABLE `Banners`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Detalles`
--
ALTER TABLE `Detalles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Horarios`
--
ALTER TABLE `Horarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Noticias`
--
ALTER TABLE `Noticias`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Peliculas`
--
ALTER TABLE `Peliculas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `UsuarioPerfil`
--
ALTER TABLE `UsuarioPerfil`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Usuarios`
--
ALTER TABLE `Usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Horarios`
--
ALTER TABLE `Horarios`
  ADD CONSTRAINT `fk_Horarios_Peliculas1` FOREIGN KEY (`idPelicula`) REFERENCES `Peliculas` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `Peliculas`
--
ALTER TABLE `Peliculas`
  ADD CONSTRAINT `fk_Peliculas_Detalles1` FOREIGN KEY (`idDetalle`) REFERENCES `Detalles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `UsuarioPerfil`
--
ALTER TABLE `UsuarioPerfil`
  ADD CONSTRAINT `fk_Usuarios_Perfil1` FOREIGN KEY (`username`) REFERENCES `Usuarios` (`username`) ON DELETE CASCADE ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
