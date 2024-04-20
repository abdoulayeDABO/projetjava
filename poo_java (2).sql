-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 19 avr. 2024 à 23:08
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `poo_java`
--

-- --------------------------------------------------------

--
-- Structure de la table `articles`
--

CREATE TABLE `articles` (
  `libelle` varchar(20) NOT NULL,
  `pu` float NOT NULL,
  `quantite` int(11) NOT NULL,
  `categorie` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `articles`
--

INSERT INTO `articles` (`libelle`, `pu`, `quantite`, `categorie`) VALUES
('Fauteuil', 45484, 72, 'Meuble'),
('Machine à laver', 7451160, 5, 'Electro Ménager'),
('Ordinateur', 404518, 58, 'Electroniques'),
('Lampe', 8412, 72, 'Luminaire'),
('Matelas', 7185, 56, 'Meubles'),
('SmartWatch', 5322, 96, 'Electronique'),
('PAIN', 2500, 45, 'NOURRITURE'),
('Table', 8551, 9, 'Meuble');

-- --------------------------------------------------------

--
-- Structure de la table `employes`
--

CREATE TABLE `employes` (
  `id` varchar(15) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `login` varchar(30) NOT NULL,
  `mdp` varchar(20) NOT NULL,
  `tel` varchar(20) NOT NULL,
  `salaire` double NOT NULL,
  `annee` varchar(4) NOT NULL,
  `poste` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `employes`
--

INSERT INTO `employes` (`id`, `nom`, `prenom`, `login`, `mdp`, `tel`, `salaire`, `annee`, `poste`) VALUES
('id1', 'Seck', 'Abdoulaye', 'AbdoulayeSeck', 'c7frv4v52', '781611546', 541215452, '210', 'Commercial'),
('id45', 'Ba', 'Mamadou', 'admin', 'passer', '771548512', 9645115, '2008', 'administrateur'),
('id816', 'admin', 'admin', 'admin1', 'admin', '7742415', 87125245, '2006', 'administrateur');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `employes`
--
ALTER TABLE `employes`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `login` (`login`),
  ADD UNIQUE KEY `login_2` (`login`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
