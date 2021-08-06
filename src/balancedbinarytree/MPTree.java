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

        Part newPart = new Part(partName);

        if (root == null) {
            root = newPart;
        } else {
            root = addRecursive(root, newPart);
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

        if (searchForPart(root, partToSearch)) {
            return partToSearch + " was found in the list.";
        }

        return partToSearch + " was not found in the list.";
    }

    private boolean searchForPart(Part current, String partToSearch) {
        if (current == null) {
            return false;
        }

        if (partToSearch.compareToIgnoreCase(current.name) > 0) {
            return searchForPart(current.right, partToSearch);

        }
        if (partToSearch.compareToIgnoreCase(current.name) < 0) {
            return searchForPart(current.left, partToSearch);
        }

        // the current one is the one your looking for.
        return true;
    }

    // Returns a string with the root and the left and right trees.
    public String display() {

        if (root == null) {
            return "There are no parts.";
        }
        String displayString = displayRoot()
                + "\nLEFT TREE: " + displayTree(root.left)
                + "\nRIGHT TREE: " + displayTree(root.right)
                + "\nLeft-Side Height: " + getHeight(root.left)
                + "\nRight-Side Height: " + getHeight(root.right);

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

        if (root != null) {
            if (searchForPart(root, partName)) {
                root = deletePart(root, partName);
                System.out.println(
                        partName + " has been removed from the list.");
            } else {
                System.out.println("That item does is not in the list.\n"
                        + "Please check your spelling and try again.");
            }
        } else {
            System.out.println("The List is Empty.");
        }
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
            int m = max(l, r);
            height = m + 1;
        }
        return height;
    }

    public String isBalanced() {

        if (isTreeBalanced(root)) {
            return "The Binary Tree is Balanced.";
        }
        return "The Binary Tree is Unbalanced.";
    }

    private boolean isTreeBalanced(Part root) {

        if (root == null) {
            return true;
        }

        // Get the height of the left and right trees
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) <= 1
                && isTreeBalanced(root.left)
                && isTreeBalanced(root.right)) {
            return true;
        }

        return false;
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
