/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balancedbinarytree;

//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;
import org.junit.Test;
import org.junit.*;

/**
 *
 * @author Andrew
 */
public class MPTreeTest {
    
    public MPTreeTest() {
    }

    /**
     * Test of add method, of class MPTree.
     */
    @Test
    public void partsAddedCorrectly() {
        
        
        //System.out.println("add");
        //String newPart = "";
        //MPTree instance = null;
        //instance.add(newPart);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
    /**
     * Test of containsPart method, of class MPTree.
     */
    @Test
    public void partFoundCorrectly() {
        MPTree pt = new MPTree("root");
        
        assertTrue(pt.containsPart("Cap Spanner"));
        
        assertTrue(pt.containsPart("Spanner"));
        
        assertTrue(pt.containsPart("Washer"));
        
        assertTrue(pt.containsPart("Screw Driver"));
        
        //System.out.println("containsPart");
        //String partToSearch = "";
        //MPTree instance = null;
        //boolean expResult = false;
        //boolean result = instance.containsPart(partToSearch);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of FindSum method, of class MPTree.
     */
    @Test
    public void testFindSum() {
        System.out.println("FindSum");
        MPTree root = null;
        MPTree instance = null;
        int expResult = 0;
        int result = instance.FindSum(root);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of IsTreeBalanced method, of class MPTree.
     */
    @Test
    public void testIsTreeBalanced() {
        System.out.println("IsTreeBalanced");
        MPTree root = null;
        MPTree instance = null;
        boolean expResult = false;
        boolean result = instance.IsTreeBalanced(root);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetHeight method, of class MPTree.
     */
    @Test
    public void testGetHeight() {
        System.out.println("GetHeight");
        MPTree node = null;
        MPTree instance = null;
        int expResult = 0;
        int result = instance.GetHeight(node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
