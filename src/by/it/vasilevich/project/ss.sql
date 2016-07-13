-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1:2016
-- Время создания: Июл 13 2016 г., 12:21
-- Версия сервера: 10.1.10-MariaDB
-- Версия PHP: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `ss`
--

-- --------------------------------------------------------

--
-- Структура таблицы `ad`
--

CREATE TABLE `ad` (
  `ID` int(11) NOT NULL,
  `Price` int(11) NOT NULL,
  `Brand` varchar(50) NOT NULL,
  `Model` varchar(50) NOT NULL,
  `Type` text NOT NULL,
  `Year` int(4) NOT NULL,
  `Engine` varchar(50) NOT NULL,
  `Transmission` varchar(50) NOT NULL,
  `Drive_unit` varchar(50) NOT NULL,
  `Mileage` int(11) NOT NULL,
  `Color` varchar(50) NOT NULL,
  `FK_Users` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `ad`
--

INSERT INTO `ad` (`ID`, `Price`, `Brand`, `Model`, `Type`, `Year`, `Engine`, `Transmission`, `Drive_unit`, `Mileage`, `Color`, `FK_Users`) VALUES
(1, 12000, 'BMW', '530', 'sedan', 2006, 'diesel', 'manual', 'rear', 250000, 'black', 3),
(2, 25000, 'AUDI', 'Q7', 'cross', 2011, 'diesel', 'manual', 'rear', 250000, 'black', 5),
(3, 14000, 'BMW', '535', 'sedan', 2008, 'petrol', 'automatic', 'rear', 180000, 'grey', 5),
(4, 10500, 'Volkswagen', 'Passat B6', 'avant', 2006, 'diesel', 'manual', 'front', 350000, 'blue', 6),
(5, 9300, 'Kia', 'Rio', 'sedan', 2011, 'petrol', 'manual', 'front', 90000, 'red', 21),
(6, 25000, 'AUDI', 'Q7', 'cross', 2011, 'diesel', 'manual', 'rear', 250000, 'black', 5),
(7, 25000, 'AUDI', 'Q7', 'cross', 2011, 'diesel', 'manual', 'rear', 250000, 'black', 5),
(8, 12000, 'BMW', '530', 'sedan', 2006, 'diesel', 'manual', 'rear', 250000, 'black', 3),
(9, 12000, 'BMW', '530', 'sedan', 2006, 'diesel', 'manual', 'rear', 250000, 'black', 3),
(10, 45000, 'Ferrari', 'F50', 'coupe', 2005, 'petrol', 'automatic', 'rear', 12000, 'red', 25);

-- --------------------------------------------------------

--
-- Структура таблицы `role`
--

CREATE TABLE `role` (
  `ID` int(11) NOT NULL,
  `Role` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `role`
--

INSERT INTO `role` (`ID`, `Role`) VALUES
(1, 'Administrator'),
(2, 'Moderator'),
(3, 'User');

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `Login` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `FK_Role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`ID`, `Login`, `Password`, `Email`, `FK_Role`) VALUES
(3, 'user', 'user', 'user@gmail.com', 3),
(4, 'user', 'user', 'user@gmail.com', 3),
(5, 'admin', 'admin', 'admin@gmail.com', 1),
(6, 'user', 'user', 'user@gmail.com', 3),
(7, 'moder', 'moder', 'moder@gmail.com', 2),
(21, 'user', 'user', 'user@gmail.com', 3),
(22, 'user', 'user', 'user@gmail.com', 3),
(23, 'user', 'user', 'user@gmail.com', 3),
(24, 'user', 'user', 'user@gmail.com', 3),
(25, 'moder', 'moder', 'moder@gmail.com', 2);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `ad`
--
ALTER TABLE `ad`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `role`
--
ALTER TABLE `role`
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
-- AUTO_INCREMENT для таблицы `ad`
--
ALTER TABLE `ad`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT для таблицы `role`
--
ALTER TABLE `role`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
