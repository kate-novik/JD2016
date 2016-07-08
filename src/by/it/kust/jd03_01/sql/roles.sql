CREATE TABLE kust.roles (
  `ID` int(11) NOT NULL DEFAULT '0' COMMENT 'ID роли пользователя',
  `Role` varchar(100) NOT NULL COMMENT 'тип пользователя'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO roles (ID, Role) VALUES
(1, 'admin'),
(2, 'user');

ALTER TABLE `roles`
  ADD PRIMARY KEY (`ID`);

SELECT * FROM roles;



