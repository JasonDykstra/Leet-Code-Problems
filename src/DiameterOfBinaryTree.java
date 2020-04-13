public class DiameterOfBinaryTree {
    int max = 0;


    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    //traverse over each node and find the depth of the left and right branches
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /*
    This one took me a while to wrap my head around, had to look at discussions and a guide online.
    Learned a lot about how to find the depth of a tree efficiently, and got confused with recursion.

    Runtime: 0 ms, faster than 100.00% of Java online submissions for Diameter of Binary Tree.
    Memory Usage: 39.2 MB, less than 18.18% of Java online submissions for Diameter of Binary Tree.
     */
}
