-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2018. Máj 01. 20:13
-- Kiszolgáló verziója: 10.1.30-MariaDB
-- PHP verzió: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `java_db`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `double_out`
--

CREATE TABLE `double_out` (
  `Score` int(11) NOT NULL,
  `Suggest` text COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `double_out`
--

INSERT INTO `double_out` (`Score`, `Suggest`) VALUES
(170, 'T20, T20, DB'),
(137, 'T17, T18, D16'),
(104, 'T18, 18, D16'),
(71, 'T13, D16'),
(169, 'Nincs ajánlatom'),
(136, 'T20, T20, D8'),
(103, 'T20, 11, D16'),
(70, 'T18, D8'),
(168, 'Nincs ajánlatom'),
(135, 'T20, T15, D15'),
(102, 'T20, 10, D16'),
(69, 'T19, D6'),
(167, 'T20, T19, DB'),
(134, 'T20, T14, D16'),
(101, 'T17 18, D16,'),
(68, 'T16, D10'),
(166, 'Nincs ajánlatom'),
(133, 'T20, T19, D8'),
(100, 'T20, D20'),
(67, 'T17, D8'),
(165, 'Nincs ajánlatom'),
(132, 'T20, T20, D6'),
(99, 'T19, 10, D16'),
(66, 'T10, D18'),
(164, 'T20, T18, DB'),
(131, 'T20, T13, D16'),
(98, 'T20, D19'),
(65, 'T15, D10'),
(163, 'Nincs ajánlatom'),
(130, 'T20, T18, D8'),
(97, 'T19, D20'),
(64, 'D16, D16'),
(162, 'Nincs ajánlatom'),
(129, 'T19, T20, D6'),
(96, 'T20, D18'),
(63, 'T13, D12'),
(161, 'T20, T17, DB'),
(128, 'T18, T14, D16'),
(95, 'T15, 18, D16'),
(62, 'T10, D16'),
(160, 'T20, T20, D20'),
(127, 'T19, T18, D8'),
(94, 'T18, D20'),
(61, 'T15, D8'),
(159, 'Nincs ajánlatom'),
(126, 'T19, T19, D6'),
(93, 'T19, D18'),
(60, '20, D20'),
(158, 'T20, T20, D19'),
(125, 'B, T20, D20'),
(92, 'T20, D16'),
(59, '19, D20'),
(157, 'T20, T19, D20'),
(124, 'T20, D16, D16'),
(91, 'T17, D20'),
(58, '18, D20'),
(156, 'T20, T20, D18'),
(123, 'T19, T16, D9'),
(90, 'T18, D18'),
(57, '17, D20'),
(155, 'T20, T15, DB'),
(122, 'T18, T20, D4'),
(89, 'T19, D16'),
(56, '16, D20'),
(154, 'T20, T18, D20'),
(121, 'T20, T15, D8'),
(88, 'T16, D20'),
(55, '15, D20'),
(153, 'T20, T19, D18'),
(120, 'T20, 20, D20'),
(87, 'T17, D18'),
(54, '14, D20'),
(152, 'T20, T20, D16'),
(119, 'T19, T10, D16'),
(86, 'T18, D16'),
(53, '13, D20'),
(151, 'T20, T17, D20'),
(118, 'T20, 18, D20'),
(85, 'T15, D20'),
(52, '20, D16'),
(150, 'T20, T18, D18'),
(117, 'T20, 17, D20'),
(84, 'T20, D12'),
(51, '19, D16'),
(149, 'T20, T19, D16'),
(116, 'T20, 16, D20'),
(83, 'T17, D16'),
(50, '18, D16'),
(148, 'T20, T16, D20'),
(115, 'T20, 15, D20'),
(82, 'T14, D20'),
(49, '17, D16'),
(147, 'T20, T17, D18'),
(114, 'T20, 14, D20'),
(81, 'T15, D18'),
(48, '16, D16'),
(146, 'T20, T18, D16'),
(113, 'T20, 13, D20'),
(80, 'T16, D16'),
(47, '15, D16'),
(145, 'T20, T15, D20'),
(112, 'T20, 20, D16'),
(79, 'T13, D20'),
(46, '14, D16'),
(144, 'T20, T20, D12'),
(111, 'T20, 19, D16'),
(78, 'T14, D18'),
(45, '13, D16'),
(143, 'T20, T17, D16'),
(110, 'T20, 18, D16'),
(77, 'T15, D16'),
(44, '12, D16'),
(142, 'T20, T14, D20'),
(109, 'T20, 17, D16'),
(76, 'T20, D8'),
(43, '11, D16'),
(141, 'T20, T15, D18'),
(108, 'T20, 16, D16'),
(75, 'T15, D15'),
(42, '10, D16'),
(140, 'T20, T16, D16'),
(107, 'T19, 18, D16'),
(74, 'T14, D16'),
(41, '9, D16'),
(139, 'T20, T13, D20'),
(106, 'T20, 14, D16'),
(73, 'T19, D8'),
(40, 'D20'),
(138, 'T20, T14, D18'),
(105, 'T20, 13, D16'),
(72, 'T20, D6');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `helper`
--

CREATE TABLE `helper` (
  `id` int(2) NOT NULL,
  `kezd` int(20) NOT NULL,
  `kilep` text COLLATE utf8_hungarian_ci NOT NULL,
  `player1` varchar(60) COLLATE utf8_hungarian_ci NOT NULL,
  `player2` varchar(60) COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `helper`
--

INSERT INTO `helper` (`id`, `kezd`, `kilep`, `player1`, `player2`) VALUES
(1, 501, 'Dupla', 'Akos', 'Bálint');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `jatekosok`
--

CREATE TABLE `jatekosok` (
  `id` int(11) NOT NULL,
  `Név` text COLLATE utf8_hungarian_ci NOT NULL,
  `Gyozelmek` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `jatekosok`
--

INSERT INTO `jatekosok` (`id`, `Név`, `Gyozelmek`) VALUES
(147, 'Akos', 12),
(148, 'Jancsika', 2),
(149, 'Peti', 2),
(150, 'Laci', 1),
(151, 'Sanyi', 3),
(152, 'Bálint', 5),
(153, 'Sikezoli', 17),
(154, 'Bence', 4),
(155, 'Erik', 7),
(156, 'Kitti', 1),
(157, 'Pisti', 2);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `simple_out`
--

CREATE TABLE `simple_out` (
  `Score` int(10) NOT NULL,
  `Suggest` text COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `simple_out`
--

INSERT INTO `simple_out` (`Score`, `Suggest`) VALUES
(180, 'T20, T20, T20'),
(145, 'T15, B, B'),
(110, 'T20, B'),
(75, 'T15, D15'),
(179, 'Nincs ajánlatom'),
(144, 'B, T18, D20'),
(109, 'B, 9, B'),
(74, 'B, D12'),
(178, 'Nincs ajánlatom'),
(143, 'B, T19, D18'),
(108, 'B, 8, B'),
(73, 'T19, D8'),
(177, 'T20, T20, T19'),
(142, 'B, B, T14'),
(107, 'T19, B'),
(72, 'B, D11'),
(176, 'Nincs ajánlatom'),
(141, 'B, T17, D20'),
(106, 'B, 6, B'),
(71, '20, T17'),
(175, 'Nincs ajánlatom'),
(140, 'B, B, D20'),
(105, 'T20, T15'),
(70, '20, B'),
(174, 'T20, T19, T19'),
(139, 'B, B, T13'),
(104, 'T18, B'),
(69, '19, B'),
(173, 'Nincs ajánlatom'),
(138, 'B, B, D19'),
(103, 'B, 3, B'),
(68, '18, B'),
(172, 'Nincs ajánlatom'),
(137, 'B, T17, D18'),
(102, 'B, 2, B'),
(67, '17, B'),
(171, 'T19, T19, T19'),
(136, 'B, B, D18'),
(101, 'B, T17'),
(66, '16, B'),
(170, 'T20, T20, B'),
(135, 'B, T15, D20'),
(100, 'B, B'),
(65, '15, B'),
(169, 'Nincs ajánlatom'),
(134, 'B, B, D17'),
(99, 'B, 17, D16'),
(64, '14, B'),
(168, 'T19, T19, T18'),
(133, 'B, B, T11'),
(98, 'B, T16'),
(63, '13, B'),
(167, 'T20, T19, B'),
(132, 'B, B, D16'),
(97, 'T19, D20'),
(62, '12, B'),
(166, 'Nincs ajánlatom'),
(131, 'B, T15, D18'),
(96, 'T20, D18'),
(61, '11, B'),
(165, 'T19, T18, T18'),
(130, 'B, B, D15'),
(95, 'B, T15'),
(60, 'T20'),
(164, 'T20, T18, B'),
(129, 'B, T19, D11'),
(94, 'T20, D17'),
(59, '9, B'),
(163, 'Nincs ajánlatom'),
(128, 'B, B, D14'),
(93, 'T19, D18'),
(58, '8, B'),
(162, 'T18, T18, T18'),
(127, 'B, T19, 20'),
(92, 'B, T14'),
(57, 'T19'),
(161, 'T20, T17, B'),
(126, 'B, B, D13'),
(91, 'T17, D20'),
(56, '16, D20'),
(160, 'B, B, T20'),
(125, 'B, T15, D15'),
(90, 'B, D20'),
(55, '5, B'),
(159, 'T19, T20, T14'),
(124, 'B, B, D12'),
(89, 'B, T13'),
(54, 'T18'),
(158, 'B, T20, T16'),
(123, 'B, T19, D8'),
(88, 'B, D19'),
(53, '3, B'),
(157, 'B, B, T19'),
(122, 'B, B, D11'),
(87, 'T17, D18'),
(52, '2, B'),
(156, 'T20, T20, D18'),
(121, 'B, T17, D10'),
(86, 'B, D18'),
(51, 'T17'),
(155, 'B, T20, T15'),
(120, 'B, 20, B'),
(85, 'T15, D20'),
(50, 'B'),
(154, 'B, B, T18'),
(119, 'B, 19, B'),
(84, 'B, D17'),
(49, '17, D16'),
(153, 'T19, T20, D18'),
(118, 'B, 18, B'),
(83, 'B, T11'),
(48, 'T16'),
(152, 'B, T20, T14'),
(117, 'B, 17, B'),
(82, 'B, D16'),
(47, '15, D16'),
(151, 'B, B, T17'),
(116, 'B, 16, B'),
(81, 'T15, D18'),
(46, '14, D16'),
(150, 'B, B, B'),
(115, 'B, 15, B'),
(80, 'B, D15'),
(45, 'T15'),
(149, 'T20, T19, D16'),
(114, 'B, 14, B'),
(79, 'T13, D20'),
(44, '12, D16'),
(148, 'B, B, T16'),
(113, 'B, 13, B'),
(78, 'B, D14'),
(43, '11, D16'),
(147, 'B, T19, D20'),
(112, 'B, 12, B'),
(77, 'T19, D10'),
(42, 'T14'),
(146, 'B, T20, D18'),
(111, 'B, 11, B'),
(76, 'B, D13'),
(41, '9, D16');

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `helper`
--
ALTER TABLE `helper`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `jatekosok`
--
ALTER TABLE `jatekosok`
  ADD PRIMARY KEY (`id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `helper`
--
ALTER TABLE `helper`
  MODIFY `id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT a táblához `jatekosok`
--
ALTER TABLE `jatekosok`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=158;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
