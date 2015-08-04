
DELETE from Appears_In;
DELETE from Attack;
DELETE from Badges;
DELETE from Evolution;
DELETE from Gym;
DELETE from Learn;
DELETE from Owns;
DELETE from Performs;
DELETE from Pokemon;
DELETE from PokemonType;
DELETE from Statistics;
DELETE from Trainer;
DELETE from Weaknesses; 

# load data using insert commands 

tee synthetic_queryLog.txt;

INSERT INTO Trainer VALUES('Bailey', 'Grass Trainer');
INSERT INTO Trainer VALUES('Brawly', 'Gym Leader');
INSERT INTO Trainer VALUES('Brock', 'Gym Leader');
INSERT INTO Trainer VALUES('Brycen', 'Gym Leader');
INSERT INTO Trainer VALUES('Aldith', 'Team Plasma');

INSERT INTO Owns VALUES('Bailey', 'Vileplum', 45);
INSERT INTO Owns VALUES('Brawly', 'Machop', 66);
INSERT INTO Owns VALUES('Brock', 'Geodude', 74);
INSERT INTO Owns VALUES('Brock', 'Onix', 95);
INSERT INTO Owns VALUES('Brycen', 'Cryogonal', 615);
INSERT INTO Owns VALUES('Aldith', 'Weavile', 461);

INSERT INTO Badges VALUES('Brawly', 'Knuckle');
INSERT INTO Badges VALUES('Brock', 'Boulder');
INSERT INTO Badges VALUES('Brycen', 'Freeze');

INSERT INTO Pokemon VALUES (45,'Vileplume','B','Flower',TRUE,'Chlorophyll');
INSERT INTO Pokemon VALUES (66,'Machop','B','Superpower',FALSE,'Guts');
INSERT INTO Pokemon VALUES (74,'Geodude','B','Rock',FALSE,'Rock Head');
INSERT INTO Pokemon VALUES (95,'Onix','B','Rock Snake',FALSE,'Rock Head');
INSERT INTO Pokemon VALUES (105,'Marowak','B','Bone Kepper',TRUE,'Rock Head');
INSERT INTO Pokemon VALUES (461,'Weavile','B','Sharp Claw',TRUE,'Pressure');
INSERT INTO Pokemon VALUES (615,'Cryogonal','U','Crystallizing',FALSE,'Levitate');

INSERT INTO PokemonType VALUES (45,'Grass');
INSERT INTO PokemonType VALUES (45,'Poison');
INSERT INTO PokemonType VALUES (66,'Fighting');
INSERT INTO PokemonType VALUES (74,'Rock');
INSERT INTO PokemonType VALUES (74,'Ground');
INSERT INTO PokemonType VALUES (95,'Rock');
INSERT INTO PokemonType VALUES (95,'Ground');
INSERT INTO PokemonType VALUES (461,'Dark');
INSERT INTO PokemonType VALUES (461,'Ice');
INSERT INTO PokemonType VALUES (615,'Ice');

INSERT INTO Statistics VALUES(45,3,4,4,5,4,3);
INSERT INTO Statistics VALUES(66,3,4,2,2,2,2);
INSERT INTO Statistics VALUES(74,2,4,4,1,1,1);
INSERT INTO Statistics VALUES(95,2,2,7,1,2,4);
INSERT INTO Statistics VALUES(105,3,4,5,2,3,3);
INSERT INTO Statistics VALUES(461,3,6,3,2,4,7);
INSERT INTO Statistics VALUES(615,3,3,2,5,6,6);

INSERT INTO Weaknesses VALUES(45,'Fire');
INSERT INTO Weaknesses VALUES(45,'Flying');
INSERT INTO Weaknesses VALUES(45,'Ice');
INSERT INTO Weaknesses VALUES(45,'Psychic');
INSERT INTO Weaknesses VALUES(66,'Fairy');
INSERT INTO Weaknesses VALUES(66,'Flying');
INSERT INTO Weaknesses VALUES(66,'Psychic');
INSERT INTO Weaknesses VALUES(74,'Fighting');
INSERT INTO Weaknesses VALUES(74,'Grass');
INSERT INTO Weaknesses VALUES(74,'Ground');
INSERT INTO Weaknesses VALUES(74,'Ice');
INSERT INTO Weaknesses VALUES(74,'Steel');
INSERT INTO Weaknesses VALUES(74,'Water');

