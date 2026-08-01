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
    int gm;
    public int maxPathSum(TreeNode root) {
        gm=Integer.MIN_VALUE;// due to negative values constraint
        dfs(root);
        return gm;
    }
    int dfs(TreeNode root){
        if(root==null) return 0;

        int lm=Math.max(0,dfs(root.left));// we need only positive paths no requirement of maximising no. of nodes
        int rm=Math.max(0,dfs(root.right));
        int m=root.val+lm+rm;//should always include root and include left and right result only if they are positive
        gm=Math.max(gm,m);
        return Math.max(lm,rm)+root.val;//we cannot repeat a node in path so either of left or right will be returned, so returning the maximum one 
    }
}
