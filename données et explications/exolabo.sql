-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 18 déc. 2020 à 19:32
-- Version du serveur :  10.4.13-MariaDB
-- Version de PHP : 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `exolabo`
--

-- --------------------------------------------------------

--
-- Structure de la table `activitee`
--

CREATE TABLE `activitee` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `activitee`
--

INSERT INTO `activitee` (`id`, `nom`, `description`) VALUES
(1, 'La pêche aux canards', 'On y pêche des canards... parfois des bananes :)'),
(4, 'll', ' salut');

-- --------------------------------------------------------

--
-- Structure de la table `aproximite`
--

CREATE TABLE `aproximite` (
  `chambre_id` int(11) NOT NULL,
  `activitee_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `aproximite`
--

INSERT INTO `aproximite` (`chambre_id`, `activitee_id`) VALUES
(5, 1);

-- --------------------------------------------------------

--
-- Structure de la table `chambre`
--

CREATE TABLE `chambre` (
  `id` int(11) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `ville` varchar(50) NOT NULL,
  `place` int(11) NOT NULL,
  `geree` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `chambre`
--

INSERT INTO `chambre` (`id`, `adresse`, `ville`, `place`, `geree`) VALUES
(1, 'Rue de la mort', 'Creuvar-Sur-Mer', 3, 1),
(2, 'rue de la longue haie', 'bruxelle', 2, 1),
(3, 'rue de la longue haie', 'bruxelle', 2, 1),
(4, 'tytyt', 'totot', 3, 1),
(5, 'tytyt', 'totot', 3, 1);

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `id` int(11) NOT NULL,
  `nPersonne` int(11) NOT NULL,
  `dataArr` date NOT NULL,
  `dateDep` date NOT NULL,
  `estReservee` int(11) NOT NULL,
  `reserve` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`id`, `nPersonne`, `dataArr`, `dateDep`, `estReservee`, `reserve`) VALUES
(3, 5, '1987-06-02', '1987-06-02', 1, 1),
(4, 5, '1987-06-03', '1987-06-03', 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `username`, `password`, `nom`, `prenom`, `email`) VALUES
(1, 'liklo', 'quidivrai', 'lilo', 'juio', 'tyty@popo.be');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `activitee`
--
ALTER TABLE `activitee`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nom` (`nom`);

--
-- Index pour la table `aproximite`
--
ALTER TABLE `aproximite`
  ADD PRIMARY KEY (`chambre_id`,`activitee_id`),
  ADD KEY `activitee_id` (`activitee_id`);

--
-- Index pour la table `chambre`
--
ALTER TABLE `chambre`
  ADD PRIMARY KEY (`id`),
  ADD KEY `geree` (`geree`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `estReservee` (`estReservee`),
  ADD KEY `reserve` (`reserve`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `activitee`
--
ALTER TABLE `activitee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `chambre`
--
ALTER TABLE `chambre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `aproximite`
--
ALTER TABLE `aproximite`
  ADD CONSTRAINT `aproximite_ibfk_1` FOREIGN KEY (`chambre_id`) REFERENCES `chambre` (`id`),
  ADD CONSTRAINT `aproximite_ibfk_2` FOREIGN KEY (`activitee_id`) REFERENCES `activitee` (`id`);

--
-- Contraintes pour la table `chambre`
--
ALTER TABLE `chambre`
  ADD CONSTRAINT `chambre_ibfk_1` FOREIGN KEY (`geree`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`estReservee`) REFERENCES `chambre` (`id`),
  ADD CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`reserve`) REFERENCES `utilisateur` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
