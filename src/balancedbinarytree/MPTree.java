package balancedbinarytree;

/**
 *
 * @author Andrew Williamson / P113357 Date: 31/07/2021 Java 3 AT2 Q2 Question 2
 * – You are required to make a mechanical parts list sorted alphabetically. You
 * need to create a balanced binary search tree for a dictionary of no less than
 * 10 words. You must be able to search the list, add and remove from the list.
 */
public class MPTree {

    private Part root;

    // Default constructor.
    public MPTree() {
    }

    // Public method to make sure the addPart() always starts at the root.
    public void add(String partName) {

        Part part = new Part(partName);

        if (root == null) {
            root = part;
        } else {
            addRecursive(root, part);
        }
    }

    // Add the new part into the tree if it's not there already.
    private Part addRecursive(Part current, Part newPart) {

        if (current == null) {
            current = newPart;
            return current;
        }

        if (newPart.name.compareToIgnoreCase(current.name) < 0) {
            // Part comes before the current part, go to the left.
            current.left = addRecursive(current.left, newPart);

            current = balanceTree(current);
        } else if (newPart.name.compareToIgnoreCase(current.name) > 0) {
            // Part comes after the current part, go to the right.
            current.right = addRecursive(current.right, newPart);

            current = balanceTree(current);
        }
        return current;
    }

    public String find(String partToSearch) {

        String s = partToSearch + " was "
                + searchForPart(root, partToSearch) + " in the list.";
        return s;
    }

    private String searchForPart(Part current, String partToSearch) {
        if (current == null) {
            return "not found";
        }

        if (partToSearch.compareToIgnoreCase(current.name) > 0) {
            return searchForPart(current.right, partToSearch);

        }
        if (partToSearch.compareToIgnoreCase(current.name) < 0) {
            return searchForPart(current.left, partToSearch);
        }

        // the current one is the one your looking for.
        return "found";
    }

    // Returns a string with the root and the left and right trees.
    public String display() {

        if (root == null) {
            return "There are no parts.";
        }
        String displayString = displayRoot()
                + "\nLEFT TREE: " + displayTree(root.left)
                + "\nRIGHT TREE: " + displayTree(root.right)
                + "\n left " + getHeight(root.left)
                + "\n right " + getHeight(root.right);

        return displayString;
    }

    // Returns the values of the nodes in a tree.
    // Called by the Display().
    private String displayTree(Part current) {

        String s = "";
        if (current != null) {

            s += current.name + ", ";
            s += displayTree(current.left);
            s += displayTree(current.right);

        }
        return s;
    }

    // Returns a string with the root.
    // Called by the Display().
    private String displayRoot() {

        if (root == null) {
            return "There is no root value.";
        }
        String a = "The root is: " + root.name;
        return a;
    }

    public void delete(String partName) {
        root = deletePart(root, partName);
    }

    private Part deletePart(Part current, String partName) {

        Part parent;
        if (current == null) {
            return current;
        } else {

            if (partName.compareToIgnoreCase(current.name) < 0) {

                current.left = deletePart(current.left, partName);

                if (balanceFactor(current) == -2) {

                    if (balanceFactor(current.right) <= 0) {

                        current = rotateRR(current);

                    } else {

                        current = rotateRL(current);
                    }
                }
            } else if (partName.compareToIgnoreCase(current.name) > 0) {

                current.right = deletePart(current.right, partName);
                if (balanceFactor(current) == 2) {

                    if (balanceFactor(current.left) >= 0) {

                        current = rotateLL(current);

                    } else {

                        current = rotateLR(current);
                    }
                }
                
            } else {

                if (current.right != null) {

                    parent = current.right;

                    while (parent.left != null) {
                        parent = parent.left;
                    }

                    current.name = parent.name;
                    current.right = deletePart(current.right, parent.name);

                    if (balanceFactor(current) == 2) {

                        if (balanceFactor(current.left) >= 0) {

                            current = rotateLL(current);

                        } else {

                            current = rotateLR(current);
                        }
                    }

                } else {

                    return current.left;
                }
            }
        }
        return current;
    }

    private Part balanceTree(Part current) {

        int bf = balanceFactor(current);

        if (bf > 1) {

            if (balanceFactor(current.left) > 0) {

                current = rotateLL(current);

            } else {

                current = rotateLR(current);

            }

        } else if (bf < -1) {

            if (balanceFactor(current.right) > 0) {

                current = rotateRL(current);

            } else {

                current = rotateRR(current);
            }
        }
        return current;
    }

    private int balanceFactor(Part current) {

        if (current == null) {
            return 0;
        }

        int l = getHeight(current.left);
        int r = getHeight(current.right);
//        int bf = Math.abs(l - r);
        int bf = l - r;
        return bf;
    }

    private Part rotateRR(Part parent) {

        Part pivot = parent.right;
        parent.right = pivot.left;
        pivot.left = parent;
        return pivot;
    }

    private Part rotateLL(Part parent) {

        Part pivot = parent.left;
        parent.left = pivot.right;
        pivot.right = parent;
        return pivot;
    }

    private Part rotateLR(Part parent) {

        Part pivot = parent.left;
        parent.left = rotateRR(pivot);
        return rotateLL(parent);
    }

    private Part rotateRL(Part parent) {

        Part pivot = parent.right;
        parent.right = rotateLL(pivot);
        return rotateRR(parent);
    }

    private int max(int l, int r) {
        return l > r ? l : r;
    }

    private int getHeight(Part current) {

        int height = 0;
        if (current != null) {
            int l = getHeight(current.left);
            int r = getHeight(current.right);
//            System.out.println(l);
//            System.out.println(r);
            int m = max(l, r);
            height = m + 1;
        }
        return height;
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

    public boolean isBalanced() {
        return isTreeBalanced(root);
    }
    
    private boolean isTreeBalanced(Part root) {
        
        if (root == null) {
            return true;
        }
        
        // Get the height of the left and right trees
        int leftHeight = GetHeight(root.left);
        int rightHeight = GetHeight(root.right);
        
        if (Math.abs(leftHeight - rightHeight) <= 1
                && isTreeBalanced(root.left)
                && isTreeBalanced(root.right)) {
            return true;
        }
        
        return false;
    }

    public int GetHeight(Part current) {

        // If the tree is empty then return 0
        if (current == null) {
            return 0;
        }
        
        // Return the higher number plus 1.
        return Math.max(GetHeight(current.left), GetHeight(current.right)) + 1;
         
    }

    /**
     * Inner class for the part node's details.
     */
    class Part {

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
