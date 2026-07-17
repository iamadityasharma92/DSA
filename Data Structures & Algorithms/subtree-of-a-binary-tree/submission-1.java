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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        res=false;
        dfs(root,subRoot);
        return res;
    }

    void dfs(TreeNode root,TreeNode subroot){
        if(root==null) return;
        boolean check= isSameTree(root,subroot);
        if(check)
        res=true;
        dfs(root.left,subroot);
        dfs(root.right,subroot);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null || p.val!=q.val) return false;


        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
