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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        // TreeNode ans=new TreeNode();
        // if((p.val<root.val && root.val<q.val))// this misses one sided splits also it ignores reverse input order 
        // ans= root;
        // search in left part
         if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }else if(p.val>root.val && q.val>root.val){// search in right part 
            return lowestCommonAncestor(root.right,p,q);
        }
        // we have found split point
        return root;
    }
}
