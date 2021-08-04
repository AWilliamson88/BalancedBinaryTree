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
        System.out.println(partsTree.display());
        
        System.out.println();
        
        System.out.println(partsTree.find("Michael"));
        System.out.println(partsTree.find("Lily"));
        System.out.println(partsTree.find("Becky"));
        System.out.println(partsTree.find("Stacey"));
        System.out.println(partsTree.find("Emma"));
        System.out.println(partsTree.find("David"));
        System.out.println(partsTree.find("Tiffany"));
        System.out.println(partsTree.find("William"));
        System.out.println(partsTree.find("Ethan"));
        System.out.println(partsTree.find("Zoe"));
        System.out.println(partsTree.find("MAva"));
        System.out.println(partsTree.find("Oliver"));
        System.out.println(partsTree.find("Jill"));
        System.out.println(partsTree.find("Issac"));
        
        

    }

}
