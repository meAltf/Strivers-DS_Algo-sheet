class Solution {
    private int heightBT(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(heightBT(root.left), heightBT(root.right));
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int lHeight = heightBT(root.left);
        int rHeight = heightBT(root.right);

        if(Math.abs(lHeight-rHeight) > 1) return false;

        Boolean left = isBalanced(root.left);
        Boolean right = isBalanced(root.right);

        if(!left || !right) return false;
        return true;
    }
}
