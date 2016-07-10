CREATE TABLE IF NOT EXISTS kust.tours (
`ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID тура',
`Country` varchar(100) NOT NULL COMMENT 'страна',
`City` varchar(100) NOT NULL COMMENT 'город',
`Hotel` varchar(100) NOT NULL COMMENT 'гостиница',
`URL` varchar(200) NOT NULL COMMENT 'сайт гостиницы',
`Date` date NOT NULL COMMENT 'дата вылета',
`Days` int(10) NOT NULL COMMENT 'продолжительность тура',
`Price` int(10) NOT NULL COMMENT 'цена',
`Type` varchar(50) NOT NULL COMMENT 'тип тура',
`Option1` varchar(200) NOT NULL COMMENT 'дополнительная опция1',
`Option2` varchar(200) NOT NULL COMMENT 'дополнительная опция2',
`FK_Users` int(11) NULL DEFAULT NULL COMMENT 'ID заказавшего пользователя',
PRIMARY KEY(`ID`),
FOREIGN KEY (FK_Users) REFERENCES users(ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;