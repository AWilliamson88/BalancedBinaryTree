package balancedbinarytree;

import java.util.LinkedList;

/**
 *
 * @author Andrew Williamson / P113357 
 * Date: 31/07/2021 
 * Java 3 AT2 Q2 
 * Question 2
 * – You are required to make a mechanical parts list sorted alphabetically. 
 * You need to create a balanced binary search tree for a dictionary of 
 * no less than 10 words. 
 * You must be able to search the list, add and remove from the list.
 */
public class MechanicalPartsList {

    public static void main(String[] args) {

        MPTree partsTree = new MPTree();

        partsTree.add("Screwdriver");
        partsTree.add("Washer");
        partsTree.add("Nuts");
        partsTree.add("Bolts");
        partsTree.add("Rivets");
        partsTree.add("Retaining Rings");
        partsTree.add("Hose Clamps");
        partsTree.add("Cable Ties");
        partsTree.add("Levers");
        partsTree.add("Springs");
        partsTree.add("Bumpers");
        partsTree.add("Mechanical Seal");
        partsTree.add("O-rings");
        partsTree.add("Rotor");

        // Check if the tree is balanced.
        System.out.println(partsTree.isBalanced());

        // Print the list.
        System.out.println(partsTree.display());

        System.out.println();

        // Attempt to find parts.
        System.out.println(partsTree.find("O-rings"));
        System.out.println(partsTree.find("Washer"));
        System.out.println(partsTree.find("Levers"));
        System.out.println(partsTree.find("Rotor"));

        System.out.println();

        System.out.println("Attempting to delete something that isn't in the list.");
        partsTree.delete("David");

        System.out.println();

        // Delete a bunch of items, all from the same side of the tree.
        System.out.println("Deleting 4 Items that are in the list.");
        partsTree.delete("Hose Clamps");
        partsTree.delete("Bumpers");
        partsTree.delete("Bolts");
        partsTree.delete("Mechanical Seal");

        System.out.println();

        // Check if the list is still balanced.
        System.out.println(partsTree.isBalanced());

        System.out.println();

        // Display the list again.
        System.out.println(partsTree.display());

    }

}
