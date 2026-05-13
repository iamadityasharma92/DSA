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
    public boolean isBalanced(TreeNode root) {
            d=0;
        if(root==null)return true;
        dfs(root);
        // System.out.println(d);
        return d>0?false:true;
    }

    public int dfs(TreeNode root){
        if(root==null)return 0;
        int lm=dfs(root.left);
        int rm=dfs(root.right);
        // System.out.println(lm+" "+rm);

        if(Math.abs(lm-rm)>1){
            d++;
        }
        return 1+Math.max(rm,lm);
    }
}
