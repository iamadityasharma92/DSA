/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    boolean balanced;
    public boolean isBalanced(TreeNode root) {
        balanced=true;
        dfs(root);
        return balanced;
    }

    int dfs(TreeNode root){
        if(root==null) return 0;
        int lh=dfs(root.left);
        int rh=dfs(root.right);
        if(Math.abs(lh-rh)>1)
        balanced=false;
        return 1+(Math.max(lh,rh));
    }
}
