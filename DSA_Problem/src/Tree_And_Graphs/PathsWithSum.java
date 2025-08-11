package Tree_And_Graphs;// Class to count paths with sum in a binary tree using simple recursive DFS
import java.util.*;

class PathTree {
    int val;
    PathTree left;
    PathTree right;

    PathTree(int val) {
        this.val = val;
    }
}

public class PathsWithSum {

    // Main method to count all paths in the tree that sum to targetSum
    public static int countPaths(PathTree root, int targetSum) {
        if (root == null) return 0;

        // Count paths starting at this node + paths in left and right subtrees
        int pathsFromRoot = countFromNode(root, targetSum);
        int pathsOnLeft = countPaths(root.left, targetSum);
        int pathsOnRight = countPaths(root.right, targetSum);

        return pathsFromRoot + pathsOnLeft + pathsOnRight;
    }

    // Count the number of paths starting from this node that sum to remainingSum
    private static int countFromNode(PathTree node, int remainingSum) {
        if (node == null) return 0;

        int totalPaths = 0;
        if (node.val == remainingSum) {
            totalPaths++; // Found a valid path
        }

        // Continue exploring left and right subtrees
        totalPaths += countFromNode(node.left, remainingSum - node.val);
        totalPaths += countFromNode(node.right, remainingSum - node.val);

        return totalPaths;
    }

    // Sample usage
    public static void main(String[] args) {
        PathTree root = new PathTree(10);
        root.left = new PathTree(5);
        root.right = new PathTree(-3);
        root.left.left = new PathTree(3);
        root.left.right = new PathTree(2);
        root.right.right = new PathTree(11);
        root.left.left.left = new PathTree(3);
        root.left.left.right = new PathTree(-2);
        root.left.right.right = new PathTree(1);

        int targetSum = 8;
        int result = countPaths(root, targetSum);
        System.out.println("Total paths that sum to " + targetSum + ": " + result);
    }
}
