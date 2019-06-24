/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyse1;

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
public class CreateTest {
    
    public CreateTest() {
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
     * Test of CreateDataBaseOrTable method, of class Create.
     */
    @Test
    public void testCreateDataBaseOrTable() {
        System.out.println("CreateDataBaseOrTable");
        String requette1 = "";
        String expResult = "";
        String result = Create.CreateDataBaseOrTable(requette1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dropDataBaseOrTable method, of class Create.
     */
    @Test
    public void testDropDataBaseOrTable() {
        System.out.println("dropDataBaseOrTable");
        String requette = "";
        String expResult = "";
        String result = Create.dropDataBaseOrTable(requette);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
