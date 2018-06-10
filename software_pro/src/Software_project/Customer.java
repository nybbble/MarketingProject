/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Software_project;

/**
 *
 * @author bmetin
 */
public class Customer {
    
    private String name;
    private String surname;
    private String e_address;
    private int order_id;
    private int product_id;
    
    public void Customer(String name,String surname, String e_address,int order_id,  int product_id)
    {
        this.name=name;
        this.surname=surname;
        this.e_address=e_address;
        this.order_id=order_id;
        this.product_id=product_id;
    
    }

   
    public String getName() {
        return name;
    }

   
    public String getSurname() {
        return surname;
    }

    public String getE_address() {
        return e_address;
    }

 
    public int getOrder_id() {
        return order_id;
    }

    public int getProduct_id() {
        return product_id;
    }
    
}
