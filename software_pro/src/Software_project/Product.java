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
public class Product {
   
/**
 *
 * @author bmetin
 */
    
    private int product_id;
    private String p_name;
    private String type;
    private int price;
    private String e_address;
    private String brand_id;
    private int stock_id;
    private int order_id;
    private int store_id;
    
    /**
     *
     * @return
     */
    public Connection getConnectionP()
    {
        Connection con = null;
         try {
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
    
    public Product(int product_id, String p_name, String type,int price,String e_address,
            String brand_id, int stock_id, int order_id, int store_id)
    {
        this.product_id = product_id;
        this.p_name = p_name;
        this.type = type;
        this.price = price;
        this.e_address = e_address;
        this.brand_id = brand_id;
        this.stock_id = stock_id;
        this.order_id = order_id;
        this.store_id = store_id;
        
    }

   
    public int getProduct_id() {
        return product_id;
    }

 
    public String getP_name() {
        return p_name;
    }

   
    public String getType() {
        return type;
    }

    
    public int getPrice() {
        return price;
    }

    
    public String getE_address() {
        return e_address;
    }

   
    public String getBrand_id() {
        return brand_id;
    }

  
    public int getStock_id() {
        return stock_id;
    }

    
    public int getOrder_id() {
        return order_id;
    }

    
    public int getStore_id() {
        return store_id;
    }
    
}
