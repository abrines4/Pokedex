/*
	Group 2
	createTable.sql
	POKEMON DATABASE
	
	Ana Briones
	Ivins Jove
	Landon Prewitt
	Yuan-Peng Yu
*/

CREATE TABLE IF NOT EXISTS Trainer (
	trainerName VARCHAR(30) PRIMARY KEY,
	trainerType  VARCHAR(30)
);
  
 CREATE TABLE IF NOT EXISTS Pokemon (
	pokemonID INT PRIMARY KEY,
	pokemonName VARCHAR(20),
	gender CHAR(1),
	category VARCHAR(20),
	evolved BOOLEAN,
	ability VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS PokemonType (
	pokemonID INT,
	pokemonType VARCHAR(20),
	PRIMARY KEY(pokemonID, pokemonType)
);

CREATE TABLE IF NOT EXISTS Statistics (
	pokemonID INT PRIMARY KEY,
	defense INT,
	attack INT,
	speed INT,
	hp INT,
	specialAttack INT,
	specialDefense INT
);

CREATE TABLE IF NOT EXISTS Weaknesses (
	pokemonID INT,
	weakness VARCHAR(20),
	PRIMARY KEY(pokemonID, weakness)
);

CREATE TABLE IF NOT EXISTS Evolution (
	pokemonID INT PRIMARY KEY,
	evolutionName VARCHAR(20),
	levelOfEvolution INT,
	evolutionType VARCHAR(75),
	previousEvolution VARCHAR(20),
	postEvolution VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS Attack (
	attackName VARCHAR(20) PRIMARY KEY,
	attackPower INT,
	attackType VARCHAR(20)
);

/* Specifies all of the attacks or moves that the pokemon is able to learn */
CREATE TABLE IF NOT EXISTS Learn (
	attackName VARCHAR(20),
	pokemonName VARCHAR(20),
	PRIMARY KEY(attackName, pokemonName)
);

CREATE TABLE IF NOT EXISTS Gym (
	gymName VARCHAR(20) PRIMARY KEY,
	leaderName VARCHAR(20),
	gymType VARCHAR(20),
	gymBadge VARCHAR(20)
);

/* Relates all of the attacks, moves, learned from leveling up */
CREATE TABLE IF NOT EXISTS Performs (
	pokemonID INT,
	attackName VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS Owns (
	trainerName VARCHAR(20),
	pokemonName VARCHAR(30),
	pokemonID INT
);

CREATE TABLE IF NOT EXISTS Appears_In (
	pokemonID INT,
	gymName VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS Badges (
	trainerName VARCHAR(20),
	gymBadge VARCHAR(20),
	PRIMARY KEY(trainerName, gymBadge)
);
