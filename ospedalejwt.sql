-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 04, 2023 at 11:46 PM
-- Server version: 5.7.24
-- PHP Version: 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ospedalejwt`
--

-- --------------------------------------------------------

--
-- Table structure for table `esame`
--

CREATE TABLE `esame` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `prezzo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `esame`
--

INSERT INTO `esame` (`id`, `nome`, `prezzo`) VALUES
(1, 'Emocromo', 15),
(2, 'Glicemia', 20),
(3, 'Esame urine', 15),
(4, 'Colesterolo', 22),
(5, 'Prolattina', 35);

-- --------------------------------------------------------

--
-- Table structure for table `esame_laboratorio`
--

CREATE TABLE `esame_laboratorio` (
  `id` int(11) NOT NULL,
  `data` date NOT NULL,
  `esito` varchar(50) NOT NULL,
  `id_esame` int(11) NOT NULL,
  `id_paziente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `esame_laboratorio`
--

INSERT INTO `esame_laboratorio` (`id`, `data`, `esito`, `id_esame`, `id_paziente`) VALUES
(1, '2023-05-01', 'Negativo', 1, 1),
(2, '2023-05-02', 'Positivo', 1, 2),
(3, '2023-05-03', 'Negativo', 3, 3),
(4, '2023-05-04', 'Positivo', 4, 2),
(5, '2023-05-05', 'Negativo', 5, 4);

-- --------------------------------------------------------

--
-- Table structure for table `medico`
--

CREATE TABLE `medico` (
  `id` int(11) NOT NULL,
  `cognome` varchar(50) NOT NULL,
  `data_n` date NOT NULL,
  `luogo_n` varchar(50) NOT NULL,
  `nome` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `medico`
--

INSERT INTO `medico` (`id`, `cognome`, `data_n`, `luogo_n`, `nome`) VALUES
(1, 'Mondragone', '1980-01-10', 'Milano', 'Fiore'),
(2, 'Bianchi', '1975-06-15', 'Roma', 'Laura'),
(3, 'Verdi', '1990-03-20', 'Napoli', 'Giuseppe'),
(4, 'Russo', '1985-09-05', 'Firenze', 'Francesca'),
(5, 'Ferrari', '1982-11-25', 'Torino', 'Luigi'),
(6, 'dfsdf', '2005-05-12', 'Milano', 'Michele');

-- --------------------------------------------------------

--
-- Table structure for table `paziente`
--

CREATE TABLE `paziente` (
  `id` int(11) NOT NULL,
  `cod_fis` varchar(16) NOT NULL,
  `cognome` varchar(50) NOT NULL,
  `data_n` date DEFAULT NULL,
  `data_ricovero` date DEFAULT NULL,
  `file` longblob,
  `luogo_n` varchar(50) DEFAULT NULL,
  `nome` varchar(50) NOT NULL,
  `sesso` varchar(1) DEFAULT NULL,
  `id_reparto` int(11) DEFAULT NULL,
  `id_user` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `paziente`
--

INSERT INTO `paziente` (`id`, `cod_fis`, `cognome`, `data_n`, `data_ricovero`, `file`, `luogo_n`, `nome`, `sesso`, `id_reparto`, `id_user`) VALUES
(1, 'RSSMRC80A10L736U', 'Rossi', '1980-01-10', '2023-05-25', NULL, 'Milano', 'Marco', 'M', 1, 1),
(2, 'BNCNLA75H55L548E', 'Bianchi', '1975-06-15', '2023-05-02', NULL, 'Roma', 'Laura', 'F', 2, NULL),
(3, 'VRDGPP90C20F839V', 'Verdi', '1990-03-20', '2023-05-03', NULL, 'Napoli', 'Giuseppe', 'M', 1, NULL),
(4, 'RSSFNC85P05D612K', 'Russo', '1985-09-05', '2023-05-04', NULL, 'Firenze', 'Francesca', 'F', 3, NULL),
(5, 'RSSMRA90A01H501A', 'Rossi', '1990-01-01', '2023-05-23', NULL, 'Roma', 'Mario', 'M', 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `reparto`
--

CREATE TABLE `reparto` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `id_medico` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reparto`
--

INSERT INTO `reparto` (`id`, `nome`, `id_medico`) VALUES
(1, 'Cardiologia', 1),
(2, 'Pneumologia', 2),
(3, 'Neurologia', 3),
(4, 'Oncologia', 4),
(5, 'Gastroenterologia', 6);

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'ROLE_PATIENT'),
(2, 'ROLE_OPERATOR');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(120) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `password`, `username`) VALUES
(1, 'harmfulcati@gmail.com', '$2a$10$U2CD7o8LtxpACl8MQ5JpVejYfXCXxjjSyppswWolbYR2015QwhQKi', 'vlad'),
(2, 'vladus.dev@gmail.com', '$2a$10$0upYs1HBUc9q4W.sZBqU2ekobpXicOMVHo3KDXEx3XIBlpw0tnTPK', 'vladus');

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `visita`
--

