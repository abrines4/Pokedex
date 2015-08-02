# Muqing's SQL data retreival & modification commands, general command and aggregate command

SELECT * FROM Learn;
SELECT COUNT(*) AS Total
FROM Learn;

# modify data
DELETE FROM Learn
WHERE attackName = "Toxic";

SELECT * FROM Learn;
SELECT COUNT(*) AS Total
FROM Learn;

SELECT Appears_In.pokemonID, Weaknesses.weakness 
FROM Weaknesses, Appears_In 
WHERE (Appears_In.gymName = 'Pewter' OR weakness = 'Ice') 
              AND Appears_In.pokemonID = Weaknesses.pokemonID;
