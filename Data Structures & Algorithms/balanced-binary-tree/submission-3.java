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
    boolean res;
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        res= true;
        dfs(root);
        return res;
    }

    int dfs(TreeNode root){
        if(root==null) return 0;
        int lh=dfs(root.left);
        int rh=dfs(root.right);
        if(Math.abs(lh-rh)>1)
        res=false;
        return 1+Math.max(lh,rh);
    }
}
