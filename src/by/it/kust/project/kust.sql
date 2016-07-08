-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1:2016
-- Время создания: Июл 08 2016 г., 11:44
-- Версия сервера: 10.1.10-MariaDB
-- Версия PHP: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `kust`
--

-- --------------------------------------------------------

--
-- Структура таблицы `roles`
--

CREATE TABLE `roles` (
  `ID` int(11) NOT NULL DEFAULT '0' COMMENT 'ID роли пользователя',
  `Role` varchar(100) NOT NULL COMMENT 'тип пользователя'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `roles`
--

INSERT INTO `roles` (`ID`, `Role`) VALUES
(1, 'admin'),
(2, 'user');

-- --------------------------------------------------------

--
-- Структура таблицы `tours`
--

CREATE TABLE `tours` (
  `ID` int(11) NOT NULL COMMENT 'ID тура',
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
  `FK_Users` int(11) NOT NULL COMMENT 'ID заказавшего пользователя'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `tours`
--

INSERT INTO `tours` (`ID`, `Country`, `City`, `Hotel`, `URL`, `Date`, `Days`, `Price`, `Type`, `Option1`, `Option2`, `FK_Users`) VALUES
(1, 'Spain', 'Barcelona', 'El Palace Hotel', 'https://www.hotelpalacebarcelona.com/en/', '2016-07-30', 10, 1500, 'Hot Tour', 'Flight', 'Medical insurance', 2),
(2, 'Georgia', 'Batumi', 'Sheraton Batumi Hotel', 'http://www.sheratonbatumi.com/', '2016-08-15', 14, 1800, 'Classic', 'Flight', 'Medical insurance', 1),
(3, 'Russia', 'Sochi', 'Hotel Russia', 'https://hotel.com', '2014-06-02', 7, 800, 'Classic', 'No Flight', 'Medical insurance', 3),
(4, 'Italy', 'Rome', 'Villa Resort Hotel', 'http://www.hotels.com/', '2015-09-23', 10, 1400, 'Hot Tour', 'Flight', 'Medical insurance', 3);

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL COMMENT 'ФИО пользлвателя',
  `Login` varchar(100) NOT NULL COMMENT 'логин',
  `Password` varchar(100) NOT NULL COMMENT 'пароль',
  `Email` varchar(100) NOT NULL COMMENT 'электронный адрес',
  `Address` varchar(150) NOT NULL COMMENT 'почтовый адрес',
  `Discount` int(3) NOT NULL COMMENT 'размер скидки',
  `FK_Role` int(11) NOT NULL COMMENT 'ID роли'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`ID`, `Name`, `Login`, `Password`, `Email`, `Address`, `Discount`, `FK_Role`) VALUES
(1, 'Ivanov Ivan', 'i.ivanov', 'hgkgdfxy', 'ivanov@mail.ru', 'Belarus, Minsk, Pushkin str.,37/11', 0, 1),
(2, 'Petrov Petr', 'p.petrov', 'jghjgrfgf', 'petrov@mail.ru', 'Belarus, Gomel, Gorkogo str.,5/68', 0, 2),
(3, 'Sidorova Olga', 's.olga', 'fgh5fghf', 'olga@mail.ru', 'Belarus, Brest, Masherov str.,28/157', 5, 2),
(4, 'Ivanov Ivan', 'i.ivanov', 'hgkgdfxy', 'ivanov@mail.ru', 'Belarus, Minsk, Pushkin str.,37/11', 0, 2);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `tours`
--
ALTER TABLE `tours`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `tours`
--
ALTER TABLE `tours`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID тура', AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
