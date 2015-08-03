# Muqing's SQL data retreival & modification commands, general command and aggregate command

SELECT Learn.attackName, Attack.attackType FROM Learn, Attack
WHERE Learn.attackName = "Blizzard" and Attack.attackType = "Ice" ;
SELECT COUNT(*) AS Total
FROM Learn;

# modify data
DELETE FROM Learn
WHERE attackName = "Toxic";

SELECT * FROM Learn;
SELECT COUNT(*) AS Total
FROM Learn;

#Ana's queries
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

# Ivins' Queries;
SELECT p.pokemonId, p.pokemonName, p.ability, s.defense, s.attack, s.hp, s.specialAttack, s.specialDefense, t.pokemonType
FROM Pokemon AS p
JOIN Statistics AS s ON p.pokemonID = s.pokemonID 
JOIN PokemonType AS t ON t.pokemonID = p.pokemonID;

SELECT pokemonID, pokemonName, category, ability 
FROM Pokemon
GROUP BY ability, category;

#Ivins' modifications 
Update PokemonType
set pokemonType = 'Shenanigans'
where pokemonType = 'Fairy' ;

INSERT INTO Pokemon (pokemonID, pokemonName, gender, category, evolved, ability) VALUES (386, 'Deoxys', 'U', 'DNA Pokemon', FALSE , 'Pressure');
INSERT INTO PokemonType( pokemonID, PokemonType) VALUES ( 386 , 'Psychic');
INSERT INTO Statistics ( pokemonID, defense, attack, speed, hp, specialAttack, specialDefense ) VALUES (386, 2, 8, 8,2,7,2);
INSERT INTO Weaknesses (pokemonID,weakness) VALUES (386 , 'Bug');
INSERT INTO Weaknesses (pokemonID,weakness) VALUES (386 , 'Ghost');
INSERT INTO Weaknesses (pokemonID,weakness) VALUES (386 , 'Dark');
INSERT INTO Learn (attackName, pokemonName) VALUES ('Rain Dance', 'Deoxys');
INSERT INTO Learn (attackName, pokemonName) VALUES ('Thunder', 'Deoxys');
INSERT INTO Learn (attackName, pokemonName) VALUES ('Solar Beam', 'Deoxys');
INSERT INTO Performs (pokemonID, attackName) VALUES (386, 'Psychic');
INSERT INTO Performs (pokemonID, attackName) VALUES (386, 'Extreme Speed');
INSERT INTO Performs (pokemonID, attackName) VALUES (386, 'Night Shade');

