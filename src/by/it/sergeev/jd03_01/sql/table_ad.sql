create table ad(
id int(11) AUTO_INCREMENT,
electronics varchar(50) NOT NULL,
manufacturer varchar(50) NOT NULL,
name varchar(50) NOT NULL,
model varchar(50) NOT NULL,
price int(11) NOT NULL,
description varchar(200) NOT NULL,
FK_User INT(11) NOT NULL,
PRIMARY KEY (ID)
);