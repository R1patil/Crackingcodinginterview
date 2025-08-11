package Tree_And_Graphs;

class MyTreeNode {
    String val;
    MyTreeNode left;
    MyTreeNode right;

    MyTreeNode(String val) {
        this.val = val;
    }
}

public class FirstCommonAncestor {

    public static MyTreeNode findCommonAncestor(MyTreeNode root, MyTreeNode p, MyTreeNode q) {
        if (root == null) return null;

        if (root == p || root == q) return root;

        MyTreeNode left = findCommonAncestor(root.left, p, q);
        MyTreeNode right = findCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;

        return left != null ? left : right;
    }

    public static void main(String[] args) {
        MyTreeNode a = new MyTreeNode("a");
        MyTreeNode b = new MyTreeNode("b");
        MyTreeNode c = new MyTreeNode("c");
        MyTreeNode d = new MyTreeNode("d");
        MyTreeNode e = new MyTreeNode("e");
        MyTreeNode f = new MyTreeNode("f");
        MyTreeNode g = new MyTreeNode("g");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        MyTreeNode ancestor1 = findCommonAncestor(a, d, e);
        System.out.println("Common Ancestor of d and e: " + (ancestor1 != null ? ancestor1.val : "null"));

        MyTreeNode ancestor2 = findCommonAncestor(a, d, g);
        System.out.println("Common Ancestor of d and g: " + (ancestor2 != null ? ancestor2.val : "null"));
    }
}
