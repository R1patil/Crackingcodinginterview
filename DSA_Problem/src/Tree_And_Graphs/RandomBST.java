package Tree_And_Graphs;// Class to represent a binary search tree with random node support
import java.util.*;

class New2TreeNode {
    int val;
    int size; // number of nodes in subtree rooted here
    New2TreeNode left;
    New2TreeNode right;

    New2TreeNode(int val) {
        this.val = val;
        this.size = 1;
    }

    // Insert a value into the BST and update sizes
    public void insert(int val) {
        if (val <= this.val) {
            if (left == null) left = new New2TreeNode(val);
            else left.insert(val);
        } else {
            if (right == null) right = new New2TreeNode(val);
            else right.insert(val);
        }
        size++; // update size after insertion
    }

    // Find a node with given value
    public New2TreeNode find(int val) {
        if (val == this.val) return this;
        else if (val < this.val) return (left != null) ? left.find(val) : null;
        else return (right != null) ? right.find(val) : null;
    }

    // Get a random node uniformly
    public New2TreeNode getRandomNode() {
        int leftSize = (left == null) ? 0 : left.size;
        int index = new Random().nextInt(size); // 0 to size-1

        if (index < leftSize) {
            return left.getRandomNode();
        } else if (index == leftSize) {
            return this;
        } else {
            return right.getRandomNode();
        }
    }
}

public class RandomBST {
    public static void main(String[] args) {
        New2TreeNode root = new New2TreeNode(10);
        root.insert(5);
        root.insert(15);
        root.insert(3);
        root.insert(7);
        root.insert(12);
        root.insert(17);

        // Print some random nodes
        for (int i = 0; i < 10; i++) {
            New2TreeNode random = root.getRandomNode();
            System.out.println("Random node: " + random.val);
        }
    }
}
