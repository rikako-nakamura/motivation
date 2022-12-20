CREATE TABLE IF NOT EXISTS motivation (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `time` VARCHAR(100) NULL,
  `rate` CHAR(5) NULL,
  `memo` VARCHAR(500) NULL,
  `create_date` DATE,
  PRIMARY KEY (`id`));

DROP TABLE IF EXISTS users;
CREATE TABLE users(
  id SERIAL PRIMARY KEY,
  username VARCHAR(20),
  password VARCHAR(60),
  rolename VARCHAR(10)
);