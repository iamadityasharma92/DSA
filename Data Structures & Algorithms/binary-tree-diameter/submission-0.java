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
    int d;
    public int diameterOfBinaryTree(TreeNode root) {
        d=0;
        if(root==null)return d;
        dfs(root);
        return d;
    }

    public int dfs(TreeNode root){
        if(root==null)return 0;
        int lm=dfs(root.left);
        int rm=dfs(root.right);
        d=Math.max(d,lm+rm);
        return 1+Math.max(rm,lm);
    }
}
