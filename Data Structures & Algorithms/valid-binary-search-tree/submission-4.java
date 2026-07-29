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
    public boolean isValidBST(TreeNode root) {
        return isValid(root,null,null);// both bounds infinity
    }
    
    boolean isValid(TreeNode root,Integer min,Integer max){
        if(root==null) return true;

        //strictly agree ancestors boundaries
        if((min!=null && root.val<=min)||(max!=null && root.val>=max)){// failing first for avoiding check further 
        // if any node is invalid then whole tree is invalid no need to check further 
            return false;
        }
        return isValid(root.left,min,root.val)&&isValid(root.right,root.val,max);
    }

}
