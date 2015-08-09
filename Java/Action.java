import java.util.*;
import java.sql.*;

public class Action {
	private Statement s;
	
	public Action(Statement conn) {s = conn;}
/*	
	public void resetDB(){

		// Drop tables & Reupload files.
		try {
			
			try{
				
				// Create a buffereader to read insertSynthetic.sql
				String update = ""; 
				String line = "";
				FileReader fileReader = new FileReader("insertAllRealData.sql");
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				while ((line = bufferedReader.readLine()) != null) {
					
					// Check to make sure new line isn't empty
					if (!line.isEmpty()) {
						

						if(line.charAt(0) != '#') {
							// Append the line to the update string.
							update += line;
						}
						
						// Check to see if everything wasn't all just a comment...
						if(update.charAt(line.length()-1) == '/' && update.charAt(line.length()-2) == '*') {
							update = "";
						} 
						
						// Check to see if instead, line reached the end of a query or update.
						else if(update.charAt(line.length()-1) == ';') {							
							s.executeUpdate(update);		
							// Reset the update string
							update = "";	
						}		
					}
				}
			}

			catch(IOException e) {
				System.err.println ("Error");
			}
			//s.execute("source createTable.sql");
			//s.execute("source insertSynthetic.sql");
		} 
		catch(SQLException e){
			System.err.println ("Error message: " + e.getMessage ());
       		System.err.println ("Error number: " + e.getErrorCode ());
		}
	}
	*/
	public String queryStatistics1(){
    	try{
			System.out.print("\n Look up for the pokemon and show its 'name' and 'hp' attribute.\n" );
			System.out.print(" You can find pokemons who has a specific weakness.\n"); 
			System.out.print("Fire = 1, Water = 2, Ice = 3, Flying = 4, Steel = 5 \n");
			System.out.print("Please enter the value for weakness: ");
			Scanner scan = new Scanner(System.in);
			int weakNUM = scan.nextInt();
			String weakAttr;

			switch(weakNUM){
				case 1:		weakAttr = "Fire";		break;
				case 2:		weakAttr = "Water";		break;
				case 3:		weakAttr = "Ice";		break;
				case 4:		weakAttr = "Flying";		break;
				case 5:		weakAttr = "Steel";		break;				 
				default:	weakAttr = "Fire";	
			}

			System.out.print(" \nThen, you can find the pokemons whose defense value is lower than a value (1~10).\n"); 
			System.out.print("Please enter the value for defense: ");
			Scanner scan1 = new Scanner(System.in);
			int defNUM = scan1.nextInt();
			
			String query =  " SELECT pokemonID, pokemonName, hp " + 
							" FROM Pokemon NATURAL JOIN Statistics AS T1 " + 
							" WHERE defense < " + defNUM + 
							" AND T1.pokemonID IN (SELECT pokemonID " +  
												" FROM Weaknesses " + 
												" WHERE weakness = '"+weakAttr+ "' ) "; 
							

			ResultSet rs1 = s.executeQuery(query);

			// print query result
			int counter =0;
			System.out.print('\n');
			System.out.println( "pokemonID\t pokemonName\t hp\n" );
			while ( rs1.next()) {	
				int 	pID = rs1.getInt("pokemonID");
				String 	pName = rs1.getString("pokemonName");
            	int 	pHP = rs1.getInt("hp");
            	System.out.println( pID + "\t\t" + pName + "\t" + pHP );
			}
			System.out.print('\n');
			return "Successful query for queryStatistics1.";
		}
		catch(SQLException e){
			System.err.println ("Error message: " + e.getMessage ());
       			System.err.println ("Error number: " + e.getErrorCode ());
			return "Unsuccessful queryStatistics1";
		}
	}

	public String queryGym(){
    	try{
			System.out.print("\n Look up for the pokemon that appear in the specific gym.\n" );
			System.out.print("Choices for gyms: Icirrus = 1, Pewter = 2, Dewford = 3 \n");
			System.out.print("Please enter the number for gym: ");
			Scanner scan = new Scanner(System.in);
			int gymNUM = scan.nextInt();
			String gymAttr;

			switch(gymNUM){
				case 1:		gymAttr = "Icirrus";		break;
				case 2:		gymAttr = "Pewter";		break;
				case 3:		gymAttr = "Dewford";		break;		 
				default:	gymAttr = "Icirrus";	
			}
			
			String query =  " SELECT gymName, pokemonID, pokemonName " + 
							" FROM Pokemon AS T1 NATURAL JOIN " + 
								" (SELECT gymName, pokemonID " + 
								" FROM Appears_In NATURAL JOIN Gym " +  
								" WHERE gymName= '"+ gymAttr+ "' ) AS T2 ";

			ResultSet rs2 = s.executeQuery(query);

			// print query result
			int counter =0;
			System.out.print('\n');
			System.out.println( "gymName\t pokemonID\tpokemonName\t \n" );
			while ( rs2.next()) {	
				String 	gName = rs2.getString("gymName");
				int 	pID = rs2.getInt("pokemonID");
				String 	pName = rs2.getString("pokemonName");
            	System.out.println( gName + "\t\t"  + pID + "\t" + pName);
			}
			System.out.print('\n');
			return "Successful query for queryGym.";
		}
		catch(SQLException e){
			System.err.println ("Error message: " + e.getMessage ());
       			System.err.println ("Error number: " + e.getErrorCode ());
			return "Unsuccessful queryGym";
		}
	}
	
