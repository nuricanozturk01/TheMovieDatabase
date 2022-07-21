DROP DATABASE IF EXISTS Movies;
CREATE DATABASE Movies;

Use Movies;


SET FOREIGN_KEY_CHECKS = 0;
CREATE TABLE User
(
	user_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(45) NOT NULL UNIQUE,
    email VARCHAR(80) NOT NULL UNIQUE,
    password VARCHAR(128) NOT NULL,
    token VARCHAR(500) DEFAULT NULL

);
CREATE TABLE tv_details
(
	tv_detail_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    overview TEXT DEFAULT NULL,
    season_number INT DEFAULT NULL,
    episode_number INT DEFAULT NULL
    
    
);
CREATE TABLE tv_show
(
	tv_show_id INT NOT NULL AUTO_INCREMENT,
    real_tv_show_id INT NOT NULL UNIQUE,
    title VARCHAR(100) NOT NULL,
    tv_detail_id INT NOT NULL,
	PRIMARY KEY AUTO_INCREMENT (tv_show_id),   
    KEY tv_detail_id (tv_detail_id),
    CONSTRAINT FOREIGN KEY (tv_detail_id) REFERENCES tv_details(tv_detail_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE user_has_tv
(
	user_has_tv_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	tv_show_id INT NOT NULL ,
    user_id INT NOT NULL,

    CONSTRAINT FOREIGN KEY (tv_show_id) REFERENCES tv_show(tv_show_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY (user_id) REFERENCES User(user_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE movie_details
(
	detail_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    overview VARCHAR(1024) DEFAULT NULL,
    genre VARCHAR(80) DEFAULT NULL,
    production VARCHAR(80) DEFAULT NULL
);

CREATE TABLE Movie
(
	movie_id INT NOT NULL AUTO_INCREMENT,
    real_movie_id INT NOT NULL UNIQUE,
    title VARCHAR(100) NOT NULL,
    detail_id INT NOT NULL,
    PRIMARY KEY AUTO_INCREMENT (movie_id),
    KEY detail_id (detail_id),
    CONSTRAINT FOREIGN KEY (detail_id) REFERENCES movie_details(detail_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE movie_has_user
(
	movie_id INT NOT NULL,
    user_id INT NOT NULL,
    KEY movie_id (movie_id),
    KEY user_id (user_id),
    CONSTRAINT FOREIGN KEY (movie_id) REFERENCES Movie(movie_id)  ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FOREIGN KEY (user_id) REFERENCES User(user_id) ON DELETE CASCADE ON UPDATE CASCADE
);



SET FOREIGN_KEY_CHECKS = 1;
ALTER TABLE movie AUTO_INCREMENT = 1;
ALTER TABLE tv_show AUTO_INCREMENT = 1;
