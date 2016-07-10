CREATE TABLE IF NOT EXISTS kust.users (
`ID` int(11) NOT NULL AUTO_INCREMENT,
`Name` varchar(100) NOT NULL COMMENT 'ФИО пользователя',
`Login` varchar(100) NOT NULL COMMENT 'логин',
`Password` varchar(100) NOT NULL COMMENT 'пароль',
`Email` varchar(100) NOT NULL COMMENT 'электронный адрес',
`Address` varchar(150) NOT NULL COMMENT 'почтовый адрес',
`Discount` int(3) NOT NULL COMMENT 'размер скидки',
`FK_Role` int(11)  NOT NULL COMMENT 'ID роли',
PRIMARY KEY(`ID`),
FOREIGN KEY (FK_Role) REFERENCES roles(ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;