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
public class Cargo {
    
    private String cargo_Address;
    private int cargo_id;
    private int order_id;
    
    public void Cargo(int cargo_id,String cargo_Address, int order_id)
    {
        this.cargo_Address = cargo_Address;
        this.cargo_id=cargo_id;
        this.order_id=order_id;
    }

   
    public String getCargo_Address() {
        return cargo_Address;
    }

 
    public int getCargo_id() {
        return cargo_id;
    }

    public int getOrder_id() {
        return order_id;
    }
  
    
    
    
}
