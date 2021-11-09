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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

CREATE TABLE `ride_student` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `student_id` bigint(20) unsigned NOT NULL,
  `ride_id` bigint(20) unsigned DEFAULT NULL,
  UNIQUE KEY `id` (`id`),
  KEY `ride_id` (`ride_id`),
  CONSTRAINT `ride_student_ibfk_1` FOREIGN KEY (`ride_id`) REFERENCES `rides` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

CREATE TABLE `rides` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `train` varchar(255) CHARACTER SET utf8 NOT NULL,
  `departure_time` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `departure_city` varchar(255) NOT NULL,
  `destination_city` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

CREATE TABLE `students` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

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
(4, 'Oostende');

INSERT INTO `ride_student` (`id`, `student_id`, `ride_id`) VALUES
(1, 2, NULL);
INSERT INTO `ride_student` (`id`, `student_id`, `ride_id`) VALUES
(2, 2, NULL);
INSERT INTO `ride_student` (`id`, `student_id`, `ride_id`) VALUES
(3, 1, NULL);

INSERT INTO `rides` (`id`, `train`, `departure_time`, `departure_city`, `destination_city`) VALUES
(1, '1', '3pm', 'Leuven', 'Brussel');
INSERT INTO `rides` (`id`, `train`, `departure_time`, `departure_city`, `destination_city`) VALUES
(2, '1', '2pm', 'Brussel', 'Leuven');
INSERT INTO `rides` (`id`, `train`, `departure_time`, `departure_city`, `destination_city`) VALUES
(3, '2', '4pm', 'Oostende', 'Leuven');
INSERT INTO `rides` (`id`, `train`, `departure_time`, `departure_city`, `destination_city`) VALUES
(4, '3', '2pm', 'Leuven ', 'Oostende');

INSERT INTO `students` (`id`, `name`) VALUES
(1, 'Rebecca');
INSERT INTO `students` (`id`, `name`) VALUES
(2, 'Noor');
INSERT INTO `students` (`id`, `name`) VALUES
(3, 'Britt');
INSERT INTO `students` (`id`, `name`) VALUES
(4, 'Liese');

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