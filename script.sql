CREATE DATABASE `movies_movielens` /*!40100 DEFAULT CHARACTER SET utf8 */;

DROP TABLE IF EXISTS `movies_movielens`.`movie`;
CREATE TABLE  `movies_movielens`.`movie` (
  `idMovieLens` int(11) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `description` varchar(5000) DEFAULT NULL,
  `ratingImdb` double DEFAULT NULL,
  `idImdb` int(11) DEFAULT NULL,
  `idTmdb` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `movies_movielens`.`recommendation`;
CREATE TABLE  `movies_movielens`.`recommendation` (
  `userId` int(11) NOT NULL,
  `movieId` int(11) NOT NULL,
  `score` double DEFAULT NULL,
  PRIMARY KEY (`userId`,`movieId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;