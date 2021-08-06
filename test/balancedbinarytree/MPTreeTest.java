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
    public void partsAdded_AndFound_Correctly() {
        
        MPTree test = new MPTree();
        
        test.add("Screwdriver");
        test.add("Washer");
        test.add("O-rings");
        test.add("Bolts");
        test.add("Rivets");
        
        
        
        String expected = 
        
        assertEquals(message, expected, actual);
        
        String newPart = "";
        MPTree instance = null;
        instance.add(newPart);
    }

    
    /**
     * Test of containsPart method, of class MPTree.
     */
    @Test
    public void partFoundCorrectly() {
        MPTree test = new MPTree();
        
        assertTrue(test.find("Cap Spanner"));
        
        assertTrue(test.find("Spanner"));
        
        assertTrue(test.find("Washer"));
        
        assertTrue(test.find("Screw Driver"));
        
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
