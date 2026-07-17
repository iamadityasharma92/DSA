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
    public int diameterOfBinaryTree(TreeNode root) {
       if(root==null) return 0;
        res=0;
        deep(root);
        return res;
    }

    int deep(TreeNode root){
        if(root==null) return 0;
        int lh=deep(root.left);
        int rh=deep(root.right);
        res= Math.max(res,(lh+rh));
        return 1+Math.max(lh,rh);
    }
}
