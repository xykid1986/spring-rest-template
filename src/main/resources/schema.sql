drop table if exists book;

create table `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `created` timestamp default CURRENT_TIMESTAMP,
  `lastModified` timestamp default CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
);