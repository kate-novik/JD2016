CREATE TABLE kust.tours (
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

INSERT INTO tours (ID, Country, City, Hotel, URL, Date, Days, Price, Type, Option1, Option2, FK_Users) VALUES
(1, 'Spain', 'Barcelona', 'El Palace Hotel', 'https://www.hotelpalacebarcelona.com/en/', '2016-07-30', 10, 1500, 'Hot Tour', 'Flight', 'Medical insurance', 2),
(2, 'Georgia', 'Batumi', 'Sheraton Batumi Hotel', 'http://www.sheratonbatumi.com/', '2016-08-15', 14, 1800, 'Classic', 'Flight', 'Medical insurance', 1),
(3, 'Russia', 'Sochi', 'Hotel Russia', 'https://hotel.com', '2014-06-02', 7, 800, 'Classic', 'No Flight', 'Medical insurance', 3),
(4, 'Italy', 'Rome', 'Villa Resort Hotel', 'http://www.hotels.com/', '2015-09-23', 10, 1400, 'Hot Tour', 'Flight', 'Medical insurance', 3);

ALTER TABLE `tours`
  ADD PRIMARY KEY (`ID`);

ALTER TABLE `tours`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID тура', AUTO_INCREMENT=5;

SELECT * FROM tours;