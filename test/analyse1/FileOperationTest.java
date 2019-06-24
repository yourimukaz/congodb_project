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
public class FileOperationTest {
    
    public FileOperationTest() {
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
     * Test of lire method, of class FileOperation.
     */
    @Test
    public void testLire() {
        System.out.println("lire");
        String fichier = "";
        ArrayList<String> expResult = null;
        ArrayList<String> result = FileOperation.lire(fichier);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ecrire method, of class FileOperation.
     */
    @Test
    public void testEcrire() {
        System.out.println("ecrire");
        ArrayList<String> Words = null;
        String namefile = "";
        FileOperation.ecrire(Words, namefile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteFile method, of class FileOperation.
     */
    @Test
    public void testDeleteFile() {
        System.out.println("deleteFile");
        String file = "";
        FileOperation.deleteFile(file);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
