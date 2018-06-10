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
public class Basket {
    
    private String product_name;
    private String brand_id;
    private int price;
    private int id;
    
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
    
    public Basket(String product_name,String brand_id,int price,int id)
    {
        //getConnection();
        
        this.brand_id = brand_id;
        this.product_name = product_name;
        this.price = price;
        this.id=id;
    }

    public String getProduct_name() {
        return product_name;
    }
    
    
    public int getId() {
        return id;
    }

    public String getBrand_id() {
        return brand_id;
    }

    public int getPrice() {
        return price;
    }
    
}
