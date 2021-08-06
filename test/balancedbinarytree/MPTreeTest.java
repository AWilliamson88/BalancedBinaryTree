/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balancedbinarytree;

//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Andrew
 */
public class MPTreeTest {

    public MPTreeTest() {
    }

    /**
     * Test of add and find methods, of class MPTree.
     */
    @Test
    public void partsAdded_AndFound_Correctly() {

        MPTree test = new MPTree();

        test.add("Screwdriver");
        test.add("Washer");
        test.add("O-rings");

        String expected = "Screwdriver was found in the list.";
        String actual = test.find("Screwdriver");
        assertEquals("Screwdriver not found", expected, actual);

        expected = "Washer was found in the list.";
        actual = test.find("Washer");
        assertEquals("Washer not found", expected, actual);

        expected = "O-rings was found in the list.";
        actual = test.find("O-rings");
        assertEquals("O-rings not found", expected, actual);

        expected = "screwdriver was found in the list.";
        actual = test.find("screwdriver");
        assertEquals("screwdriver not found", expected, actual);

        expected = "washer was found in the list.";
        actual = test.find("washer");
        assertEquals("Washer not found", expected, actual);

    }

    /**
     * Test if Items in the list are deleted correctly.
     */
    @Test
    public void ItemsDeletedCorrectly() {

        MPTree test = new MPTree();

        test.add("Screwdriver");
        test.add("Washer");
        test.add("O-rings");

        test.delete("Screwdriver");
        String expected = "Screwdriver was not found in the list.";
        String actual = test.find("Screwdriver");
        assertEquals("Screwdriver was found", expected, actual);

        test.delete("Washer");
        expected = "Washer was not found in the list.";
        actual = test.find("Washer");
        assertEquals("Washer was found", expected, actual);

        test.delete("O-rings");
        expected = "O-rings was not found in the list.";
        actual = test.find("O-rings");
        assertEquals("O-rings was found", expected, actual);
    }

    /**
     * Test balancing methods work correctly.
     */
    @Test
    public void TreeMaintainsBalance() {

        MPTree test = new MPTree();

        test.add("Screwdriver");
        test.add("Washer");
        test.add("O-rings");
        test.add("Nuts");

        String treeIsBalanced = "The Binary Tree is Balanced.";

        String balanceTest = test.isBalanced();
        assertEquals("The Tree is Unbalanced.", treeIsBalanced, balanceTest);

        test.add("Bolts");
        test.add("Rivets");
        test.add("Retaining Rings");
        test.add("Hose Clamps");

        balanceTest = test.isBalanced();
        assertEquals("The Tree is Unbalanced.", treeIsBalanced, balanceTest);

        test.add("Cable Ties");
        test.add("Levers");
        test.add("Springs");
        test.add("Bumpers");
        test.add("Mechanical Seal");
        test.add("Rotor");

        balanceTest = test.isBalanced();
        assertEquals("The Tree is Unbalanced.", treeIsBalanced, balanceTest);

        test.delete("Screwdriver");
        test.delete("Washer");
        test.delete("O-rings");
        test.delete("Hose Clamps");
        test.delete("Bumpers");
        test.delete("Bolts");
        test.delete("Mechanical Seal");

        balanceTest = test.isBalanced();
        assertEquals("The Tree is Unbalanced.", treeIsBalanced, balanceTest);

    }

}