INSERT INTO Weaknesses VALUES(95,'Fighting');
INSERT INTO Weaknesses VALUES(95,'Grass');
INSERT INTO Weaknesses VALUES(95,'Ground');
INSERT INTO Weaknesses VALUES(95,'Ice');
INSERT INTO Weaknesses VALUES(95,'Steel');
INSERT INTO Weaknesses VALUES(95,'Water');
INSERT INTO Weaknesses VALUES(105,'Grass');
INSERT INTO Weaknesses VALUES(105,'Ice');
INSERT INTO Weaknesses VALUES(105,'Water');
INSERT INTO Weaknesses VALUES(461,'Fighting');
INSERT INTO Weaknesses VALUES(461,'Bug');
INSERT INTO Weaknesses VALUES(461,'Fire');
INSERT INTO Weaknesses VALUES(461,'Rock');
INSERT INTO Weaknesses VALUES(461,'Steel');
INSERT INTO Weaknesses VALUES(461,'Fairy');
INSERT INTO Weaknesses VALUES(615,'Fire');
INSERT INTO Weaknesses VALUES(615,'Fighting');
INSERT INTO Weaknesses VALUES(615,'Rock');
INSERT INTO Weaknesses VALUES(615,'Steel');

INSERT INTO Evolution VALUES(45,'Vileplume',NULL,NULL,'Gloom',NULL);
INSERT INTO Evolution VALUES(66,'Machop',28,'Normal','Egg','Machoke');
INSERT INTO Evolution VALUES(74,'Geodude',25,'Normal','Egg','Graveler');
INSERT INTO Evolution VALUES(95,'Onix',NULL,'Trade holding Metal Coat','Egg','Steelix');
INSERT INTO Evolution VALUES(461,'Weavile',NULL,NULL,'Sneasel',NULL);
INSERT INTO Evolution VALUES(615,'Cryogonal',NULL,NULL,'Egg',NULL);

INSERT INTO Attack VALUES('Toxic',0,'Poison');
INSERT INTO Attack VALUES('Bulk Up',0,'Fighting');
INSERT INTO Attack VALUES('Hidden Power',60,'Normal');
INSERT INTO Attack VALUES('Psyshock',80,'Psychic');
INSERT INTO Attack VALUES('Thief',60,'Dark');
INSERT INTO Attack VALUES('Blizzard',110,'Ice');

INSERT INTO Learn VALUES('Toxic','Vileplume');
INSERT INTO Learn VALUES('Bulk Up','Machop');
INSERT INTO Learn VALUES('Hidden Power','Geodude');
INSERT INTO Learn VALUES('Psyshock','Onix');
INSERT INTO Learn VALUES('Thief','Weavile');
INSERT INTO Learn VALUES('Blizzard','Cryogonal');

INSERT INTO Gym VALUES('Dewford','Brawly','Knuckle','Fighting');
INSERT INTO Gym VALUES('Pewter','Brock','Boulder','Rock');
INSERT INTO Gym VALUES('Icirrus','Brycen','Freeze','Ice');

INSERT INTO Performs VALUES(45,'Aromatherapy');
INSERT INTO Performs VALUES(66,'Bulk Up');
INSERT INTO Performs VALUES(74,'Bulldoze');
INSERT INTO Performs VALUES(95,'Confusion');
INSERT INTO Performs VALUES(461,'Scratch');
INSERT INTO Performs VALUES(615,'Solar Beam');


INSERT INTO Appears_In VALUES(45,'Celadon');
INSERT INTO Appears_In VALUES(66,'Cianwood');
INSERT INTO Appears_In VALUES(74,'Pewter');
INSERT INTO Appears_In VALUES(95,'Cyllage');
INSERT INTO Appears_In VALUES(461,'Icirrus');
INSERT INTO Appears_In VALUES(615,'Snowbelle');


source ../SQL-Scripts/qurry.sql;
