-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 06 Lut 2022, 22:03
-- Wersja serwera: 10.4.22-MariaDB
-- Wersja PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `baza1`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `klienci`
--

CREATE TABLE `klienci` (
  `id_kli` int(4) NOT NULL,
  `nazwisko` varchar(25) COLLATE utf8_polish_ci NOT NULL,
  `imie` varchar(25) COLLATE utf8_polish_ci NOT NULL,
  `nr_dowodu` varchar(9) COLLATE utf8_polish_ci NOT NULL,
  `miejscowosc` varchar(25) COLLATE utf8_polish_ci NOT NULL,
  `ulica` varchar(25) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `klienci`
--

INSERT INTO `klienci` (`id_kli`, `nazwisko`, `imie`, `nr_dowodu`, `miejscowosc`, `ulica`) VALUES
(10, 'TWAROŻEK', 'PIOTR', 'AA1234567', 'WARSZAWA', 'DLUGA 8/12'),
(15, 'CIEŚLAK', 'JAN', 'BC2343561', 'WROCLAW', 'NORWIDA 2/1'),
(20, 'ADAMCZYK', 'PAWEL', 'AG8967452', 'POZNAN', 'KROTKA 2'),
(25, 'BRACKI', 'BOGDAN', 'CC3478690', 'GDANSK', 'BALTYCKA 67/4'),
(30, 'LIPKA', 'JAKUB', 'CE6712098', 'KATOWICE', 'POLNA 9'),
(31, 'BOŻEK', 'PIOTR', 'SD3321643', 'KRYG', 'MELA 2/4'),
(33, 'NOWAK', 'KIESŁAW', 'JD4280120', 'SZYMBARG', 'KAPIBARA 4/10'),
(34, 'KAPECKI', 'ADRIAN', 'DW4817654', 'DĘBICA', 'RODOKOT 3/20'),
(35, 'STACUCH', 'PAWEŁ', 'JK4001453', 'SĘKOWA', 'KAZIMIERZA 7/10'),
(36, 'KOWALSKI', 'RAFAŁ', 'IE0731282', 'PIASECZNO', 'OGROWA 1/85'),
(37, 'KRÓL', 'MONIKA', 'MK3060390', 'ŁAŃCUT', 'GŁÓWNA 3/36');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pracownicy`
--

CREATE TABLE `pracownicy` (
  `id_prac` int(11) NOT NULL,
  `nazwisko` varchar(25) COLLATE utf8_polish_ci NOT NULL,
  `imie` varchar(25) COLLATE utf8_polish_ci NOT NULL,
  `telefon` varchar(9) COLLATE utf8_polish_ci NOT NULL,
  `pesel` bigint(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `pracownicy`
--

INSERT INTO `pracownicy` (`id_prac`, `nazwisko`, `imie`, `telefon`, `pesel`) VALUES
(1, 'NOWAK', 'PIOTR', '234532123', 32323242125),
(2, 'MYŚLIWIEC', 'WIESŁAW', '842902136', 94215329106),
(3, 'PRÓL', 'KONRAD', '942150521', 21252196224),
(5, 'RUBY', 'MATI', '952734124', 13295916278),
(6, 'BRANIECKI', 'ALBERT', '492142189', 2123953292),
(7, 'TUSK', 'NATALIA', '492612429', 1302485932);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `samochody`
--

CREATE TABLE `samochody` (
  `id_sam` int(4) NOT NULL,
  `nr_rej` varchar(8) COLLATE utf8_polish_ci NOT NULL,
  `marka` varchar(12) COLLATE utf8_polish_ci NOT NULL,
  `model` varchar(12) COLLATE utf8_polish_ci NOT NULL,
  `rok_prod` int(4) NOT NULL,
  `kraj_prod` varchar(15) COLLATE utf8_polish_ci NOT NULL,
  `poj_sil` int(3) NOT NULL,
  `koszt_dnia` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `samochody`
--

INSERT INTO `samochody` (`id_sam`, `nr_rej`, `marka`, `model`, `rok_prod`, `kraj_prod`, `poj_sil`, `koszt_dnia`) VALUES
(100, 'KRA-1023', 'OPEL', 'ASTRA', 1995, 'NIEMCY', 1, 45),
(110, 'KRC-A120', 'MERCEDES', 'S600', 1998, 'NIEMCY', 6, 200),
(120, 'TAV-1909', 'FORD', 'Ka', 2000, 'USA', 1, 40),
(130, 'WAW-8967', 'TOYOTA', 'YARIS', 2001, 'JAPONIA', 1, 45),
(140, 'WRE-4509', 'OPEL', 'VECTRA', 1997, 'NIEMCY', 3, 80),
(150, 'GDA-A890', 'OPEL', 'YARISKA', 1995, 'NIEMCY', 2, 60),
(160, 'PKT-0967', 'VOLVO', '440', 1984, 'SZWECJA', 1, 30),
(170, 'TAW-6598', 'FIAT', 'PUNTO', 1991, 'WLOCHY', 1, 40),
(180, 'KRC-4590', 'NISSAN', 'MICRA', 1998, 'JAPONIA', 1, 45),
(190, 'POK-9089', 'OPEL', 'CALIBRA', 1990, 'NIEMCY', 2, 55),
(200, 'HPJ-4205', 'MELAK', 'MELINIARZ', 1995, 'NIGGERIA', 3, 59);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `wypozyczenia`
--

CREATE TABLE `wypozyczenia` (
  `id_wyp` int(4) NOT NULL,
  `id_sam` int(4) NOT NULL,
  `id_prac` int(4) NOT NULL,
  `id_kli` int(4) NOT NULL,
  `data_wyp` date NOT NULL,
  `data_zwr` date NOT NULL,
  `koszt` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `wypozyczenia`
--

INSERT INTO `wypozyczenia` (`id_wyp`, `id_sam`, `id_prac`, `id_kli`, `data_wyp`, `data_zwr`, `koszt`) VALUES
(1, 150, 1, 15, '2003-01-15', '2003-02-15', 1800),
(2, 120, 2, 30, '2003-04-08', '2004-04-17', 360),
(3, 180, 1, 25, '2004-09-10', '2005-01-11', 5535),
(4, 130, 3, 20, '2004-12-30', '2005-01-14', 675),
(7, 140, 3, 10, '2006-01-03', '2006-01-02', 80),
(8, 110, 2, 10, '2006-01-02', '2006-12-30', 72400),
(9, 170, 1, 15, '2006-02-15', '2007-01-01', 8000),
(11, 160, 3, 25, '2006-02-16', '2006-12-01', 4590),
(13, 140, 2, 15, '2021-12-07', '2021-12-31', 230),
(14, 170, 1, 15, '2021-12-15', '2022-12-13', 2300),
(15, 110, 2, 15, '2022-01-03', '2022-01-13', 412),
(16, 110, 1, 33, '2022-01-04', '2022-01-13', 341),
(17, 130, 7, 37, '2022-01-18', '2022-01-26', 300),
(18, 170, 6, 35, '2022-01-04', '2022-01-08', 350),
(19, 140, 6, 36, '2021-01-21', '2022-01-11', 640),
(20, 110, 7, 33, '2022-01-18', '2022-01-19', 40);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `klienci`
--
ALTER TABLE `klienci`
  ADD PRIMARY KEY (`id_kli`);

--
-- Indeksy dla tabeli `pracownicy`
--
ALTER TABLE `pracownicy`
  ADD PRIMARY KEY (`id_prac`);

--
-- Indeksy dla tabeli `samochody`
--
ALTER TABLE `samochody`
  ADD PRIMARY KEY (`id_sam`);

--
-- Indeksy dla tabeli `wypozyczenia`
--
ALTER TABLE `wypozyczenia`
  ADD PRIMARY KEY (`id_wyp`),
  ADD KEY `ID_SAM` (`id_sam`),
  ADD KEY `ID_KLI` (`id_kli`),
  ADD KEY `ID_PRAC` (`id_prac`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `klienci`
--
ALTER TABLE `klienci`
  MODIFY `id_kli` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT dla tabeli `pracownicy`
--
ALTER TABLE `pracownicy`
  MODIFY `id_prac` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT dla tabeli `samochody`
--
ALTER TABLE `samochody`
  MODIFY `id_sam` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=201;

--
-- AUTO_INCREMENT dla tabeli `wypozyczenia`
--
ALTER TABLE `wypozyczenia`
  MODIFY `id_wyp` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `wypozyczenia`
--
ALTER TABLE `wypozyczenia`
  ADD CONSTRAINT `wypozyczenia_ibfk_1` FOREIGN KEY (`id_sam`) REFERENCES `samochody` (`id_sam`) ON UPDATE CASCADE,
  ADD CONSTRAINT `wypozyczenia_ibfk_2` FOREIGN KEY (`id_kli`) REFERENCES `klienci` (`id_kli`) ON UPDATE CASCADE,
  ADD CONSTRAINT `wypozyczenia_ibfk_3` FOREIGN KEY (`id_prac`) REFERENCES `pracownicy` (`id_prac`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
