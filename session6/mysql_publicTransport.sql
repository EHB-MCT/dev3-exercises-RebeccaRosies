/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE TABLE `cities` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

CREATE TABLE `rides` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `train` varchar(255) CHARACTER SET utf8 NOT NULL,
  `departure_time` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `departure_city` varchar(255) CHARACTER SET utf8 NOT NULL,
  `destination_city` varchar(255) CHARACTER SET utf8 NOT NULL,
  `date` date DEFAULT NULL,
  `departure_platform` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1986 DEFAULT CHARSET=latin1;

CREATE TABLE `trains` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `type` varchar(255) CHARACTER SET utf8 NOT NULL,
  `max_speed` int(10) unsigned NOT NULL,
  `max_passengers` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

INSERT INTO `cities` (`id`, `name`) VALUES
(1, 'Leuven');
INSERT INTO `cities` (`id`, `name`) VALUES
(2, 'Antwerpen');
INSERT INTO `cities` (`id`, `name`) VALUES
(3, 'Gent');
INSERT INTO `cities` (`id`, `name`) VALUES
(4, 'Oostende'),
(5, 'Parijs'),
(6, 'Londen'),
(7, 'Amsterdam');

INSERT INTO `rides` (`id`, `train`, `departure_time`, `departure_city`, `destination_city`, `date`, `departure_platform`) VALUES
(0, '', NULL, '', '', NULL, 1);
INSERT INTO `rides` (`id`, `train`, `departure_time`, `departure_city`, `destination_city`, `date`, `departure_platform`) VALUES
(1, '1', '3pm', 'Leuven', 'Brussel', '2021-11-25', 2);
INSERT INTO `rides` (`id`, `train`, `departure_time`, `departure_city`, `destination_city`, `date`, `departure_platform`) VALUES
(2, '2', '2pm', 'Brussel', 'Leuven', '2021-11-25', 3);
INSERT INTO `rides` (`id`, `train`, `departure_time`, `departure_city`, `destination_city`, `date`, `departure_platform`) VALUES
(3, '2', '4pm', 'Oostende', 'Leuven', '2021-11-26', 4),
(4, '3', '2pm', 'Leuven ', 'Oostende', '2021-11-28', 4),
(5, '2', '6pm', 'Leuven', 'Parijs', '2021-11-25', 6),
(6, '1', '1pm', 'Brussel', 'Leuven', '2021-11-25', 2),
(7, '1', '3pm', 'Brussel', 'Leuven', '2021-11-25', 9),
(8, '1', '4pm', 'Brussel', 'Leuven', '2021-11-25', 3),
(9, '1', '5pm', 'Brussel', 'Leuven', '2021-11-25', 4),
(10, '1', '6pm', 'Brussel', 'Leuven', '2021-11-25', 3),
(11, '1', '7pm', 'Brussel', 'Leuven', '2021-11-25', 2),
(12, '1', '8pm', 'Brussel', 'Leuven', '2021-11-25', 1),
(13, '1', '10am', 'Brussel', 'Leuven', '2021-11-25', 3),
(14, '1', '10am', 'Brussel', 'Leuven', '2021-11-23', 8),
(15, '1', '1pm', 'Brussel', 'Leuven', '2021-11-23', 2),
(16, '1', '2pm', 'Brussel', 'Leuven', '2021-11-23', 1);

INSERT INTO `trains` (`id`, `type`, `max_speed`, `max_passengers`) VALUES
(1, 'TGV', 575, 200);
INSERT INTO `trains` (`id`, `type`, `max_speed`, `max_passengers`) VALUES
(2, 'inter-city', 200, 100);



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;