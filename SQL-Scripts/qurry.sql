#Landon
# Lists in order all of the attacks used by gym leaders’ pokemon. 
SELECT DISTINCT attackName
FROM Performs 
WHERE pokemonID IN (
	SELECT pokemonID
	FROM Owns
WHERE trainerName IN (
SELECT trainerName
FROM Trainer
WHERE trainerType = 'Gym Leader') ) ORDER BY attackName;

# Lists all of the Distinct Pokemon owned by multiple trainers
SELECT DISTINCT pokemonName
FROM Pokemon p1
WHERE (
SELECT COUNT(*)
FROM Owns o1
WHERE p1.pokemonName =  o1.pokemonName)
 >= 2 ORDER BY pokemonName;

#Patricks’ Queries:
/* Show the name and hp for the pokemon that has the following characteristics: hp<3, speed=5, and weakness is ground. */
SELECT DISTINCT pokemonName, hp 
FROM Pokemon  NATURAL JOIN Statistics CROSS JOIN Weaknesses
WHERE ( hp<3 AND speed = 5 AND weakness= 'Ground');

/* Find the ID of the pokemon, that have the highest hp in each pokemon type.  */
SELECT pokemonID, MAX(hp), pokemonType
FROM	Statistics NATURAL JOIN PokemonType
GROUP BY pokemonType;

# Masons’ Queries:

# present attack name and pokemon ID which satisfy that this pokemon appears in Pewter.
SELECT Performs.attackName, Performs.pokemonID
FROM Performs, Appears_In
WHERE Appears_In.gymName = 'Pewter' AND Appears_In.pokemonID = Performs.pokemonID;

# count the number of attack which can be learnt by a pokemon whose evolution name is Geodude and previous evolution is egg.
SELECT COUNT(DISTINCT Performs.attackName) AS Total_attack_number
FROM Performs, Evolution
WHERE Performs.pokemonID = (
	  SELECT Evolution.pokemonID
	  FROM Evolution
	  WHERE Evolution.evolutionName = 'Pikachu' and Evolution.previousEvolution = 'Pichu');


# Ivins’ Queries:

# joins 3 tables, and selects a few attributes from it.
SELECT p.pokemonID, p.pokemonName, p.ability, s.defense, s.attack, s.hp, s.specialAttack, s.specialDefense, t.pokemonType
FROM Pokemon AS p
JOIN Statistics AS s ON p.pokemonID = s.pokemonID 
JOIN PokemonType AS t ON t.pokemonID = p.pokemonID;

# groups pokemon based on ability and then by category 
SELECT pokemonID, pokemonName, category, ability 
FROM Pokemon
GROUP BY ability, category;

# Anas’ Queries:
SELECT Appears_In.pokemonID, Weaknesses.weakness
FROM Weaknesses, Appears_In
WHERE (Appears_In.gymName = 'Pewter' OR weakness = 'Ice') 
AND Appears_In.pokemonID = Weaknesses.pokemonID;

SELECT pokemonID
FROM Owns
WHERE trainerName = 'Bailey'
UNION
SELECT pokemonID
FROM Weaknesses
WHERE weakness = 'Fairy';
