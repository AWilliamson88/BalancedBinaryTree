package balancedbinarytree;

import java.util.LinkedList;

/**
 * 
 * @author Andrew Williamson / P113357
 * Date: 31/07/2021
 * Java 3 AT2 Q2
 * Question 2 – You are required to make a mechanical parts list sorted 
 * alphabetically. 
 * You need to create a balanced binary search tree for a dictionary
 * of no less than 10 words. 
 * You must be able to search the list, add and remove from the list.
 */
public class MechanicalPartsList {

    public static void main(String[] args) {
        
        MPTree partsTree = new MPTree("root");
        
        partsTree.add("node1");
        partsTree.add("node2");
        
        
        partsTree.add("node3");
        partsTree.add("node4");
        
        partsTree.add("node5");
        partsTree.add("node6");
        
        partsTree.add("node7");
        
        partsTree.add("node8");
        partsTree.add("node9");
        
        
        boolean isBalanced = partsTree.IsTreeBalanced(partsTree);
        
        
        LinkedList<MPTree> parts = new LinkedList<>();
        
        
        
        
        
        
        
        
    }
    
}
