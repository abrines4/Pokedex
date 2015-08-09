import java.util.*;
import java.lang.Exception;
import java.sql.*;

public class Menu{
	
	public static void main(String[] args){
		try{
		Connection conn = null;
		//connection will be made
		String userName = "mqzhou";
		String password = "920122";
		String url = "jdbc:mysql://database2.cs.tamu.edu/mqzhou-pokemon";
		Class.forName ("com.mysql.jdbc.Driver").newInstance ();
		conn = DriverManager.getConnection (url, userName, password);
		Statement s = conn.createStatement();
		
		Action action = new Action(s);
		
		//clear all tables and insert fresh info
		//action.resetDB();
		
		while(true){
			try{
			System.out.print("\n1:  Look up a Pokemon based on Statistics\n");
			System.out.print("2:  Look up Pokemon that appear in any gym\n");
			System.out.print("3:  Look up popular Pokemon (pokemon owned by more than one Trainer)\n");
			System.out.print("4:  Look up all the attacks a Gym Leader's Pokemon can perform\n");
			System.out.print("5:  Count how many attacks a Pokemon can perform\n");
			System.out.print("6:  Update a Trainer's type\n");
			System.out.print("7:  Update a Pokemon's statistics\n");
			System.out.print("8:  Delete a Pokemon\n");
			System.out.print("9:  Delete an attack\n");
			System.out.print("10: Quit\n");
			System.out.print("Choose one of the above options: ");
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			switch(choice){
				case 1: 
					//Call Patrick's selection
					break;
				case 2:
					//Call Patrick's selection
					break;
				case 3:
					//Call Landon's selection ( Pokemon with multiple owners )
					System.out.println(action.multipleOwners());
					break;
				case 4:
					//Call Mason's selection
				    //Action.listAttackOfGLPoke;
					String result_4 = action.listAttackOfGLPoke();
					System.out.println(result_4);	
					break;
				case 5:
					//Call Mason's count
				    String result_5 = action.countAttackOfPoke();
					System.out.println(result_5);	
					break;
				case 6:
					//Call Landon's update (Update trainerType)
					System.out.println(action.trainerType());
					break;
				case 7:
					//Call Landon's update
					break;
				case 8:
					//Call Ana's deletion
					String result = action.deletePokemon();
					System.out.println(result);	
					break;
				case 9:
					//Call Ivin's deletion
					result = action.deleteAttack();
					System.out.println(result);
					break;
				case 10:
					//Call quit
					//close connection
					conn.close();
					System.exit(0);
					break;
				default:
					System.out.print("Invalid choice.\n");
					break;
			}
			}
			catch(Exception i){
				System.out.print("Invalid choice.\n");
			}
		}
		}
		catch(SQLException e) {
			System.err.println ("Error message: " + e.getMessage ());
			System.err.println ("Error number: " + e.getErrorCode ());
			System.exit(-1);
		}
		catch(Exception e) {
			System.err.println("Unknown error");
			System.exit(-2);
		}
	}
}
