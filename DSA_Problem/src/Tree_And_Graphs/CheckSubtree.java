package Tree_And_Graphs;

// Definition of binary tree node
class New1TreeNode {
    int val;
    New1TreeNode left;
    New1TreeNode right;

    New1TreeNode(int val) {
        this.val = val;
    }
}

public class CheckSubtree {

    // Main function to check if t2 is a subtree of t1
    public static boolean isSubtree(New1TreeNode t1, New1TreeNode t2) {
        if (t2 == null) return true;      // An empty tree is always a subtree
        if (t1 == null) return false;     // Can't find match if main tree is empty

        // If roots match, check for identical trees
        if (areIdentical(t1, t2)) return true;

        // Recurse left and right to keep checking
        return isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
    }

    // Helper function to check if two trees are structurally identical
    public static boolean areIdentical(New1TreeNode t1, New1TreeNode t2) {
        if (t1 == null && t2 == null) return true;  // Both null → match
        if (t1 == null || t2 == null) return false; // One null → no match
        if (t1.val != t2.val) return false;         // Mismatch in value

        // Recursively check left and right children
        return areIdentical(t1.left, t2.left) && areIdentical(t1.right, t2.right);
    }

    // Example usage
    public static void main(String[] args) {
        // Build T1
        New1TreeNode t1 = new New1TreeNode(10);
        t1.left = new New1TreeNode(4);
        t1.right = new New1TreeNode(12);
        t1.left.left = new New1TreeNode(2);
        t1.left.right = new New1TreeNode(5);

        // Build T2
        New1TreeNode t2 = new New1TreeNode(4);
        t2.left = new New1TreeNode(2);
        t2.right = new New1TreeNode(5);

        // Check if T2 is a subtree of T1
        boolean result = isSubtree(t1, t2);
        System.out.println("Is T2 a subtree of T1? " + result);
    }
}
