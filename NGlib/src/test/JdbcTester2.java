// rs1を引数にしてrs2を取り出したい。
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTester2 {
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
	ResultSet rs1;
	ResultSet rs2;
	
	
	System.out.println ("**** Enter class JdbcTester1");
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
      PreparedStatement ps = con.prepareStatement("SELECT br_name FROM brand WHERE id=?;");
      empNo2 = "";
      //**** product_info ****//
      // Execute a query and generate a ResultSet instance
      rs1 = stmt.executeQuery("SELECT * FROM product_info;");
      rs2 = ps.executeQuery();
      System.out.println("**** Created JDBC ResultSet object");

      // Print all of the employee numbers to standard output device
      while (rs1.next()) {
        empNo1 = rs1.getString(2);
        int n = rs1.getInt(3);
        while (rs2.next()) {
        	ps = con.prepareStatement("SELECT br_name FROM brand WHERE id=?;");
        	ps.setInt(1,n);
        	empNo2 = rs2.getString(2);
        }
        empNo3 = rs1.getString(4);
        empNo4 = rs1.getString(5);
        empNo5 = rs1.getString(6);
        empNo6 = rs1.getString(7);
        System.out.println("*************************************************************************************");
        System.out.println("Game Title   = " + empNo1);
        System.out.println("Brand name   = " + empNo2);
        System.out.println("Release Date = " + empNo3);
        System.out.println("series name  = " + empNo4);
        System.out.println("Game Engine  = " + empNo5);
        System.out.println("Comments     = " + empNo6);
      }
      System.out.println("*************************************************************************************");
      System.out.println("**** Fetched all rows from JDBC ResultSet");
      // Close the ResultSet
      rs1.close();
      rs2.close();
      System.out.println("**** Closed JDBC ResultSet");
      
      // Close the Statement
      stmt.close();
      System.out.println("**** Closed JDBC Statement");

      // Connection must be on a unit-of-work boundary to allow close
      con.commit();
      System.out.println ( "**** Transaction committed" );
      
      
      /* *** 6 ***
       * このステートメントにより、アプリケーションがデータ・ソースから切断されます。
       * 『JDBC アプリケーションでのデータ・ソースからの切断』を参照してください。
       * *** 6 ***/
      
      // Close the connection
      con.close();        /*** 6 ***/ 
      System.out.println("**** Disconnected from data source");

      System.out.println("**** JDBC Exit from class JdbcTester1 - no errors");

    }
    
    catch (ClassNotFoundException e)
    {
      System.err.println("Could not load JDBC driver");
      System.out.println("Exception: " + e);
      e.printStackTrace();
    }

    
    /* *** 5 ***
     *  この try/catch ブロックでは、SQL エラー処理用の SQLException クラスの
     * 使用が示されています。
     *  SQL エラーの処理の詳細については、
     * 『IBM® Data Server Driver for JDBC and SQLJ 使用時の SQLException の処理』
     * を参照してください。 
     *  SQL 警告の処理については、
     * 『IBM Data Server Driver for JDBC and SQLJ 使用時の SQLWarning の処理』
     * を参照してください。
     * *** 5 ***/
    
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