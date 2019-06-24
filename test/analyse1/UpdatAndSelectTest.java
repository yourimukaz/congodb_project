/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyse1;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adeleste-ciel
 */
public class UpdatAndSelectTest {
    
    public UpdatAndSelectTest() {
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
     * Test of updat method, of class UpdatAndSelect.
     */
    @Test
    public void testUpdat() {
        System.out.println("updat");
        String query = "";
        UpdatAndSelect.updat(query);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of select method, of class UpdatAndSelect.
     */
    @Test
    public void testSelect() {
        System.out.println("select");
        String query = "";
        ArrayList<String> expResult = null;
        ArrayList<String> result = UpdatAndSelect.select(query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
