CREATE TABLE IF NOT EXISTS kust.roles (
`ID` int(11) NOT NULL COMMENT 'ID роли пользователя',
`Role` varchar(100) COMMENT 'тип пользователя',
PRIMARY KEY(`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;