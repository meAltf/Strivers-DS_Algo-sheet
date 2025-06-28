class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int lHeight = maxDepth(root.left);
        int rHeight = maxDepth(root.right);

        return 1+ Math.max(lHeight,rHeight);
    }
}
