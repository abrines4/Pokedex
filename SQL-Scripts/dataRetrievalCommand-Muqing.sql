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