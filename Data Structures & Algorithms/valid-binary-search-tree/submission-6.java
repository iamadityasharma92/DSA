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
        
        return validate(root,null,null);// infinity in min and max
    }

    boolean validate(TreeNode root,Integer min,Integer max){
        if(root == null) return true ;

        if((min!=null && root.val<=min)||(max!=null && root.val>=max)){// fail fast 
        // ancestors check
        // 1st condition ensures on right traversal that if root is smaller than min than invalid node 
        // 2nd condition ensures on left traversal that if root is greater than max than invalid node
            return false;
        }
        return validate(root.left,min,root.val)&& validate(root.right,root.val,max);
    }
}