CREATE TABLE `visita` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `visita`
--

INSERT INTO `visita` (`id`, `nome`) VALUES
(1, 'Visita di controllo'),
(2, 'Visita specialistica'),
(3, 'Visita pre-operatoria');

-- --------------------------------------------------------

--
-- Table structure for table `visita_paziente`
--

CREATE TABLE `visita_paziente` (
  `id` int(11) NOT NULL,
  `data` date NOT NULL,
  `esito` varchar(50) NOT NULL,
  `id_medico` int(11) NOT NULL,
  `id_paziente` int(11) NOT NULL,
  `id_visita` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `visita_paziente`
--

INSERT INTO `visita_paziente` (`id`, `data`, `esito`, `id_medico`, `id_paziente`, `id_visita`) VALUES
(1, '2023-05-06', 'Negativa', 1, 1, 1),
(2, '2023-05-07', 'Positiva', 2, 2, 2),
(3, '2023-05-08', 'Negativa', 3, 3, 3),
(4, '2023-05-09', 'Positiva', 4, 4, 2),
(5, '2023-05-10', 'Negativa', 5, 5, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `esame`
--
ALTER TABLE `esame`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `esame_laboratorio`
--
ALTER TABLE `esame_laboratorio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhkguytm23bc9amq69oo47jqk7` (`id_esame`),
  ADD KEY `FK5ktke5wd3xqtv6rfrx36lxv7n` (`id_paziente`);

--
-- Indexes for table `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `paziente`
--
ALTER TABLE `paziente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKiftvrrqgwfgxg6qn8rp8pbxio` (`id_reparto`),
  ADD KEY `FKahp285fbpom3r2msa1xen2sva` (`id_user`);

--
-- Indexes for table `reparto`
--
ALTER TABLE `reparto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpqvr9h93gykjw8de3xfafkcdh` (`id_medico`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`),
  ADD UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`);

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`);

--
-- Indexes for table `visita`
--
ALTER TABLE `visita`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `visita_paziente`
--
ALTER TABLE `visita_paziente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKm63o376tq6msx9csr6bg1a17n` (`id_medico`),
  ADD KEY `FKjp91ymshnbvryowk5x5xaku5u` (`id_paziente`),
  ADD KEY `FKrbs9ol9qntbay1opfbvneec99` (`id_visita`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `esame`
--
ALTER TABLE `esame`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `esame_laboratorio`
--
ALTER TABLE `esame_laboratorio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `medico`
--
ALTER TABLE `medico`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `paziente`
--
ALTER TABLE `paziente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `reparto`
--
ALTER TABLE `reparto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `visita`
--
ALTER TABLE `visita`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `visita_paziente`
--
ALTER TABLE `visita_paziente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `esame_laboratorio`
--
ALTER TABLE `esame_laboratorio`
  ADD CONSTRAINT `FK5ktke5wd3xqtv6rfrx36lxv7n` FOREIGN KEY (`id_paziente`) REFERENCES `paziente` (`id`),
  ADD CONSTRAINT `FKhkguytm23bc9amq69oo47jqk7` FOREIGN KEY (`id_esame`) REFERENCES `esame` (`id`);

--
-- Constraints for table `paziente`
--
ALTER TABLE `paziente`
  ADD CONSTRAINT `FKahp285fbpom3r2msa1xen2sva` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKiftvrrqgwfgxg6qn8rp8pbxio` FOREIGN KEY (`id_reparto`) REFERENCES `reparto` (`id`);

--
-- Constraints for table `reparto`
--
ALTER TABLE `reparto`
  ADD CONSTRAINT `FKpqvr9h93gykjw8de3xfafkcdh` FOREIGN KEY (`id_medico`) REFERENCES `medico` (`id`);

--
-- Constraints for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `visita_paziente`
--
ALTER TABLE `visita_paziente`
  ADD CONSTRAINT `FKjp91ymshnbvryowk5x5xaku5u` FOREIGN KEY (`id_paziente`) REFERENCES `paziente` (`id`),
  ADD CONSTRAINT `FKm63o376tq6msx9csr6bg1a17n` FOREIGN KEY (`id_medico`) REFERENCES `medico` (`id`),
  ADD CONSTRAINT `FKrbs9ol9qntbay1opfbvneec99` FOREIGN KEY (`id_visita`) REFERENCES `visita` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
