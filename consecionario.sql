-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-06-2020 a las 02:17:13
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `consecionario`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `CATID` int(11) NOT NULL,
  `CATIPO` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`CATID`, `CATIPO`) VALUES
(1, 'campero'),
(2, 'automovil');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `datospersonales`
--

CREATE TABLE `datospersonales` (
  `DATID` int(11) NOT NULL,
  `USUID` int(11) DEFAULT NULL,
  `DATNOMBRE` varchar(50) DEFAULT NULL,
  `DATAPELLIDO` varchar(50) DEFAULT NULL,
  `DATIPOID` varchar(20) DEFAULT NULL,
  `DATNUMEROID` varchar(20) DEFAULT NULL,
  `DATELEFONO` varchar(20) DEFAULT NULL,
  `DATCORREO` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `datospersonales`
--

INSERT INTO `datospersonales` (`DATID`, `USUID`, `DATNOMBRE`, `DATAPELLIDO`, `DATIPOID`, `DATNUMEROID`, `DATELEFONO`, `DATCORREO`) VALUES
(1, 6, 'angie', 'ortiz', NULL, NULL, '999999999', 'ortizv600@gmail.com'),
(2, 8, 'Angie', 'Reyes', NULL, NULL, '00000', 'ortizv600@gmail.com'),
(18, 30, 'Hanibal', 'Escocio', NULL, NULL, '340567891', 'ortizv600@gmail.com'),
(19, 31, 'qwer', 'prueba', NULL, NULL, '00000000', 'ortizv600@gmail.com'),
(20, 32, 'Paola', 'Lombana', NULL, NULL, '3218954567', 'ortizv600@gmail.com'),
(21, 33, 'Dayan', 'Castillo', NULL, NULL, '3228954567', 'ortizv600@gmail.com'),
(22, 34, 'Natalia', 'Castillo', NULL, NULL, '3228954567', 'ortizv600@gmail.com'),
(23, 35, 'Oscar', 'Cubillos', NULL, NULL, '3228954567', 'ortizv600@gmail.com'),
(24, 36, 'Jesus', 'Ortiz', NULL, NULL, '3228954567', 'ortizv600@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `ROLID` int(11) NOT NULL,
  `ROLTIPO` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`ROLID`, `ROLTIPO`) VALUES
(1, 'Comprador'),
(2, 'Vendedor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `USUID` int(11) NOT NULL,
  `USULOGIN` varchar(20) DEFAULT NULL,
  `USUPASSWORD` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`USUID`, `USULOGIN`, `USUPASSWORD`) VALUES
(6, 'Angie2002', 'YhyqHEnG'),
(8, 'Angie123', 'angie123'),
(9, 'Angieo', 'Angieo'),
(30, 'Hanibal23', '1234'),
(31, 'qwer', 'qwer'),
(32, 'Paola123', 'paolita123'),
(33, 'Dayan24', 'dayan24'),
(34, 'Natalia23', 'natalia23'),
(35, 'Oscar54', 'oscar54'),
(36, 'Jesus27', 'jesus27');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_rol`
--

CREATE TABLE `usuario_rol` (
  `ROLID` int(11) NOT NULL,
  `USUID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario_rol`
--

INSERT INTO `usuario_rol` (`ROLID`, `USUID`) VALUES
(1, 6),
(1, 8),
(1, 9),
(1, 30),
(1, 31),
(1, 32),
(1, 33),
(1, 34),
(1, 35),
(1, 36),
(2, 6),
(2, 8),
(2, 30),
(2, 32),
(2, 33),
(2, 34),
(2, 35),
(2, 36);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculo`
--

CREATE TABLE `vehiculo` (
  `VEHPLACA` varchar(10) NOT NULL,
  `DATID` int(11) DEFAULT NULL,
  `CATID` int(11) DEFAULT NULL,
  `VEHMODELO` int(11) DEFAULT NULL,
  `VEHMARCA` varchar(50) DEFAULT NULL,
  `VEHESTADO` varchar(30) DEFAULT NULL,
  `VEHPRECIO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `vehiculo`
--

INSERT INTO `vehiculo` (`VEHPLACA`, `DATID`, `CATID`, `VEHMODELO`, `VEHMARCA`, `VEHESTADO`, `VEHPRECIO`) VALUES
('BBB666', 18, 2, 2020, 'CHEVROLET', 'NUEVO', 50000000),
('EEE786', 1, 2, 2017, 'Suzuki', 'Usado', 500000000),
('HTR095', 1, 1, 2020, 'CHEVROLET', 'NUEVO', 50000000),
('jad123', 1, 1, 2020, 'CHEVROLET', 'USADO', 500000000),
('PTR096', 1, 2, 2019, '', 'USADO', 5555),
('QWE123', 1, 2, 2019, 'RENAULT', 'USADO', 12000000),
('QWE456', 1, 1, 2019, 'CHEVROLET', 'NUEVO', 0),
('QWE459', 1, 2, 2020, 'CHEVROLET', 'NUEVO', 54000000),
('TTR546', 23, 2, 2018, 'Suzuki', 'Usado', 400000000),
('TTT546', 20, 1, 2017, 'CHEVROLET', 'Usado', 500000000),
('TTT564', 1, 1, 2019, 'CHEVROLET', 'NUEVO', 54000000),
('TTY546', 22, 2, 2018, 'Suzuki', 'Usado', 500000000),
('VVA123', 1, 2, 2020, 'CHEVROLET', 'USADO', 0),
('WED564', 2, 2, 2017, 'CHEVROLET', 'Usado', 500000000),
('WED566', 21, 2, 2017, 'Suzuki', 'Usado', 500000000),
('WED569', 24, 1, 2017, 'Suzuki', 'Nuevo', 400000000);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`CATID`);

--
-- Indices de la tabla `datospersonales`
--
ALTER TABLE `datospersonales`
  ADD PRIMARY KEY (`DATID`),
  ADD KEY `FK_RELATIONSHIP_1` (`USUID`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`ROLID`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`USUID`);

--
-- Indices de la tabla `usuario_rol`
--
ALTER TABLE `usuario_rol`
  ADD PRIMARY KEY (`ROLID`,`USUID`),
  ADD KEY `FK_RELATIONSHIP_2` (`USUID`);

--
-- Indices de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD PRIMARY KEY (`VEHPLACA`),
  ADD KEY `FK_REFERENCE_5` (`CATID`),
  ADD KEY `FK_REFERENCE_6` (`DATID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `CATID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `datospersonales`
--
ALTER TABLE `datospersonales`
  MODIFY `DATID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `ROLID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `USUID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `datospersonales`
--
ALTER TABLE `datospersonales`
  ADD CONSTRAINT `FK_RELATIONSHIP_1` FOREIGN KEY (`USUID`) REFERENCES `usuario` (`USUID`);

--
-- Filtros para la tabla `usuario_rol`
--
ALTER TABLE `usuario_rol`
  ADD CONSTRAINT `FK_RELATIONSHIP_2` FOREIGN KEY (`USUID`) REFERENCES `usuario` (`USUID`),
  ADD CONSTRAINT `FK_RELATIONSHIP_3` FOREIGN KEY (`ROLID`) REFERENCES `rol` (`ROLID`);

--
-- Filtros para la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD CONSTRAINT `FK_REFERENCE_5` FOREIGN KEY (`CATID`) REFERENCES `categoria` (`CATID`),
  ADD CONSTRAINT `FK_REFERENCE_6` FOREIGN KEY (`DATID`) REFERENCES `datospersonales` (`DATID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
