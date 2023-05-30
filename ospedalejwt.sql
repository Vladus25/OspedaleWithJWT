-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mag 30, 2023 alle 17:51
-- Versione del server: 10.4.27-MariaDB
-- Versione PHP: 8.2.0

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
-- Struttura della tabella `esame`
--

CREATE TABLE `esame` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `prezzo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `esame`
--

INSERT INTO `esame` (`id`, `nome`, `prezzo`) VALUES
(1, 'Emocromo', 15),
(2, 'Glicemia', 20),
(3, 'Esame urine', 15),
(4, 'Colesterolo', 22),
(5, 'Prolattina', 35);

-- --------------------------------------------------------

--
-- Struttura della tabella `esame_laboratorio`
--

CREATE TABLE `esame_laboratorio` (
  `id` int(11) NOT NULL,
  `data` date NOT NULL,
  `esito` varchar(50) NOT NULL,
  `id_esame` int(11) NOT NULL,
  `id_paziente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `esame_laboratorio`
--

INSERT INTO `esame_laboratorio` (`id`, `data`, `esito`, `id_esame`, `id_paziente`) VALUES
(1, '2023-05-01', 'Negativo', 1, 1),
(2, '2023-05-02', 'Positivo', 1, 2),
(3, '2023-05-03', 'Negativo', 3, 3),
(4, '2023-05-04', 'Positivo', 4, 2),
(5, '2023-05-05', 'Negativo', 5, 4);

-- --------------------------------------------------------

--
-- Struttura della tabella `medico`
--

