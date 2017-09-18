-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.1.73-community - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para springhibernate
CREATE DATABASE IF NOT EXISTS `springhibernate` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `springhibernate`;


-- Volcando estructura para tabla springhibernate.attribute_product_value
CREATE TABLE IF NOT EXISTS `attribute_product_value` (
  `attribute_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `value` varchar(50) NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`attribute_id`,`product_id`),
  KEY `FK_attribute_product_value_product` (`product_id`),
  CONSTRAINT `FK_attribute_product_value_attribute` FOREIGN KEY (`attribute_id`) REFERENCES `eav_attribute` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_attribute_product_value_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla springhibernate.attribute_product_value: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `attribute_product_value` DISABLE KEYS */;
INSERT INTO `attribute_product_value` (`attribute_id`, `product_id`, `value`, `active`) VALUES
	(1, 1, 'Valor 1 1', 0),
	(1, 3, 'Valor 1 3', 1),
	(2, 1, 'Valor 2 1', 0),
	(3, 1, 'Nuevo valor', 1),
	(4, 2, 'Valor 4 2', 0),
	(6, 2, 'Valor 6 2', 0),
	(6, 4, 'Valor 6 4', 0),
	(7, 3, 'Valor 7 3', 1);
/*!40000 ALTER TABLE `attribute_product_value` ENABLE KEYS */;


-- Volcando estructura para tabla springhibernate.brand
CREATE TABLE IF NOT EXISTS `brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) COLLATE utf8_bin NOT NULL,
  `country` varchar(60) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Volcando datos para la tabla springhibernate.brand: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` (`id`, `name`, `country`) VALUES
	(1, 'Seat', 'España');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;


-- Volcando estructura para tabla springhibernate.color
CREATE TABLE IF NOT EXISTS `color` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Volcando datos para la tabla springhibernate.color: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `color` DISABLE KEYS */;
INSERT INTO `color` (`id`, `name`) VALUES
	(4, 'Black'),
	(6, 'Orange'),
	(7, 'Purple'),
	(1, 'Red'),
	(2, 'White'),
	(5, 'Yellow');
/*!40000 ALTER TABLE `color` ENABLE KEYS */;


-- Volcando estructura para tabla springhibernate.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_bin NOT NULL,
  `gender` tinyint(1) NOT NULL,
  `age` int(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Volcando datos para la tabla springhibernate.customer: ~31 rows (aproximadamente)
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`id`, `name`, `gender`, `age`) VALUES
	(1, 'Customer1', 1, 25),
	(8, 'Customer2', 1, 26),
	(9, 'Customer3', 1, 28),
	(10, 'Customer4', 1, 30),
	(86, 'Customer18', 1, 25),
	(87, 'Customer19', 1, 25),
	(88, 'Customer20', 1, 25),
	(89, 'Customer18', 1, 25),
	(90, 'Customer19', 1, 25),
	(91, 'Customer20', 1, 25),
	(95, 'Customer18', 1, 25),
	(96, 'Customer19', 1, 25),
	(97, 'Customer20', 1, 25),
	(98, 'Customer18', 1, 25),
	(99, 'Customer19', 1, 25),
	(100, 'Customer20', 1, 25),
	(101, 'Customer18', 1, 25),
	(102, 'Customer19', 1, 25),
	(103, 'Customer20', 1, 25),
	(107, 'Customer18', 1, 25),
	(108, 'Customer19', 1, 25),
	(109, 'Customer20', 1, 25),
	(113, 'Customer18', 1, 25),
	(114, 'Customer19', 1, 25),
	(115, 'Customer20', 1, 25),
	(116, 'Customer18', 1, 25),
	(117, 'Customer19', 1, 25),
	(118, 'Customer20', 1, 25),
	(122, 'Customer18', 1, 25),
	(123, 'Customer19', 1, 25),
	(124, 'Customer20', 1, 25);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;


-- Volcando estructura para tabla springhibernate.customer_address
CREATE TABLE IF NOT EXISTS `customer_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL DEFAULT '0',
  `address` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_CUSTOMER_ADDRESS_CUSTOMER` (`customer_id`),
  CONSTRAINT `FK_CUSTOMER_ADDRESS_CUSTOMER` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla springhibernate.customer_address: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `customer_address` DISABLE KEYS */;
INSERT INTO `customer_address` (`id`, `customer_id`, `address`) VALUES
	(1, 1, 'Plaza falsa 123'),
	(2, 1, 'Calle falsa 123');
/*!40000 ALTER TABLE `customer_address` ENABLE KEYS */;


-- Volcando estructura para tabla springhibernate.customer_favorites_vehicle_types
CREATE TABLE IF NOT EXISTS `customer_favorites_vehicle_types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL DEFAULT '0',
  `vehicle_type_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_CUSOMTER_FAV` (`customer_id`),
  KEY `FKVEHICLE_TYPE_FAV` (`vehicle_type_id`),
  CONSTRAINT `FKVEHICLE_TYPE_FAV` FOREIGN KEY (`vehicle_type_id`) REFERENCES `vehicle_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_CUSOMTER_FAV` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla springhibernate.customer_favorites_vehicle_types: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `customer_favorites_vehicle_types` DISABLE KEYS */;
