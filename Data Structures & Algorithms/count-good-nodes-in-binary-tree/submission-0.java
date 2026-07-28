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
        dfs(root,root);
        return res;
    }

    void dfs(TreeNode root,TreeNode proot){
        if(root==null) return;
        if(isGoodNode(root,proot)){
            res++;
        }
        dfs(root.left,proot);
        dfs(root.right,proot);
    }

    boolean isGoodNode(TreeNode root,TreeNode proot){
        // now again we need to perform DFS

        return findAgain(proot,root,root.val);
    }

    boolean findAgain(TreeNode current,TreeNode target,int targetValue){
        if(current==null)return false;

        if(current.val>targetValue) return false;
        if(current==target) return true;
        //search in Left
        if(findAgain(current.left,target,targetValue)){
            return true;
        }
        // search in right
        return findAgain(current.right,target,targetValue);
    }
}
