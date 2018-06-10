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
public class BuyFrameTest {
    
    public BuyFrameTest() {
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

    /**
     * Test of calculatePrice method, of class BuyFrame.
     */
    @Test
    public void testCalculatePrice() {
        System.out.println("calculatePrice");
        BuyFrame instance = null;
        instance.calculatePrice();
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertCustomerAddress method, of class BuyFrame.
     */
    @Test
    public void testInsertCustomerAddress() {
        System.out.println("insertCustomerAddress");
        BuyFrame instance = null;
        instance.insertCustomerAddress();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class BuyFrame.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        BuyFrame.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