	public String multipleOwners() {
		try {

			// Prompt user for number of owners per pokemon.
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter the number of owners you would like per pokemon: ");
			int own = scan.nextInt();

			// Execute the Query
			s.executeQuery("SELECT DISTINCT pokemonName "
				+ "FROM Pokemon p1 "
				+ "WHERE ( "
				+ 	"SELECT COUNT(*) "
				+	"FROM Owns o1 "
				+ 	"WHERE p1.pokemonName = o1.pokemonName) "
				+ ">=" + own + " ORDER BY pokemonName"
				);

			// Print the results. 
			ResultSet result = s.getResultSet();
			int count = 0;
			System.out.print('\n');
			while(result.next()){
				System.out.print(result.getString("pokemonName"));
				if(!result.isLast()) System.out.print(", ");
				count++;
			} 

			// Print the number of results.
			return("\n \n" + (count) + " rows in set!");

		// End of try
		} catch(SQLException e){
			System.err.println ("Error message: " + e.getMessage ());
	       	System.err.println ("Error number: " + e.getErrorCode ());
			return "Unsuccessful query";
		// End of catch
		}
	}
	
	public String trainerType() {	
		try{

			// Provide the user with a list of trainers
			Scanner scan = new Scanner(System.in);
			System.out.print("Here is a list of the trainers known: \n \n");

			// Execute the query output the results of the trainers
			String trainerQuery = ""
			  + "SELECT DISTINCT trainerName "
			  + "FROM Trainer "
			  + "ORDER BY trainerName";
			 s.executeQuery(trainerQuery);
			 ResultSet results = s.getResultSet();

			// output the results of the trainers
			while(results.next()){
				System.out.print(results.getString("trainerName"));
				if(!results.isLast()) System.out.print(", ");
			} System.out.print("\n \n");

			// Prompt the user for which trainer they would like to update
			System.out.print("Which trainer would you like to update: ");
			String trainerChoice = scan.nextLine();

			// Prompt the user for what type they would like to update the trainer as...
			System.out.print("What type of trainer would you like him/her to be: ");
			String trainerType = scan.nextLine();

			// Update the Trainer
			s.executeUpdate("UPDATE Trainer "
			  + "SET trainerType = '" + trainerType + "' "
			  + "WHERE trainerName = '" + trainerChoice + "'");

			// Working example:
			// UPDATE Trainer SET trainerType = 'test' WHERE trainerName = 'Zoey';
			
			return ("\n Update has been made!\n");

		// End of try
		} catch(SQLException e){
			System.err.println("Error message: " + e.getMessage());
			System.err.println("Error number: " + e.getErrorCode());
			return "Unsuccessful Update, possible typo.";
		// End of Catch
		}
	} // End of trainerType
	
	public String queryStatistics(){
    try{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the ID number of the Poekmon you would like to survey: ");
		int pokemonID = scan.nextInt();
		
		s.executeQuery("SELECT * FROM Statistics WHERE "+ pokemonID +" =  pokemonID ");
		return "Successful query。.";
		}
		catch(SQLException e){
			System.err.println ("Error message: " + e.getMessage ());
       			System.err.println ("Error number: " + e.getErrorCode ());
			return "Unsuccessful deletion";
		}
	}
	
