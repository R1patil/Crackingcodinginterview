package Tree_And_Graphs;

public class Tree_Traversal {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        /*
                         1
                       / \
                      2   3
                     / \
                    4   5
                   /
                  6

          */

        Tree_Traversal tree_traversal = new Tree_Traversal();
        System.out.print("Inorder: ");
        tree_traversal.inorder(root);
        System.out.println();

        System.out.print("Preorder: ");
        tree_traversal.preorder(root);
        System.out.println();

        System.out.print("Postorder: ");
        tree_traversal.postorder(root);
        System.out.println();

        System.out.print("height of the tree");
        System.out.println();
        System.out.println(tree_traversal.getHeight(root));

        System.out.println("height of the balanced tree");
        System.out.println();
        System.out.println(tree_traversal.getHeightBalanced(root));
        System.out.println(tree_traversal.isBalanced(root));

        System.out.println("cheak the binary srch treee is tree");
        System.out.println(tree_traversal.isValidBST(root));



    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //root->left->right
    public void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }
    //left->root->right
    public void inorder(TreeNode root){
        if(root==null)return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
    //left->right->root
    public void postorder(TreeNode root){
        if(root==null)return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    // find the height of the tree
    public int getHeight(TreeNode root) {
        if (root == null) return -1;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int getHeightBalanced(TreeNode root) {
        if (root == null) return -1;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
   // we are  balancing the tree we need to count we use the preorder
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int left = checkHeight(node.left);
        if (left == -1) return -1;  // left subtree is not balanced

        int right = checkHeight(node.right);
        if (right == -1) return -1; // right subtree is not balanced

        if (Math.abs(left - right) > 1) return -1; // current node not balanced

        return 1 + Math.max(left, right); // return height if balanced
    }

    // its binary serach tree is valid or not
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode node, long min, long max) {
        if (node == null) return true;

        if (node.val <= min || node.val >= max) return false;

        return isValidBSTHelper(node.left, min, node.val)
                && isValidBSTHelper(node.right, node.val, max);
    }






}
