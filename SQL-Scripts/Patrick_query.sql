/* Query by Yuan-Peng Yu */

/* Show the pokemons and their HP. The po */
SELECT	name, HP 
FROM	PokemonList, Statistics, Weakness
WHERE	( HP<2 AND Speed = 6 AND Weakness= 'Fire')


SELECT	name
FROM	PokemonList, Appears_In
WHERE	gymName=(
				SELECT	gymName 
				FROM	Gym
				WHERE	(leaderName='Brock' AND gymBadge='Boulder')
				);
