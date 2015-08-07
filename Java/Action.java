import java.util.*;
import java.sql.*;

public class Action {
	private Statement s;
	
	public Action(Statement conn) {s = conn;}
	
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
    Statement stmt = null;
    String query =
    	"SELECT leaderName " + 
    	"FROM Gym";

    try {
    	Scanner scan = new Scanner(System.in);
    	System.out.println("You can view all attacks used by your disered gym leaders’ pokemons. All gym leaders are listed as follows.");
    	System.out.println("Gym leaders:");
        ResultSet rs = s.executeQuery(query);
        while (rs.next()) {
            String leaderName = rs.getString("leaderName");
            System.out.println(leaderName + "\t");
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
