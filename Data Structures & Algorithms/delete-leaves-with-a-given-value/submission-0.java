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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        TreeNode res=dfs(root,target);
        if(res!=null && res.val==target){
            if(res.left==null && res.right==null){
                res=null;
            }
        }
        return res;
    }

    TreeNode dfs(TreeNode root,int t){
        if(root==null) return null;

        TreeNode ln=dfs(root.left,t);
        TreeNode rn=dfs(root.right,t);
        if(ln!=null && ln.val==t){
            if(ln.left==null && ln.right==null){
                root.left=null;
            }
        }
        if(rn!=null && rn.val==t){
            if(rn.left==null && rn.right==null){
                root.right=null;
            }
        }
        return root;
    }
}