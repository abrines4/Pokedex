#Update:

# landon*
# Change all of the trainers whose type is ‘Basic’ to ‘Pokemon Trainer’
UPDATE Trainer
SET trainerType = 'Pokemon Trainer' 
WHERE trainerType = 'Basic';


# update pokemonType = ‘Fairy’ to ‘Blood’
UPDATE PokemonType
SET pokemonType = 'Blood'
WHERE pokemonType = 'Fairy' ;

#Delete 
#landon
# Delete all the weak links. Any pokemon that has a 1 for a stats goes.
DELETE FROM Pokemon WHERE pokemonID IN (SELECT pokemonID FROM Statistics WHERE defense=1 OR attack=1 OR speed=1 OR hp=1);
DELETE FROM Owns WHERE pokemonID IN (SELECT pokemonID FROM Statistics WHERE defense=1 OR attack=1 OR speed=1 OR hp=1);
DELETE FROM Performs WHERE pokemonID IN (SELECT pokemonID FROM Statistics WHERE defense=1 OR attack=1 OR speed=1 OR hp=1);
DELETE FROM Appears_In WHERE pokemonID IN (SELECT pokemonID FROM Statistics WHERE defense=1 OR attack=1 OR speed=1 OR hp=1);
DELETE FROM PokemonType WHERE pokemonID IN (SELECT pokemonID FROM Statistics WHERE defense=1 OR attack=1 OR speed=1 OR hp=1);
DELETE FROM Weaknesses WHERE pokemonID IN (SELECT pokemonID FROM Statistics WHERE defense=1 OR attack=1 OR speed=1 OR hp=1);
DELETE FROM Evolution WHERE pokemonID IN (SELECT pokemonID FROM Statistics WHERE defense=1 OR attack=1 OR speed=1 OR hp=1);
DELETE FROM Statistics WHERE defense=1 OR attack=1 OR speed=1 OR hp=1;

# Mason
# delete attack tuples which attack type = poison and power larger than 10
DELETE 
FROM Attack
WHERE attackType = 'Poison' AND attackPower > 10;

# Insertion:
/* Yuan-Peng Yu’s Modification */
/* Insert new trainer */



# Insert new pokemon into respective tables ( Pokemon, PokemonType, Weaknesses, Statistics, Learn, Performs)

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


#
INSERT INTO Trainer VALUES('Yuan-Peng Yu', 'Basic');
INSERT INTO Trainer VALUES('Ana Briones', 'Arena Tycoon');
INSERT INTO Trainer VALUES('Ivins Jove',	'Pokemon Master');
INSERT INTO Trainer VALUES('Landon Prewitt','Sky Trainer');

/* Every trainer has at least one pokemon */
INSERT INTO Owns VALUES('Yuan-Peng Yu',	'Magmar', 126);
INSERT INTO Owns VALUES('Ana Briones', 'Raticate', 20);
INSERT INTO Owns VALUES('Ivins Jove', 'Dragonite',  149);
INSERT INTO Owns VALUES('Landon Prewitt','Skitty', 	300);
