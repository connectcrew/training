// リストページの処理の雛型
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTester3 {
  public static void main(String[] args) {

	//**** Define variables ****//
	// for connection
	String urlPrefix = "jdbc:mysql://";
	String url;
	String user;
	String password;
	// for get String
	String empNo1;
	String empNo2;
	String empNo3;
	String empNo4;
	String empNo5;
	String empNo6;
	Connection con;
	Statement stmt;
	ResultSet rs;



	System.out.println ("**** Enter class JdbcTester3");
	// show me your parameter
	System.out.println("url:" + args[0]);
	System.out.println("user:" + args[1]);
	System.out.println("pass:" + args[2]);



    if (args.length!=3)
    {
      System.err.println ("Invalid value. First argument appended to "+
       "jdbc:mysql:// must specify a valid URL.");
      System.err.println ("Second argument must be a valid user ID.");
      System.err.println ("Third argument must be the password for the user ID.");
      System.exit(1);
    }
    url = urlPrefix + args[0];
    user = args[1];
    password = args[2];
    try
    {




      // Load the driver
      Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("**** Loaded the JDBC driver");

      // Create the connection using the IBM Data Server Driver for JDBC and SQLJ
      con = DriverManager.getConnection (url, user, password);
      // Commit changes manually
      con.setAutoCommit(false);
      System.out.println("**** Created a JDBC connection to the data source");




      // Create the Statement
      stmt = con.createStatement();
      System.out.println("**** Created JDBC Statement object");

      //**** product_info ****//
      // Execute a query and generate a ResultSet instance
//     rs = stmt.executeQuery();	// extract from table B by matching id

      System.out.println("**** Created JDBC ResultSet object");

      // Print all of the employee numbers to standard output device
//      while (rs.next()) {
//        empNo1 = rs.getString(1);
//        empNo2 = rs.getString(2);
//        empNo3 = rs.getString(3);
//        empNo4 = rs.getString(4);
//        empNo5 = rs.getString(5);
//        empNo6 = rs.getString(6);
//        System.out.println("*****************************************************************");
//        System.out.println("Game Title   = " + empNo1);
//        System.out.println("Brand name   = " + empNo2);
//        System.out.println("Release Date = " + empNo3);
//        System.out.println("series name  = " + empNo4);
//        System.out.println("Game Engine  = " + empNo5);
//        System.out.println("Comments     = " + empNo6);
//      }
      System.out.println("*****************************************************************");
      System.out.println("**** Fetched all rows from JDBC ResultSet");
      // Close the ResultSet
//      rs.close();
      System.out.println("**** Closed JDBC ResultSet");

      // Close the Statement
      stmt.close();
      System.out.println("**** Closed JDBC Statement");

      // Connection must be on a unit-of-work boundary to allow close
      con.commit();
      System.out.println ( "**** Transaction committed" );



      // Close the connection
      con.close();        /*** 6 ***/
      System.out.println("**** Disconnected from data source");

      System.out.println("**** JDBC Exit from class JdbcTester3 - no errors");

    }

    catch (ClassNotFoundException e)
    {
      System.err.println("Could not load JDBC driver");
      System.out.println("Exception: " + e);
      e.printStackTrace();
    }



    catch(SQLException ex)     /*** 5 ***/
    {
      System.err.println("SQLException information");
      while(ex!=null) {
        System.err.println ("Error msg: " + ex.getMessage());
        System.err.println ("SQLSTATE: " + ex.getSQLState());
        System.err.println ("Error code: " + ex.getErrorCode());
        ex.printStackTrace();
        ex = ex.getNextException(); // For drivers that support chained exceptions
      }
    }
  }  // End main
}    // End EzJava