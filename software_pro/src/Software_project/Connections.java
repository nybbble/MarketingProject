/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Software_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author bmetin
 */
public class Connections {
    
    public static Connection getConnection()
    {
        Connection con = null;
         try {
            
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Connection to Database...");
            con = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SOFTWARE_PRO","bmetin1");
          
            System.out.println("Creating statement");
            Statement stmt = (Statement) con.createStatement();
        }

        catch (Exception ex)
        {
            System.out.println("Exception: " + ex.getMessage() + "");
        
        }
         return con;
    }
    
}
