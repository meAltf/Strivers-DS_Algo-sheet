package Trees;

import javax.swing.tree.TreeCellRenderer;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data1) {
        this.data = data1;
    }
}

public class BinaryTreeTraversal {

    /**
     * preOrder -> root | left | right
     **/
    private void printPreOrderTree(TreeNode root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        printPreOrderTree(root.left);
        printPreOrderTree(root.right);
    }

    /**
     * preOrder -> left | right | root
     **/
    private void printPostOrderTree(TreeNode root) {
        if (root == null) return;

        printPostOrderTree(root.left);
        printPostOrderTree(root.right);
        System.out.print(root.data + " ");
    }

    /**
     * preOrder -> left | root | right
     **/
    private void printInOrderTree(TreeNode root) {
        if (root == null) return;

        printInOrderTree(root.left);
        System.out.print(root.data + " ");
        printInOrderTree(root.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(10);

        BinaryTreeTraversal tree = new BinaryTreeTraversal();
        System.out.println("Pre-order Traversal :- ");
        tree.printPreOrderTree(root);
        System.out.println();

        System.out.println("Post-order Traversal :- ");
        tree.printPostOrderTree(root);
        System.out.println();

        System.out.println("In-order Traversal :- ");
        tree.printInOrderTree(root);
        System.out.println();
    }
}
