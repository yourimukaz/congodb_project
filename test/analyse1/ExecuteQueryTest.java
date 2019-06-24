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
public class ExecuteQueryTest {
    
    public ExecuteQueryTest() {
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
     * Test of query method, of class ExecuteQuery.
     */
    @Test
    public void testQuery() {
        System.out.println("query");
        String requetteX = "";
        String expResult = "";
        String result = ExecuteQuery.query(requetteX);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decodeurInitial method, of class ExecuteQuery.
     */
    @Test
    public void testDecodeurInitial() {
        System.out.println("decodeurInitial");
        String requette = "";
        int expResult = 0;
        int result = ExecuteQuery.decodeurInitial(requette);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class ExecuteQuery.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        String chaine = "";
        char caractere = ' ';
        int expResult = 0;
        int result = ExecuteQuery.count(chaine, caractere);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
