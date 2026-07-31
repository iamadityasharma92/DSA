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

        int lm=dfs(root.left);
        int rm=dfs(root.right);
        int m=0;
        m=root.val+Math.max(0,lm)+Math.max(0,rm);//should always include root and include left and right result only if they are positive
        if(gm<m){// store in global max
            gm=m;
        }
        return Math.max(0,Math.max(lm,rm))+root.val;//we cannot repeat a node in path so either of left or right will be returned, so returning the maximum one 
        // what if max of lm and rm both negative we'll not include them in path as we need to maximise path sum and no need to maximise no. of nodes
    }
}
