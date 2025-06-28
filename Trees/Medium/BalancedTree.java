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

-- Approach : 2 | Extended version of Height of Binary Tree

class Solution {
    private int isDfs(TreeNode root){
        if(root == null) return 0;

        int lHeight = isDfs(root.left);
        if(lHeight == -1) return -1;
        int rHeight = isDfs(root.right);
        if(rHeight == -1) return -1;

        if(Math.abs(lHeight-rHeight) > 1) return -1;
        return 1 + Math.max(lHeight, rHeight);
    }

    public boolean isBalanced(TreeNode root) {
        return isDfs(root) != -1;
    }
}