CREATE TABLE `medico` (
  `id` int(11) NOT NULL,
  `cognome` varchar(50) NOT NULL,
  `data_n` date NOT NULL,
  `luogo_n` varchar(50) NOT NULL,
  `nome` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `medico`
--

INSERT INTO `medico` (`id`, `cognome`, `data_n`, `luogo_n`, `nome`) VALUES
(1, 'Mondragone', '1980-01-10', 'Milano', 'Fiore'),
(2, 'Bianchi', '1975-06-15', 'Roma', 'Laura'),
(3, 'Verdi', '1990-03-20', 'Napoli', 'Giuseppe'),
(4, 'Russo', '1985-09-05', 'Firenze', 'Francesca'),
(5, 'Ferrari', '1982-11-25', 'Torino', 'Luigi');

-- --------------------------------------------------------

--
-- Struttura della tabella `paziente`
--

CREATE TABLE `paziente` (
  `id` int(11) NOT NULL,
  `cod_fis` varchar(16) NOT NULL,
  `cognome` varchar(50) NOT NULL,
  `data_n` date DEFAULT NULL,
  `data_ricovero` date DEFAULT NULL,
  `file` longblob DEFAULT NULL,
  `luogo_n` varchar(50) DEFAULT NULL,
  `nome` varchar(50) NOT NULL,
  `sesso` varchar(1) DEFAULT NULL,
  `id_reparto` int(11) DEFAULT NULL,
  `id_user` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `paziente`
--

INSERT INTO `paziente` (`id`, `cod_fis`, `cognome`, `data_n`, `data_ricovero`, `file`, `luogo_n`, `nome`, `sesso`, `id_reparto`, `id_user`) VALUES
(1, 'RSSMRC80A10L736U', 'Rossi', '1980-01-10', '2023-05-25', NULL, 'Milano', 'Marco', 'M', 1, 1),
(2, 'BNCNLA75H55L548E', 'Bianchi', '1975-06-15', '2023-05-02', NULL, 'Roma', 'Laura', 'F', 2, NULL),
(3, 'VRDGPP90C20F839V', 'Verdi', '1990-03-20', '2023-05-03', NULL, 'Napoli', 'Giuseppe', 'M', 1, NULL),
(4, 'RSSFNC85P05D612K', 'Russo', '1985-09-05', '2023-05-04', NULL, 'Firenze', 'Francesca', 'F', 3, NULL),
(5, 'RSSMRA90A01H501A', 'Rossi', '1990-01-01', '2023-05-23', NULL, 'Roma', 'Mario', 'M', 1, NULL);

-- --------------------------------------------------------

--
-- Struttura della tabella `reparto`
--

CREATE TABLE `reparto` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `id_medico` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `reparto`
--

INSERT INTO `reparto` (`id`, `nome`, `id_medico`) VALUES
(1, 'Cardiologia', 1),
(2, 'Pneumologia', 2),
(3, 'Neurologia', 3),
(4, 'Oncologia', 4),
(5, 'Gastroenterologia', 5);

-- --------------------------------------------------------

--
-- Struttura della tabella `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'ROLE_PATIENT'),
(2, 'ROLE_OPERATOR');

-- --------------------------------------------------------

--
-- Struttura della tabella `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(120) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `users`
--

INSERT INTO `users` (`id`, `email`, `password`, `username`) VALUES
(1, 'harmfulcati@gmail.com', '$2a$10$U2CD7o8LtxpACl8MQ5JpVejYfXCXxjjSyppswWolbYR2015QwhQKi', 'vlad'),
(2, 'vladus.dev@gmail.com', '$2a$10$0upYs1HBUc9q4W.sZBqU2ekobpXicOMVHo3KDXEx3XIBlpw0tnTPK', 'vladus');

-- --------------------------------------------------------

--
-- Struttura della tabella `user_roles`
--

CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `visita`
--

CREATE TABLE `visita` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `visita`
--

INSERT INTO `visita` (`id`, `nome`) VALUES
(1, 'Visita di controllo'),
(2, 'Visita specialistica'),
(3, 'Visita pre-operatoria');

-- --------------------------------------------------------

--
-- Struttura della tabella `visita_paziente`
--

CREATE TABLE `visita_paziente` (
  `id` int(11) NOT NULL,
  `data` date NOT NULL,
  `esito` varchar(50) NOT NULL,
  `id_medico` int(11) NOT NULL,
  `id_paziente` int(11) NOT NULL,
  `id_visita` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `visita_paziente`
--

INSERT INTO `visita_paziente` (`id`, `data`, `esito`, `id_medico`, `id_paziente`, `id_visita`) VALUES
(1, '2023-05-06', 'Negativa', 1, 1, 1),
(2, '2023-05-07', 'Positiva', 2, 2, 2),
(3, '2023-05-08', 'Negativa', 3, 3, 3),
(4, '2023-05-09', 'Positiva', 4, 4, 2),
(5, '2023-05-10', 'Negativa', 5, 5, 1);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `esame`
--
ALTER TABLE `esame`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `esame_laboratorio`
--
ALTER TABLE `esame_laboratorio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhkguytm23bc9amq69oo47jqk7` (`id_esame`),
  ADD KEY `FK5ktke5wd3xqtv6rfrx36lxv7n` (`id_paziente`);

--
-- Indici per le tabelle `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `paziente`
--
ALTER TABLE `paziente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKiftvrrqgwfgxg6qn8rp8pbxio` (`id_reparto`),
  ADD KEY `FKahp285fbpom3r2msa1xen2sva` (`id_user`);

--
-- Indici per le tabelle `reparto`
--
ALTER TABLE `reparto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpqvr9h93gykjw8de3xfafkcdh` (`id_medico`);

--
-- Indici per le tabelle `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`),
  ADD UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`);

--
-- Indici per le tabelle `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`);

--
-- Indici per le tabelle `visita`
--
ALTER TABLE `visita`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `visita_paziente`
--
ALTER TABLE `visita_paziente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKm63o376tq6msx9csr6bg1a17n` (`id_medico`),
  ADD KEY `FKjp91ymshnbvryowk5x5xaku5u` (`id_paziente`),
  ADD KEY `FKrbs9ol9qntbay1opfbvneec99` (`id_visita`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `esame`
--
ALTER TABLE `esame`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `esame_laboratorio`
--
ALTER TABLE `esame_laboratorio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `medico`
--
ALTER TABLE `medico`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `paziente`
--
ALTER TABLE `paziente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT per la tabella `reparto`
--
ALTER TABLE `reparto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `visita`
--
ALTER TABLE `visita`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT per la tabella `visita_paziente`
--
ALTER TABLE `visita_paziente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `esame_laboratorio`
--
ALTER TABLE `esame_laboratorio`
  ADD CONSTRAINT `FK5ktke5wd3xqtv6rfrx36lxv7n` FOREIGN KEY (`id_paziente`) REFERENCES `paziente` (`id`),
  ADD CONSTRAINT `FKhkguytm23bc9amq69oo47jqk7` FOREIGN KEY (`id_esame`) REFERENCES `esame` (`id`);

--
-- Limiti per la tabella `paziente`
--
ALTER TABLE `paziente`
  ADD CONSTRAINT `FKahp285fbpom3r2msa1xen2sva` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKiftvrrqgwfgxg6qn8rp8pbxio` FOREIGN KEY (`id_reparto`) REFERENCES `reparto` (`id`);

--
-- Limiti per la tabella `reparto`
--
ALTER TABLE `reparto`
  ADD CONSTRAINT `FKpqvr9h93gykjw8de3xfafkcdh` FOREIGN KEY (`id_medico`) REFERENCES `medico` (`id`);

--
-- Limiti per la tabella `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Limiti per la tabella `visita_paziente`
--
ALTER TABLE `visita_paziente`
  ADD CONSTRAINT `FKjp91ymshnbvryowk5x5xaku5u` FOREIGN KEY (`id_paziente`) REFERENCES `paziente` (`id`),
  ADD CONSTRAINT `FKm63o376tq6msx9csr6bg1a17n` FOREIGN KEY (`id_medico`) REFERENCES `medico` (`id`),
  ADD CONSTRAINT `FKrbs9ol9qntbay1opfbvneec99` FOREIGN KEY (`id_visita`) REFERENCES `visita` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
