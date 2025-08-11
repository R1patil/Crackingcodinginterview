package Tree_And_Graphs;

import java.util.*;

// TreeNode definition
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

public class ListOfDepths {

    // Function to create list of depths
    public static List<LinkedList<TreeNode>> listOfDepths(TreeNode root) {
        List<LinkedList<TreeNode>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            LinkedList<TreeNode> levelList = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                levelList.add(current);

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }

            result.add(levelList);
        }

        return result;
    }

    // Helper function to print the result
    public static void printLevelLists(List<LinkedList<TreeNode>> lists) {
        int level = 0;
        for (LinkedList<TreeNode> list : lists) {
            System.out.print("Level " + level + ": ");
            for (TreeNode node : list) {
                System.out.print(node.val + " ");
            }
            System.out.println();
            level++;
        }
    }

    // Sample binary tree for testing
    public static TreeNode createSampleTree() {
        /*
                1
               / \
              2   3
             / \   \
            4   5   6
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = createSampleTree();
        List<LinkedList<TreeNode>> lists = listOfDepths(root);
        printLevelLists(lists);
    }
}
