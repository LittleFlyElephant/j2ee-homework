DROP TABLE IF EXISTS `tb_students`;
CREATE TABLE `tb_students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `name` VARCHAR(255),
  `phone` INT(11) DEFAULT NULL,
  `email` VARCHAR(255) NOT NULL,
  `permission` TINYINT NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  `deletedAt` datetime DEFAULT NULL,
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tb_students(username, password, name, email, permission, createdAt, updatedAt)
    VALUE ('cr', '123', 'crname', '1395314348@qq.com', 3, now(), now());

DROP TABLE IF EXISTS `tb_courses`;
CREATE TABLE `tb_courses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` VARCHAR(255) NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  `deletedAt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tb_courses(course_name, createdAt, updatedAt) VALUES
  ('微积分', now(), now()),
  ('体系结构', now(), now()),
  ('人机交互', NOW(), now());

DROP TABLE IF EXISTS `tb_courses_select`;
CREATE TABLE `tb_courses_select` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` INT(11) NOT NULL,
  `user_id` INT(11) NOT NULL,
  `score` INT(11) DEFAULT NULL,
  `absent` TINYINT(1) DEFAULT 0,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  `deletedAt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tb_courses_select(course_id, user_id, score, absent, createdAt, updatedAt) VALUES
  (1, 1, 90, 0, now(),now()),
  (2, 1, NULL, 1, now(), now()),
  (1, 2, 89, 0, now(), now());