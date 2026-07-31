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
    public int rob(TreeNode root) {
        int[] res=dfs(root);
        return Math.max(res[0],res[1]);
    }

    int[] dfs(TreeNode root){//arr[0]-> skip root arr[1]-> include root
        if(root==null) return new int[]{0,0};

        int[] lp=dfs(root.left);
        int[] rp=dfs(root.right);

        int withRoot=root.val+lp[0]+rp[0];// include current root add skip childs result so far
        int withoutRoot=Math.max(lp[0],lp[1])+Math.max(rp[0],rp[1]);// do not add root.val take maximum from child results and add them
        return new int[]{withoutRoot,withRoot};
        
    }
}