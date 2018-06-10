/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Software_project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bmetin
 */
public class CargoTest {
    
    public CargoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void testCargo() {
        System.out.println("Cargo");
        int cargo_id = 0;
        String cargo_Address = "";
        int order_id = 0;
        Cargo instance = new Cargo();
        instance.Cargo(cargo_id, cargo_Address, order_id);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCargo_Address() {
        System.out.println("getCargo_Address");
        Cargo instance = new Cargo();
        String expResult = "";
        String result = instance.getCargo_Address();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCargo_id() {
        System.out.println("getCargo_id");
        Cargo instance = new Cargo();
        int expResult = 0;
        int result = instance.getCargo_id();
        assertEquals(expResult, result);
    
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetOrder_id() {
        System.out.println("getOrder_id");
        Cargo instance = new Cargo();
        int expResult = 0;
        int result = instance.getOrder_id();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