	public String deletePokemon(){
		//asks user for pokemon ID for deletion
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the ID number of the Poekmon you would like to delete: ");
		int pokemonID = scan.nextInt();
		try{
		//ddeletes pokemon from all necessary tables
		s.executeUpdate("DELETE FROM Pokemon WHERE "+ pokemonID +" =  pokemonID ");
		s.executeUpdate("DELETE FROM Owns WHERE "+ pokemonID +" =  pokemonID ");
		s.executeUpdate("DELETE FROM Performs WHERE "+ pokemonID +" =  pokemonID ");
		s.executeUpdate("DELETE FROM Appears_In WHERE "+ pokemonID +" =  pokemonID ");
		s.executeUpdate("DELETE FROM PokemonType WHERE "+ pokemonID +" =  pokemonID ");
		s.executeUpdate("DELETE FROM Weaknesses WHERE "+ pokemonID +" =  pokemonID ");
		s.executeUpdate("DELETE FROM Evolution WHERE "+ pokemonID +" =  pokemonID ");
		s.executeUpdate("DELETE FROM Statistics WHERE "+ pokemonID +" =  pokemonID ");
		return "Successful deletion " + pokemonID;
		}
		catch(SQLException e){
		//catches any sql errors
			System.err.println ("Error message: " + e.getMessage ());
       			System.err.println ("Error number: " + e.getErrorCode ());
			return "Unsuccessful deletion " + pokemonID;
		}
	}
	//Delete the specified Attack from the Attack, Performs and Learn Tables.
	public String deleteAttack(){
		//Reads in input from the user.
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the name of the Attack you would like to delete: ");
		String attack = scan.nextLine();
		try{
		System.out.println(attack);
		// Delete the specified attack from the following tables.
		s.executeUpdate("DELETE FROM Attack WHERE '" + attack +"' = attackName");
		s.executeUpdate("DELETE FROM Performs WHERE '" + attack +"' = attackName");
		s.executeUpdate("DELETE FROM Learn WHERE '" + attack +"' = attackName");
		
		return "Successful deletion of attack: " + attack;
		}
		catch(SQLException e){
			//Catch any exceptions thrown from the MySQL Server.
			System.err.println ("Error message: " + e.getMessage ());
			System.err.println ("Error number: " + e.getErrorCode ());
			return "Unsuccessful deletion of attack: " + attack;
		}
	}
    
	public String listAttackOfGLPoke() { // List of all attacks performed by gym leaders’ pokemon
    String leader_Name;
    String attackName;
    String query_leaders =
    	"SELECT leaderName " +
    	"FROM Gym";

    try {
    	System.out.println("You can view all attacks performed by your disered gym leaders’ pokemons. All gym leaders are listed as follows.");
    	System.out.println("Gym leaders:");
        ResultSet rs_leaderName = s.executeQuery(query_leaders);
        while (rs_leaderName.next()) {
            leader_Name = rs_leaderName.getString("leaderName");
            System.out.println(leader_Name + "\t");
        }
        System.out.println("Please enter a gym leader's name:");
        Scanner scan = new Scanner(System.in);
        leader_Name = scan.nextLine();
        ResultSet rs_listAttackOfGLPoke = s.executeQuery(
        "SELECT DISTINCT attackName " + 
        "FROM Performs " +
        "WHERE pokemonID IN ( " +
        	"SELECT pokemonID " +
        	"FROM Owns " +
        	"WHERE trainerName = '" + leader_Name +    // attention to ''. SQL command should be trainerName = 'leader_Name' 
        	"' ) ORDER BY attackName"
        );
        System.out.println("all attacks performed by " + leader_Name + "'s pokemon(s) are listed as follows: ");
        while (rs_listAttackOfGLPoke.next()) {
            attackName = rs_listAttackOfGLPoke.getString("attackName");
            System.out.println(attackName + "\t");
        }

        return "Successful search";
    }
    
	catch(SQLException e){
		System.err.println ("Error message: " + e.getMessage ());
    	System.err.println ("Error number: " + e.getErrorCode ());
		return "Unsuccessful search";
	}
    }
    
    
    public String countAttackOfPoke() {	
        String pokemon_Name;
        int countAttackOfPoke;
              
    try {
    	System.out.println("Please enter a pokemon name: ");
        Scanner scan = new Scanner(System.in);
        pokemon_Name = scan.nextLine();
        ResultSet rs_countAttackOfPoke = s.executeQuery(
        	"SELECT COUNT(DISTINCT Performs.attackName) AS Total_attack_number " +
            "FROM Performs NATURAL JOIN Pokemon " +
            "WHERE Performs.pokemonID = ( " +
        	  "SELECT Pokemon.pokemonID " + 
        	  "FROM Pokemon " +
        	  "WHERE Pokemon.pokemonName = '" + pokemon_Name + "')"
        );
        // The default situation is that cursor is positioned before the first row and then requesting data. we need to move the cursor to the first row. That why we do rs.next(). We can write in the following way as well.
       /*
       rs_countAttackOfPoke.next();
       countAttackOfPoke = rs_countAttackOfPoke.getInt("Total_attack_number");
       System.out.println("The total number of attacks which " + pokemon_Name + " can perform is " + countAttackOfPoke);
       */
        while (rs_countAttackOfPoke.next()) {   
                countAttackOfPoke = rs_countAttackOfPoke.getInt("Total_attack_number");
                System.out.println("The total number of attacks which " + pokemon_Name + " can perform is " + countAttackOfPoke);
            }
        return "Successful search";
    }
    
	catch(SQLException e){
		System.err.println ("Error message: " + e.getMessage ());
    	System.err.println ("Error number: " + e.getErrorCode ());
		return "Unsuccessful search";
	}   
    }
}
