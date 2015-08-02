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
