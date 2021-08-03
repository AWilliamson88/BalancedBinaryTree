package balancedbinarytree;

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

public class MPTree {

    private Part root;

    // Constructor that accepts an integer for the value of the node.
    public MPTree(String newPart) {
        Part part = new Part(newPart);
        root = part;
    }
    
    // Public method to make sure the addPart() always starts at the root.
    public void add(String newPart) {
        addPart(root, newPart);
    }
    
    // Add the new part into the tree if it's not there already.
    private Part addPart(Part current, String newPart) {
        if (current == null){
            return new Part(newPart);
        }
        
        if (newPart.compareToIgnoreCase(current.name) < 0) {
            // Part comes before the current part, go to the left.
            current.left = addPart(current.left, newPart);
        } else if(newPart.compareToIgnoreCase(current.name) > 0) {
            // Part comes after the current part, go to the right.
            current.right = addPart(current.right, newPart);
        } else {
            // Part already exists.
            return current;
        }
        
        return current;
    }
    
    public boolean containsPart(String partToSearch) {
        return searchForPart(root, partToSearch);
    }
    
    private boolean searchForPart(Part current, String partToSearch) {
        if (current == null) {
            return false;
        }
        
        if(partToSearch.compareToIgnoreCase(current.name) > 0) {
            return searchForPart(current.right, partToSearch);
        } if (partToSearch.compareToIgnoreCase(current.name) < 0) {
            searchForPart(current.left, partToSearch);
        }
        // the current one is the one your looking for.
            return true;
        
        
    }

    public Part delete(String partName){
        deletePart(root, partName);
    }

    private Part deletePart(Part current, String partName) {
        if (current == null) {
        return null;
    }
        
        if (partName.compareToIgnoreCase(current.name) == 0) {
            // Node to delete found
            // ... code to delete the node will go here
            
            // Null if there are no children.
            if (current.left == null && current.right == null) {
                return null;
            }
            
            // If one is null return the other.
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }
            
            
            
            
        } 
        
        if (partName.compareToIgnoreCase(current.name) < 0) {
            current.left = deletePart(current.left, partName);
            return current;
        } else {
        current.right = deletePart(current.right, partName);
        }
        
        return current;
        
    }


    
    // Method to find the total value of all the nodes in the tree.
    // Assuming all the node values are integers.
    public int FindSum(MPTree root) {

        if (root == null) {
            return 0;
        } else {
            return 0;
            //return root.getValue() + FindSum(root.getLeft()) +
            // FindSum(root.getRight());
        }
    }

    
    public boolean IsTreeBalanced(MPTree root){
        if (root == null){
            return true;
        }
        return (GetHeight(root) >= 1);
    }
    
    public int GetHeight(MPTree node) {
        
        // If the tree is empty then return 0
        if (node == null){
            return 0;
        }
        
        // Get the height of the left and right trees
        //int leftHeight = GetHeight(node.getLeft());
        //int rightHeight = GetHeight(node.getRight());
        
        // If the left or right tree's heights are less than 0 or
        // the left tree height minus the right tree height is greater than 1
        // return -1 indecating the tree is unbalanced.
        /*
        if (leftHeight < 0 || 
                rightHeight < 0 || 
                Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        
        // Return the higher number plus 1.
        return Math.max(leftHeight, rightHeight) + 1;
        */
        // delete this.
        return 0;
    }
    
    
    
    /**
     * Inner class for the part node's details.
     */
    class Part{
        String name;
        Part left;
        Part right;
        
        // Constructor that accepts a String for the value of the node.
    Part(String newPart) {
        name = newPart;
        left = null;
        right = null;
    }
        
    }

}
