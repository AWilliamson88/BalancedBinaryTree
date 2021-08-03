package balancedbinarytree;

import java.util.LinkedList;

/**
 *
 * @author Andrew Williamson / P113357 Date: 31/07/2021 Java 3 AT2 Q2 Question 2
 * – You are required to make a mechanical parts list sorted alphabetically. You
 * need to create a balanced binary search tree for a dictionary of no less than
 * 10 words. You must be able to search the list, add and remove from the list.
 */
public class MechanicalPartsList {

    public static void main(String[] args) {

        MPTree partsTree = new MPTree();

        partsTree.add("MAva");
        partsTree.add("Zoe");
        partsTree.add("David");
        partsTree.add("William");
        partsTree.add("Emma");
        partsTree.add("Tiffany");
        partsTree.add("Issac");
        partsTree.add("Michael");
        partsTree.add("Lily");
        partsTree.add("Jill");
        partsTree.add("Oliver");
        partsTree.add("Ethan");
        partsTree.add("Stacey");
        partsTree.add("Becky");

        boolean isBalanced = partsTree.IsTreeBalanced(partsTree);

        //LinkedList<MPTree> parts = new LinkedList<>();
//        System.out.println(partsTree.DisplayRoot());
        System.out.println(partsTree.Display());
        
        System.out.println();
        
        System.out.println(partsTree.Find("Michael"));
        System.out.println(partsTree.Find("Lily"));
        System.out.println(partsTree.Find("Becky"));
        System.out.println(partsTree.Find("Stacey"));
        System.out.println(partsTree.Find("Emma"));
        System.out.println(partsTree.Find("David"));
        System.out.println(partsTree.Find("Tiffany"));
        System.out.println(partsTree.Find("William"));
        System.out.println(partsTree.Find("Ethan"));
        System.out.println(partsTree.Find("Zoe"));
        System.out.println(partsTree.Find("MAva"));
        System.out.println(partsTree.Find("Oliver"));
        System.out.println(partsTree.Find("Jill"));
        System.out.println(partsTree.Find("Issac"));
        
        

    }

}
