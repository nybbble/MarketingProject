/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Software_project;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author bmetin
 */
public class Brand {
    
    private String brand_id;
    private int product_id;
    private String brand_name;
    
    public static Connection getConnection()
    {
        Connection con = null;
         try {
             //con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SOFTWARE_PRO","bmetin1");
            
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Connection to Database...");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SOFTWARE_PRO","bmetin1");
        }

        catch (Exception ex)
        {
            System.out.println("Exception: " + ex.getMessage() + "");
        
        }
         return con;
    }
    
    public Brand(String brand_id,String brand_name,int product_id)
    {
        //getConnection();
        
        this.brand_id = brand_id;
        this.product_id = product_id;
        this.brand_name = brand_name;
    }
    
    public String getBrandId()
    {
        return brand_id;
    }
    
    public int getProductId()
    {
        return product_id;
    }
    
    public String getBrandName()
    {
        return brand_name;
    }
    
    
    
}
