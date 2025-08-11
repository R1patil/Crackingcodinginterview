package Tree_And_Graphs;

import java.util.LinkedList;
import java.util.Queue;
public class leavelorder_BFS {
    public static void main(String[] args) {
        Tree_Traversal.TreeNode root = new Tree_Traversal.TreeNode(5);
        root.left = new Tree_Traversal.TreeNode(4);
        root.right=new Tree_Traversal.TreeNode(3);
        leavelorder_BFS bfs=new leavelorder_BFS();
        bfs.levelOrder(root);

    }
    public void levelOrder(Tree_Traversal.TreeNode root) {
        if (root == null) return;

        Queue<Tree_Traversal.TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Tree_Traversal.TreeNode current = queue.poll(); // dequeue
            System.out.print(current.val + " ");

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
}
