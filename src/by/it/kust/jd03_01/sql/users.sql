CREATE TABLE kust.users (
  `ID` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL COMMENT 'ФИО пользлвателя',
  `Login` varchar(100) NOT NULL COMMENT 'логин',
  `Password` varchar(100) NOT NULL COMMENT 'пароль',
  `Email` varchar(100) NOT NULL COMMENT 'электронный адрес',
  `Address` varchar(150) NOT NULL COMMENT 'почтовый адрес',
  `Discount` int(3) NOT NULL COMMENT 'размер скидки',
  `FK_Role` int(11) NOT NULL COMMENT 'ID роли'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO users (ID, Name, Login, Password, Email, Address, Discount, FK_Role) VALUES
(1, 'Ivanov Ivan', 'i.ivanov', 'hgkgdfxy', 'ivanov@mail.ru', 'Belarus, Minsk, Pushkin str.,37/11', 0, 1),
(2, 'Petrov Petr', 'p.petrov', 'jghjgrfgf', 'petrov@mail.ru', 'Belarus, Gomel, Gorkogo str.,5/68', 0, 2),
(3, 'Sidorova Olga', 's.olga', 'fgh5fghf', 'olga@mail.ru', 'Belarus, Brest, Masherov str.,28/157', 5, 2),
(4, 'Ivanova Luda', 'l.ivanova', 'hgkgdfxy', 'ivanov@mail.ru', 'Belarus, Minsk, Pushkin str.,37/11', 3, 2);

ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

  SELECT * FROM users;
