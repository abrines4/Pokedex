import java.util.*;
import java.sql.*;

public class Action {
	private Statement s;
	
	public Action(Statement conn) {s = conn;}
	
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
			  +	"SELECT DISTINCT trainerName "
			  + "FROM Trainer";
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
			  + "SET trainerType = " + trainerType + " "
			  + "WHERE trainerName = " + trainerChoice);

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
    
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the ID number of the Poekmon you would like to delete: ");
		int pokemonID = scan.nextInt();
		try{
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
			System.err.println ("Error message: " + e.getMessage ());
       			System.err.println ("Error number: " + e.getErrorCode ());
			return "Unsuccessful deletion " + pokemonID;
		}
	}

		public String deleteAttack(){
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the name of the Attack you would like to delete: ");
		String attack = scan.nextLine();
		try{
		System.out.println(attack);
		s.executeUpdate("DELETE FROM Attack WHERE '" + attack +"' = attackName");
		s.executeUpdate("DELETE FROM Performs WHERE '" + attack +"' = attackName");
		s.executeUpdate("DELETE FROM Learn WHERE '" + attack +"' = attackName");
		
		return "Successful deletion of attack: " + attack;
		}
		catch(SQLException e){
			System.err.println ("Error message: " + e.getMessage ());
			System.err.println ("Error number: " + e.getErrorCode ());
			return "Unsuccessful deletion of attack: " + attack;
		}
	}
    
	public String listAttackOfGLPoke() { // List of all attacks used by gym leaders’ pokemon
    String leader_Name;
    String query_leaders =
    	"SELECT " + leader_Name +
    	"FROM Gym";
    String query_listAttackOfGLPoke = 
        "SELECT DISTINCT attackName " + 
        "FROM Performs " +
        "WHERE pokemonID IN ( " +
        	"SELECT pokemonID " +
        	"FROM Owns " +
        	"WHERE trainerName = " + leader_Name +
        	" ) ORDER BY attackName"
           
    try {
    	System.out.println("You can view all attacks used by your disered gym leaders’ pokemons. All gym leaders are listed as follows.");
    	System.out.println("Gym leaders:");
        ResultSet rs_leaderName = s.executeQuery(query);
        while (rs.next()) {
            String leader_Name = rs.getString("leaderName");
            System.out.println(leader_Name + "\t");
        }
        System.out.println("Please enter a gym leader's name:");
        Scanner scan = new Scanner(System.in);
        leader_Name = scan.nextLine();
        ResultSet rs_listAttackOfGLPoke = s.executeQuery(query_listAttackOfGLPoke);
        while (rs.next()) {
            String attackName = rs.getString("attackName");
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
    	"SELECT COUNT(DISTINCT Performs.attackName) AS Total_attack_number
        FROM Performs, Evolution
        WHERE Performs.pokemonID = (
        	  SELECT Evolution.pokemonID
        	  FROM Evolution
        	  WHERE Evolution.evolutionName = 'Pikachu' and Evolution.previousEvolution = 'Pichu');"
        String leader_Name;
    String query_leaders =
    	"SELECT " + leader_Name +
    	"FROM Gym";
    String query_listAttackOfGLPoke = 
        "SELECT DISTINCT attackName " + 
        "FROM Performs " +
        "WHERE pokemonID IN ( " +
        	"SELECT pokemonID " +
        	"FROM Owns " +
        	"WHERE trainerName = " + leader_Name +
        	" ) ORDER BY attackName"
           
    try {
    	System.out.println("You can view all attacks used by your disered gym leaders’ pokemons. All gym leaders are listed as follows.");
    	System.out.println("Gym leaders:");
        ResultSet rs_leaderName = s.executeQuery(query);
        while (rs.next()) {
            String leader_Name = rs.getString("leaderName");
            System.out.println(leader_Name + "\t");
        }
        System.out.println("Please enter a gym leader's name:");
        Scanner scan = new Scanner(System.in);
        leader_Name = scan.nextLine();
        ResultSet rs_listAttackOfGLPoke = s.executeQuery(query_listAttackOfGLPoke);
        while (rs.next()) {
            String attackName = rs.getString("attackName");
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

    /*
   s.executeQuery ("SELECT id, name, category FROM animal");
   ResultSet rs = s.getResultSet ();
   int count = 0;
   while (rs.next ())
   {
       int idVal = rs.getInt ("id");
       String nameVal = rs.getString ("name");
       String catVal = rs.getString ("category");
       System.out.println (
               "id = " + idVal
               + ", name = " + nameVal
               + ", category = " + catVal);
       ++count;
   }
   rs.close ();
   s.close ();
   System.out.println (count + " rows were retrieved");	
   */	

}
