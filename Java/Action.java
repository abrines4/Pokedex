import java.util.*;
import java.sql.*;

public class Action {
	private Statement s;
	
	public Action(Statement conn) {s = conn;}
	
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
        "FROM Performs" +
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
