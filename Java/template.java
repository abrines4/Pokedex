// Landon, Patrick, Ivan, Ana, Mason CSCE 310 

import java.sql.*;

   public class test
   {
       public static void main (String[] args)
       {
           Connection conn = null;

           try
           {
               String userName = "CSNetid";
               String password = "CSNetpw";
               String url = "jdbc:mysql://database2.cs.tamu.edu/DB_name";
               Class.forName ("com.mysql.jdbc.Driver").newInstance ();
               conn = DriverManager.getConnection (url, userName, password);
               System.out.println ("Database connection established");
           }
           catch (Exception e)
           {
               System.err.println ("Cannot connect to database server");
           }
           finally
           {
               if (conn != null)
               {
                   try
                   {
                       conn.close ();
                       System.out.println ("Database connection terminated");
                   }
                   catch (Exception e) { /* ignore close errors */ }
               }
           }
       } // End of main
   }
