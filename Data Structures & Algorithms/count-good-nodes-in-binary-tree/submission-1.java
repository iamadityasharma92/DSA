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
    int res;
    public int goodNodes(TreeNode root) {
        res=0;
        dfs(root,root.val);// considering root as first maximum
        return res;
    }

    void dfs(TreeNode root,int maxi){
        if(root==null) return;
        if(root.val>=maxi){
            res++;
            maxi=root.val;
        }

        dfs(root.left,maxi);
        dfs(root.right,maxi);
    }
}
