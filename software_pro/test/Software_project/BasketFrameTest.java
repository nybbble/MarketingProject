/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Software_project;

import java.sql.Connection;
import java.util.ArrayList;
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
public class BasketFrameTest {
    
    public BasketFrameTest() {
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
     * Test of executeSQLQuery method, of class BasketFrame.
     */
    @Test
    public void testExecuteSQLQuery() {
        System.out.println("executeSQLQuery");
        String query = "";
        String message = "";
        BasketFrame instance = new BasketFrame();
        instance.executeSQLQuery(query, message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSum method, of class BasketFrame.
     */
    @Test
    public void testGetSum() {
        System.out.println("getSum");
        //int rowsCount = 0;
        int rowsCount2 = -1;
        BasketFrame instance = new BasketFrame();
        //int expResult = 0;
        int expResult2 = -1;
        //int result = instance.getSum(rowsCount);
        int result2 = instance.getSum(rowsCount2);
        //assertEquals(expResult, result);
        assertEquals(expResult2, result2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConnection method, of class BasketFrame.
     */
    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        Connection expResult = null;
        Connection result = BasketFrame.getConnection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addBasket method, of class BasketFrame.
     */
    @Test
    public void testAddBasket() {
        System.out.println("addBasket");
        String searchQuery = "";
        BasketFrame instance = new BasketFrame();
        instance.addBasket(searchQuery);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of viewBasket method, of class BasketFrame.
     */
    @Test
    public void testViewBasket() {
        System.out.println("viewBasket");
        String searchQuery = "";
        BasketFrame instance = new BasketFrame();
        ArrayList<Basket> expResult = null;
        ArrayList<Basket> result = instance.viewBasket(searchQuery);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findBasket method, of class BasketFrame.
     */
    @Test
    public void testFindBasket() {
        System.out.println("findBasket");
        String query = "";
        BasketFrame instance = new BasketFrame();
        instance.findBasket(query);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteBasket method, of class BasketFrame.
     */
    @Test
    public void testDeleteBasket() {
        System.out.println("deleteBasket");
        String searchQuery = "";
        BasketFrame instance = new BasketFrame();
        ArrayList<Basket> expResult = null;
        ArrayList<Basket> result = instance.deleteBasket(searchQuery);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findBasket_delete method, of class BasketFrame.
     */
    @Test
    public void testFindBasket_delete() {
        System.out.println("findBasket_delete");
        String query = "";
        BasketFrame instance = new BasketFrame();
        instance.findBasket_delete(query);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class BasketFrame.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        BasketFrame.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
