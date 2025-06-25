package Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalBT {

    private static List<List<Integer>> printLevelOrderBT(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> levelList = new LinkedList<List<Integer>>();
        if (root == null) return levelList;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subLevelList = new LinkedList<Integer>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode currLevel = queue.peek();
                queue.remove();

                if (currLevel.left != null) queue.offer(currLevel.left);
                if (currLevel.right != null) queue.offer(currLevel.right);
                subLevelList.add(currLevel.data);
            }
            levelList.add(subLevelList);
        }
        return levelList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(10);

        System.out.println("Level-order Traversal :-");
        List<List<Integer>> result = printLevelOrderBT(root);
        for (List<Integer> subResult : result) {
            System.out.print(subResult + " ");
        }
    }
}