INSERT INTO `customer_favorites_vehicle_types` (`id`, `customer_id`, `vehicle_type_id`) VALUES
	(2, 1, 2),
	(3, 8, 1),
	(5, 1, 1);
/*!40000 ALTER TABLE `customer_favorites_vehicle_types` ENABLE KEYS */;


-- Volcando estructura para tabla springhibernate.customer_social_networks
CREATE TABLE IF NOT EXISTS `customer_social_networks` (
  `customer_id` int(11) NOT NULL,
  `facebook` varchar(50) DEFAULT NULL,
  `twitter` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  CONSTRAINT `FK_CUSTOMER_CUSTOMER_SOCILA_NETWORKS` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla springhibernate.customer_social_networks: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `customer_social_networks` DISABLE KEYS */;
INSERT INTO `customer_social_networks` (`customer_id`, `facebook`, `twitter`) VALUES
	(1, 'Customer1 FB', 'Customer1 Twitter');
/*!40000 ALTER TABLE `customer_social_networks` ENABLE KEYS */;


-- Volcando estructura para tabla springhibernate.dealership
CREATE TABLE IF NOT EXISTS `dealership` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Volcando datos para la tabla springhibernate.dealership: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `dealership` DISABLE KEYS */;
INSERT INTO `dealership` (`id`, `name`) VALUES
	(1, 'Dealership1');
/*!40000 ALTER TABLE `dealership` ENABLE KEYS */;


-- Volcando estructura para tabla springhibernate.description_translations
CREATE TABLE IF NOT EXISTS `description_translations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `language_id` int(11) NOT NULL,
  `vehicle_id` int(11) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_LANGUAGE_TRADUCTION` (`language_id`),
  KEY `FK_VEHICLE_TRADUCTION` (`vehicle_id`),
  CONSTRAINT `FK_LANGUAGE_TRADUCTION` FOREIGN KEY (`language_id`) REFERENCES `language` (`id`),
  CONSTRAINT `FK_VEHICLE_TRADUCTION` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla springhibernate.description_translations: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `description_translations` DISABLE KEYS */;
INSERT INTO `description_translations` (`id`, `language_id`, `vehicle_id`, `description`) VALUES
	(1, 1, 1, 'El coche mas grande'),
	(2, 2, 1, 'The biggest car');
/*!40000 ALTER TABLE `description_translations` ENABLE KEYS */;


-- Volcando estructura para tabla springhibernate.eav_attribute
CREATE TABLE IF NOT EXISTS `eav_attribute` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `attribute_type_id` int(11) NOT NULL,
  `group_attribute_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `code` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_attribute_attribute_type` (`attribute_type_id`),
  KEY `FK_attribute_attribute_group` (`group_attribute_id`),
  CONSTRAINT `FK_attribute_attribute_group` FOREIGN KEY (`group_attribute_id`) REFERENCES `eav_attribute_group` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_attribute_attribute_type` FOREIGN KEY (`attribute_type_id`) REFERENCES `eav_attribute_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla springhibernate.eav_attribute: ~10 rows (aproximadamente)
/*!40000 ALTER TABLE `eav_attribute` DISABLE KEYS */;
INSERT INTO `eav_attribute` (`id`, `attribute_type_id`, `group_attribute_id`, `name`, `code`) VALUES
	(1, 1, 1, 'Atributo 1', 'attribute_1'),
	(2, 3, 1, 'Atributo 2', 'attribute_2'),
	(3, 5, 1, 'Atributo 3', 'attribute_3'),
	(4, 1, 2, 'Atributo 4', 'attribute_4'),
	(5, 2, 2, 'Atributo 5', 'attribute_5'),
	(6, 2, 4, 'Atributo 6', 'attribute_6'),
	(7, 4, 4, 'Atributo 7', 'attribute_7'),
	(8, 1, 4, 'Atributo 8', 'attribute_8'),
	(9, 3, 4, 'Atributo 9', 'attribute_9'),
	(10, 1, 5, 'Atributo 10', 'attribute_10');
/*!40000 ALTER TABLE `eav_attribute` ENABLE KEYS */;


-- Volcando estructura para tabla springhibernate.eav_attribute_group
CREATE TABLE IF NOT EXISTS `eav_attribute_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `code` varchar(50) NOT NULL,
  `other_column` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla springhibernate.eav_attribute_group: ~11 rows (aproximadamente)
/*!40000 ALTER TABLE `eav_attribute_group` DISABLE KEYS */;
INSERT INTO `eav_attribute_group` (`id`, `name`, `code`, `other_column`) VALUES
	(1, 'otro nombre', 'attribute_group_1', 'other 1'),
	(2, 'Grupo de atributos 2', 'attribute_group_2', 'other 2'),
	(3, 'Grupo de atributos 3', 'attribute_group_3', 'other 3'),
	(4, 'Grupo de atributos 4', 'attribute_group_4', 'other 4'),
	(5, 'Grupo de atributos 5', 'attribute_group_5', 'other 5'),
	(7, 'nombre x', 'codigo x', 'otra columna x'),
	(8, 'nombre x', 'codigo x', 'otra columna x'),
	(9, 'nombre x', 'codigo x', 'otra columna x'),
	(10, 'nombre x', 'codigo x', 'otra columna x'),
	(11, 'nombre x', 'codigo x', 'otra columna x'),
	(12, 'nombre x', 'codigo x', 'otra columna x');
/*!40000 ALTER TABLE `eav_attribute_group` ENABLE KEYS */;


-- Volcando estructura para tabla springhibernate.eav_attribute_type
CREATE TABLE IF NOT EXISTS `eav_attribute_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `code` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla springhibernate.eav_attribute_type: ~13 rows (aproximadamente)
/*!40000 ALTER TABLE `eav_attribute_type` DISABLE KEYS */;
INSERT INTO `eav_attribute_type` (`id`, `name`, `code`) VALUES
	(1, 'Tipo de atributo 1', 'attribute_type_1'),
	(2, 'Tipo de atributo 2', 'attribute_type_2'),
	(3, 'Tipo de atributo 3', 'attribute_type_3'),
	(4, 'Tipo de atributo 4', 'attribute_type_4'),
	(5, 'Tipo de atributo 5', 'attribute_type_5'),
	(6, 'Nuevo tipo de   atributo', 'nuevo_tipo_de_atributo'),
	(7, 'Nuevo tipo de   atributo', 'nuevo_tipo_de_atributo'),
	(8, 'Nuevo tipo de   atributo', 'nuevo_tipo_de_atributo'),
	(9, 'Nuevo tipo de   atributo', 'nuevo_tipo_de_atributo'),
	(10, 'Nuevo tipo de   atributo', 'nuevo_tipo_de_atributo'),
	(11, 'Nuevo tipo de   atributo', 'nuevo_tipo_de_atributo'),
	(12, 'Nuevo tipo de   atributo', 'nuevo_tipo_de_atributo'),
	(13, 'Nuevo tipo de   atributo', 'nuevo_tipo_de_atributo');
/*!40000 ALTER TABLE `eav_attribute_type` ENABLE KEYS */;


-- Volcando estructura para tabla springhibernate.employee_2
CREATE TABLE IF NOT EXISTS `employee_2` (
  `person_id` bigint(10) NOT NULL,
  `joining_date` date DEFAULT NULL,
  `department_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`person_id`),
  CONSTRAINT `FK_PERSON` FOREIGN KEY (`person_id`) REFERENCES `person_2` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla springhibernate.employee_2: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `employee_2` DISABLE KEYS */;
INSERT INTO `employee_2` (`person_id`, `joining_date`, `department_name`) VALUES
	(2, NULL, 'dep 2'),
	(3, NULL, 'dep 3'),
	(5, NULL, 'dep 5');
/*!40000 ALTER TABLE `employee_2` ENABLE KEYS */;


-- Volcando estructura para tabla springhibernate.employee_3
CREATE TABLE IF NOT EXISTS `employee_3` (
  `person_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `joining_date` date DEFAULT NULL,
  `department_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla springhibernate.employee_3: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `employee_3` DISABLE KEYS */;
INSERT INTO `employee_3` (`person_id`, `firstname`, `lastname`, `joining_date`, `department_name`) VALUES
	(1, 'firstname e 1', 'lastname e 1', NULL, 'dep e 1'),
	(2, 'firstname e 2', 'lastname e 2', NULL, 'dep e 2'),
	(3, 'firstname e 3', 'lastname e 3', NULL, 'dep e 3');
/*!40000 ALTER TABLE `employee_3` ENABLE KEYS */;


-- Volcando estructura para tabla springhibernate.language
CREATE TABLE IF NOT EXISTS `language` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla springhibernate.language: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `language` DISABLE KEYS */;
INSERT INTO `language` (`id`, `name`) VALUES
	(1, 'Español'),
	(2, 'English');
/*!40000 ALTER TABLE `language` ENABLE KEYS */;


-- Volcando estructura para tabla springhibernate.owner_2
CREATE TABLE IF NOT EXISTS `owner_2` (
  `person_id` bigint(20) NOT NULL DEFAULT '0',
  `stocks` bigint(11) DEFAULT NULL,
  `partnership_stake` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`person_id`),
  CONSTRAINT `FK_PERSON2` FOREIGN KEY (`person_id`) REFERENCES `person_2` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla springhibernate.owner_2: ~13 rows (aproximadamente)
/*!40000 ALTER TABLE `owner_2` DISABLE KEYS */;
INSERT INTO `owner_2` (`person_id`, `stocks`, `partnership_stake`) VALUES
	(1, 5, 31),
	(6, 8, 32),
	(7, 9, 53),
	(9, 51, 89),
	(10, 18, 26),
	(11, 888, 999),
	(12, 888, 999),
	(13, 888, 999),
	(14, 888, 999),
	(15, 888, 999),
	(16, 888, 999),
	(17, 888, 999),
	(18, 888, 999);
/*!40000 ALTER TABLE `owner_2` ENABLE KEYS */;


-- Volcando estructura para tabla springhibernate.owner_3
CREATE TABLE IF NOT EXISTS `owner_3` (
  `person_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) NOT NULL DEFAULT '0',
  `lastname` varchar(50) NOT NULL DEFAULT '0',
  `stocks` bigint(11) DEFAULT NULL,
  `partnership_stake` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla springhibernate.owner_3: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `owner_3` DISABLE KEYS */;
INSERT INTO `owner_3` (`person_id`, `firstname`, `lastname`, `stocks`, `partnership_stake`) VALUES
	(1, 'firstname o 1', 'lastname o 1', 3, 52),
	(2, 'firstname o 2', 'lastname o 2', 31, 52),
	(3, 'firstname o 3', 'lastname o 3', 312, 15),
	(4, 'firstname o 3', 'lastname o 3', 33, 52);
/*!40000 ALTER TABLE `owner_3` ENABLE KEYS */;


-- Volcando estructura para tabla springhibernate.person_1
CREATE TABLE IF NOT EXISTS `person_1` (
  `person_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `joining_date` date DEFAULT NULL,
  `department_name` varchar(50) DEFAULT NULL,
  `discriminator` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla springhibernate.person_1: ~9 rows (aproximadamente)
/*!40000 ALTER TABLE `person_1` DISABLE KEYS */;
INSERT INTO `person_1` (`person_id`, `firstname`, `lastname`, `joining_date`, `department_name`, `discriminator`) VALUES
	(1, 'firstname 1', 'lastname 1', NULL, NULL, NULL),
	(2, 'firstname 2', 'lastname 2', NULL, NULL, NULL),
	(3, 'firstname 3', 'lastname 3', NULL, 'dep 3', 'E'),
	(4, 'firstname 4', 'lastname 4', NULL, NULL, NULL),
	(5, 'firstname 5', 'lastname 5', NULL, 'dep 5', 'E'),
	(6, 'firstname 6', 'lastname 6', NULL, 'dep 6', 'E'),
	(7, 'firstname 7', 'lastname 7', NULL, NULL, NULL),
	(8, 'firstname 8', 'lastname 8', NULL, NULL, NULL),
	(9, 'firstname 9', 'lastname 9', NULL, NULL, NULL);
/*!40000 ALTER TABLE `person_1` ENABLE KEYS */;


-- Volcando estructura para tabla springhibernate.person_2
CREATE TABLE IF NOT EXISTS `person_2` (
  `person_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) NOT NULL DEFAULT '0',
  `lastname` varchar(50) NOT NULL DEFAULT '0',
  `discriminator` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla springhibernate.person_2: ~18 rows (aproximadamente)
/*!40000 ALTER TABLE `person_2` DISABLE KEYS */;
INSERT INTO `person_2` (`person_id`, `firstname`, `lastname`, `discriminator`) VALUES
	(1, 'firstname 1', 'lastname 1', 'O'),
	(2, 'firstname 2', 'lastname 2', 'E'),
	(3, 'firstname 3', 'lastname 3', 'E'),
	(4, 'firstname 4', 'lastname 4', 'P'),
	(5, 'firstname 5', 'lastname 5', 'E'),
	(6, 'firstname 6', 'lastname 6', 'O'),
	(7, 'firstname 7', 'lastname 7', 'O'),
	(8, 'firstname 8', 'lastname 8', 'P'),
	(9, 'firstname 9', 'lastname 9', 'O'),
	(10, 'firstname owner', 'lastname owner', 'O'),
	(11, 'firstname owner 2', 'lastname owner 2', 'O'),
	(12, 'firstname owner 3', 'lastname owner 3', 'O'),
	(13, 'firstname owner 3', 'lastname owner 3', NULL),
	(14, 'firstname owner 3', 'lastname owner 3', NULL),
	(15, 'firstname owner 3', 'lastname owner 3', NULL),
	(16, 'firstname owner 3', 'lastname owner 3', NULL),
	(17, 'firstname owner 3', 'lastname owner 3', NULL),
	(18, 'firstname owner 3', 'lastname owner 3', NULL);
/*!40000 ALTER TABLE `person_2` ENABLE KEYS */;


-- Volcando estructura para tabla springhibernate.person_3
CREATE TABLE IF NOT EXISTS `person_3` (
  `person_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) NOT NULL DEFAULT '0',
  `lastname` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla springhibernate.person_3: ~9 rows (aproximadamente)
/*!40000 ALTER TABLE `person_3` DISABLE KEYS */;
INSERT INTO `person_3` (`person_id`, `firstname`, `lastname`) VALUES
	(1, 'firstname 1', 'lastname 1'),
	(2, 'firstname 2', 'lastname 2'),
	(3, 'firstname 3', 'lastname 3'),
	(4, 'firstname 4', 'lastname 4'),
	(5, 'firstname 5', 'lastname 5'),
	(6, 'firstname 6', 'lastname 6'),
	(7, 'firstname 7', 'lastname 7'),
	(8, 'firstname 8', 'lastname 8'),
	(9, 'firstname 9', 'lastname 9');
/*!40000 ALTER TABLE `person_3` ENABLE KEYS */;


-- Volcando estructura para tabla springhibernate.product
CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(50) NOT NULL,
  `price` float NOT NULL,
  `stock` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla springhibernate.product: ~10 rows (aproximadamente)
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`id`, `name`, `description`, `price`, `stock`) VALUES
	(1, 'Producto 1', 'Descripcion del producto 1', 1, 1),
	(2, 'Producto 2', 'Descripcion del producto 2', 2, 2),
	(3, 'Producto 3', 'Descripcion del producto 3', 3, 3),
	(4, 'Producto 4', 'Descripcion del producto 4', 4, 4),
	(5, 'Producto 5', 'Descripcion del producto 5', 5, 5),
	(6, 'Producto 6', 'Descripcion del producto 6', 6, 6),
	(7, 'Producto 7', 'Descripcion del producto 7', 7, 7),
	(8, 'Producto 8', 'Descripcion del producto 8', 8, 8),
	(9, 'Producto 9', 'Descripcion del producto 9', 9, 9),
	(10, 'Producto 10', 'Descripcion del producto 10', 10, 10);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;


-- Volcando estructura para tabla springhibernate.sale
CREATE TABLE IF NOT EXISTS `sale` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vehicle_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `purchase_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `price` float NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_order_vehicle_idx` (`vehicle_id`),
  KEY `fk_order_customer_idx` (`customer_id`),
  CONSTRAINT `fk_sale_vehicle` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Volcando datos para la tabla springhibernate.sale: ~30 rows (aproximadamente)
/*!40000 ALTER TABLE `sale` DISABLE KEYS */;
INSERT INTO `sale` (`id`, `vehicle_id`, `customer_id`, `purchase_date`, `price`) VALUES
	(1, 1, 1, '2017-09-18 19:16:09', 19),
	(2, 1, 1, '2016-05-28 10:11:08', 15000),
	(3, 1, 1, '2016-05-30 17:49:47', 15000),
	(4, 1, 1, '2017-09-18 19:16:09', 15000),
	(5, 1, 1, '2016-05-30 18:24:30', 15000),
	(6, 1, 1, '2016-06-15 19:00:46', 15),
	(7, 1, 1, '2016-06-15 19:00:46', 15000),
	(8, 1, 1, '2016-06-16 19:06:54', 15000),
	(9, 2, 1, '2016-06-19 18:37:42', 12),
	(10, 3, 1, '2016-06-19 18:38:26', 45000),
	(11, 1, 1, '2016-06-25 11:14:51', 15000),
	(12, 1, 1, '2016-06-25 11:20:00', 15000),
	(13, 3, 1, '2016-06-25 19:04:04', 45000),
	(14, 3, 1, '2016-06-25 19:11:13', 45000),
	(15, 3, 1, '2016-06-25 20:08:09', 45000),
	(16, 3, 1, '2016-06-25 20:44:04', 45000),
	(17, 3, 1, '2016-06-26 10:02:14', 45000),
	(18, 1, 1, '2016-06-26 10:02:14', 15000),
	(19, 3, 1, '2017-09-16 10:44:17', 45000),
	(20, 1, 1, '2017-09-16 10:44:17', 15000),
	(21, 3, 1, '2017-09-16 10:59:55', 45000),
	(22, 1, 1, '2017-09-16 10:59:55', 15000),
	(23, 3, 1, '2017-09-16 11:03:56', 45000),
	(24, 1, 1, '2017-09-16 11:03:56', 15000),
	(25, 3, 1, '2017-09-16 11:05:22', 45000),
	(26, 1, 1, '2017-09-16 11:05:22', 15000),
	(27, 3, 1, '2017-09-18 19:11:05', 45000),
	(28, 1, 1, '2017-09-18 19:11:05', 15000),
	(29, 3, 1, '2017-09-18 19:16:09', 45000),
	(30, 1, 1, '2017-09-18 19:16:09', 15000);
/*!40000 ALTER TABLE `sale` ENABLE KEYS */;


-- Volcando estructura para tabla springhibernate.vehicle
CREATE TABLE IF NOT EXISTS `vehicle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_bin NOT NULL,
  `vehicle_type_id` int(11) NOT NULL,
  `color_id` int(11) NOT NULL,
  `price` float NOT NULL,
  `stock` int(11) NOT NULL DEFAULT '0',
  `brand_id` int(11) NOT NULL,
  `dealership_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `fk_vehicle_vehicle_type_idx` (`vehicle_type_id`),
  KEY `fk_vehicle_color_idx` (`color_id`),
  KEY `fk_vehicle_brand_idx` (`brand_id`),
  KEY `fk_vehicle_dealership_idx` (`dealership_id`),
  CONSTRAINT `fk_vehicle_brand` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_vehicle_color` FOREIGN KEY (`color_id`) REFERENCES `color` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_vehicle_dealership` FOREIGN KEY (`dealership_id`) REFERENCES `dealership` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_vehicle_vehicle_type` FOREIGN KEY (`vehicle_type_id`) REFERENCES `vehicle_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Volcando datos para la tabla springhibernate.vehicle: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` (`id`, `name`, `vehicle_type_id`, `color_id`, `price`, `stock`, `brand_id`, `dealership_id`) VALUES
	(1, 'Car1', 1, 1, 15000, 80, 1, 1),
	(2, 'Motorbike1', 2, 2, 7000, 10, 1, 1),
	(3, 'Truck1', 3, 4, 45000, 10, 1, 1);
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;


-- Volcando estructura para tabla springhibernate.vehicle_type
CREATE TABLE IF NOT EXISTS `vehicle_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Volcando datos para la tabla springhibernate.vehicle_type: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `vehicle_type` DISABLE KEYS */;
INSERT INTO `vehicle_type` (`id`, `name`) VALUES
	(1, 'Car'),
	(2, 'Motorbike'),
	(3, 'Truck');
/*!40000 ALTER TABLE `vehicle_type` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
