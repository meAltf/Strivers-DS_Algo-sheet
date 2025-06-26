class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null) return ans;

        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            ans.add(root.val);

            if(root.right != null) stack.push(root.right);
            if(root.left != null) stack.push(root.left);
        }
        return ans;
    }
}
