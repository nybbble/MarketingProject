/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Software_project;

import java.sql.Connection;
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
public class BrandTest {
    
    public BrandTest() {
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
    public void testGetConnection() {
        System.out.println("getConnection");
        Connection expResult = null;
        Connection result = Brand.getConnection();
        assertEquals(expResult, result);
     
        fail("The test case is a prototype.");
    }

    
    @Test
    public void testGetBrandId() {
        System.out.println("getBrandId");
        Brand instance = null;
        String expResult = "";
        String result = instance.getBrandId();
        assertEquals(expResult, result);
   
        fail("The test case is a prototype.");
    }

 
    @Test
    public void testGetProductId() {
        System.out.println("getProductId");
        Brand instance = null;
        int expResult = 0;
        int result = instance.getProductId();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetBrandName() {
        System.out.println("getBrandName");
        Brand instance = null;
        String expResult = "";
        String result = instance.getBrandName();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
